package com.example.android.pokdex;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

class RegionLoader extends AsyncTaskLoader<List<RegionList>> {

    private String mUrl;

    public RegionLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<RegionList> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        return RegionQueryUtils.extractRegion(mUrl);
    }
}
