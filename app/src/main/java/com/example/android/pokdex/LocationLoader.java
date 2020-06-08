package com.example.android.pokdex;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

class LocationLoader extends AsyncTaskLoader<List<LocationList>> {

    private String mUrl;

    public LocationLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<LocationList> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        return LocationQueryUtils.extractLocation(mUrl);
    }
}
