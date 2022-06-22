package com.example.movie_demo_java.models;

import com.example.movie_demo_java.services.IssuesTestService;
import com.gen.movie_demo_java.comicstock.IssuesApi;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class ComicStockIntegrationTestConfig {

    @Bean
    public IssuesApi issuesApi() {
        return new IssuesTestService();
    }
}
