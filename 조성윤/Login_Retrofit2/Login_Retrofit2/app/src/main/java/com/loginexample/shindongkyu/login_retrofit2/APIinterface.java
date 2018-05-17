package com.loginexample.shindongkyu.login_retrofit2;

/**
 * Created by shindongkyu on 2018. 5. 10..
 */


import com.loginexample.shindongkyu.login_retrofit2.p1.Example;
import com.loginexample.shindongkyu.login_retrofit2.p1.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;



public interface APIinterface {


    @POST("login/signin")//어떤 요청메소드를 보낼 때 baseurl뒤에 붙여줌 명시..
    Call<Example> login(@Body User user);//Call이 어떤 모델을 보내서 하는지 우리는 응답을 받을 때 Example이라는 모델로부터 받음
    //login(어떤 걸 요청할 건지) 우리는 User라는 객체를 보낼 것.interface를 만들어 놓은 것
    //@레트로핏에서 사용... 레트로핏 튜토리얼 참고할 것 레트로핏 자체의 방식




}
