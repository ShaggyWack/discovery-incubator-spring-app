package com.example.movie_demo_java;

import com.example.movie_demo_java.generated_implementation.controllers.MovieController;
import com.example.movie_demo_java.generated_implementation.mappers.AppModelMapper;
import com.example.movie_demo_java.handlers.FileHandler;
import com.example.movie_demo_java.models.ComicStockIntegrationTestConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.gen.movie_demo_java.comicstock.models.IssueDto;
import com.gen.movie_demo_java.comicstock.models.ResourceDto;
import com.gen.movie_demo_java.movies.models.Movie;
import com.gen.movie_demo_java.movies.models.MovieImages;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(ComicStockIntegrationTestConfig.class)
class MovieDemoJavaApplicationTests {
    //Wiremock controller mocking
    private static final String moviesPath = "/generated/issues";
    private static final long moviesId = 56016L;

    private static WireMockServer wireMockServer = new WireMockServer();
    private final FileHandler fileHandler = new FileHandler();
    private final MovieController movieController;


    @Autowired
    public MovieDemoJavaApplicationTests(MovieController movieController) {
        this.movieController = movieController;
    }


    @BeforeAll
    static void startWireMock() {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig()
                .dynamicPort()
                .bindAddress("127.0.0.1"));

        wireMockServer.start();
    }

    @AfterAll
    static void stopWireMock() {
        wireMockServer.stop();
    }

    @Test
    public void testSuccessMovieGetApi() {
        JsonNode mockJson = fileHandler.getMovieMockDataJSON();
        wireMockServer.stubFor(get(urlEqualTo(moviesPath))
                        .willReturn(aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withJsonBody(mockJson)));

        ResponseEntity<List<Movie>> movieListResponse = movieController.getMovies();

        assertEquals(HttpStatus.OK, movieListResponse.getStatusCode());
    }

    @Test
    public void testSuccessMovieGetByIdApi() {
        JsonNode mockJson = fileHandler.getMovieByIdMockDataJSON();
        wireMockServer.stubFor(get(urlEqualTo(moviesPath))
                .willReturn(aResponse()
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withJsonBody(mockJson)));

        ResponseEntity<Movie> movieResponse = movieController.getMovieById(moviesId);

        assertEquals(HttpStatus.OK, movieResponse.getStatusCode());

        wireMockServer.stop();
    }

    @Test
    public void testFailureMovieGetApi() {
        wireMockServer.stubFor(get(urlEqualTo(moviesPath))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withFixedDelay(2000)));

        ResponseEntity<List<Movie>> movieListResponse = movieController.getMovies();

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, movieListResponse.getStatusCode());
    }

    @Test
    public void testFailureMovieGetByIdApi() {
        wireMockServer.stubFor(get(urlEqualTo(moviesPath))
                .willReturn(aResponse()
                        .withStatus(500)
                        .withFixedDelay(2000)));

        ResponseEntity<Movie> movieResponse = movieController.getMovieById(moviesId);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, movieResponse.getStatusCode());

        wireMockServer.stop();
    }

    //Mockito Object Mocks
    @Test
    public void shouldAppModelMapperMapIssueDtoToMovie() {
        Movie mockMovieResult = createMockMovieObject();

        IssueDto issueDto = mock(IssueDto.class);

        when(issueDto.getTitle()).thenReturn("Civil War");
        when(issueDto.getId()).thenReturn(1);
        when(issueDto.getDescription()).thenReturn("The movie where they fight");

        List<ResourceDto> images = new ArrayList<>();
        ResourceDto mockResourceDto = new ResourceDto();
        mockResourceDto.setExtension("jpg");
        mockResourceDto.setPath("base/dir/image");
        images.add(mockResourceDto);

        when(issueDto.getImages()).thenReturn(images);

        AppModelMapper appModelMapper = new AppModelMapper();

        assertEquals(mockMovieResult, appModelMapper.fromIssueDTOToMovieModel(issueDto));
    }

    private Movie createMockMovieObject() {
        Movie mockMovieResult = new Movie();

        MovieImages mockMovieImages = createMockMovieImagesObject();

        mockMovieResult.setId(1L);
        mockMovieResult.setTitle("Civil War");
        mockMovieResult.setDescription("The movie where they fight");
        mockMovieResult.setImages(mockMovieImages);

        return mockMovieResult;
    }

    private MovieImages createMockMovieImagesObject() {
        MovieImages mockMovieImages = new MovieImages();
        mockMovieImages.setExtension("jpg");
        mockMovieImages.setPath("base/dir/image");

        return mockMovieImages;
    }
}
