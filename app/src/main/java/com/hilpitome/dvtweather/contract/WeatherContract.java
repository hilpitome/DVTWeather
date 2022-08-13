package com.hilpitome.dvtweather.contract;

import com.hilpitome.dvtweather.data.CurrentWeatherResponse;

public interface WeatherContract {
    interface View {
        void setCurrentWeather(CurrentWeatherResponse data);
        void setWeatherForecast(CurrentWeatherResponse data);
        void showProgress();
        void removeProgress();
    }
    interface Presenter {
        void getCurrentWeather();
        void getForecastedWeather();
        void cleanUp();
        void setCurrentWeatherData(CurrentWeatherResponse data);
        void setWeatherForecast(CurrentWeatherResponse data);
    }
    interface WeatherModel {
        void fetchCurrentWeather();
       void fetchForecastedWeather();
    }
}
