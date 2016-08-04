package com.arao.simpleweather.presentation.presenter;

import com.arao.simpleweather.data.entity.City;
import com.arao.simpleweather.data.execption.WeatherException;
import com.arao.simpleweather.data.repository.DataCallback;
import com.arao.simpleweather.data.repository.WeatherRepository;
import com.arao.simpleweather.presentation.view.HomeView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.sort;

public class HomePresenter implements DataCallback<City> {

    private final WeatherRepository matchRepository;

    private List<City> results;

    private HomeView homeView;

    public HomePresenter(WeatherRepository weatherRepository) {
        this.matchRepository = weatherRepository;
        this.results = new ArrayList<>();
    }

    public void init(HomeView homeView) {
        this.homeView = homeView;

        matchRepository.weatherForCities(initialiseCityNameList(), this);
    }

    public void refresh() {
        results = new ArrayList<>();
        matchRepository.weatherForCities(initialiseCityNameList(), this);
    }

    @Override
    public void onSuccess(City result) {
        results.add(result);
        sort(results);
        homeView.displayWeatherForCities(results);
    }

    @Override
    public void onError(WeatherException ex) {
        City errorCity = City.Builder.cityBuilder()
                .name(ex.getCity())
                .build();
        results.add(errorCity);
        homeView.displayWeatherForCities(results);
    }

    private List<String> initialiseCityNameList() {
        List<String> cityNames = new ArrayList<>();
        cityNames.add("London");
        cityNames.add("Nairobi");
        cityNames.add("Barcelona");
        cityNames.add("Paris");
        cityNames.add("Lima");
        cityNames.add("Beijing");
        cityNames.add("Moscow");
        cityNames.add("Melbourne");
        cityNames.add("Athens");
        cityNames.add("Montreal");

        return cityNames;
    }

}
