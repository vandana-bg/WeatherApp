package com.tutorial.weatherapp.view.fragment.locationweather.view;

import com.tutorial.weatherapp.model.fivedayweather.WeatherBean;

public interface WeatherFragmentView {

    void showProgressBar();

    void hideProgressBar();

    void showFeedBackMessage(String message);

    void onSuccessfullyGetCurrentWeather(WeatherBean response);
}
