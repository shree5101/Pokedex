package com.example.android.pokdex;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.sax.TextElementListener;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonInfoActivity extends AppCompatActivity {

    TextView pokemonName;
    ImageView pokemonImage;
    TextView heightView;
    TextView weightView;
    TextView baseExperienceView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_info_activity);

        Intent intent = getIntent();
        String name = intent.getStringExtra("pokemon_name");
        String url = intent.getStringExtra("pokemon_image");
        String height = intent.getStringExtra("pokemon_height");
        String weight = intent.getStringExtra("pokemon_weight");
        String baseExperience = intent.getStringExtra("base_experience");

        pokemonName = findViewById(R.id.pokemon_info_name);
        pokemonName.setText(name);

        pokemonImage = findViewById(R.id.pokemon_info_image);
        Picasso.get()
                .load(url)
                .fit()
                .into(pokemonImage);

        heightView = findViewById(R.id.height_info);
        heightView.setText(height);

        weightView = findViewById(R.id.weight_info);
        weightView.setText(weight);

        baseExperienceView = findViewById(R.id.base_experience_info);
        baseExperienceView.setText(baseExperience);

//        ConnectivityManager connManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connManager.getActiveNetworkInfo();
//
//        if (networkInfo != null && networkInfo.isConnected()) {
//            LoaderManager loaderManager = getSupportLoaderManager();
//            loaderManager.initLoader(1, null, this);
//        } else {
//            mEmptyStateTextView = findViewById(R.id.no_internet_view);
//            infoScrollView.setVisibility(View.GONE);
//            mEmptyStateTextView.setText("No internet connection!");
//            View loaderAnimation = findViewById(R.id.loading_indicator);
//            loaderAnimation.setVisibility(View.GONE);
//        }
//        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
//
//        heightView = findViewById(R.id.height_info);
//        heightView.setText(infoList.getPokemonHeight());
    }



//    private String POKEMON_INFO_URL = "https://pokeapi.co/api/v2/pokemon/" + name;
//
//    @NonNull
//    @Override
//    public Loader<List<PokemonInfoList>> onCreateLoader(int i, Bundle bundle) {
//        // Create a new loader for the given URL
//        return new PokemonInfoLoader(this, POKEMON_INFO_URL);
//    }
//
//    @Override
//    public void onLoadFinished(@NonNull Loader loader, Object data) {
//
//    }
//
//    @Override
//    public void onLoaderReset(@NonNull Loader loader) {
//
//    }
//
//    @SuppressLint("SetTextI18n")
//    public void onLoadFinished(@androidx.annotation.NonNull Loader<List<PokemonList>> loader, List<PokemonList> data) {
//        mEmptyStateTextView.setText("No pokemon found!");
//        View loaderAnimation = findViewById(R.id.loading_indicator);
//        loaderAnimation.setVisibility(View.GONE);
//    }

}
