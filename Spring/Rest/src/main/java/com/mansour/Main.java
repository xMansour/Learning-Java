package com.mansour;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mansour.entities.User;

import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream("jsonData.json");

        User user = objectMapper.readValue(inputStream, User.class);
        System.out.println("user = " + user);
        for (String language :
                user.getLanguages()) {
            System.out.println("language = " + language);
        }

    }
}
