package com.example.demo;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DemoScheduler {

    //@Scheduled(fixedDelay = 5000)
    public void sched() throws MalformedURLException, IOException {
        System.out.println("Scheduled run");

        String out = new Scanner(new URL(
                "http://s000.tinyupload.com/download.php?file_id=47296773449061649749&t=4729677344906164974959070")
                        .openStream(),
                "UTF-8").useDelimiter("\\A").next();
        
        System.out.println(out);

    }

}
