package com.example.android.pokdex;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

class TypeLoader extends AsyncTaskLoader<List<TypeList>> {

    private String mUrl;

    public TypeLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<TypeList> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        return TypeQueryUtils.extractType(mUrl);
    }
}
