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

public class RegionActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<RegionList>> {

    private static final int REGION_LOADER_ID = 1;

    private TextView mEmptyStateTextView;

    private RegionAdapter mAdapter;

    private static final String REGION_URL = "https://pokeapi.co/api/v2/region";

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.region_activity);

        ListView regionView = findViewById(R.id.region_list_view);

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        assert connManager != null;
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getSupportLoaderManager();
            loaderManager.initLoader(REGION_LOADER_ID, null, this);
        } else {
            mEmptyStateTextView = findViewById(R.id.no_internet_view);
            regionView.setEmptyView(mEmptyStateTextView);
            mEmptyStateTextView.setText("No internet connection!");
            View loaderAnimation = findViewById(R.id.loading_indicator);
            loaderAnimation.setVisibility(View.GONE);
        }


        mEmptyStateTextView = findViewById(R.id.empty_view);
        regionView.setEmptyView(mEmptyStateTextView);

        mAdapter = new RegionAdapter(this, new ArrayList<>());
        regionView.setAdapter(mAdapter);

    }

    @NonNull
    @Override
    public Loader<List<RegionList>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new RegionLoader(this, REGION_URL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@androidx.annotation.NonNull Loader<List<RegionList>> loader, List<RegionList> data) {
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
    public void onLoaderReset(@NonNull Loader<List<RegionList>> loader) {
        mAdapter.clear();
    }
}
