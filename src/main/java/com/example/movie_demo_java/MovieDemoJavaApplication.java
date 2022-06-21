package com.example.movie_demo_java;

import com.example.movie_demo_java.generated_implementation.models.ComicStockIntegrationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(ComicStockIntegrationConfig.class)
public class MovieDemoJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(MovieDemoJavaApplication.class, args);
    }
}
