package coma.example.anamarrugo.mycinema.presenter;

import android.util.Log;

import java.util.ArrayList;

import coma.example.anamarrugo.mycinema.R;
import coma.example.anamarrugo.mycinema.model.MovieInfo;
import coma.example.anamarrugo.mycinema.repository.MapperError;
import coma.example.anamarrugo.mycinema.repository.MoviesRepository;
import coma.example.anamarrugo.mycinema.repository.RepositoryError;
import coma.example.anamarrugo.mycinema.views.activities.IMoviesView;
import retrofit.RetrofitError;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class MoviesPresenter  extends BasePresenter<IMoviesView,MoviesRepository> {

    ArrayList<MovieInfo> moviesList = new ArrayList<MovieInfo>();

    public MoviesPresenter() {
    }

    public void getMovies() {
        if (getValidateInternet().isConnected()) {
            createThreadGetMovies();
        } else {
            getView().showAlertDialogInternet(R.string.error, R.string.validate_internet);
        }
    }

    private void createThreadGetMovies() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                getMoviesRepository();
            }
        });
        thread.start();
    }

    private void getMoviesRepository() {
        try {
            if( moviesList.size()==0 ) {
                moviesList = getRepository().getMovies();
            }
            try { Thread.sleep(1000); } catch( Exception e ){}
            getView().showMoviesList(moviesList);
        } catch (RetrofitError retrofitError) {
            Log.w("myApp","error:"+retrofitError.getMessage()+"");
            Log.w("myApp","error2:"+retrofitError.getResponse()+"");
            Log.w("myApp","error3:"+retrofitError.getCause()+"");
            // retrofitError.getCause().printStackTrace();
            RepositoryError repositoryError = MapperError.convertRetrofitErrorToRepositoryError(retrofitError);
            getView().showAlertError(R.string.error, repositoryError.getMessage());
        }
    }

    public ArrayList<MovieInfo> getMoviesList() {
        return moviesList;
    }

    public void setMoviesList(ArrayList<MovieInfo> moviesList) {
        this.moviesList = moviesList;
    }

}
