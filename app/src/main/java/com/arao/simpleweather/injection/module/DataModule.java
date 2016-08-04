package com.arao.simpleweather.injection.module;

import com.arao.simpleweather.data.repository.WeatherRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    WeatherRepository matchRepository(WeatherRepository apiMatchRepository) {
        return apiMatchRepository;
    }

}
