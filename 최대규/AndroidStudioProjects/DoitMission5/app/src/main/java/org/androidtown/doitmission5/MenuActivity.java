package org.androidtown.doitmission5;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
    }

    public void button1Clicked(View view){
        Intent intent = new Intent();
        intent.putExtra("name", button1.getText().toString());
        setResult(Activity.RESULT_OK, intent);

        finish();
    }

    public void button2Clicked(View view){
        Intent intent = new Intent();
        intent.putExtra("name", button2.getText().toString());
        setResult(Activity.RESULT_OK, intent);

        finish();
    }

    public void button3Clicked(View view){
        Intent intent = new Intent();
        intent.putExtra("name", button3.getText().toString());
        setResult(Activity.RESULT_OK, intent);

        finish();
    }
}
