package com.hilpitome.dvtweather.repository;


import com.hilpitome.dvtweather.BuildConfig;
import com.hilpitome.dvtweather.api.WeatherService;
import com.hilpitome.dvtweather.contract.WeatherContract;
import com.hilpitome.dvtweather.data.CurrentWeatherResponse;
import com.hilpitome.dvtweather.data.ForecastWeatherResponse;
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
        Call<CurrentWeatherResponse> response = weatherService.getCurrentWeather(-1.550300, 36.938221, BuildConfig.OPEN_WEATHER_API,  "metric");

        response.enqueue(new Callback<CurrentWeatherResponse>() {
            @Override
            public void onResponse(Call<CurrentWeatherResponse> call, Response<CurrentWeatherResponse> response) {
                presenter.setCurrentWeatherData(response.body());
                Timber.i("fetch weather in repository");

            }

            @Override
            public void onFailure(Call<CurrentWeatherResponse> call, Throwable t) {
                call.cancel();
                presenter.setCurrentWeatherData(null);

            }
        });
    }

    @Override
    public void fetchForecastedWeather()  {
        Call<ForecastWeatherResponse> response = weatherService.getWeatherForecast(-1.550300, 36.938221, BuildConfig.OPEN_WEATHER_API, 5, "metric");
        response.enqueue(new Callback<ForecastWeatherResponse>() {
            @Override
            public void onResponse(Call<ForecastWeatherResponse> call, Response<ForecastWeatherResponse> response) {
                presenter.setWeatherForecast(response.body());
            }

            @Override
            public void onFailure(Call<ForecastWeatherResponse> call, Throwable t) {
                call.cancel();
                presenter.setWeatherForecast(null);
            }
        });
    }
}
