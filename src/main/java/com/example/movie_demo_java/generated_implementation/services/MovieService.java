package com.example.movie_demo_java.generated_implementation.services;

import com.example.movie_demo_java.generated_implementation.mappers.AppModelMapper;
import com.example.movie_demo_java.generated_implementation.repositories.MovieRepository;

import com.gen.movie_demo_java.comicstock.models.IssueDto;
import com.gen.movie_demo_java.movies.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getMovieDataModels() throws NullPointerException{

        List<IssueDto> movieListResponse = movieRepository.gatherMovieDataFromDataSource();

        return AppModelMapper.fromIssueListDTOToMovieModelList(movieListResponse);
    }

    public Movie getSingleDataModelById(long movieId) throws NullPointerException {
        IssueDto movieResponse =  movieRepository.gatherSingleMovieDataModelById(movieId);

        return AppModelMapper.fromIssueDTOToMovieModel(movieResponse);
    }
}
