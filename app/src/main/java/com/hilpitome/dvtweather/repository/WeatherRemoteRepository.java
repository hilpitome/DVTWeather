package com.hilpitome.dvtweather.repository;

import androidx.lifecycle.LiveData;

import com.hilpitome.dvtweather.data.WeatherResponse;

public class WeatherRemoteRepository implements WeatherRepository{
    @Override
    public LiveData<WeatherResponse> fetchCurrentWeather() {
        return null;
    }

    @Override
    public LiveData<WeatherResponse> fetchForecastedWeather() {
        return null;
    }
}
