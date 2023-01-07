package com.mansour.models;

import com.mansour.FortuneService;
import com.mansour.HappyFortuneService;

public class RunningCoach implements Coach {
    private FortuneService happyFortuneService;

    @Override
    public String doWorkout() {
        return "Run 5k...";
    }

    @Override
    public String getDailyFortune() {
        return happyFortuneService.getFortune();
    }

    public void setHappyFortuneService(HappyFortuneService happyFortuneService) {
        this.happyFortuneService = happyFortuneService;
    }
}
