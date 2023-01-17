package com.mansour;

import com.mansour.models.Coach;
import com.mansour.models.FootballCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IoCDemo {
    public static void main(String[] args) {
        //Load spring configuration file
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        //Retrieve the bean from the spring container
        Coach swimmingCoach = context.getBean("swimmingCoach", Coach.class);    //Coach.class is specified to enable internal casting.

        //Call methods on the spring bean
        System.out.println(swimmingCoach.doWorkout());
        System.out.println(swimmingCoach.getDailyFortune());

        System.out.println();
        System.out.println();

        FootballCoach footballCoach = context.getBean("footballCoach", FootballCoach.class);
        System.out.println(footballCoach.doWorkout());
        System.out.println(footballCoach.getDailyFortune());
        System.out.println(footballCoach.getCoachId());
        System.out.println(footballCoach.getCoachName());

        System.out.println();
        System.out.println();

        Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
        System.out.println(baseballCoach.doWorkout());
        System.out.println(baseballCoach.getDailyFortune());

        System.out.println();
        System.out.println();

        Coach runningCoach = context.getBean("runningCoach", Coach.class);
        System.out.println(runningCoach.doWorkout());
        System.out.println(runningCoach.getDailyFortune());

        Coach runningCoach2 = context.getBean("runningCoach", Coach.class);

        //Testing scopes

        System.out.println("runningCoach2.equals(runningCoach) = " + runningCoach2.equals(runningCoach));
        System.out.println("runningCoach2 memory address = " + runningCoach2);
        System.out.println("runningCoach memory address = " + runningCoach);
        
        
        //Annotations Bean Configuration
        ClassPathXmlApplicationContext annotationsContext = new ClassPathXmlApplicationContext("annotationsApplicationContext.xml");
        Coach tennisCoach = annotationsContext.getBean("tennisCoach", Coach.class); //default bean id
        System.out.println("tennisCoach.doWorkout() = " + tennisCoach.doWorkout());

        Coach AnotherTennisCoach = annotationsContext.getBean("TCoach", Coach.class); //default bean id
        System.out.println("AnotherTennisCoach.doWorkout() = " + AnotherTennisCoach.doWorkout());


        //Close the context
        context.close();
        annotationsContext.close();
    }
}