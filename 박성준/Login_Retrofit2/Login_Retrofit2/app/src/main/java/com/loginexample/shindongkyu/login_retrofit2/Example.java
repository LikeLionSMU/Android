package com.loginexample.shindongkyu.login_retrofit2;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Example{

    @SerializedName("stat")
    @Expose
    public String stat;

    @SerializedName("data")
    @Expose
    public Data data;

}