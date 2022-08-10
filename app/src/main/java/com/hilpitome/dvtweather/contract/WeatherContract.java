package com.hilpitome.dvtweather.contract;

import androidx.lifecycle.LiveData;

import com.hilpitome.dvtweather.data.WeatherResponse;

public interface WeatherContract {
    interface View {
        void setCurrentWeather(WeatherResponse data);
        void setWeatherForecast(WeatherResponse data);
        void showProgress();
        void removeProgress();
    }
    interface Presenter {
        void getCurrentWeather();
        void getForecastedWeather();
        void cleanUp();
        void setCurrentWeatherData(WeatherResponse data);
        void setWeatherForecast(WeatherResponse data);
    }
    interface WeatherModel {
        void fetchCurrentWeather();
       void fetchForecastedWeather();
    }
}
