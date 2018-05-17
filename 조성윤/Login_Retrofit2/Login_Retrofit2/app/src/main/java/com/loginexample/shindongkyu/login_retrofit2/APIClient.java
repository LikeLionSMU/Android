package com.loginexample.shindongkyu.login_retrofit2;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */

public class APIClient {//레트로핏으로 api통신을 할 때 어떤 식으로 사용을 하겠다는 걸 명시해줌

    private static Retrofit retrofit = null;

    static Retrofit getClient() {//코드가 바뀔 일이 거의 없음 baseurl만 바꿔서 사용..
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()//retrofit 빌드
                .baseUrl("http://13.125.61.58:3000/")
                .addConverterFactory(GsonConverterFactory.create())//요청, 응답할 때 어떤 형식으로 파싱을 하는지(우리는 Gson)
                .client(client)
                .build();

        return retrofit;
    }
}
