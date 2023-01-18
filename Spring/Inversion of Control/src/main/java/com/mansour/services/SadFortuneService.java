package com.mansour.services;

import org.springframework.stereotype.Component;

@Component
public class SadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Sad fortune...";
    }
}
