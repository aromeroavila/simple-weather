package com.arao.simpleweather.presentation;

import android.app.Application;

import com.arao.simpleweather.injection.component.ApplicationComponent;
import com.arao.simpleweather.injection.component.DaggerApplicationComponent;
import com.arao.simpleweather.injection.module.ApplicationModule;

public class SimpleWeatherApplication extends Application {

    private static SimpleWeatherApplication instance;

    private ApplicationComponent appComponent;

    public SimpleWeatherApplication() {
        instance = this;
    }

    public static SimpleWeatherApplication getApplication() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent
                = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }

}
