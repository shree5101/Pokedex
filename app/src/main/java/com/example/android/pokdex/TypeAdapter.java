package com.example.android.pokdex;


import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


class TypeAdapter extends ArrayAdapter<TypeList> {

    TextView typeNameView;

    private static final String LOG_TAG = RegionAdapter.class.getSimpleName();

    public TypeAdapter(Activity context, ArrayList<TypeList> typeLists) {
        super(context, 0, typeLists);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_without_image, parent, false);
        }

        TypeList currentTypeList = getItem(position);
        typeNameView = listItemView.findViewById(R.id.name_view);
        assert currentTypeList != null;
        typeNameView.setText(currentTypeList.getTypeName());

        return listItemView;
    }

}
