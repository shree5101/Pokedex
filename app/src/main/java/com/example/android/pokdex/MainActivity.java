package com.example.android.pokdex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button openAllPokemonList;
    Button openItems;
    Button openLocations;
    Button openTypes;
    Button openRegions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openAllPokemonList = findViewById(R.id.all_pokemon_button);
        openAllPokemonList.setOnClickListener(v -> {
            Intent allPokemonListIntent = new Intent(MainActivity.this, PokemonListActivity.class);
            startActivity(allPokemonListIntent);
        });

        openItems = findViewById(R.id.item_button);
        openItems.setOnClickListener(v -> {
            Intent itemsIntent = new Intent(MainActivity.this, ItemsActivity.class);
            startActivity(itemsIntent);
        });

        openLocations = findViewById(R.id.location_button);
        openLocations.setOnClickListener(v -> {
            Intent locationIntent = new Intent(MainActivity.this, LocationActivity.class);
            startActivity(locationIntent);
        });

        openTypes = findViewById(R.id.type_button);
        openTypes.setOnClickListener(v -> {
            Intent typeIntent = new Intent(MainActivity.this, TypeActivity.class);
            startActivity(typeIntent);
        });

        openRegions = findViewById(R.id.region_button);
        openRegions.setOnClickListener(v -> {
            Intent regionIntent = new Intent(MainActivity.this, RegionActivity.class);
            startActivity(regionIntent);
        });
    }
}