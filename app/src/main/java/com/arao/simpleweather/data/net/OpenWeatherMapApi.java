package com.arao.simpleweather.data.net;

import com.arao.simpleweather.data.entity.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapApi {

    String OPEN_WEATHER_MAP_API_BASE_URL = "http://api.openweathermap.org/data/2.5/";
    String OPEN_WEATHER_MAP_ICON_URL = "http://openweathermap.org/img/w//";

    @GET("weather")
    Call<City> weatherForCityWithName(@Query("q") String cityName, @Query("APPID") String apiKey);

}
