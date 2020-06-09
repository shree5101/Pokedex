package com.example.android.pokdex;

class PokemonInfoList {

    public String mPokemonWeight;
    public String mPokemonHeight;
    public String mPokemonBaseExperience;

    public PokemonInfoList(String weight, String height, String baseExperience){
        mPokemonBaseExperience = baseExperience;
        mPokemonHeight = height;
        mPokemonWeight = weight;
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
