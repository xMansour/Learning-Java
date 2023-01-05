package com.mansour;

import com.mansour.models.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Coach coach = context.getBean("swimmingCoach", Coach.class);    //Coach.class is specified to enable internal casting.
        //Coach coach = context.getBean("footballCoach", Coach.class);
        System.out.println(coach.doWorkout());
    }
}