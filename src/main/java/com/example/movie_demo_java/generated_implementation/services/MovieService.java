package com.example.movie_demo_java.generated_implementation.services;

import com.example.movie_demo_java.generated_implementation.models.MovieModel;
import com.example.movie_demo_java.generated_implementation.repositories.MovieRepository;
import com.gen.movie_demo_java.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovieDataModels() throws IOException {

        Response<List<Movie>> movieListResponse = movieRepository.gatherMovieDataFromDataSource();

        if (!movieListResponse.isSuccessful()) {
            throw new IOException(movieListResponse.errorBody() != null
                    ? movieListResponse.errorBody().string() : "Unknown error");
        }

        return movieListResponse.body();
    }

    public Movie getSingleDataModelById(long movieId) throws IOException {
        Response<Movie> movieResponse =  movieRepository.gatherSingleMovieDataModelById(movieId);

        if (!movieResponse.isSuccessful()) {
            throw new IOException(movieResponse.errorBody() != null
                    ? movieResponse.errorBody().string() : "Unknown error");
        }

        return movieResponse.body();
    }
}
