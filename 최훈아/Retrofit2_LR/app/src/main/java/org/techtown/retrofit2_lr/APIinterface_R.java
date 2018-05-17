package org.techtown.retrofit2_lr;

import org.techtown.retrofit2_lr.Model.Example;
import org.techtown.retrofit2_lr.Model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by HoonAh on 2018-05-14.
 */

public interface APIinterface_R {
    @POST("login/signup")
    Call<Example> join(@Body User user);
}
