package com.example.movie_demo_java.generated_implementation.repositories;

import com.example.movie_demo_java.generated_implementation.services.IssuesService;
import com.gen.movie_demo_java.comicstock.IssuesApi;
import com.gen.movie_demo_java.comicstock.models.IssueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Repository
public class MovieRepository {

    private final IssuesService issuesService;

    @Autowired
    public MovieRepository(IssuesService issuesService) {
        this.issuesService = issuesService;
    }
    public Response<List<IssueDto>> gatherMovieDataFromDataSource() throws IOException {
        return issuesService.issuesGet().execute();
    }

    public Response<IssueDto> gatherSingleMovieDataModelById(long movieId) throws IOException {
        return issuesService.issuesGet_0((int)movieId).execute();
    }
}
