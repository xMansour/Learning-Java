package com.mansour.applicationcontextaware.components;

import com.mansour.applicationcontextaware.entities.Person;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class Component2 {
    @Resource(name = "getSecondPerson")
    private Person person;

    @PostConstruct
    public void init() {
        System.out.println("Component2 Person = " + person);
    }


}
