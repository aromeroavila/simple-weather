package com.arao.simpleweather.data.entity;

import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("type")
    private int type;
    @SerializedName("id")
    private int id;
    @SerializedName("message")
    private float message;
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private int sunrise;
    @SerializedName("sunset")
    private int sunset;

    public String getCountry() {
        return country;
    }

    public int getId() {
        return id;
    }

    public float getMessage() {
        return message;
    }

    public int getSunrise() {
        return sunrise;
    }

    public int getSunset() {
        return sunset;
    }

    public int getType() {
        return type;
    }
}
