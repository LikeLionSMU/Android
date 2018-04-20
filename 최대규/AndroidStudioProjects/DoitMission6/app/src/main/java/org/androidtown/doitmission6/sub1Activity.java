package org.androidtown.doitmission6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sub1Activity extends AppCompatActivity {

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sub1Activity extends AppCompatActivity {

    private Button toMenu;
    private Button toLogin;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub1);
        toMenu = findViewById(R.id.button4);
        toLogin = findViewById(R.id.button5);
    }

    public void toMenuProcess(View view){
        Intent intent = new Intent();
        intent.putExtra("name_sub1", "sub1Activity");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void toLogInProcess(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("name", "sub1Activity");
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);

        finish();
    }
}
