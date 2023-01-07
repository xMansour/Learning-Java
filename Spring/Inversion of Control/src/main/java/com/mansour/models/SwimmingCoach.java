package com.mansour.models;

import com.mansour.FortuneService;

public class SwimmingCoach implements Coach {

    private final FortuneService fortuneService;

    public SwimmingCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String doWorkout() {
        return "Swim for 15 mins";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
