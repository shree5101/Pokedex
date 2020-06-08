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

public class ItemsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<ItemList>> {

    private static final int ITEMS_LOADER_ID = 1;

    private TextView mEmptyStateTextView;

    private ItemsAdapter mAdapter;

    private static final String ITEMS_URL = "https://pokeapi.co/api/v2/item?limit=954";

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_activity);

        ListView itemsView = findViewById(R.id.item_list_view);

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        assert connManager != null;
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getSupportLoaderManager();
            loaderManager.initLoader(ITEMS_LOADER_ID, null, this);
        } else {
            mEmptyStateTextView = findViewById(R.id.no_internet_view);
            itemsView.setEmptyView(mEmptyStateTextView);
            mEmptyStateTextView.setText("No internet connection!");
            View loaderAnimation = findViewById(R.id.loading_indicator);
            loaderAnimation.setVisibility(View.GONE);
        }


        mEmptyStateTextView = findViewById(R.id.empty_view);
        itemsView.setEmptyView(mEmptyStateTextView);

        mAdapter = new ItemsAdapter(this, new ArrayList<>());
        itemsView.setAdapter(mAdapter);

    }

    @NonNull
    @Override
    public Loader<List<ItemList>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new ItemLoader(this, ITEMS_URL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@androidx.annotation.NonNull Loader<List<ItemList>> loader, List<ItemList> data) {
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
    public void onLoaderReset(@NonNull Loader<List<ItemList>> loader) {
        mAdapter.clear();
    }

}
