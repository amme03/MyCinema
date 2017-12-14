package coma.example.anamarrugo.mycinema.helper;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public class ValidateInternet implements IValidateInternet{

    private Context context;

    public ValidateInternet(Context context) {
        this.context = context;
    }

    @Override
    public boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting() && networkInfo.isAvailable() && networkInfo.isConnected();

    }
}
