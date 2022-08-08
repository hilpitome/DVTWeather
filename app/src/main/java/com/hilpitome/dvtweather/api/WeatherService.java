package com.hilpitome.dvtweather.api;

import com.hilpitome.dvtweather.data.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface WeatherService {
    @GET("forecast")
    Call<WeatherResponse> getWeatherForecast(@Path("Appid") String appId);
}
