package com.arao.simpleweather.presentation.presenter;

import com.arao.simpleweather.data.entity.City;
import com.arao.simpleweather.data.execption.WeatherException;
import com.arao.simpleweather.data.repository.WeatherRepository;
import com.arao.simpleweather.presentation.view.HomeView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class HomePresenterTest {

    @Rule
    public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private WeatherRepository weatherRepository;
    @Mock
    private HomeView homeView;
    @Mock
    private City city;
    @Mock
    private WeatherException weatherException;

    @Captor
    private ArgumentCaptor<List<String>> cityNameListCaptor;
    @Captor
    private ArgumentCaptor<List<City>> cityListCaptor;


    @InjectMocks
    private HomePresenter homePresenter;

    @Before
    public void setup() {
        homePresenter.init(homeView);
    }

    @Test
    public void shouldRequestWeatherFor10Cities_whenInitialising() {
        verify(weatherRepository).weatherForCities(cityNameListCaptor.capture(), eq(homePresenter));
        List<String> value = cityNameListCaptor.getValue();
        assertEquals(10, value.size());
    }

    @Test
    public void shouldRequestWeatherFor10Cities_whenRefreshing() {
        homePresenter.refresh();

        verify(weatherRepository, times(2)).weatherForCities(cityNameListCaptor.capture(), eq(homePresenter));
        List<String> value = cityNameListCaptor.getValue();
        assertEquals(10, value.size());
    }

    @Test
    public void shouldDisplayResultsOnUi_whenSuccessfulDataResponseReceived() {
        homePresenter.onSuccess(city);

        verify(homeView).displayWeatherForCities(cityListCaptor.capture());
        List<City> value = cityListCaptor.getValue();
        assertTrue(value.contains(city));
    }

    @Test
    public void shouldDisplayResultsOnUi_whenErrorDataResponseReceived() {
        when(weatherException.getCity()).thenReturn("example");

        homePresenter.onError(weatherException);

        verify(homeView).displayWeatherForCities(cityListCaptor.capture());
        List<City> value = cityListCaptor.getValue();
        assertEquals("example", value.get(0).getName());
    }

}