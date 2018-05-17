package com.loginexample.shindongkyu.login_retrofit2;

import com.loginexample.shindongkyu.login_retrofit2.p1.Example;
import com.loginexample.shindongkyu.login_retrofit2.p1.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by syJOE on 2018-05-15.
 */

public interface APIinterface2 {

    @POST("login/signup")
    Call<Example> login(@Body User user);
}
