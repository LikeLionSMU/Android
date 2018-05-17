package com.loginexample.shindongkyu.login_retrofit2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main2Activity extends AppCompatActivity {

    APIinterface apiinterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        apiinterface = APIClient.getClient().create(APIinterface.class);


        //회원가입
        Button b = (Button)findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {

            EditText emailtxt = (EditText) findViewById(R.id.editText);
            EditText pwdtxt = (EditText) findViewById(R.id.editText2);


            @Override
            public void onClick(View view) {
                String email = emailtxt.getText().toString();
                String pwd = pwdtxt.getText().toString();

                User user = new User(email,pwd);

                Call<Example> gotoregister = apiinterface.signup(user);
                gotoregister.enqueue(new Callback<Example>() {

                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {

                        String displayResponse = "";


                        int code = response.code();
                        String stringcode = Integer.toString(code);


                        if ("201".equals(stringcode)){
                            Example registerresponse = response.body();
                            displayResponse += "registerstat: " + registerresponse.stat +"\n";
                            Data data = registerresponse.data;
                            //displayResponse += "email: " + data.email+ "\n" + "ink: " +data1a.ink + "\n" + "userid: " + data.userId + "\n";
                            displayResponse += "email: " + data.email+ "\n" + "ink: " +data.ink + "\n";
                            Toast toast = Toast.makeText(getApplicationContext(), displayResponse, Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else if("401".equals(stringcode)) {
                            Toast toast = Toast.makeText(getApplicationContext(), "이메일이 중복됩니다.", Toast.LENGTH_LONG);
                            toast.show();
                        }

                        else{
                        //501
                            Toast toast = Toast.makeText(getApplicationContext(), "정보를 입력해주세요", Toast.LENGTH_LONG);
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

        Button b1 = findViewById(R.id.button2);

        //뒤로가기
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();

            }
        });


    }
}
