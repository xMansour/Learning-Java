package com.mansour.springioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Locale;

@Controller
@PropertySource("classpath:application.properties")
public class GreetingController {
    @Autowired
    private ResourceBundleMessageSource source;
    @Value("${language}")
    private String language;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public void hello() {
        if (language.equals("en"))
            System.out.println(source.getMessage("message", null, Locale.US));
        else if (language.equals("fr"))
            System.out.println(source.getMessage("message", null, Locale.FRANCE));

    }
}
