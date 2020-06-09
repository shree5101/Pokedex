package com.example.android.pokdex;

public class PokemonList {

    public String mPokemonImageUrl;
    public String mPokemonName;

    public PokemonList(String pokemonName, String pokemonImageUrl) {
        super();
        this.mPokemonName = pokemonName;
        this.mPokemonImageUrl = pokemonImageUrl;
    }

    public PokemonList() {

    }

    public void setPokemonImageUrl(String mPokemonImageUrl) {
        this.mPokemonImageUrl = mPokemonImageUrl;
    }

    public void setPokemonName(String mPokemonName) {
        this.mPokemonName = mPokemonName;
    }

    public String getPokemonName() {
        return mPokemonName;
    }

    public String getPokemonImageUrl() {
        return mPokemonImageUrl;
    }
}
