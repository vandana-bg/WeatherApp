package com.tutorial.weatherapp.view.fragment.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tutorial.weatherapp.R;
import com.tutorial.weatherapp.database.Favourite;
import com.tutorial.weatherapp.database.FavouriteRepository;
import com.tutorial.weatherapp.view.fragment.BaseFragment;
import com.tutorial.weatherapp.view.fragment.home.adapter.ViewPagerAdapter;
import com.tutorial.weatherapp.view.fragment.locationweather.FragmentWeather;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.tutorial.weatherapp.MyApp.cityName;
import static com.tutorial.weatherapp.MyApp.latitude;
import static com.tutorial.weatherapp.MyApp.longitude;

public class FragmentHome extends BaseFragment implements FavouriteRepository.FetchSavedListInterface {

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    Unbinder unbinder;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    private ViewPagerAdapter viewPagerAdapter;
    FavouriteRepository repository;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, view);

        repository = new FavouriteRepository(getActivity());
        repository.getTasks(this);

        setupViewPager(viewpager);
        tabLayout.setupWithViewPager(viewpager);


        return view;
    }

    private void setupViewPager(ViewPager viewPager) {
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new FragmentWeather(), cityName,String.valueOf(latitude),
                String.valueOf(longitude));

        viewPager.setAdapter(viewPagerAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void savedPlaces(List<Favourite> list) {
        if (list!=null&&list.size()>0)
                updateViewPager(list);

    }

    private void updateViewPager(List<Favourite> list) {
        for (int i=0;i<list.size();i++) {
            viewPagerAdapter.addFragment(new FragmentWeather(), list.get(i).getDescription(),
                    list.get(i).getLatitude(),
                    list.get(i).getLongitude());
        }
        viewPagerAdapter.notifyDataSetChanged();

    }
}
