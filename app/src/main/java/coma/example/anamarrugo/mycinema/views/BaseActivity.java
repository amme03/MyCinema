package coma.example.anamarrugo.mycinema.views;



import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;




import java.lang.reflect.ParameterizedType;

import coma.example.anamarrugo.mycinema.common.StateMaintainer;
import coma.example.anamarrugo.mycinema.helper.IValidateInternet;
import coma.example.anamarrugo.mycinema.helper.ShowAlertDialog;
import coma.example.anamarrugo.mycinema.helper.ValidateInternet;
import coma.example.anamarrugo.mycinema.presenter.BasePresenter;
import coma.example.anamarrugo.mycinema.repository.BaseRepository;


/**
 * Created by leidyzulu on 16/09/17.
 */

public class BaseActivity<T extends BasePresenter,B extends BaseRepository> extends AppCompatActivity implements IBaseView {

    private StateMaintainer stateMaintainer = new StateMaintainer( getFragmentManager(), BaseActivity.class.getName() );
    private IValidateInternet validateInternet;
    private ProgressDialog progressDialog;
    private T presenter;
    private ShowAlertDialog showAlertDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        validateInternet = new ValidateInternet(BaseActivity.this);
        this.showAlertDialog = new ShowAlertDialog(this);
        setupMVP(
                (Class)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]),
                (Class)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[1])
        );
    }

    private void setupMVP( Class<T> classPresenter, Class<B> classRepository ) {
        if( stateMaintainer.firstTimeIn() ) {
            try {
                setPresenter( classPresenter.newInstance() );
                Log.w("myApp","presnter Nuevo:"+getPresenter());
                getPresenter().setRepository( classRepository==null || classRepository.getName().equals("co.com.etn.movies.repository.BaseRepository") ? null : classRepository.newInstance() );
                getPresenter().inject(this, getValidateInternet());
                stateMaintainer.put(getPresenter());
            } catch( Exception e ){
                e.printStackTrace();
            }
        }
        else {
            setPresenter( (T) stateMaintainer.get( classPresenter.getName() ) );
        }
    }

    public ShowAlertDialog getShowAlertDialog() {
        return showAlertDialog;
    }

    @Override
    public void showProgress(int message) {
        progressDialog.setMessage(getResources().getString(message));
        progressDialog.show();
    }

    public void createProgressDialog(){
        this.progressDialog = new ProgressDialog(this);
    }

    @Override
    public void hideProgress() {
        progressDialog.dismiss();
    }

    public IValidateInternet getValidateInternet() {
        return validateInternet;
    }


    public T getPresenter() {
        return presenter;
    }

    public void setPresenter(T presenter) {
        this.presenter = presenter;
    }

}
