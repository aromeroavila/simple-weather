package com.arao.simpleweather.data.execption;

public class WeatherException extends Exception {

    private final String city;

    public WeatherException(String city) {
        this.city = city;
    }

}
