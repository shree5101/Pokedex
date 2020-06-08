package com.example.android.pokdex;

class PokemonList {

    public String mPokemonImageUrl;
    public String mPokemonName;



    public PokemonList(String pokemonName, String pokemonImageUrl) {
        mPokemonName = pokemonName;
        mPokemonImageUrl = pokemonImageUrl;
    }

    public String getPokemonName() {
        return mPokemonName;
    }

    public String getPokemonImageUrl() {
        return mPokemonImageUrl;
    }
}
