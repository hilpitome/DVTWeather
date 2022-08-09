package com.hilpitome.dvtweather.api;

import com.hilpitome.dvtweather.data.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("forecast")
    Call<WeatherResponse> getWeatherForecast(@Query("lat") double lat, @Query("lon") double lon,
                                             @Query("appid") String appId, @Query("cnt") int cnt,
                                             @Query("units") String units);
    @GET("weather")
    Call<WeatherResponse> getCurrentWeather(@Query("lat") double lat, @Query("lon") double lon,
                                            @Query("appid") String appId, @Query("cnt") int cnt,
                                            @Query("units") String units);
}
