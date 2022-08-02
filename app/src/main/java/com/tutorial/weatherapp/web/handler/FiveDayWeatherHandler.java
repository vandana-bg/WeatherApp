package com.tutorial.weatherapp.web.handler;


import com.tutorial.weatherapp.model.fivedayweather.WeatherBean;

public interface FiveDayWeatherHandler extends BaseHandler {
    void onSuccess(WeatherBean response);

}
