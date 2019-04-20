package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class HttpTrafficController {

    @Autowired
    HttpServiceRepository httpRepo;

    @PostMapping("/http/request/post")
    public @ResponseBody String postTransaction(@RequestBody HttpIncoming httpIncoming) {
        String modifiedRequestPayload = "";
        try {
            HttpTraffic httpTraffic = convertIncomingToDBObject(httpIncoming);
            httpRepo.save(httpTraffic);
            modifiedRequestPayload = modifiedRequest(httpTraffic.getTransactionId());
        } catch (Exception e) {
            return "";
        }
        return modifiedRequestPayload;
    }

    private String modifiedRequest(String transactionId) {
        return httpRepo.findByTransactionId(transactionId).getModifiedRequestPayload() + "null";
    }

    private HttpTraffic convertIncomingToDBObject(HttpIncoming httpIncoming) {
        if (httpIncoming != null) {
            HttpTraffic httpTraffic = new HttpTraffic();
            httpTraffic.setEnvironment(httpIncoming.getEnvironment());
            httpTraffic.setIpAddress(httpIncoming.getIpAddress());
            httpTraffic.setModifiedRequestPayload(httpIncoming.getModifiedRequestPayload());
            httpTraffic.setModifiedResponsePayload(httpIncoming.getModifiedResponsePayload());
            httpTraffic.setRequestHeader(httpIncoming.getRequestHeader());
            httpTraffic.setRequestModificationStatus(httpIncoming.getRequestModificationStatus());
            httpTraffic.setRequestPayload(httpIncoming.getRequestPayload());
            httpTraffic.setRequestReceivedTimestamp(httpIncoming.getRequestReceivedTimestamp());
            httpTraffic.setRequestURL(httpIncoming.getRequestURL());
            httpTraffic.setResponseHeader(httpIncoming.getResponseHeader());
            httpTraffic.setResponseModificationStatus(httpIncoming.getResponseModificationStatus());
            httpTraffic.setResponsePayload(httpIncoming.getResponsePayload());
            httpTraffic.setResponseSentTimestamp(httpIncoming.getResponseSentTimestamp());
            httpTraffic.setServiceName(httpIncoming.getServiceName());
            httpTraffic.setTimeTaken(httpIncoming.getTimeTaken());
            httpTraffic.setTransactionId(httpIncoming.getTransactionId());
            httpTraffic.setUserId(httpIncoming.getUserId());
            return httpTraffic;
        }
        return null;
    }
}
