package org.techtown.retrofit2_lr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.techtown.retrofit2_lr.Model.Data;
import org.techtown.retrofit2_lr.Model.Example;
import org.techtown.retrofit2_lr.Model.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    APIinterface_L apiinterface_l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        apiinterface_l = APIClient.getClient().create(APIinterface_L.class);

        Button bt1 = (Button)findViewById(R.id.button); // LOGIN
        Button bt2 = (Button)findViewById(R.id.button2); // SIGNUP

        bt1.setOnClickListener(new View.OnClickListener() { // LOGIN

            EditText emailtxt = (EditText) findViewById(R.id.editText);
            EditText pwdtxt = (EditText) findViewById(R.id.editText2);

            @Override
            public void onClick(View view) {
                String email = emailtxt.getText().toString();
                String pwd = pwdtxt.getText().toString();

                User user = new User(email, pwd);

                Call<Example> gotologin = apiinterface_l.login(user);
                gotologin.enqueue(new Callback<Example>() {
                    @Override
                    public void onResponse(Call<Example> call, Response<Example> response) {
                        String displayResponse = "";

                        int code = response.code();
                        String stringcode = Integer.toString(code);

                        if("201".equals(stringcode)){ // 로그인성공
                            Example loginresponse = response.body();
                            displayResponse += "loginstat: " + loginresponse.stat + "\n";
                            Data data = loginresponse.data;
                            displayResponse += "email: " + data.email + "\n" + "ink: " + data.ink + "\n" + "userid: " + data.userId + "\n";
                            Toast toast = Toast.makeText(getApplicationContext(), displayResponse, Toast.LENGTH_LONG);
                            toast.show();
                        }
                        else{
                            Toast toast = Toast.makeText(getApplicationContext(), "정보를 다시한번 확인해주세요.", Toast.LENGTH_LONG);
                            toast.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Example> call, Throwable t) {
                        Toast toast = Toast.makeText(getApplicationContext(), "인터넷이 연결되어 있지 않습니다.", Toast.LENGTH_LONG);
                        toast.show();

                        call.cancel();
                    }
                });

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() { // SIGNUP
            @Override
            public void onClick(View view) {
                Intent registerIntent= new Intent(MainActivity.this, RegisterActivity.class);
                MainActivity.this.startActivity(registerIntent);
            }
        });
    }
}
