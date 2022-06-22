package com.example.movie_demo_java.handlers;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class FileHandler {

    public JsonNode getMovieMockDataJSON(){
        String path = "src/test/resources/movies_data.json";

        File file = new File(path);

        try {
            String jsonContent = Files.readString(file.toPath(), StandardCharsets.UTF_8);

            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getJsonFactory();
            JsonParser jp = factory.createJsonParser(jsonContent);
            JsonNode jsonNode = mapper.readTree(jp);
            return  jsonNode;
        } catch (IOException e) {
            return null;
        }
    }

    public JsonNode getMovieByIdMockDataJSON(){
        String path = "src/test/resources/single_movie_data.json";

        File file = new File(path);

        try {
            String jsonContent = Files.readString(file.toPath(), StandardCharsets.UTF_8);

            ObjectMapper mapper = new ObjectMapper();
            JsonFactory factory = mapper.getJsonFactory();
            JsonParser jp = factory.createJsonParser(jsonContent);
            JsonNode jsonNode = mapper.readTree(jp);
            return  jsonNode;
        } catch (IOException e) {
            return null;
        }
    }
}
