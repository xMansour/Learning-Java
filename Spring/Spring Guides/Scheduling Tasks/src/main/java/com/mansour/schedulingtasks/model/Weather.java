package com.mansour.schedulingtasks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private WeatherDetails[] weather;
    @JsonProperty("main")
    private Temperature temperature;
    private String timezone;
    private String name;

    public WeatherDetails[] getWeather() {
        return weather;
    }

    public void setWeather(WeatherDetails[] weather) {
        this.weather = weather;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weather=" + Arrays.toString(weather) +
                ", temperature=" + temperature +
                ", timezone='" + timezone + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
