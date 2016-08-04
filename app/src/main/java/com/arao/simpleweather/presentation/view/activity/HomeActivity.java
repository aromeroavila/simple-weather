package com.arao.simpleweather.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.arao.simpleweather.R;
import com.arao.simpleweather.data.entity.City;
import com.arao.simpleweather.injection.component.ActivityComponent;
import com.arao.simpleweather.presentation.SimpleWeatherApplication;
import com.arao.simpleweather.presentation.presenter.HomePresenter;
import com.arao.simpleweather.presentation.view.HomeView;
import com.arao.simpleweather.presentation.view.adapter.CityWeatherAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @BindView(R.id.loading_layout)
    LinearLayout loadingLayout;
    @BindView(R.id.city_weather_list)
    ListView weatherList;

    @Inject
    HomePresenter homePresenter;
    @Inject
    CityWeatherAdapter cityWeatherAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        resolveDependencies();

        weatherList.setAdapter(cityWeatherAdapter);
        homePresenter.init(this);
    }

    private void resolveDependencies() {
        ActivityComponent activityComponent = SimpleWeatherApplication
                .getApplication()
                .getAppComponent()
                .activityComponent();
        activityComponent.resolveDependenciesFor(this);
    }

    @Override
    public void displayWeatherForCities(List<City> cities) {
        removeLoadingIfDisplayed();
        cityWeatherAdapter.setData(cities);
    }

    private void removeLoadingIfDisplayed() {
        if (loadingLayout.getVisibility() == VISIBLE) {
            loadingLayout.setVisibility(GONE);
        }
    }
}
