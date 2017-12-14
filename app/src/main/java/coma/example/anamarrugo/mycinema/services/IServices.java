package coma.example.anamarrugo.mycinema.services;

import com.estimote.coresdk.cloud.model.User;


import java.util.ArrayList;

import coma.example.anamarrugo.mycinema.model.Records;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;

/**
 * Created by ana.marrugo on 12/12/2017.
 */

public interface IServices {



    @GET("/user/auth")
    User login(@Query("email") String user, @Query("password") String password);


    @GET("/user")
    User autoLogin(@Header("Authorization") String token);




    @GET("/current.xml")
    Records getMovies();
}
