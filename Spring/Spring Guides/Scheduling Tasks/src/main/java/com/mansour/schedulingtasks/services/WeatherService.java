package com.mansour.schedulingtasks.services;

import com.mansour.schedulingtasks.SchedulingTasksApplication;
import com.mansour.schedulingtasks.model.City;
import com.mansour.schedulingtasks.model.Weather;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class WeatherService {
    private static final Logger log = LoggerFactory.getLogger(SchedulingTasksApplication.class);
    private final String GEOCODING_API;
    @Autowired
    private RestTemplate restTemplate;
    @Value("${appid}")
    private String appId;

    private String CURRENT_WEATHER_DATA_BASE_URL;

    public WeatherService(@Value("${GEOCODING_API}") String geocodingApi, @Value("${q}") String cityName, @Value("${limit}") String limit, @Value("${appid}") String appId, @Value("${CURRENT_WEATHER_DATA_API}") String currentWeatherDataApi) {
        GEOCODING_API = geocodingApi + "?q=" + cityName + "&limit=" + limit + "&appid=" + appId;
        CURRENT_WEATHER_DATA_BASE_URL = currentWeatherDataApi;
        log.info("GEOCODING_REQUEST_URL:" + GEOCODING_API);
    }

    @Scheduled(fixedRate = 5000)
    public void getTemperature() {
        City[] city = restTemplate.getForObject(GEOCODING_API, City[].class);
        if (city != null && city.length > 0) {
            log.info("CITY: " + city[0]);
            String CURRENT_WEATHER_DATA_API = CURRENT_WEATHER_DATA_BASE_URL + "?lat=" + city[0].getLat() + "&lon=" + city[0].getLon() + "&units=metric" + "&appid=" + appId;
            log.info("CURRENT_WEATHER_DATA_API:" + CURRENT_WEATHER_DATA_API);
            Weather weather = restTemplate.getForObject(CURRENT_WEATHER_DATA_API, Weather.class);
            log.info("weather:" + weather);
            log.info("==========================================================================");
        }

    }
}
