package com.arao.simpleweather.injection.module;

import android.content.Context;
import android.content.res.Resources;

import com.arao.simpleweather.presentation.SimpleWeatherApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final SimpleWeatherApplication application;

    public ApplicationModule(SimpleWeatherApplication application) {
        this.application = application;
    }

    @Provides
    Resources resources() {
        return application.getResources();
    }

    @Provides
    Context appContext() {
        return application;
    }

}
