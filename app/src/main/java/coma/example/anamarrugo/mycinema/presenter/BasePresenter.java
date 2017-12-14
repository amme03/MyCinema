package coma.example.anamarrugo.mycinema.presenter;


import coma.example.anamarrugo.mycinema.helper.IValidateInternet;
import coma.example.anamarrugo.mycinema.repository.BaseRepository;
import coma.example.anamarrugo.mycinema.views.IBaseView;

/**
 * Created by leidyzulu on 16/09/17.
 */

public class BasePresenter <T extends IBaseView,B extends BaseRepository>{

    private T view;
    private B repository;
    private IValidateInternet validateInternet;

    public void inject(T view, IValidateInternet validateInternet) {
        this.view = view;
        this.validateInternet = validateInternet;
    }

    public T getView() {
        return view;
    }

    public <B extends BaseRepository> IValidateInternet getValidateInternet() {
        return validateInternet;
    }

    public B getRepository() {
        return repository;
    }

    public void setRepository(B repository) {
        this.repository = repository;
        if( this.repository!=null ) {
            this.repository.setPresenter(this);
        }
    }

}
