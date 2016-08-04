package com.arao.simpleweather.data.net;

import com.arao.simpleweather.BuildConfig;
import com.arao.simpleweather.data.entity.City;
import com.arao.simpleweather.data.repository.DataCallback;
import com.arao.simpleweather.data.repository.WeatherRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ApiMatchRepository implements WeatherRepository {

    private final Retrofit retrofit;
    private final CallbackConverterFactory callbackConverterFactory;

    @Inject
    ApiMatchRepository(Retrofit retrofit, CallbackConverterFactory callbackConverterFactory) {
        this.retrofit = retrofit;
        this.callbackConverterFactory = callbackConverterFactory;
    }

    @Override
    public void weatherForCities(List<String> cityNames, DataCallback<City> callback) {
        OpenWeatherMapApi service = retrofit.create(OpenWeatherMapApi.class);

        for (String cityName : cityNames) {
            Call<City> weatherCall = service.weatherForCityWithName(cityName, BuildConfig.OPEN_WEATHER_MAP_API_KEY);
            weatherCall.enqueue(callbackConverterFactory.getRetrofitCallbackConverter(callback, cityName));
        }
    }
}
