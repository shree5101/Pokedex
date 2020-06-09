package com.example.android.pokdex;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

class PokemonInfoLoader extends AsyncTaskLoader<List<PokemonInfoList>> {

    private String mUrl;

    public PokemonInfoLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<PokemonInfoList> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        return PokemonInfoQueryUtils.extractPokemonInfo(mUrl);
    }
}
