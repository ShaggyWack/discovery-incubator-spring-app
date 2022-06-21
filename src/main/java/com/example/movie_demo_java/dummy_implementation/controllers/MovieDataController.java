package com.example.movie_demo_java.dummy_implementation.controllers;

import com.example.movie_demo_java.dummy_implementation.models.MovieDataModel;
import com.example.movie_demo_java.dummy_implementation.services.MovieDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(path = "api/issues")
public class MovieDataController {

    private final MovieDataService movieDataService;

    @Autowired
    public MovieDataController(MovieDataService movieDataService) {
        this.movieDataService = movieDataService;
    }

    @GetMapping
    public List<MovieDataModel> getMovieData() {
        return movieDataService.getMovieDataModels();
    }

    @GetMapping(value = "/{id}")
    public MovieDataModel getSingleMovieData(@PathVariable("id") int movieId) throws ResponseStatusException {
        MovieDataModel movie = movieDataService.getSingleDataModelById(movieId);

        if (movie != null){
            return movie;
        }else{
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    String.format("Movie with id: %s does not exist", movieId)
            );
        }
    }
}
