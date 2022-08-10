package com.hilpitome.dvtweather;

import android.app.Application;
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
