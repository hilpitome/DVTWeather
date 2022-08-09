package com.hilpitome.dvtweather;

import android.app.Application;
import android.util.Log;

import com.hilpitome.dvtweather.api.WeatherService;
import com.hilpitome.dvtweather.data.WeatherResponse;
import com.hilpitome.dvtweather.utils.Constants;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DVTWeatherApplication extends Application {
    private Retrofit retrofit;

    @Override
    public void onCreate(){
        super.onCreate();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
        Call<WeatherResponse> response = getWeatherService().getWeatherForecast(-1.550300,36.938221,Constants.OPEN_WEATHER_MAP_API_KEY, 2, "metric");
        response.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.i("DVTWeather", "success");
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                call.cancel();
                Log.i("DVTweather", t.getMessage());

            }
        });

        Call<WeatherResponse> currentWeather = getWeatherService().getCurrentWeather(-1.550300,36.938221,Constants.OPEN_WEATHER_MAP_API_KEY, 2, "metric");
        currentWeather.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                Log.i("currentweather", "success");
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                call.cancel();
                Log.i("currentweather", t.getMessage());

            }
        });
    }

    public WeatherService getWeatherService(){
        return retrofit.create(WeatherService.class);
    }
}
