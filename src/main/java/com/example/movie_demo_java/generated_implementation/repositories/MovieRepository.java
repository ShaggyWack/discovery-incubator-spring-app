package com.example.movie_demo_java.generated_implementation.repositories;

import com.gen.movie_demo_java.comicstock.IssuesApi;
import com.gen.movie_demo_java.comicstock.models.IssueDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.io.IOException;
import java.util.List;

@Repository
public class MovieRepository {

    @Autowired
    private IssuesApi issuesApi;
    public List<IssueDto> gatherMovieDataFromDataSource() {
        return issuesApi.issuesGet();
    }

    public IssueDto gatherSingleMovieDataModelById(long movieId) {
        return issuesApi.issuesGet_0((int)movieId);
    }
}
