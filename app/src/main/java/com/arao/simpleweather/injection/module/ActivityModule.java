package com.arao.simpleweather.injection.module;


import android.content.res.Resources;

import com.arao.simpleweather.data.repository.WeatherRepository;
import com.arao.simpleweather.presentation.presenter.HomePresenter;
import com.arao.simpleweather.presentation.view.adapter.CityWeatherAdapter;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    HomePresenter homePresenter(WeatherRepository weatherRepository) {
        return new HomePresenter(weatherRepository);
    }

    @Provides
    CityWeatherAdapter cityWeatherAdapter(Resources resources, Picasso picasso) {
        return new CityWeatherAdapter(resources, picasso);
    }

}
