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


class RegionAdapter extends ArrayAdapter<RegionList> {

    TextView regionNameView;

    private static final String LOG_TAG = RegionAdapter.class.getSimpleName();

    public RegionAdapter(Activity context, ArrayList<RegionList> regionLists) {
        super(context, 0, regionLists);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_without_image, parent, false);
        }

        RegionList currentRegionList = getItem(position);
        regionNameView = listItemView.findViewById(R.id.name_view);
        assert currentRegionList != null;
        regionNameView.setText(currentRegionList.getTypeName());


        return listItemView;
    }

}
