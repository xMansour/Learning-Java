package com.mansour.springioc.config;

public class BeanOne {
    public BeanOne(BeanTwo beanTwo) {
    }

    @Override
    public String toString() {
        return "BeanOne{}";
    }
}
