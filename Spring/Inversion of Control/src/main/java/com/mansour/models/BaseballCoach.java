package com.mansour.models;

import com.mansour.services.FortuneService;

public class BaseballCoach implements Coach {
    private FortuneService midFortuneService;

    @Override
    public String doWorkout() {
        return "Start batting for 45 mins";
    }

    @Override
    public String getDailyFortune() {
        return midFortuneService.getFortune();
    }

    public void setMidFortuneService(MidFortuneService midFortuneService) {
        this.midFortuneService = midFortuneService;

    }
}
