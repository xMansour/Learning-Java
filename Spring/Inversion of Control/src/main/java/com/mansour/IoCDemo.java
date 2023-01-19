package com.mansour;

import com.mansour.config.SportConfig;
import com.mansour.models.Coach;
import com.mansour.models.FootballCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
        System.out.println("AnotherTennisCoach.getDailyFortune() = " + AnotherTennisCoach.getDailyFortune());
        System.out.println("AnotherTennisCoach.getDailyFortune2() = " + AnotherTennisCoach.getDailyFortune2());
        System.out.println("AnotherTennisCoach.testFieldInjectionsAutoWiring() = " + AnotherTennisCoach.testFieldInjectionsAutoWiring());
        System.out.println("AnotherTennisCoach.getUserName() = " + AnotherTennisCoach.getUserName());
        System.out.println("AnotherTennisCoach.getPassword() = " + AnotherTennisCoach.getPassword());

        Coach AnotherTennisCoach2 = annotationsContext.getBean("TCoach", Coach.class); //default bean id
        System.out.println("AnotherTennisCoach2.equals(AnotherTennisCoach): " + AnotherTennisCoach2.equals(AnotherTennisCoach));
        System.out.println("AnotherTennisCoach Memory location: " + AnotherTennisCoach);
        System.out.println("AnotherTennisCoach2 Memory location: " + AnotherTennisCoach2);

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SportConfig.class);
        Coach AnotherTennisCoach3 = annotationConfigApplicationContext.getBean("TCoach", Coach.class);
        Coach footballCoach2 = annotationConfigApplicationContext.getBean("footBallCoach", Coach.class);
        System.out.println("AnotherTennisCoach3.equals(AnotherTennisCoach): " + AnotherTennisCoach2.equals(AnotherTennisCoach3));
        System.out.println("AnotherTennisCoach Memory location: " + AnotherTennisCoach);
        System.out.println("AnotherTennisCoach2 Memory location: " + AnotherTennisCoach2);
        System.out.println("AnotherTennisCoach3 Memory location: " + AnotherTennisCoach3);
        System.out.println("footballCoach2.getDailyFortune(): "+ footballCoach2.getDailyFortune());
        //Close the context
        context.close();
        annotationsContext.close();
        annotationConfigApplicationContext.close();
    }
}