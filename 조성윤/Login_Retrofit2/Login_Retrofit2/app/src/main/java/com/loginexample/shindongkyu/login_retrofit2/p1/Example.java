package com.loginexample.shindongkyu.login_retrofit2.p1;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Example{

    @SerializedName("stat") //포스트맨에서 응답받은 값들을 나타냄
    @Expose
    public String stat;
    @SerializedName("data")
    @Expose
    public Data data;



}