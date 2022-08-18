package com.hilpitome.dvtweather;

import android.app.Application;
import android.bluetooth.le.PeriodicAdvertisingParameters;
import android.content.Context;

import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;

import java.util.concurrent.TimeUnit;

import timber.log.Timber;

public class DVTWeatherApplication extends Application {

    @Override
    public void onCreate(){
        super.onCreate();
        // This will initialise Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

}
