package com.hilpitome.dvtweather.presenter;

import com.hilpitome.dvtweather.contract.WeatherContract;
import com.hilpitome.dvtweather.data.CurrentWeatherResponse;
import com.hilpitome.dvtweather.data.ForecastWeatherResponse;
import com.hilpitome.dvtweather.repository.WeatherRemoteRepository;

import java.lang.ref.WeakReference;

import timber.log.Timber;

public class WeatherPresenter implements WeatherContract.Presenter {
    private WeakReference<WeatherContract.View> view;
    private WeatherContract.WeatherModel repository;

    public WeatherPresenter(WeatherContract.View view){
        this.view = new WeakReference<>(view);
        repository = new WeatherRemoteRepository(this);
    }
    @Override
    public void getCurrentWeather() {
        view.get().showProgress();
        repository.fetchCurrentWeather();
    }

    @Override
    public void getForecastedWeather() {
        view.get().showProgress();
        repository.fetchForecastedWeather();
    }

    @Override
    public void cleanUp() {
        this.view = null;

    }

    @Override
    public void setCurrentWeatherData(CurrentWeatherResponse data) {
        view.get().removeProgress();
        view.get().setCurrentWeather(data);
        Timber.d("current weather in presenter");
    }

    @Override
    public void setWeatherForecast(ForecastWeatherResponse data) {
        view.get().removeProgress();
        view.get().setWeatherForecast(data);
        Timber.d("forecasted weather in presenter");
    }
}
