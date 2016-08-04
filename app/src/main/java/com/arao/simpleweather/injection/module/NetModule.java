package com.arao.simpleweather.injection.module;

import com.arao.simpleweather.data.net.CallbackConverterFactory;
import com.arao.simpleweather.injection.scope.PerApplication;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    private static final String WHATS_THE_SCORE_API_BASE_URL = "http://api.whatsthescore.com/api/test/";

    @Provides
    @PerApplication
    Retrofit retrofit() {
        return new Retrofit.Builder()
                .baseUrl(WHATS_THE_SCORE_API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

//    @Provides
//    @PerApplication
//    Picasso picasso(Context context) {
//        return Picasso.with(context);
//    }

    @Provides
    CallbackConverterFactory callbackConverterFactory() {
        return new CallbackConverterFactory();
    }

}
