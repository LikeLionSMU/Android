package com.loginexample.shindongkyu.login_retrofit2.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */

public class Data {
    @SerializedName("user_id")
    @Expose
    public Integer userId;
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("ink")
    @Expose
    public Integer ink;

}