package com.example.movie_demo_java.generated_implementation.models;

import com.example.movie_demo_java.generated_implementation.services.IssuesService;
import com.gen.movie_demo_java.comicstock.IssuesApi;
import com.gen.movie_demo_java.comicstock.handler.ApiClient;
import org.springframework.context.annotation.Bean;

public class ComicStockIntegrationConfig {
    @Bean
    public IssuesService IssuesService() {
        return new IssuesService();
    }

    @Bean
    public ApiClient apiClient() {
        return new ApiClient();
    }
}
