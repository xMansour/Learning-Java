package com.mansour.models;

import com.mansour.services.FortuneService;

public interface Coach {
    String doWorkout();

    String getDailyFortune();

    default String getDailyFortune2(){
        return null;
    }

    default String testMethodAutoWiring(FortuneService fortuneService){
        return null;
    }

    default String testFieldInjectionsAutoWiring(){
        return null;
    }

    default String getUserName(){
        return null;
    }

    default String getPassword(){
        return null;
    }
}
