package coma.example.anamarrugo.mycinema.views.activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;

import coma.example.anamarrugo.mycinema.R;
import coma.example.anamarrugo.mycinema.model.MovieInfo;
import coma.example.anamarrugo.mycinema.presenter.MoviesPresenter;
import coma.example.anamarrugo.mycinema.repository.MoviesRepository;
import coma.example.anamarrugo.mycinema.views.BaseActivity;
import coma.example.anamarrugo.mycinema.views.adapter.MovieAdapter;
import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

/**
 * Created by ana.marrugo on 11/12/2017.
 */

public class MoviesActivity extends BaseActivity<MoviesPresenter,MoviesRepository> implements IMoviesView {

    private ContentLoadingProgressBar progress;
    private FeatureCoverFlow coverFlow;
    private MovieAdapter movieAdapter;


    private TextSwitcher mTitle;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        mTitle = (TextSwitcher) findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater = LayoutInflater.from(MoviesActivity.this);
                TextView txt = (TextView) inflater.inflate( R.layout.layout_title, null );
                return txt;
            }
        });

        Animation in = AnimationUtils.loadAnimation( this, R.anim.slide_in_top );
        Animation out = AnimationUtils.loadAnimation( this, R.anim.slide_out_bottom );
        mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);


        progress = (ContentLoadingProgressBar) findViewById(R.id.progress);
        coverFlow = (FeatureCoverFlow) findViewById( R.id.coverFlow );
        callAdapter();

        progress.show();
        progress.setVisibility(View.VISIBLE);
        getPresenter().getMovies();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private void callAdapter() {
        final ArrayList<MovieInfo> moviesList = getPresenter().getMoviesList();
        movieAdapter = new MovieAdapter( moviesList, this );
        coverFlow.setAdapter( movieAdapter );
        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                if( position<moviesList.size() ) {
                    mTitle.setText(moviesList.get(position).getTitle());
                }
            }
            @Override
            public void onScrolling() {
            }
        });
        coverFlow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent( MoviesActivity.this, MovieDetailActivity.class );
                intent.putExtra("movie", moviesList.get(i) );

                startActivity( intent );
            }
        });
    }

    @Override
    public void showMoviesList(final ArrayList<MovieInfo> moviesList) {
        Log.w("myApp","showMoviesList");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                progress.setVisibility(View.GONE);
                progress.hide();
                callAdapter();

            }
        });
    }

    @Override
    public void showAlertDialogInternet(final int title, final int message) {
        showAlertDialog(title, getResources().getString(message));
    }

    @Override
    public void showAlertError(int title, String message) {
        showAlertDialog(title, message);
    }

    private void showAlertDialog(final int title, final String message) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                getShowAlertDialog().showAlertDialog(title, message, false, R.string.accept, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getPresenter().getMovies();
                    }
                }, R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
            }
        });
    }






}
