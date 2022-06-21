package com.example.movie_demo_java.generated_implementation.mappers;

import com.gen.movie_demo_java.comicstock.models.IssueDto;
import com.gen.movie_demo_java.movies.models.Movie;
import com.gen.movie_demo_java.movies.models.MovieImages;

import java.util.ArrayList;
import java.util.List;

public class AppModelMapper {
    public static List<Movie> fromIssueListDTOToMovieModelList(List<IssueDto> issueDtos) throws NullPointerException{
        List<Movie> movies = new ArrayList<>();

        for (IssueDto issueDto: issueDtos) {
            movies.add(fromIssueDTOToMovieModel(issueDto));
        }

        return movies;
    }

    public static Movie fromIssueDTOToMovieModel(IssueDto issueDto) throws NullPointerException{
        Movie movie = new Movie();
        MovieImages movieImages = new MovieImages();

        if (issueDto.getImages() != null && issueDto.getImages().size() != 0) {
            movieImages.setExtension(issueDto.getImages().get(0).getExtension());
            movieImages.setPath(issueDto.getImages().get(0).getPath());
            movieImages.setPathIncludingExtension(issueDto.getImages().get(0).getPathIncludingExtension());
        }

        movie.setId(issueDto.getId().longValue());
        movie.setTitle(issueDto.getTitle());
        movie.setDescription(issueDto.getDescription());
        movie.setImages(movieImages);

        return movie;
    }
}
