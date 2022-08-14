package com.hilpitome.dvtweather.contract;

import com.hilpitome.dvtweather.data.CurrentWeatherResponse;
import com.hilpitome.dvtweather.data.ForecastWeatherResponse;

public interface WeatherContract {
    interface View {
        void setCurrentWeather(CurrentWeatherResponse data);
        void setWeatherForecast(ForecastWeatherResponse data);
        void showProgress();
        void removeProgress();
    }
    interface Presenter {
        void getCurrentWeather();
        void getForecastedWeather();
        void cleanUp();
        void setCurrentWeatherData(CurrentWeatherResponse data);
        void setWeatherForecast(ForecastWeatherResponse data);
    }
    interface WeatherModel {
        void fetchCurrentWeather();
       void fetchForecastedWeather();
    }
}
