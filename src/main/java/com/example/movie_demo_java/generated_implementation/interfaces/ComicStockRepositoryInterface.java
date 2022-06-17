package com.example.movie_demo_java.generated_implementation.interfaces;

import com.gen.movie_demo_java.models.Movie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface ComicStockRepositoryInterface {
        @GET("api/issues")
        Call<List<Movie>> listMovies();

        @GET("api/issues")
        Call<Movie> getMovieById(@Path("id") long id);

}
