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

public class TypeActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<TypeList>> {

    private static final int TYPE_LOADER_ID = 1;

    private TextView mEmptyStateTextView;

    private TypeAdapter mAdapter;

    private static final String TYPE_URL = "https://pokeapi.co/api/v2/type?limit=20";

    @SuppressLint("SetTextI18n")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_activity);

        ListView typeView = findViewById(R.id.type_list_view);

        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        assert connManager != null;
        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            LoaderManager loaderManager = getSupportLoaderManager();
            loaderManager.initLoader(TYPE_LOADER_ID, null, this);
        } else {
            mEmptyStateTextView = findViewById(R.id.no_internet_view);
            typeView.setEmptyView(mEmptyStateTextView);
            mEmptyStateTextView.setText("No internet connection!");
            View loaderAnimation = findViewById(R.id.loading_indicator);
            loaderAnimation.setVisibility(View.GONE);
        }


        mEmptyStateTextView = findViewById(R.id.empty_view);
        typeView.setEmptyView(mEmptyStateTextView);

        mAdapter = new TypeAdapter(this, new ArrayList<>());
        typeView.setAdapter(mAdapter);

    }

    @NonNull
    @Override
    public Loader<List<TypeList>> onCreateLoader(int i, Bundle bundle) {
        // Create a new loader for the given URL
        return new TypeLoader(this, TYPE_URL);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onLoadFinished(@androidx.annotation.NonNull Loader<List<TypeList>> loader, List<TypeList> data) {
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
    public void onLoaderReset(@NonNull Loader<List<TypeList>> loader) {
        mAdapter.clear();
    }

}
