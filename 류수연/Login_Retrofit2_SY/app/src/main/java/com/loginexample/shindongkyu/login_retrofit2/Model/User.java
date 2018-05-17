package com.loginexample.shindongkyu.login_retrofit2.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */

public class User {
    @SerializedName("email")
    public String email;
    @SerializedName("pwd")
    public String pwd;

    public User(String email, String pwd) {
        this.email = email;
        this.pwd = pwd;
    }
}
