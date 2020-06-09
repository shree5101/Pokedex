package com.example.android.pokdex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PokemonInfoActivity extends AppCompatActivity {

    TextView pokemonName;
    ImageView pokemonImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_info_activity);

        Intent intent = getIntent();
        String name = intent.getStringExtra("pokemon_name");
        String url = intent.getStringExtra("pokemon_image");
        pokemonImage = findViewById(R.id.pokemon_info_image);
        pokemonName = findViewById(R.id.pokemon_info_name);
        pokemonName.setText(name);




    }
}
