package com.tutorial.weatherapp.web;

import com.google.gson.JsonObject;
import com.tutorial.weatherapp.model.fivedayweather.WeatherBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mobile on 3/15/2017.
 */

public interface WebApi {

    @GET("forecast.json?")
    Call<WeatherBean> getWeather(@Query("q") String lat_lon,
                                 @Query("key") String key,
                                 @Query("days") String days);


    @GET("place/nearbysearch/json?key={key}&sensor=false&location={latitude},{longitude}&radius=47022&keyword={text}")
    Call<JsonObject> getNearByPlaces(@Path("key") String key,
                                     @Path("latitude") String latitude,
                                     @Path("longitude") String longitude,
                                     @Path("text") String param);
}
