package com.arao.simpleweather.data.repository;

import com.arao.simpleweather.data.execption.WeatherException;

public interface DataCallback<T> {

    void onSuccess(T result);

    void onError(WeatherException ex);

}
