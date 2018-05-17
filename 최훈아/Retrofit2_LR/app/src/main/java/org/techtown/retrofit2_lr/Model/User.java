package org.techtown.retrofit2_lr.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HoonAh on 2018-05-14.
 */

public class User {
    @SerializedName("email")
    public String email;
    @SerializedName("pwd")
    public String pwd;

    public User(String email, String pwd){
        this.email = email;
        this.pwd = pwd;
    }
}
