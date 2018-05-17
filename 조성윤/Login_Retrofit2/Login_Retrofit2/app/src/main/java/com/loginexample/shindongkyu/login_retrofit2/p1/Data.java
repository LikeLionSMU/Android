package com.loginexample.shindongkyu.login_retrofit2.p1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */

public class Data {
    @SerializedName("user_id")//json형식을 구조를 모델링해줌
    @Expose
    public Integer userId;
    @SerializedName("email")//json형식을 구조를 모델링해줌
    @Expose
    public String email;
    @SerializedName("ink")//json형식을 구조를 모델링해줌
    @Expose
    public Integer ink;

}