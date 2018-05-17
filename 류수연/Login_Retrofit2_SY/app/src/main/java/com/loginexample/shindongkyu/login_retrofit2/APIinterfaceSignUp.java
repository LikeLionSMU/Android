package com.loginexample.shindongkyu.login_retrofit2;

import com.loginexample.shindongkyu.login_retrofit2.Model.Example;
import com.loginexample.shindongkyu.login_retrofit2.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by 수연 on 2018-05-15.
 */

public interface APIinterfaceSignUp {
    @POST("login/signup")
    Call<Example> login(@Body User user);
}
