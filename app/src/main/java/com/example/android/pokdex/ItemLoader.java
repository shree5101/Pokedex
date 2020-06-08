package com.example.android.pokdex;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

class ItemLoader extends AsyncTaskLoader<List<ItemList>> {

    private String mUrl;

    public ItemLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<ItemList> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        return ItemQueryUtils.extractItems(mUrl);
    }
}
