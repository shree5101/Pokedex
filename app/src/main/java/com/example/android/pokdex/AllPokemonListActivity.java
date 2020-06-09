package com.example.android.pokdex;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;

import androidx.loader.content.Loader;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AllPokemonListActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<PokemonList>> {

    private static final int POKEMON_LIST_LOADER_ID = 1;

    private TextView mEmptyStateTextView;
    private final PokemonListAdapter mAdapter;


    private static final String POKEMON_NAMES_URL = "https://pokeapi.co/api/v2/pokemon?limit=964";

    public AllPokemonListActivity(PokemonListAdapter mAdapter) {
        this.mAdapter = mAdapter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_list_view);

        ListView namesListView = findViewById(R.id.pokemon_list_view);

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getSupportLoaderManager();
            loaderManager.initLoader(POKEMON_LIST_LOADER_ID, null, this);
        } else {
            mEmptyStateTextView = findViewById(R.id.no_internet_view);
            namesListView.setEmptyView(mEmptyStateTextView);
            mEmptyStateTextView.setText("No internet connection!");
            View loaderAnimation = findViewById(R.id.loading_indicator);
            loaderAnimation.setVisibility(View.GONE);
        }


        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        namesListView.setEmptyView(mEmptyStateTextView);

        mAdapter = new PokemonListAdapter(this, new ArrayList<>());
        namesListView.setAdapter(mAdapter);

        namesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent pokemonInfo = new Intent(AllPokemonListActivity.this, PokemonInfoActivity.class);
                pokemonInfo.putExtra("pokemon_name", Objects.requireNonNull(mAdapter.getItem(position)).getPokemonName());
                pokemonInfo.putExtra("pokemon_image", Objects.requireNonNull(mAdapter.getItem(position)).getPokemonName());
                startActivity(pokemonInfo);
            }
        });

    }

    @NonNull
    @Override
    public Loader<List<PokemonList>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new PokemonListLoader(this, POKEMON_NAMES_URL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@androidx.annotation.NonNull Loader<List<PokemonList>> loader, List<PokemonList> data) {
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        }

        mEmptyStateTextView.setText("No pokemon found!");
        View loaderAnimation = findViewById(R.id.loading_indicator);
        loaderAnimation.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(@androidx.annotation.NonNull Loader<List<PokemonList>> loader) {
        mAdapter.clear();
    }

}
