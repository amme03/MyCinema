package coma.example.anamarrugo.mycinema.views.activities;

import java.util.ArrayList;

import coma.example.anamarrugo.mycinema.model.MovieInfo;
import coma.example.anamarrugo.mycinema.views.IBaseView;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public interface IMoviesView extends IBaseView {

    void showMoviesList( ArrayList<MovieInfo> moviesList );

    void showAlertDialogInternet(int title, int message);

    void showAlertError(int title, String message);

}