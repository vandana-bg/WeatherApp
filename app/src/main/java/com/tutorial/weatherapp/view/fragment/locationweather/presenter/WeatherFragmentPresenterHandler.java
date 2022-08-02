package com.tutorial.weatherapp.view.fragment.locationweather.presenter;


public interface WeatherFragmentPresenterHandler {

   void getCurrentWeather(String lat, String lon, String key);

}
