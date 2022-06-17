package com.example.movie_demo_java.generated_implementation.repositories;

import com.example.movie_demo_java.generated_implementation.interfaces.ComicStockRepositoryInterface;
import com.example.movie_demo_java.generated_implementation.models.MovieModel;
import com.gen.movie_demo_java.models.Movie;
import com.google.gson.Gson;
import org.springframework.stereotype.Repository;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieRepository {

    private String BASE_URL = "http://frontendshowcase.azurewebsites.net";
    private ArrayList<MovieModel.MovieImageModel> imageList1 = new ArrayList<>() {{
        add(new MovieModel.MovieImageModel(
                "http://i.annihil.us/u/prod/marvel/i/mg/e/e0/56b3abf44dda3",
                "jpg",
                "http://i.annihil.us/u/prod/marvel/i/mg/e/e0/56b3abf44dda3.jpg"
        ));
    } };

    private ArrayList<MovieModel.MovieImageModel> imageList2 = new ArrayList<>() {{
        add(new MovieModel.MovieImageModel(
                "http://i.annihil.us/u/prod/marvel/i/mg/7/40/56b36c949f91d",
                "jpg",
                "http://i.annihil.us/u/prod/marvel/i/mg/7/40/56b36c949f91d.jpg"
        ));
    } };

    private ArrayList<MovieModel.MovieImageModel> imageList3 = new ArrayList<>() {{
        add(new MovieModel.MovieImageModel(
                "http://i.annihil.us/u/prod/marvel/i/mg/9/a0/56b4eac074c89",
                "jpg",
                "http://i.annihil.us/u/prod/marvel/i/mg/9/a0/56b4eac074c89.jpg"
        ));
    } };

    private MovieModel avengersModel = new MovieModel(
            1,
            "Avengers",
            "The movie with all the heroes",
            imageList1
    );

    private MovieModel civilWarModel = new MovieModel(
            2,
            "Civil War",
            "The movie with some of the the heroes, but not all of them",
            imageList2
    );

    private MovieModel inhumansModel = new MovieModel(
            3,
            "Inhumans",
            "The movie with even less of the heroes, and some of them aren't human",
            imageList3
    );

    public Response<List<Movie>> gatherMovieDataFromDataSource() throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ComicStockRepositoryInterface serviceInterface = retrofit.create(ComicStockRepositoryInterface.class);

        Call<List<Movie>> retrofitCall = serviceInterface.listMovies();

        return retrofitCall.execute();
    }

    public Response<Movie> gatherSingleMovieDataModelById(long movieId) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ComicStockRepositoryInterface serviceInterface = retrofit.create(ComicStockRepositoryInterface.class);

        Call<Movie> retrofitCall = serviceInterface.getMovieById(movieId);

        return retrofitCall.execute();
    }
}
