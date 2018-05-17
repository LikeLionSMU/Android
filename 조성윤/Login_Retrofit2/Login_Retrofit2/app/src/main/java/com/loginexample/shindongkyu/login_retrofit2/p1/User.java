package com.loginexample.shindongkyu.login_retrofit2.p1;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */

public class User {//모델링 - json파일에 맞게끔 매핑해주는 것
    @SerializedName("email")
    public String email;
    @SerializedName("pwd")
    public String pwd;

    public User(String email, String pwd) {//받아서 바로 보내기 위해
        this.email = email;
        this.pwd = pwd;
    }
}
