package org.techtown.retrofit2_lr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HoonAh on 2018-05-14.
 */

public class Data {
    @SerializedName("email")
    @Expose
    public String email;
    @SerializedName("ink")
    @Expose
    public Integer ink;
    @SerializedName("user_id")
    @Expose
    public Integer userId;
}
