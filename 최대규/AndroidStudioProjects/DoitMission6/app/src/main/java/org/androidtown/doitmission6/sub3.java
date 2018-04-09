package org.androidtown.doitmission6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sub3 extends AppCompatActivity {

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sub3 extends AppCompatActivity {

    private Button toMenu;
    private Button toLogIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub3);

        toMenu = findViewById(R.id.button8);
        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name_sub3", "sub3");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        toLogIn = findViewById(R.id.button9);
        toLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("name", "sub3");
                startActivity(intent);
                finish();
            }
        });
    }
}
