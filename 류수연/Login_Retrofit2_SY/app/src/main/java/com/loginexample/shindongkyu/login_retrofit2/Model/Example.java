package com.loginexample.shindongkyu.login_retrofit2.Model;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.loginexample.shindongkyu.login_retrofit2.Model.Data;


public class Example{

    @SerializedName("stat")
    @Expose
    public String stat;
    @SerializedName("data")
    @Expose
    public Data data;



}