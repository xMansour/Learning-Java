package com.mansour.models;

import com.mansour.FortuneService;

public class BadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Bad Fortune...";
    }
}
