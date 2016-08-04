package com.arao.simpleweather.data.net;

import com.arao.simpleweather.data.entity.City;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface OpenWeatherMapApi {

    @GET("weather")
    Call<City> weatherForCityWithName(@Query("q") String cityName, @Query("APPID") String apiKey);

}
