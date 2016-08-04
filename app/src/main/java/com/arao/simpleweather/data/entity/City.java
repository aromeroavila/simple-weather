package com.arao.simpleweather.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class City {

    @SerializedName("coord")
    private Coord coord;
    @SerializedName("weather")
    private List<Weather> weather = new ArrayList<Weather>();
    @SerializedName("base")
    private String base;
    @SerializedName("main")
    private Main main;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("rain")
    private Rain rain;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("dt")
    private int dt;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("cod")
    private int cod;

    public String getBase() {
        return base;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public int getCod() {
        return cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public int getDt() {
        return dt;
    }

    public int getId() {
        return id;
    }

    public Main getMain() {
        return main;
    }

    public String getName() {
        return name;
    }

    public Rain getRain() {
        return rain;
    }

    public Sys getSys() {
        return sys;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public Wind getWind() {
        return wind;
    }
}
