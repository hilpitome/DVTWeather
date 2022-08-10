package com.hilpitome.dvtweather.repository;


import android.util.Log;

import com.hilpitome.dvtweather.api.WeatherService;
import com.hilpitome.dvtweather.contract.WeatherContract;
import com.hilpitome.dvtweather.data.WeatherResponse;
import com.hilpitome.dvtweather.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class WeatherRemoteRepository implements WeatherContract.WeatherModel {
    private Retrofit retrofit;
    private WeatherService weatherService;
    private WeatherContract.Presenter presenter;

    public WeatherRemoteRepository(WeatherContract.Presenter presenter){
        this.presenter = presenter;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        weatherService = retrofit.create(WeatherService.class);
    }

    @Override
    public void fetchCurrentWeather() {
        Call<WeatherResponse> response = weatherService.getCurrentWeather(-1.550300, 36.938221, Constants.OPEN_WEATHER_MAP_API_KEY, 2, "metric");
        Timber.i("after calling fet current weather");

        response.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                presenter.setCurrentWeatherData(response.body());
                Timber.i("fetch weather in repository");

            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                call.cancel();
                presenter.setCurrentWeatherData(null);

            }
        });
    }

    @Override
    public void fetchForecastedWeather()  {
        Call<WeatherResponse> response = weatherService.getWeatherForecast(-1.550300, 36.938221, Constants.OPEN_WEATHER_MAP_API_KEY, 2, "metric");
        response.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                presenter.setWeatherForecast(response.body());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                call.cancel();
                presenter.setWeatherForecast(null);
            }
        });
    }
}
