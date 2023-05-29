package com.mansour.springrest.entites;

public class Address {
    private String cityName;
    private String countryName;
    private String zipCode;

    public Address(String cityName, String countryName, String zipCode) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
