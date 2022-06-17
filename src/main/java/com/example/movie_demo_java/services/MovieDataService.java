package com.example.movie_demo_java.services;

import com.example.movie_demo_java.models.MovieDataModel;
import com.example.movie_demo_java.repositories.MovieDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieDataService {

    private MovieDataRepository movieDataRepository;

    @Autowired
    public MovieDataService(MovieDataRepository movieDataRepository) {
        this.movieDataRepository = movieDataRepository;
    }

    public List<MovieDataModel> getMovieDataModels(){
            return movieDataRepository.gatherMovieDataFromDataSource();
    }

    public MovieDataModel getSingleDataModelById(int movieId){
        return movieDataRepository.gatherSingleMovieDataModelById(movieId);
    }
}
