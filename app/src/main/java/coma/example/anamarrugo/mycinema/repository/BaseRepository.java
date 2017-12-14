package coma.example.anamarrugo.mycinema.repository;

import coma.example.anamarrugo.mycinema.presenter.BasePresenter;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class BaseRepository<T extends BasePresenter> {

    private T presenter;

    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

}
