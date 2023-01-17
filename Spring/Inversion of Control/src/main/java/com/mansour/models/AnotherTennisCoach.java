package com.mansour.models;

import org.springframework.stereotype.Component;

@Component("TCoach")
public class AnotherTennisCoach implements Coach{
    @Override
    public String doWorkout() {
        return "Play 40 mins of tennis";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
