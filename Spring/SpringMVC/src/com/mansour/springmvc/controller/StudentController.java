package com.mansour.springmvc.controller;

import com.mansour.springmvc.models.Student;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;


@Controller
@RequestMapping("/student")
public class StudentController {

    @RequestMapping("/showForm")
    public String showForm(Model model) {
        //Creating a new student object
        Student student = new Student();
        //Adding the object to the model
        model.addAttribute("student", student);
        return "student-form";
    }

    @RequestMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        System.out.println("student.getFirstName(): " + student.getFirstName());
        System.out.println("student.getLastName(): " + student.getLastName());
        System.out.println("student.getAge(): " + student.getAge());
        System.out.println("student.getCourseCode(): " + student.getCourseCode());

        if (bindingResult.hasErrors()) {
            System.out.println("BindingResult has errors");
            return "student-form";
        } else {
            return "student-confirmation";
        }
    }


    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
