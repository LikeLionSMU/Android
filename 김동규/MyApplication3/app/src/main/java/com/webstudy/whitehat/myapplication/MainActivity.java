package com.webstudy.whitehat.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);

                startActivityForResult(intent, 101);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 101 && resultCode == 0){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), name + " 요청코드: " + requestCode + " 결과코드: "+resultCode, Toast.LENGTH_SHORT).show();
        }
        else if(requestCode == 101 && resultCode == 1){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), name + " 요청코드: " + requestCode + " 결과코드: "+resultCode, Toast.LENGTH_SHORT).show();
        }
        else if(requestCode == 101 && resultCode == 2){
            String name = data.getStringExtra("name");
            Toast.makeText(getApplicationContext(), name + " 요청코드: " + requestCode + " 결과코드: "+resultCode, Toast.LENGTH_SHORT).show();
        }
    }
}
