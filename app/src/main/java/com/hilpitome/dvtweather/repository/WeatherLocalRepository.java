package com.hilpitome.dvtweather.repository;

import androidx.lifecycle.LiveData;

import com.hilpitome.dvtweather.data.WeatherResponse;

public class WeatherLocalRepository implements WeatherRepository{
    @Override
    public LiveData<WeatherResponse> fetchCurrentWeather() {
        return null;
    }

    @Override
    public LiveData<WeatherResponse> fetchForecastedWeather() {
        return null;
    }
}
