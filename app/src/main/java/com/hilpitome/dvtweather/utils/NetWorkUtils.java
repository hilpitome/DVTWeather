package com.hilpitome.dvtweather.utils;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.hilpitome.dvtweather.DVTWeatherApplication;

import timber.log.Timber;

public class NetWorkUtils {
    public static boolean isNetworkAvailable() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) DVTWeatherApplication.getDVTWeatherApplication()
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();

        } catch (Exception e) {
            Timber.e(e);

        }

        return false;
    }
}
