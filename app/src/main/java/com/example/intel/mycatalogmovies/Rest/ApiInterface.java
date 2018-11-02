package com.example.intel.mycatalogmovies.Rest;
import com.example.intel.mycatalogmovies.Model.MoviewResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class ApiInterface {
    @GET("movie/now_playing")
    public Call<MoviewResponse> getNowPlayingMovies(@Query("api_key") String apiKey) {
        return null;
    }

    @GET("movie/{id}")
    Call<MoviewResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey) {
        return null;
    }
}
