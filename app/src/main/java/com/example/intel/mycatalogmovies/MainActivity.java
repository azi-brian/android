package com.example.intel.mycatalogmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.intel.mycatalogmovies.Model.Movie;
import com.example.intel.mycatalogmovies.Model.MoviewResponse;
import com.example.intel.mycatalogmovies.Rest.ApiClient;
import com.example.intel.mycatalogmovies.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "8cfbaecee6b19dd84192a608a3f2b6a9";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (API_KEY.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }

        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<MoviewResponse> call = apiService.getNowPlayingMovies(API_KEY);
        call.enqueue(new Callback<MoviewResponse>() {
            @Override
            public void onResponse(Call<MoviewResponse>call, Response<MoviewResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
                Toast.makeText(MainActivity.this, "Number of movies received: " + movies.size(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<MoviewResponse>call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
