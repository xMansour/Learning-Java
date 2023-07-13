package com.mansour.consumingarestfulwebservice;

import com.mansour.consumingarestfulwebservice.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingARestfulWebServiceApplication {
    private static final String API_URL = "http://www.omdbapi.com/?apikey=xxxxxxxx&t=";
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumingARestfulWebServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConsumingARestfulWebServiceApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder restTemplateBuilder) {
        return restTemplateBuilder.build();
    }

    @Bean
    public CommandLineRunner run(RestTemplate restTemplate) {
        return args -> {
            Movie movie = restTemplate.getForObject(API_URL + "interstellar", Movie.class);
            LOGGER.info("MOVIE_DETAILS: " + movie);
        };
    }

}
