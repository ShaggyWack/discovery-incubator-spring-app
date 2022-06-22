package com.example.movie_demo_java.dummy_implementation.models;

import java.util.ArrayList;

public class MovieDataModel {

    private int id;
    private String title;
    private String description;
    private ArrayList<MovieImageModel> images;

    public MovieDataModel(int id, String title, String description, ArrayList<MovieImageModel> images) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.images = images;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<MovieImageModel> getImages() {
        return images;
    }

    @Override
    public String toString() {
        return "MovieApiDataModel{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", images=" + images +
                '}';
    }

    public static class MovieImageModel {
        private String path;
        private String extension;
        private String pathIncludingExtension;

        public MovieImageModel(String path, String extension, String pathIncludingExtension) {
            this.path = path;
            this.extension = extension;
            this.pathIncludingExtension = pathIncludingExtension;
        }

        public String getPath() {
            return path;
        }

        public String getExtension() {
            return extension;
        }

        public String getPathIncludingExtension() {
            return pathIncludingExtension;
        }

        @Override
        public String toString() {
            return "MovieApiImageModel{" +
                    "path='" + path + '\'' +
                    ", extension='" + extension + '\'' +
                    ", pathIncludingExtension='" + pathIncludingExtension + '\'' +
                    '}';
        }
    }
}