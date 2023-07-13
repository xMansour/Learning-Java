package com.mansour.schedulingtasks.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Temperature(String temp, String feels_like, String temp_min, String temp_max, String pressure, String humidity) {
}
