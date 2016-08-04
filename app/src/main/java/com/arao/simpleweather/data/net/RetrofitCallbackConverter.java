package com.arao.simpleweather.data.net;

import com.arao.simpleweather.data.execption.WeatherException;
import com.arao.simpleweather.data.repository.DataCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class RetrofitCallbackConverter<T> implements Callback<T> {

    private final DataCallback<T> dataCallback;
    private final String cityName;

    RetrofitCallbackConverter(DataCallback<T> dataCallback, String cityName) {
        this.dataCallback = dataCallback;
        this.cityName = cityName;
    }

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        if (response.isSuccessful()) {
            dataCallback.onSuccess(response.body());
        } else {
            dataCallback.onError(new WeatherException(cityName));
        }
    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        dataCallback.onError(new WeatherException(cityName));
    }
}
