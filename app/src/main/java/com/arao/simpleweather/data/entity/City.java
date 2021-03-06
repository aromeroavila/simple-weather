package com.arao.simpleweather.data.entity;

import java.util.ArrayList;
import java.util.List;

public class City implements Comparable<City> {

    private List<Weather> weather = new ArrayList<>();
    private int id;
    private String name;

    private City(Builder builder) {
        name = builder.name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    @Override
    public int compareTo(City city) {
        if (city == null || name == null || city.name == null) {
            return 1;
        }
        return name.compareTo(city.name);
    }

    public static final class Builder {
        private String name;

        public static Builder cityBuilder() {
            return new Builder();
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public City build() {
            return new City(this);
        }
    }
}
