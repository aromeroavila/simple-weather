package com.arao.simpleweather.presentation.view.adapter;

import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.arao.simpleweather.R;
import com.arao.simpleweather.data.entity.City;
import com.arao.simpleweather.data.entity.Weather;
import com.arao.simpleweather.data.net.OpenWeatherMapApi;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CityWeatherAdapter extends BaseAdapter {

    private static final String PNG_IMAGE_EXTENSION = ".png";

    private final Resources resources;
    private final Picasso picasso;

    private List<City> cities;

    public CityWeatherAdapter(Resources resources, Picasso picasso) {
        this.resources = resources;
        this.picasso = picasso;
    }

    public void setData(List<City> matches) {
        this.cities = matches;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        int size = 0;
        if (cities != null) {
            size = cities.size();
        }
        return size;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.city_weather_item, viewGroup, false);
            viewHolder = setupViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        final City city = cities.get(i);
        fillViewHolderData(viewHolder, city);

        return view;
    }

    @Override
    public Object getItem(int i) {
        return cities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return cities.get(i).getId();
    }

    @NonNull
    private ViewHolder setupViewHolder(View view) {
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.cityName = (TextView) view.findViewById(R.id.city_name);
        viewHolder.weatherDescription = (TextView) view.findViewById(R.id.weather_description);
        viewHolder.weatherIcon = (ImageView) view.findViewById(R.id.weather_icon);
        return viewHolder;
    }

    private void fillViewHolderData(ViewHolder viewHolder, City city) {
        viewHolder.cityName.setText(city.getName());
        List<Weather> weatherList = city.getWeather();

        if (city.getId() != -1 && weatherList != null && weatherList.size() > 0) {
            Weather weather = weatherList.get(0);
            viewHolder.weatherDescription.setText(weather.getDescription());
            String iconUrl = buildIconUrl(weather.getIcon());
            picasso.load(iconUrl).into(viewHolder.weatherIcon);
        } else {
            viewHolder.weatherDescription.setText(resources.getString(R.string.error_city_weather));
        }
    }

    @SuppressWarnings("StringBufferReplaceableByString")
    @NonNull
    private String buildIconUrl(String iconRelativeUrl) {
        StringBuilder iconUrlBuilder = new StringBuilder();
        iconUrlBuilder.append(OpenWeatherMapApi.OPEN_WEATHER_MAP_ICON_URL);
        iconUrlBuilder.append(iconRelativeUrl);
        iconUrlBuilder.append(PNG_IMAGE_EXTENSION);
        return iconUrlBuilder.toString();
    }

    private class ViewHolder {
        TextView cityName;
        TextView weatherDescription;
        ImageView weatherIcon;
    }
}
