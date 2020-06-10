package com.example.android.pokdex;

public class PokemonList {

    public String mPokemonImageUrl;
    public String mPokemonName;
    public String mPokemonWeight;
    public String mPokemonHeight;
    public String mPokemonBaseExperience;

    public PokemonList(String pokemonName, String pokemonImageUrl, String weight, String height, String baseExperience) {
        super();
        this.mPokemonName = pokemonName;
        this.mPokemonImageUrl = pokemonImageUrl;
        this.mPokemonBaseExperience = baseExperience;
        this.mPokemonHeight = height;
        this.mPokemonWeight = weight;
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

    public String getPokemonWeight() {
        return mPokemonWeight;
    }

    public void setPokemonWeight(String mPokemonWeight) {
        this.mPokemonWeight = mPokemonWeight;
    }

    public String getPokemonHeight() {
        return mPokemonHeight;
    }

    public void setPokemonHeight(String mPokemonHeight) {
        this.mPokemonHeight = mPokemonHeight;
    }

    public String getPokemonBaseExperience() {
        return mPokemonBaseExperience;
    }

    public void setPokemonBaseExperience(String mPokemonBaseExperience) {
        this.mPokemonBaseExperience = mPokemonBaseExperience;
    }
}
