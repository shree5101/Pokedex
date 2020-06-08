package com.example.android.pokdex;


import android.annotation.SuppressLint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;

import androidx.loader.content.Loader;


import java.util.ArrayList;
import java.util.List;

public class LocationActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<LocationList>> {

    private static final int LOCATION_LOADER_ID = 1;

    private TextView mEmptyStateTextView;

    private LocationAdapter mAdapter;

    private static final String LOCATION_URL = "https://pokeapi.co/api/v2/location?limit=781";

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.location_activity);

        ListView locationView = findViewById(R.id.location_list_view);

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        assert connManager != null;
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getSupportLoaderManager();
            loaderManager.initLoader(LOCATION_LOADER_ID, null, this);
        } else {
            mEmptyStateTextView = findViewById(R.id.no_internet_view);
            locationView.setEmptyView(mEmptyStateTextView);
            mEmptyStateTextView.setText("No internet connection!");
            View loaderAnimation = findViewById(R.id.loading_indicator);
            loaderAnimation.setVisibility(View.GONE);
        }


        mEmptyStateTextView = findViewById(R.id.empty_view);
        locationView.setEmptyView(mEmptyStateTextView);

        mAdapter = new LocationAdapter(this, new ArrayList<>());
        locationView.setAdapter(mAdapter);

    }

    @NonNull
    @Override
    public Loader<List<LocationList>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new LocationLoader(this, LOCATION_URL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@androidx.annotation.NonNull Loader<List<LocationList>> loader, List<LocationList> data) {
        // Clear the adapter of previous earthquake data
        mAdapter.clear();

        // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
        // data set. This will trigger the ListView to update.
        if (data != null && !data.isEmpty()) {
            mAdapter.addAll(data);
        }

        mEmptyStateTextView.setText("No item found!");
        View loaderAnimation = findViewById(R.id.loading_indicator);
        loaderAnimation.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<List<LocationList>> loader) {
        mAdapter.clear();
    }

}
