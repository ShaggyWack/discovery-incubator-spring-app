package com.example.movie_demo_java.generated_implementation.models;

import com.example.movie_demo_java.generated_implementation.services.IssuesService;
import com.gen.movie_demo_java.comicstock.IssuesApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ComicStockIntegrationConfig {
    @Bean
    public IssuesApi issuesApi() {
        return new IssuesService();
    }

}
