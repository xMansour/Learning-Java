package com.mansour.springioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller

public class GreetingController {
    @Autowired
    private ResourceBundleMessageSource source;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void hello() {
        System.out.println(source.getMessage("message", null, Locale.FRANCE));
    }
}
