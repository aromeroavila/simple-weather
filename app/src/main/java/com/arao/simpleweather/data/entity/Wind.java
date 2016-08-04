package com.arao.simpleweather.data.entity;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")
    private float speed;
    @SerializedName("deg")
    private int deg;
    @SerializedName("gust")
    private float gust;

    public int getDeg() {
        return deg;
    }

    public float getGust() {
        return gust;
    }

    public float getSpeed() {
        return speed;
    }
}