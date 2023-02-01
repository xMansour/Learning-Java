package com.mansour.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller //inherits from @Component and scanned via @ComponentScan
//@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String index() {
        System.out.println("Home Redirection...");
        return "home";
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public String login() {
        return "login-form";
    }

    /*@RequestMapping(value = "processForm", method = RequestMethod.GET)
    public String showFormData(HttpServletRequest request, Model model){
        String userName = request.getParameter("userName");
        System.out.println("userName = " + userName);
        String password = request.getParameter("password");
        System.out.println("password = " + password);
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        return "show-login-form";
    }*/

    @RequestMapping(value = "/processForm", method = RequestMethod.GET)
    public String showFormData(@RequestParam("userName") String userName, @RequestParam("password") String password, Model model){
        System.out.println("userName = " + userName);
        System.out.println("password = " + password);
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        return "show-login-form";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String getUser() {
        System.out.println("User Redirection...");
        return "user";
    }
}
