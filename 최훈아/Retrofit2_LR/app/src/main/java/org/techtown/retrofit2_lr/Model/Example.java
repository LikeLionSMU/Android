package org.techtown.retrofit2_lr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by HoonAh on 2018-05-14.
 */

public class Example {
    @SerializedName("stat")
    @Expose
    public String stat;
    @SerializedName("data")
    @Expose
    public Data data;
}
