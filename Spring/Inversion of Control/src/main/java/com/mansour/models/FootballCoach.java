package com.mansour.models;

import com.mansour.services.FortuneService;
import org.springframework.beans.factory.annotation.Value;

public class FootballCoach implements Coach {
    private final FortuneService fortuneService;

    @Value("${coachName}")
    private String coachName;
    @Value("${coachId}")
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
        return this.coachName;
    }

    public String getCoachId() {
        return this.coachId;
    }


}
