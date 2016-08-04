package com.arao.simpleweather.data.net;

import com.arao.simpleweather.data.repository.DataCallback;

public class CallbackConverterFactory {

    <T> RetrofitCallbackConverter<T> getRetrofitCallbackConverter(DataCallback<T> dataCallback, String cityName) {
        return new RetrofitCallbackConverter<>(dataCallback, cityName);
    }

}
