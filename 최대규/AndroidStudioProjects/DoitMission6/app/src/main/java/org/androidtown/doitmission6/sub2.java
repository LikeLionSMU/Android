package org.androidtown.doitmission6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sub2 extends AppCompatActivity {

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sub2 extends AppCompatActivity {

    private Button toMenu;
    private Button toLogIn;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub2);

        toLogIn = findViewById(R.id.button7);
        toLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("name", "sub2");
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP| Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);

                finish();
            }
        });

        toMenu = findViewById(R.id.button6);
    }

    public void toMenuProcess_sub2(View view){
        Intent intent = new Intent();
        intent.putExtra("name_sub2", "sub2");
        setResult(RESULT_OK, intent);

        finish();
    }
}
