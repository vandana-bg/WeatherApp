package com.tutorial.weatherapp.view.fragment.locationweather.presenter;


import com.tutorial.weatherapp.model.fivedayweather.WeatherBean;
import com.tutorial.weatherapp.view.fragment.locationweather.view.WeatherFragmentView;
import com.tutorial.weatherapp.web.WebServices;
import com.tutorial.weatherapp.web.handler.CurrentWeatherHandler;

public class WeatherFragmentPresenter implements WeatherFragmentPresenterHandler {
    WeatherFragmentView view;

    public WeatherFragmentPresenter(WeatherFragmentView view) {
        this.view = view;
    }

    @Override
    public void getCurrentWeather(String lat, String lon, String key) {
        view.showProgressBar();
        WebServices.getInstance().getCurrentWeatherData(new CurrentWeatherHandler() {
            @Override
            public void onSuccess(WeatherBean response) {
                view.hideProgressBar();
                view.onSuccessfullyGetCurrentWeather(response);

            }

            @Override
            public void onError(String message) {
                view.hideProgressBar();
                view.showFeedBackMessage(message);
            }
        },lat,lon,key);
    }

}
