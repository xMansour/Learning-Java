package com.mansour.config;

import com.mansour.models.Coach;
import com.mansour.models.FootballCoach;
import com.mansour.services.FortuneService;
import com.mansour.services.HappyFortuneService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan("com.mansour")
@PropertySource("classpath:config.properties")
public class SportConfig {

    @Bean
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }
    @Bean
    public Coach footBallCoach(){
        return new FootballCoach(happyFortuneService());
    }


    //This fixes the values returned from fields annotated with @Value
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

}
