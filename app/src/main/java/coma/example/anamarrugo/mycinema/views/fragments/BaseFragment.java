package coma.example.anamarrugo.mycinema.views.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import coma.example.anamarrugo.mycinema.helper.IValidateInternet;
import coma.example.anamarrugo.mycinema.presenter.BasePresenter;
import coma.example.anamarrugo.mycinema.views.BaseActivity;
import coma.example.anamarrugo.mycinema.views.IBaseView;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class BaseFragment <T extends BasePresenter> extends Fragment implements IBaseView {


    private BaseActivity baseActivity;
    private IValidateInternet validateInternet;
    private T presenter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseActivity = (BaseActivity) getActivity();
        validateInternet = baseActivity.getValidateInternet();
    }

    @Override
    public void showProgress(int message) {
        baseActivity.showProgress(message);
    }

    @Override
    public void hideProgress() {
        baseActivity.hideProgress();
    }

    public BaseActivity getBaseActivity() {
        return baseActivity;
    }

    public void setBaseActivity(BaseActivity baseActivity) {
        this.baseActivity = baseActivity;
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }

    public void setValidateInternet(IValidateInternet validateInternet) {
        this.validateInternet = validateInternet;
    }

    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }
}
