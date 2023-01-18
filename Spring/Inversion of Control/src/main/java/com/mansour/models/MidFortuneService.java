package com.mansour.models;

import com.mansour.services.FortuneService;

public class MidFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Mid Fortune...";
    }
}
