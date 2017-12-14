package coma.example.anamarrugo.mycinema.presenter;

import coma.example.anamarrugo.mycinema.repository.BaseRepository;
import coma.example.anamarrugo.mycinema.repository.IMoviesRepository;
import coma.example.anamarrugo.mycinema.views.activities.IDetailMovieView;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class DetailMoviesPresenter extends BasePresenter<IDetailMovieView, BaseRepository> {

    private IMoviesRepository moviesRepository;

    public DetailMoviesPresenter(IMoviesRepository moviesRepository) {
        this.moviesRepository = moviesRepository;
    }


}

