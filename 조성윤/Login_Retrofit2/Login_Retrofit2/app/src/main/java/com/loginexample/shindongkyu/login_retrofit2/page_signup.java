package com.loginexample.shindongkyu.login_retrofit2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.loginexample.shindongkyu.login_retrofit2.p1.Data;
import com.loginexample.shindongkyu.login_retrofit2.p1.Example;
import com.loginexample.shindongkyu.login_retrofit2.p1.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by syJOE on 2018-05-15.
 */

public class page_signup extends AppCompatActivity{
    APIinterface2 apiinterface2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_signup);

        apiinterface2 = APIClient.getClient().create(APIinterface2.class);

        Button b2 = (Button)findViewById(R.id.button2);
        Button b4 = (Button)findViewById(R.id.button4);

        b2.setOnClickListener(new View.OnClickListener() {//JOIN버튼
            EditText emailtext = (EditText)findViewById(R.id.editText3);
            EditText pwdtext = (EditText)findViewById(R.id.editText4);

            @Override
            public void onClick(View v) {
                String email = emailtext.getText().toString();
                String pwd = pwdtext.getText().toString();
                User user = new User(email, pwd);

                Call<Example> gotologin = apiinterface2.login(user);

                gotologin.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        String displayResponse="";

                        int code3 = response.code();
                        String stringcode3 = Integer.toString(code3);

                        if("201".equals(stringcode3)){
                            Example loginresponse = response.body();
                            displayResponse +="loginstat: "+loginresponse.stat+"\n";
                            Data data = loginresponse.data;
                            displayResponse +="email: "+data.email+"\n"+"ink: "+data.ink+"\n";
                            Toast toast = Toast.makeText(getApplicationContext(), displayResponse, Toast.LENGTH_LONG);
                            toast.show();
                            Intent intent3 = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent3);

                        }
                        else if("401".equals(stringcode3)){
                            Toast toast = Toast.makeText(getApplicationContext(), "이메일이 중복입니다.", Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else if("501".equals(stringcode3)){
                            Toast toast = Toast.makeText(getApplicationContext(), "빈 항목에 정보를 기입해주세요.", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG);
                        toast.show();
                        call.cancel();

                    }
                });
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {//BACK버튼
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent4);
            }
        });
    }
}
