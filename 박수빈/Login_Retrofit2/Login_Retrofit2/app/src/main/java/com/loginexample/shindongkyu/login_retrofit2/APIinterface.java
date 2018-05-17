package com.loginexample.shindongkyu.login_retrofit2;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;


public interface APIinterface {


    @POST("login/signin")
    Call<Example> login(@Body User user);

    @POST("login/signup")
    Call<Example> signup(@Body User user);

}
