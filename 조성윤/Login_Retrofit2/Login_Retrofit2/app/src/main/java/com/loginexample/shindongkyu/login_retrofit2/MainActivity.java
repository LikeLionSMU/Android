package com.loginexample.shindongkyu.login_retrofit2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    APIinterface apiinterface; //api에 있는 인터페이스를 사용할 것이기 때문에

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiinterface = APIClient.getClient().create(APIinterface.class);//apiClient를 사용할 것

        Button b = (Button)findViewById(R.id.button);
        Button b3 = (Button)findViewById(R.id.button3);

        b.setOnClickListener(new View.OnClickListener() {//LOGIN버튼

            EditText emailtxt = (EditText) findViewById(R.id.editText);
            EditText pwdtxt = (EditText) findViewById(R.id.editText2);

            @Override
            public void onClick(View view) {
                String email = emailtxt.getText().toString();
                String pwd = pwdtxt.getText().toString();
                User user = new User(email,pwd);//user라는 객체에 emailtxt, pwdtxt에 있는 값을 넣어줌

                Call<Example> gotologin = apiinterface.login(user);//user객체를 interface login에 넣어줌

                gotologin.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {

                        String displayResponse = "";

                        int code = response.code();//응답에서 코드
                        String stringcode = Integer.toString(code);

                        if ("201".equals(stringcode)){
                            Example loginresponse = response.body();
                            displayResponse += "loginstat: " + loginresponse.stat +"\n";
                            Data data = loginresponse.data;
                            displayResponse += "email: " + data.email+ "\n" + "ink: " +data.ink + "\n" + "userid: " + data.userId + "\n";
                            Toast toast = Toast.makeText(getApplicationContext(), displayResponse, Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else{
                            Toast toast = Toast.makeText(getApplicationContext(), "정보를 제대로 입력해주세요", Toast.LENGTH_LONG);
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

        b3.setOnClickListener(new View.OnClickListener() {//SIGNUP버튼

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), page_signup.class);
                startActivity(intent);
            }
        });
    }
}
