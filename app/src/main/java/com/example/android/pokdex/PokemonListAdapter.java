package com.example.android.pokdex;


import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;


class PokemonListAdapter extends ArrayAdapter<PokemonList> implements Filterable {

    TextView pokemonNameView;
    ImageView pokemonImageView;

    private static final String LOG_TAG = PokemonListAdapter.class.getSimpleName();

    public PokemonListAdapter(Activity context, ArrayList<PokemonList> pokemonList) {
        super(context, 0, pokemonList);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        PokemonList currentPokemonList = getItem(position);
        pokemonNameView = listItemView.findViewById(R.id.name_view);
        assert currentPokemonList != null;
        pokemonNameView.setText(currentPokemonList.getPokemonName());

        pokemonImageView = listItemView.findViewById(R.id.image_view);
        Picasso.get()
                .load(currentPokemonList.getPokemonImageUrl())
                .fit()
                .into(pokemonImageView);

        return listItemView;
    }

}
