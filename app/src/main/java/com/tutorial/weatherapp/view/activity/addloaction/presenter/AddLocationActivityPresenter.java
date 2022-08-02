package com.tutorial.weatherapp.view.activity.addloaction.presenter;
import com.tutorial.weatherapp.view.activity.addloaction.view.AddLocationActivityView;
import com.tutorial.weatherapp.web.WebServices;
import com.tutorial.weatherapp.web.handler.NearByPlacesHandler;

public class AddLocationActivityPresenter implements AddLocationActivityPresenterHandler {
    AddLocationActivityView view;

    public AddLocationActivityPresenter(AddLocationActivityView view) {
        this.view = view;
    }

    @Override
    public void getData(String apiKey, String latitude, String longitude, String text) {
        WebServices.getInstance().getNearByPlaces(new NearByPlacesHandler() {
            @Override
            public void onSuccess(String response) {
                view.onSuccessfullyGetPlace(response);
            }


            @Override
            public void onError(String message) {
                view.onFailure(message);
            }
        }, apiKey, latitude, longitude, text);
    }

}
