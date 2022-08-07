package com.hilpitome.dvtweather.repository;

import androidx.lifecycle.LiveData;

import com.hilpitome.dvtweather.data.WeatherResponse;

public interface WeatherRepository {
    LiveData<WeatherResponse> fetchCurrentWeather();
    LiveData<WeatherResponse> fetchForecastedWeather();
}
