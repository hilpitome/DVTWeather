package com.hilpitome.dvtweather.api;

import com.hilpitome.dvtweather.data.CurrentWeatherResponse;
import com.hilpitome.dvtweather.data.ForecastWeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("forecast")
    Call<ForecastWeatherResponse> getWeatherForecast(@Query("lat") double lat, @Query("lon") double lon,
                                                     @Query("appid") String appId, @Query("cnt") int cnt,
                                                     @Query("units") String units);
    @GET("weather")
    Call<CurrentWeatherResponse> getCurrentWeather(@Query("lat") double lat, @Query("lon") double lon,
                                                   @Query("appid") String appId,
                                                   @Query("units") String units);
}
