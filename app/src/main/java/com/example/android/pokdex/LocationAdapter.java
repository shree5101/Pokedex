package com.example.android.pokdex;


import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


class LocationAdapter extends ArrayAdapter<LocationList> {

    TextView locationNameView;


    private static final String LOG_TAG = LocationAdapter.class.getSimpleName();

    public LocationAdapter(Activity context, ArrayList<LocationList> locationList) {
        super(context, 0, locationList);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_without_image, parent, false);
        }

        LocationList currentLocationList = getItem(position);
        locationNameView = listItemView.findViewById(R.id.name_view);
        assert currentLocationList != null;
        locationNameView.setText(currentLocationList.getLocationName());


        return listItemView;
    }

}
