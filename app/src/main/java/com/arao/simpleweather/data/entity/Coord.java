package com.arao.simpleweather.data.entity;

import com.google.gson.annotations.SerializedName;

public class Coord {

    @SerializedName("lon")
    private float lon;
    @SerializedName("lat")
    private float lat;

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }
}
