package com.hilpitome.dvtweather.presenter;

import com.hilpitome.dvtweather.contract.WeatherContract;

import java.lang.ref.WeakReference;

public class WeatherPresenter implements WeatherContract.Presenter {
    private WeakReference<WeatherContract.View> view;

    public WeatherPresenter(WeatherContract.View view){
        this.view = new WeakReference<>(view);
    }
    @Override
    public void getCurrentWeather() {
        view.get().showProgress();

    }

    @Override
    public void getForecastedWeather() {

    }

    @Override
    public void cleanUp() {
        this.view = null;

    }
}
