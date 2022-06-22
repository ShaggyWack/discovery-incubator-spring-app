package com.example.movie_demo_java.dummy_implementation.repositories;

import com.example.movie_demo_java.dummy_implementation.models.MovieDataModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MovieDataRepository {
    private ArrayList<MovieDataModel.MovieImageModel> imageList1 = new ArrayList<>() {{
        add(new MovieDataModel.MovieImageModel(
                "http://i.annihil.us/u/prod/marvel/i/mg/e/e0/56b3abf44dda3",
                "jpg",
                "http://i.annihil.us/u/prod/marvel/i/mg/e/e0/56b3abf44dda3.jpg"
        ));
    } };

    private ArrayList<MovieDataModel.MovieImageModel> imageList2 = new ArrayList<>() {{
        add(new MovieDataModel.MovieImageModel(
                "http://i.annihil.us/u/prod/marvel/i/mg/7/40/56b36c949f91d",
                "jpg",
                "http://i.annihil.us/u/prod/marvel/i/mg/7/40/56b36c949f91d.jpg"
        ));
    } };

    private ArrayList<MovieDataModel.MovieImageModel> imageList3 = new ArrayList<>() {{
        add(new MovieDataModel.MovieImageModel(
                "http://i.annihil.us/u/prod/marvel/i/mg/9/a0/56b4eac074c89",
                "jpg",
                "http://i.annihil.us/u/prod/marvel/i/mg/9/a0/56b4eac074c89.jpg"
        ));
    } };

    private MovieDataModel avengersModel = new MovieDataModel(
            1,
            "Avengers",
            "The movie with all the heroes",
            imageList1
    );

    private MovieDataModel civilWarModel = new MovieDataModel(
            2,
            "Civil War",
            "The movie with some of the the heroes, but not all of them",
            imageList2
    );

    private MovieDataModel inhumansModel = new MovieDataModel(
            3,
            "Inhumans",
            "The movie with even less of the heroes, and some of them aren't human",
            imageList3
    );

    public List<MovieDataModel> gatherMovieDataFromDataSource(){
        return List.of(
                avengersModel,
                civilWarModel,
                inhumansModel
        );
    }

    public MovieDataModel gatherSingleMovieDataModelById(int movieId){
        ArrayList<MovieDataModel> movies = new ArrayList<>(){{
            add(avengersModel);
            add(civilWarModel);
            add(inhumansModel);
        }};

        for (MovieDataModel movie : movies) {
            if (movie.getId() == movieId){
                return movie;
            }
        }

        return null;
    }
}
