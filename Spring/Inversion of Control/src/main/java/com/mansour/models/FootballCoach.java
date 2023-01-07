package com.mansour.models;

import com.mansour.FortuneService;

public class FootballCoach implements Coach {
    private final FortuneService fortuneService;
    private String coachName;
    private String coachId;

    public FootballCoach(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String doWorkout() {
        return "Pass the ball for 30 mins.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setCoachName(String coachName) {
        this.coachName = coachName;
    }

    public void setCoachId(String coachId) {
        this.coachId = coachId;
    }
    public String getCoachName() {
        return coachName;
    }

    public String getCoachId() {
        return coachId;
    }
}
