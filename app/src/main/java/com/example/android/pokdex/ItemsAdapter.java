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


class ItemsAdapter extends ArrayAdapter<ItemList> {

    TextView itemNameView;
    ImageView itemImageView;

    private static final String LOG_TAG = ItemsAdapter.class.getSimpleName();

    public ItemsAdapter(Activity context, ArrayList<ItemList> itemList) {
        super(context, 0, itemList);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        ItemList currentItemList = getItem(position);
        itemNameView = listItemView.findViewById(R.id.name_view);
        assert currentItemList != null;
        itemNameView.setText(currentItemList.getItemName());

        itemImageView = listItemView.findViewById(R.id.image_view);
        Picasso.get()
                .load(currentItemList.getItemImageUrl())
                .fit()
                .into(itemImageView);

        return listItemView;
    }

}
