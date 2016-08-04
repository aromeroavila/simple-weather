package com.arao.simpleweather.presentation.presenter;

import com.arao.simpleweather.data.entity.City;
import com.arao.simpleweather.data.execption.WeatherException;
import com.arao.simpleweather.data.repository.DataCallback;
import com.arao.simpleweather.data.repository.WeatherRepository;
import com.arao.simpleweather.presentation.view.HomeView;

import java.util.ArrayList;
import java.util.List;

public class HomePresenter implements DataCallback<City> {

    private final WeatherRepository matchRepository;
    private List<String> cityNames;
    private List<City> results;

    private HomeView homeView;

    public HomePresenter(WeatherRepository weatherRepository) {
        this.matchRepository = weatherRepository;
        this.results = new ArrayList<>();
    }

    public void init(HomeView homeView) {
        this.homeView = homeView;

        initialiseCityNameList();
        matchRepository.weatherForCities(cityNames, this);
    }

    @Override
    public void onSuccess(City result) {
        results.add(result);
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

    private void initialiseCityNameList() {
        cityNames = new ArrayList<>();
        cityNames.add("London");
        cityNames.add("Madrid");
        cityNames.add("Barcelona");
        cityNames.add("Paris");
        cityNames.add("New York");
        cityNames.add("Pekin");
        cityNames.add("Madrid");
        cityNames.add("Barcelona");
        cityNames.add("Paris");
        cityNames.add("New York");
    }

}
