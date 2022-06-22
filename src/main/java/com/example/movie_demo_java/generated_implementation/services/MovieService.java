package com.example.movie_demo_java.generated_implementation.services;

import com.example.movie_demo_java.generated_implementation.mappers.AppModelMapper;
import com.example.movie_demo_java.generated_implementation.repositories.MovieRepository;

import com.gen.movie_demo_java.comicstock.models.IssueDto;
import com.gen.movie_demo_java.movies.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final AppModelMapper appModelMapper = new AppModelMapper();

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movie> getMovieDataModels() throws NullPointerException, IOException {

        Response<List<IssueDto>> movieListResponse = movieRepository.gatherMovieDataFromDataSource();

        if (!movieListResponse.isSuccessful()) {
            throw new IOException(movieListResponse.errorBody() != null
                    ? movieListResponse.errorBody().string() : "Unknown error");
        }

        List<IssueDto> issuesList = movieListResponse.body();

        return appModelMapper.fromIssueListDTOToMovieModelList(issuesList);
    }

    public Movie getSingleDataModelById(long movieId) throws NullPointerException, IOException {
        Response<IssueDto> movieResponse = movieRepository.gatherSingleMovieDataModelById(movieId);

        if (!movieResponse.isSuccessful()) {
            throw new IOException(movieResponse.errorBody() != null
                    ? movieResponse.errorBody().string() : "Unknown error");
        }

        IssueDto issue = movieResponse.body();

        return appModelMapper.fromIssueDTOToMovieModel(issue);
    }
}
