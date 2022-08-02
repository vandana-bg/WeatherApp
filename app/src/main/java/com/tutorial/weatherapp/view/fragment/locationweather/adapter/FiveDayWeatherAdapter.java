package com.tutorial.weatherapp.view.fragment.locationweather.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tutorial.weatherapp.R;
import com.tutorial.weatherapp.model.fivedayweather.WeatherBean;
import com.tutorial.weatherapp.util.FrequentFunction;

import java.util.List;


public class FiveDayWeatherAdapter extends RecyclerView.Adapter<FiveDayWeatherAdapter.ViewHolder> {

    private List<WeatherBean.ForecastBean.ForecastdayBean> mItemsList;
    private Context context;

    public FiveDayWeatherAdapter(List<WeatherBean.ForecastBean.ForecastdayBean> itemsList) {
        this.mItemsList=itemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view by inflating the row item xml.
        context=parent.getContext();
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.weather_listrow, parent, false);
        // Set the view to the ViewHolder
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textViewMaxMin.setText(mItemsList.get(position+1).day.maxtemp_c +"/"+
                mItemsList.get(position+1).day.mintemp_c+ "°C");

        holder.textViewWeather.setText(mItemsList.get(position+1).day.condition.text);

        holder.textViewWeekDay.setText(FrequentFunction.getDay(
                mItemsList.get(position+1).date_epoch));

        String imageUrl ="http:"+mItemsList.get(position+1).day.condition.icon
                .replace("64x64",
                "128x128");


        Glide.with((context))
                .load(imageUrl)
                .into(holder.imageViewWeather);

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    // Create the ViewHolder class to keep references to your views
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewWeekDay,textViewWeather,textViewMaxMin;
        public ImageView imageViewWeather;

        /**
         * Constructor
         * @param v The container view which holds the elements from the row item xml
         */
        public ViewHolder(View v) {
            super(v);

            textViewWeekDay = (TextView) v.findViewById(R.id.textViewWeekDay);
            textViewWeather = (TextView) v.findViewById(R.id.textViewWeather);
            textViewMaxMin = (TextView) v.findViewById(R.id.textViewMaxMinWeather);
            imageViewWeather =  v.findViewById(R.id.imageViewWeather);
        }


    }

}