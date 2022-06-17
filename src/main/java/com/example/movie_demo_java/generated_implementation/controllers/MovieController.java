package com.example.movie_demo_java.generated_implementation.controllers;

import com.example.movie_demo_java.generated_implementation.services.MovieService;


import com.gen.movie_demo_java.GeneratedApi;
import com.gen.movie_demo_java.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;

@RestController
public class MovieController implements GeneratedApi {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieDataService) {
        this.movieService = movieDataService;
    }

    @Override
    public ResponseEntity<Movie> getMovieById(Long id) {
        try {
            Movie movie = movieService.getSingleDataModelById(id);

            if (movie != null){
                return new ResponseEntity<>(movie,HttpStatus.OK);
            }else{
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR,
                        String.format("Movie with id: %s does not exist", id)
                );
            }

        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "There was an error getting the movie",
                    e);
        }
    }

    @Override
    public ResponseEntity<List<Movie>> getMovies() {
        try {
            return new ResponseEntity<>(movieService.getMovieDataModels(), HttpStatus.OK);
        } catch (IOException e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "There was an error getting ALL the movies",
                    e);

        }
    }
}
