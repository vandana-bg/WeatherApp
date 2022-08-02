package com.tutorial.weatherapp.view.fragment.managelocation.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tutorial.weatherapp.R;
import com.tutorial.weatherapp.database.Favourite;

import java.util.List;

/**
 * Created by Thakur on 4/30/2018.
 */

public class ManageLocationAdapter extends RecyclerView.Adapter<ManageLocationAdapter.ViewHolder> {
    View view;
    List<Favourite> favouriteList;
    ItemLongPressInterface interfaceLongPress;


    public ManageLocationAdapter(ItemLongPressInterface interfaceLongPress,
                                 List<Favourite> favouriteList) {
        this.favouriteList = favouriteList;
        this.interfaceLongPress = interfaceLongPress;
    }

    public void customNotify( List<Favourite> favouriteList) {
        this.favouriteList = favouriteList;
        notifyDataSetChanged();
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_manage_location, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvFulladdress.setText(favouriteList.get(position).getTitle());
        holder.tvTitle.setText(favouriteList.get(position).getDescription());
        holder.imageViewPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                interfaceLongPress.longPress(v,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return favouriteList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvFulladdress;
        LinearLayout  linearLayoutRoot;
        ImageView imageViewPopup;


        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            linearLayoutRoot = itemView.findViewById(R.id.linearLayoutRoot);
            tvFulladdress = itemView.findViewById(R.id.tv_full_address);
            imageViewPopup = itemView.findViewById(R.id.imageViewPopup);


        }
    }

  public interface ItemLongPressInterface {
        void longPress(View view,int position);
    }
}
