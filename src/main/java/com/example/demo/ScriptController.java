package com.example.demo;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class ScriptController {

    @Autowired
    ScriptRepository scriptRepo;

    @PostMapping("/s/add")
    public @ResponseBody String addScript(@RequestParam String type, @RequestParam String environment,
            @RequestBody IncomingScript incomingScript) {
        if (type != null && !(type.equals("select") || type.equals("update"))) {
            return "Type should be either select or update";
        }

        String addTimeStamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        String transactionId = new Long(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant().toEpochMilli())
                .toString();
        String content = incomingScript.getStmt();

        Script scriptToBeAdded = new Script();
        scriptToBeAdded.setScriptId(transactionId);
        scriptToBeAdded.setCreateTs(addTimeStamp);
        scriptToBeAdded.setStmt(content);
        scriptToBeAdded.setType(type);
        scriptToBeAdded.setEnvironment(environment);
        scriptRepo.save(scriptToBeAdded);

        return "Posted query. Wait for results!";
    }

    @GetMapping("/s/get")
    public @ResponseBody String getScript(@RequestParam String environment, @RequestParam String processingService) {

        try {

            List<Script> scriptList = scriptRepo.findByEnvironmentAndProcessingTsIsNull(environment);

            if (!scriptList.isEmpty()) {
                Script partialUpdateScript = scriptList.get(0);
                partialUpdateScript.setProcessingService(processingService);
                partialUpdateScript.setProcessingTs(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
                scriptRepo.save(partialUpdateScript);

                return scriptList.get(0).getScriptId() + "####" + scriptList.get(0).getType() + "::::"
                        + scriptList.get(0).getStmt();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "NA";
        }
        return "NA";
    }

    @PostMapping("/s/post")
    public @ResponseBody String postExecutionResult(@RequestParam String scriptId, @RequestParam String status,
            @RequestBody IncomingResult result) {
        try {

            Script script = scriptRepo.findByScriptId(scriptId);
            script.setResult(result.getResult());
            String resultTs = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
            script.setResultTs(resultTs);
            script.setResultStatus(status);

            scriptRepo.save(script);
        } catch (Exception e) {
            e.printStackTrace();
            return "Posting failed!";
        }

        return "Posted successfully";
    }

}
