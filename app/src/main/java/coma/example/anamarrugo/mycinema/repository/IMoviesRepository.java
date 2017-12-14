package coma.example.anamarrugo.mycinema.repository;

import java.util.ArrayList;

import coma.example.anamarrugo.mycinema.model.MovieInfo;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public interface IMoviesRepository {
    public ArrayList<MovieInfo> getMovies();
}
