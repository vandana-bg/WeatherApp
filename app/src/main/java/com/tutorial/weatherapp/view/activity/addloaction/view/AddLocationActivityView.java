package com.tutorial.weatherapp.view.activity.addloaction.view;

public interface AddLocationActivityView {

    void onSuccessfullyGetPlace(String response);

    void onFailure(String response);
}
