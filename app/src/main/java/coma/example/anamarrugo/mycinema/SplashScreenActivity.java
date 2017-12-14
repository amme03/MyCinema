package coma.example.anamarrugo.mycinema;

import android.content.Intent;
import android.os.AsyncTask;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import coma.example.anamarrugo.mycinema.R;
import coma.example.anamarrugo.mycinema.views.activities.MoviesActivity;

public class SplashScreenActivity extends AppCompatActivity {
    // Splash screen timer
    private static int SPLASH_TIME_OUT = 5000;
    String now_playing, earned;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(SplashScreenActivity.this, MoviesActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}