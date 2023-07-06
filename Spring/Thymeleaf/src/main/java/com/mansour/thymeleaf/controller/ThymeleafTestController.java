package com.mansour.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@Controller
public class ThymeleafTestController {
    @GetMapping("/hi")
    public String helloThymeleaf(Model model){
        model.addAttribute("date", new Date());
        return "thymeleaf-index";
    }

}
