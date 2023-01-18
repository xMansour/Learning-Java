package com.mansour.models;

import com.mansour.services.FortuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("TCoach")
public class AnotherTennisCoach implements Coach{
    private FortuneService fortuneService;
    private FortuneService fortuneService2;
    @Autowired
    @Qualifier("sadFortuneService")
    private FortuneService fortuneService3;

    @Value("${userName}")
    private String userName;
    @Value("${password}")
    private String password;
    @Autowired
    public AnotherTennisCoach(@Qualifier("sadFortuneService") FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Autowired
    public void setFortuneService(@Qualifier("hopeGoodFortuneService") FortuneService fortuneService2) {
        this.fortuneService2 = fortuneService2;
    }

    @Override
    public String doWorkout() {
        return "Play 40 mins of tennis";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }


    @Override
    public String getDailyFortune2() {
        return fortuneService2.getFortune();
    }

    @Override
    @Autowired
    public String testMethodAutoWiring(@Qualifier("methodAutoWiredFortuneService") FortuneService fortuneService) {
        return fortuneService.getFortune();
    }

    @Override
    public String testFieldInjectionsAutoWiring() {
        return fortuneService3.getFortune();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
