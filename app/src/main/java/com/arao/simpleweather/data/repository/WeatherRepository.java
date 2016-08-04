package com.arao.simpleweather.data.repository;

import com.arao.simpleweather.data.entity.City;

import java.util.List;

public interface WeatherRepository {

    /**
     * Given a list of weatherForCityWithName names, it returns the weather data for each of them one per one
     * to the provided callback.
     *
     * @param cityNames List of names of the cities to get the weather data
     * @param callback  Called one time per each of the cities queried
     */
    void weatherForCities(List<String> cityNames, DataCallback<City> callback);

}
