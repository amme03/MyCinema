package coma.example.anamarrugo.mycinema.views.activities;

import java.util.ArrayList;

import coma.example.anamarrugo.mycinema.views.IBaseView;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public interface IDetailMovieView extends IBaseView {

    void showToast(int message);
    public void showCastingList(final ArrayList<String> castArrayList);

    void showToast(String message);
}
