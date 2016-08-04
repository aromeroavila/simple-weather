package com.arao.simpleweather.injection.module;

import android.content.Context;

import com.arao.simpleweather.data.net.CallbackConverterFactory;
import com.arao.simpleweather.data.net.OpenWeatherMapApi;
import com.arao.simpleweather.injection.scope.PerApplication;
import com.squareup.picasso.Picasso;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.arao.simpleweather.data.net.OpenWeatherMapApi.OPEN_WEATHER_MAP_API_BASE_URL;

@Module
public class NetModule {

    @Provides
    @PerApplication
    Retrofit retrofit() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        return new Retrofit.Builder()
                .baseUrl(OPEN_WEATHER_MAP_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }

    @Provides
    @PerApplication
    Picasso picasso(Context context) {
        return Picasso.with(context);
    }

    @Provides
    CallbackConverterFactory callbackConverterFactory() {
        return new CallbackConverterFactory();
    }


}
