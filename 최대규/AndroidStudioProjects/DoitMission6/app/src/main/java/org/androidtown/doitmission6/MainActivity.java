package org.androidtown.doitmission6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_CODE = 1;
    private static final int RESULT_CODE_SUB1 = 11;
    private static final int RESULT_CODE_SUB2 = 12;
    private static final int RESULT_CODE_SUB3 = 13;

    private EditText id_text;
    private EditText pass_text;
    private Button login_button;

   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         id_text = findViewById(R.id.editText);
         pass_text = findViewById(R.id.editText2);
         login_button = findViewById(R.id.logButton);

         login_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 if(id_text.getText().toString().equals("")){
                     Toast.makeText(MainActivity.this, "ID를 입력해주세요.", Toast.LENGTH_LONG).show();
                 }
                 else if(pass_text.getText().toString().equals("")){
                     Toast.makeText(MainActivity.this, "PASSWORD를 입력해주세요.", Toast.LENGTH_LONG).show();
                 }
                 else{
                     Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                     startActivityForResult(intent, RESULT_CODE);
                 }
             }
         });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_CODE:
                if(resultCode == RESULT_OK){
                    try{
                        Bundle bundle = data.getExtras();
                        String name = bundle.getString("name");
                        Toast.makeText(this, name + " 메뉴에서 응답함.", Toast.LENGTH_LONG).show();
                    } catch (NullPointerException e){
                        Log.e("MainActivity", "Null intent를 참조하였습니다");
                    }
                }
                break;


        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        try{
            Bundle bundle = intent.getExtras();
            String name = bundle.getString("name");
            Toast.makeText(this, name + " 메뉴에서 응답함.", Toast.LENGTH_LONG).show();
        } catch (NullPointerException e){
            Log.e("MainActivity", "Null intent를 참조하였습니다");
        }
   }
}
