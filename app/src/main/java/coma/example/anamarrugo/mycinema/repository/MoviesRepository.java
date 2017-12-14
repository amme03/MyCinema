package coma.example.anamarrugo.mycinema.repository;

import java.util.ArrayList;
import coma.example.anamarrugo.mycinema.helper.ServicesFactory;
import coma.example.anamarrugo.mycinema.helper.TypeDecryption;
import coma.example.anamarrugo.mycinema.model.MovieInfo;
import coma.example.anamarrugo.mycinema.model.Records;
import coma.example.anamarrugo.mycinema.presenter.MoviesPresenter;
import coma.example.anamarrugo.mycinema.services.IServices;
import retrofit.RetrofitError;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class MoviesRepository extends BaseRepository<MoviesPresenter> implements IMoviesRepository {

    private IServices services;

    public MoviesRepository() {
        ServicesFactory servicesFactory = new ServicesFactory(TypeDecryption.XML);
        services = (IServices) servicesFactory.getInstance(IServices.class);
    }

    @Override
    public ArrayList<MovieInfo> getMovies() throws RetrofitError {
        Records r = services.getMovies();
        return r.getMovies();
    }

}
