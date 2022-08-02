package com.tutorial.weatherapp;

import android.app.Application;

import com.tutorial.weatherapp.util.SharedPref;
import com.tutorial.weatherapp.web.WebServices;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MyApp extends Application {

    public static double latitude;
    public static double longitude;
    public static String cityName;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        new WebServices();
        new SharedPref(this);
    }
}
