package com.mansour.models;

import com.mansour.FortuneService;
import com.mansour.HappyFortuneService;
import org.springframework.beans.factory.DisposableBean;

public class RunningCoach implements Coach, DisposableBean {
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

    private void initMethod() {
        System.out.println("Init...");
    }

    private void destroyMethod() {
        System.out.println("Destroy...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Destroy Bean...");
    }
}
