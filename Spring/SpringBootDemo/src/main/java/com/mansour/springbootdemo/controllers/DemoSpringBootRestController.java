package com.mansour.springbootdemo.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class DemoSpringBootRestController {
    @Value("${name}")
    private String userName;

    @Value("${job.title}")
    private String jobTitle;


    @GetMapping("/rest/")
    public String index() {
        return "Hello world!, my name is: " + userName + " and i work as a " + jobTitle;
    }

    @GetMapping("/devtoolstest/")
    public String devToolsTest(){
        return "Dev Tools Test Again!";
    }
}
