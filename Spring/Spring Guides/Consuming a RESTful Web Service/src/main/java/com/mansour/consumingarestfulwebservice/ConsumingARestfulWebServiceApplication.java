package com.mansour.consumingarestfulwebservice;

import com.mansour.consumingarestfulwebservice.model.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumingARestfulWebServiceApplication {
    private final String REQUEST_URL;
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumingARestfulWebServiceApplication.class);

    public ConsumingARestfulWebServiceApplication(@Value("${API_URL}") String API_URL, @Value("${MOVIE_NAME}") String MOVIE_NAME,
                                                  @Value("${API_KEY}") String API_KEY) {
        this.REQUEST_URL = API_URL + API_KEY + "&t=" + MOVIE_NAME;
    }

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
            Movie movie = restTemplate.getForObject(REQUEST_URL, Movie.class);
            LOGGER.info("MOVIE_DETAILS: " + movie);
        };
    }

}
