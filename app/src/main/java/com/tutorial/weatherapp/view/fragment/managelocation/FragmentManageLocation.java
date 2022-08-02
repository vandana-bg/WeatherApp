package com.tutorial.weatherapp.view.fragment.managelocation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.tutorial.weatherapp.R;
import com.tutorial.weatherapp.database.Favourite;
import com.tutorial.weatherapp.database.FavouriteRepository;
import com.tutorial.weatherapp.util.Constants;
import com.tutorial.weatherapp.view.activity.addloaction.AddLocationActivity;
import com.tutorial.weatherapp.view.fragment.BaseFragment;
import com.tutorial.weatherapp.view.fragment.managelocation.adapter.ManageLocationAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;


public class FragmentManageLocation extends BaseFragment implements
        FavouriteRepository.FetchSavedListInterface, ManageLocationAdapter.ItemLongPressInterface {


    @BindView(R.id.recyclerViewLocations)
    RecyclerView recyclerViewLocations;
    Unbinder unbinder;
    FavouriteRepository repository;
    List<Favourite> favouriteList;
    ManageLocationAdapter manageLocationAdapter;
    FavouriteRepository.FetchSavedListInterface fetchSavedListInterface;
    ManageLocationAdapter.ItemLongPressInterface itemLongPressInterface;
    @BindView(R.id.textViewCount)
    TextView textViewCount;
    @BindView(R.id.main_nodata)
    LinearLayout mainNodata;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_manage_location, container, false);
        unbinder = ButterKnife.bind(this, view);
        fetchSavedListInterface = this;
        itemLongPressInterface = this;
        repository = new FavouriteRepository(getActivity());
        repository.getTasks(this);
        return view;
    }

    private void setAdapter() {
        recyclerViewLocations.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayout.VERTICAL, false));
        manageLocationAdapter = new ManageLocationAdapter(itemLongPressInterface, favouriteList);
        recyclerViewLocations.setAdapter(manageLocationAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.floatingButtonAddLocation)
    public void onViewClicked() {
        if (favouriteList!=null&&favouriteList.size()<9)
        startActivity(new Intent(getActivity(), AddLocationActivity.class));
        else
            Toast.makeText(getActivity(), "Limit Exceed!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Constants.searcstatus.equalsIgnoreCase("true")) {
            Constants.searcstatus = "false";
            repository.getTasks(this);
        }
    }

    @Override
    public void savedPlaces(List<Favourite> list) {
        this.favouriteList = list;

        if (favouriteList != null && favouriteList.size() > 0) {
            mainNodata.setVisibility(View.GONE);
            setAdapter();
            textViewCount.setText("("+favouriteList.size()+"/10)");
        }
        else if (manageLocationAdapter != null) {
            manageLocationAdapter.customNotify(favouriteList);
            mainNodata.setVisibility(View.VISIBLE);
            textViewCount.setText("(0/10)");
        }else {
            mainNodata.setVisibility(View.VISIBLE);
            textViewCount.setText("(0/10)");
        }

    }

    @Override
    public void longPress(View view, int position) {
        showMenu(view, position);
    }

    public void showMenu(View view, final int position) {
        final PopupMenu popupMenu = new PopupMenu(getActivity(), view);

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.item_delete:
                        repository.deleteTask(String.valueOf(favouriteList.get(position).getId()));
                        repository.getTasks(fetchSavedListInterface);
                        popupMenu.dismiss();
                        break;
                    case R.id.item_cancel:
                        popupMenu.dismiss();
                        break;
                }
                return true;
            }
        });
        popupMenu.inflate(R.menu.menu_location_popup);
        popupMenu.show();
    }
}