package com.mansour.services;

public class BadFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "Bad Fortune...";
    }
}
