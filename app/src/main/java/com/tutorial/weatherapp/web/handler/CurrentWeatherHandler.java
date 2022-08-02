package com.tutorial.weatherapp.web.handler;


import com.tutorial.weatherapp.model.fivedayweather.WeatherBean;

public interface CurrentWeatherHandler extends BaseHandler {
    void onSuccess(WeatherBean response);

}
