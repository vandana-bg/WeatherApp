package com.tutorial.weatherapp.view.fragment.locationweather;

import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.tutorial.weatherapp.R;
import com.tutorial.weatherapp.model.fivedayweather.WeatherBean;
import com.tutorial.weatherapp.util.Constants;
import com.tutorial.weatherapp.util.FrequentFunction;
import com.tutorial.weatherapp.util.SharedPref;
import com.tutorial.weatherapp.view.fragment.BaseFragment;
import com.tutorial.weatherapp.view.fragment.locationweather.adapter.FiveDayWeatherAdapter;
import com.tutorial.weatherapp.view.fragment.locationweather.presenter.WeatherFragmentPresenter;
import com.tutorial.weatherapp.view.fragment.locationweather.presenter.WeatherFragmentPresenterHandler;
import com.tutorial.weatherapp.view.fragment.locationweather.view.WeatherFragmentView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class FragmentWeather extends BaseFragment implements WeatherFragmentView {
    @BindView(R.id.textViewLastUpdate)
    TextView textViewLastUpdate;
    @BindView(R.id.textViewCityAddress)
    TextView textViewCityAddress;
    @BindView(R.id.textViewTime)
    TextView textViewTime;
    @BindView(R.id.textViewMaxMin)
    TextView textViewMaxMin;
    @BindView(R.id.textViewWeather)
    TextView textViewWeather;
    @BindView(R.id.textViewCityFeelsLike)
    TextView textViewCityFeelsLike;
    @BindView(R.id.textViewWeatherInfo)
    TextView textViewWeatherInfo;
    @BindView(R.id.textViewPreciption)
    TextView textViewPreciption;
    @BindView(R.id.textViewPressure)
    TextView textViewPressure;
    @BindView(R.id.textViewVisibility)
    TextView textViewVisibility;
    @BindView(R.id.textViewCloudCover)
    TextView textViewCloudCover;
    @BindView(R.id.textViewUvIndex)
    TextView textViewUvIndex;
    @BindView(R.id.textViewHumidity)
    TextView textViewHumidity;
    @BindView(R.id.textViewSunrise)
    TextView textViewSunrise;
    @BindView(R.id.textViewWind)
    TextView textViewWind;
    @BindView(R.id.textViewSunset)
    TextView textViewSunset;
    @BindView(R.id.recyclerViewFiveDays)
    RecyclerView recyclerViewFiveDays;
    Unbinder unbinder;
    @BindView(R.id.imageViewWeather)
    ImageView imageViewWeather;
    @BindView(R.id.linearLayout1)
    LinearLayout linearLayout1;
    @BindView(R.id.adView)
    AdView adView;
    private WeatherFragmentPresenterHandler mPresenter;
    private String latitude, longitude;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FragmentWeather.
     */
    public static FragmentWeather newInstance() {
        return new FragmentWeather();
    }

    public FragmentWeather() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_weather, container, false);
        unbinder = ButterKnife.bind(this, view);
        mPresenter = new WeatherFragmentPresenter(this);

        MobileAds.initialize(getActivity(),
                getActivity().getString(R.string.ad_id));
        AdRequest adRequest =  new AdRequest.Builder()
                .build();
        adView.loadAd(adRequest);


        if (SharedPref.getBoolean(Constants.IS_PREMIUM))
            adView.setVisibility(View.GONE);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewFiveDays.setLayoutManager(linearLayoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),
                linearLayoutManager.getOrientation());
        recyclerViewFiveDays.addItemDecoration(dividerItemDecoration);
        recyclerViewFiveDays.setHasFixedSize(true);

        Bundle bundle = getArguments();
        latitude = bundle.getString("latitude");
        longitude = bundle.getString("longitude");

        mPresenter.getCurrentWeather(latitude,
                longitude,
                Constants.APIXXU_API_KEY);

        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void showProgressBar() {
        showLoadingDialog();
    }

    @Override
    public void hideProgressBar() {
        hideLoadingDialog();
    }

    @Override
    public void showFeedBackMessage(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onSuccessfullyGetCurrentWeather(WeatherBean response) {

        String imageUrl = "http:" + response.current.condition.icon.replace("64x64",
                "128x128");

        Glide.with(getActivity())
                .load(imageUrl)
                .into(imageViewWeather);

        textViewWeatherInfo.setText(response.current.condition.text);
        textViewCityAddress.setText(response.location.name);

        if (SharedPref.getDataFromPref(Constants.TIME_FORMAT).equalsIgnoreCase(Constants.TIME_FORMAT_24)) {
            textViewTime.setText(FrequentFunction.get12HrsByDate(response.location.
                    localtime));
            textViewSunset.setText("Sunset: " + FrequentFunction.get24hrsTime(response.
                    forecast.forecastday.get(0)
                    .astro.sunset));
            textViewSunrise.setText("Sunrise: " + FrequentFunction.get24hrsTime(response
                    .forecast.forecastday.get(0).astro.sunrise));
        } else {
            Log.d("locationTIme", response.location.localtime_epoch + "");
            textViewTime.setText(FrequentFunction.get12HrsByDate(
                    response.location.localtime));
            textViewSunset.setText("Sunset: " + response.forecast.forecastday
                    .get(0).astro.sunset);
            textViewSunrise.setText("Sunrise: " + response.forecast.forecastday
                    .get(0).astro.sunrise);
        }


        if (SharedPref.getDataFromPref(Constants.DATE_FORMAT).equalsIgnoreCase(Constants.DATE_FORMAT_API))
            textViewLastUpdate.setText("Last Update: " +
                    response.current.last_updated);
        else {
            textViewLastUpdate.setText("Last Update: " +
                    FrequentFunction.getCurrentDate());
        }

        if (SharedPref.getDataFromPref(Constants.TEMPERATURE).equalsIgnoreCase(Constants.TEMPERATURE_F)) {
            textViewMaxMin.setText(response.forecast.forecastday.get(0)
                    .day.maxtemp_f + "/" + response.forecast.forecastday.get(0)
                    .day.mintemp_f + "°F");

            textViewWeather.setText(response.current.temp_f + "°F");

            textViewCityFeelsLike.setText("Feels Like: " +
                    (response.current.feelslike_f + "°F"));
        } else {
            textViewMaxMin.setText(response.forecast.forecastday.get(0)
                    .day.maxtemp_c + "/" + response.forecast.forecastday.get(0)
                    .day.mintemp_c + "°C");

            textViewWeather.setText(response.current.temp_c + "°C");

            textViewCityFeelsLike.setText("Feels Like: " +
                    (response.current.feelslike_c + "°C"));
        }

        if (SharedPref.getDataFromPref(Constants.PRESSURE).
                equalsIgnoreCase(Constants.PRESSURE_MIILLIBAR))
            textViewPressure.setText("Pressure: " +
                    (response.current.pressure_mb));
        else
            textViewPressure.setText("Pressure: " +
                    response.current.pressure_in);


        if (SharedPref.getDataFromPref(Constants.PRECIPTION).
                equalsIgnoreCase(Constants.PRECIPTION_INCHES))
            textViewPreciption.setText("Precip: " +
                    (response.current.pressure_in+" "+Constants.PRECIPTION_INCHES));
        else
            textViewPreciption.setText("Precip: " +
                    response.current.precip_mm+" "+Constants.PRECIPTION_MM);


        if (SharedPref.getDataFromPref(Constants.WIND_SPEED).equalsIgnoreCase
                (Constants.WIND_METRES))
            textViewWind.setText("Wind: " + response.current.wind_mph + " " +
                    Constants.WIND_METRES);
        else
            textViewWind.setText("Wind: " + response.current.wind_kph + " "
                    + Constants.WIND_KILLOMETRES);


        textViewVisibility.setText("Visibility: " + response.current.vis_km);
        textViewHumidity.setText("Humidity: " + response.current.humidity + "%");
        textViewCloudCover.setText("Cloud Cover: " + response.current.cloud + "%");
        textViewUvIndex.setText("UV Index: " + response.current.uv);
        setAdapter(response.forecast.forecastday);

    }

    private void setAdapter(List<WeatherBean.ForecastBean.ForecastdayBean> forecastday) {
        FiveDayWeatherAdapter fiveDayWeatherAdapter = new FiveDayWeatherAdapter(forecastday);
        recyclerViewFiveDays.setAdapter(fiveDayWeatherAdapter);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_refresh:
                // Do Fragment menu item stuff here
                mPresenter.getCurrentWeather(latitude, longitude,
                        Constants.APIXXU_API_KEY);

                return true;
            case R.id.action_share:
                // Not implemented here
                return false;
            default:
                break;
        }

        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}