package com.example.android.pokdex;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

class PokemonListLoader extends AsyncTaskLoader<List<PokemonList>> {

    private String mUrl;

    public PokemonListLoader(@NonNull Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

    @Nullable
    @Override
    public List<PokemonList> loadInBackground() {
        if (mUrl == null){
            return null;
        }

        return QueryUtils.extractPokemonNames(mUrl);
    }
}
