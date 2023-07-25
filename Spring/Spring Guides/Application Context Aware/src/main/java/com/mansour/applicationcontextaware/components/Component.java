package com.mansour.applicationcontextaware.components;

import com.mansour.applicationcontextaware.entities.Person;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

@org.springframework.stereotype.Component
public class Component {

    private final Person person;

    @Autowired
    public Component(@Qualifier("SecondPerson") Person person) {
        this.person = person;
    }


    @PostConstruct
    public void init() {
        System.out.println("Person: " + person);
    }
}
