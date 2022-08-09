package com.hilpitome.dvtweather.contract;

import com.hilpitome.dvtweather.data.WeatherResponse;

public interface WeatherContract {
    interface View {
        void setCurrentWeather(WeatherResponse data);
        void setWeatherForecast(WeatherResponse data);
        void showProgress();
        void removeProgres();
    }
    interface Presenter {
        void getCurrentWeather();
        void getForecastedWeather();
        void cleanUp();
    }
    interface Interacter {
        void getCurrentWeather();
        void getForecastedWeather();
    }
}
