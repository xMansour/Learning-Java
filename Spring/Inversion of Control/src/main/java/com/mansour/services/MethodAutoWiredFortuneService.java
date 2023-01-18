package com.mansour.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MethodAutoWiredFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Autowired method fortune service";
    }
}
