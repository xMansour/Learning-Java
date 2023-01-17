package com.mansour.models;

import org.springframework.stereotype.Component;

@Component  //default: same class name with first letter lower case.
public class TennisCoach implements Coach{
    @Override
    public String doWorkout() {
        return "Play 50 mins of tennis.";
    }

    @Override
    public String getDailyFortune() {
        return null;
    }
}
