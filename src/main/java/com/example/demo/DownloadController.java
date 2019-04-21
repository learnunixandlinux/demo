package com.example.demo;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DownloadController {

    @GetMapping("/downloads/beats/filebeat/filebeat-5.2.0-amd64.deb")
    public void downloadFile(HttpServletResponse response, @RequestHeader HttpHeaders headers) {
        String internalFileName = "special/filebeat-5.2.0-amd64.deb";

        if (headers.get("User-Agent") != null && ((headers.get("User-Agent").toString().indexOf("Edge") != -1)
                || (headers.get("User-Agent").toString().indexOf("Chrome") != -1)
                || (headers.get("User-Agent").toString().indexOf("Mozilla") != -1))) {
            internalFileName = "filebeat-5.2.0-amd64.deb";
        }

        File file = null;

        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        System.out.println("path:" + classloader.getResource(internalFileName).getFile());
        // file = new File(classloader.getResource(internalFileName).getFile());
        file = new File("~/filebeat-5.2.0-amd64.deb");

        System.out.println("file.getName():"+file.getName());
        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        System.out.println("mimeType:"+mimeType);
        

        response.setContentType("application/octet-stream");

        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));
        response.setHeader("Connection", "Keep-Alive");

        System.out.println("File length set to:" + String.valueOf(file.length()));

        response.setHeader("Content-Length", "8929120");

        System.out.println("response header set to:" + response.getHeader("Content-Length"));

        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());
        } catch (IOException e) {

        }
    }

}
