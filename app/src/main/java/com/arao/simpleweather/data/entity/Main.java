package com.arao.simpleweather.data.entity;

import com.google.gson.annotations.SerializedName;

public class Main {

    @SerializedName("temp")
    private float temp;
    @SerializedName("pressure")
    private int pressure;
    @SerializedName("humidity")
    private int humidity;
    @SerializedName("temp_min")
    private float tempMin;
    @SerializedName("temp_max")
    private float tempMax;

    public int getHumidity() {
        return humidity;
    }

    public int getPressure() {
        return pressure;
    }

    public float getTemp() {
        return temp;
    }

    public float getTempMax() {
        return tempMax;
    }

    public float getTempMin() {
        return tempMin;
    }
}
