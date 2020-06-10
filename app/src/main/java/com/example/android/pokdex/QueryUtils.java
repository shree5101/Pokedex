package com.example.android.pokdex;


import android.text.TextUtils;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class QueryUtils {


    private QueryUtils() {
    }


    public static List<PokemonList> extractPokemonNames(String requestUrl) {

        ArrayList<PokemonList> names = new ArrayList<>();
        StringBuilder requestUrlBuilder = new StringBuilder(requestUrl);
        for (int j = 1; j <= 10; j++) {
            requestUrlBuilder.append(j);
            requestUrl = requestUrlBuilder.toString();
            Log.v("MODIFIED URL", requestUrl);

            if (TextUtils.isEmpty(requestUrl)) {
                return null;
            }

            URL url = createUrl(requestUrl);

            // Perform HTTP request to the URL and receive a JSON response back
            String jsonResponse = null;
            try {
                jsonResponse = makeHttpRequest(url);
            } catch (IOException e) {
                Log.e("LOG_TAG", "Problem making the HTTP request.", e);
            }

            try {

                // Create a JSONObject from the SAMPLE_JSON_RESPONSE string
                assert jsonResponse != null;
                JSONObject baseJsonResponse = new JSONObject(jsonResponse);

                String pokemonName = baseJsonResponse.getString("name");
                String pokemonImageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + (j) + ".png";
                String height = baseJsonResponse.getString("height");
                String weight = baseJsonResponse.getString("weight");
                String baseExperience = baseJsonResponse.getString("base_experience");


                PokemonList newPokemonName = new PokemonList(pokemonName, pokemonImageUrl, weight, height, baseExperience);
                names.add(newPokemonName);


            } catch (JSONException e) {

                Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
            }
            if (j < 10){
                requestUrlBuilder.deleteCharAt(requestUrlBuilder.length() - 1);
            } else if(j>=10 && j<100) {
                requestUrlBuilder.deleteCharAt(requestUrlBuilder.length() - 1);
                requestUrlBuilder.deleteCharAt(requestUrlBuilder.length() - 1);
            } else {
                requestUrlBuilder.deleteCharAt(requestUrlBuilder.length() - 1);
                requestUrlBuilder.deleteCharAt(requestUrlBuilder.length() - 1);
                requestUrlBuilder.deleteCharAt(requestUrlBuilder.length() - 1);
            }

        }
        return names;
    }

    /**
     * Returns new URL object from the given string URL.
     */
    private static URL createUrl(String stringUrl) {
        URL url = null;
        try {
            url = new URL(stringUrl);
        } catch (MalformedURLException e) {
            Log.e("LOG_TAG", "Problem building the URL ", e);
        }
        return url;
    }

    /**
     * Make an HTTP request to the given URL and return a String as the response.
     */
    private static String makeHttpRequest(URL url) throws IOException {
        String jsonResponse = "";

        // If the URL is null, then return early.
        if (url == null) {
            return jsonResponse;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setReadTimeout(10000 /* milliseconds */);
            urlConnection.setConnectTimeout(15000 /* milliseconds */);
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            // If the request was successful (response code 200),
            // then read the input stream and parse the response.
            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();

                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e("LOG_TAG", "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e("LOG_TAG", "Problem retrieving the earthquake JSON results.", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (inputStream != null) {
                // Closing the input stream could throw an IOException, which is why
                // the makeHttpRequest(URL url) method signature specifies than an IOException
                // could be thrown.
                inputStream.close();
            }
        }
        return jsonResponse;
    }

    /**
     * Convert the {@link InputStream} into a String which contains the
     * whole JSON response from the server.
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

}