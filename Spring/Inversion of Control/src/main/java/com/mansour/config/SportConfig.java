package com.mansour.config;

import com.mansour.models.Coach;
import com.mansour.models.FootballCoach;
import com.mansour.services.FortuneService;
import com.mansour.services.HappyFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.mansour")
public class SportConfig {

    @Bean
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }
    @Bean
    public Coach footBallCoach(){
        return new FootballCoach(happyFortuneService());
    }

}
