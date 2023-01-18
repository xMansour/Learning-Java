package com.mansour.services;

import org.springframework.stereotype.Component;

@Component
public class HopeGoodFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Hope Good Fortune...";
    }


}
