package com.catwizard.spotify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by poolebu on 8/10/16.
 */
@RestController
public class LogingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    LogingService logingService;

    @RequestMapping("/searchById")
    public Greeting loging(@RequestParam(value = "albumId") String albumNameRequest) {


         String message = logingService.searchById(albumNameRequest);


        return new Greeting(counter.incrementAndGet(),message);



    }
}