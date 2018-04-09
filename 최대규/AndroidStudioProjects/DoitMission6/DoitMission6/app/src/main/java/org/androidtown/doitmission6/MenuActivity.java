package org.androidtown.doitmission6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private static final int RESULT_CODE_SUB1 = 11;
    private static final int RESULT_CODE_SUB2 = 12;
    private static final int RESULT_CODE_SUB3 = 13;

    private Button customer_info_maintain_button;
    private Button sales_info_maintain_button;
    private Button product_info_maintain_button;
    private Button from_menu_to_login_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        customer_info_maintain_button = findViewById(R.id.button);
        sales_info_maintain_button = findViewById(R.id.button2);
        product_info_maintain_button = findViewById(R.id.button3);

        from_menu_to_login_button = findViewById(R.id.button10);

        customer_info_maintain_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), sub1Activity.class);
                startActivityForResult(intent1, RESULT_CODE_SUB1);
            }
        });

        sales_info_maintain_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getApplicationContext(), sub2.class);
                startActivityForResult(intent2, RESULT_CODE_SUB2);
            }
        });

        product_info_maintain_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getApplicationContext(), sub3.class);
                startActivityForResult(intent3, RESULT_CODE_SUB3);
            }
        });

        from_menu_to_login_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                processCommand();
            }
        });
    }

    private void processCommand(){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("name", "MenuActivity");
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_CODE_SUB1:
                if (resultCode == RESULT_OK){
                    try{
                        Bundle bundle = data.getExtras();
                        String name = bundle.getString("name_sub1");
                        Toast.makeText(this, name + " 메뉴에서 응답함.", Toast.LENGTH_LONG).show();
                    } catch (NullPointerException e){
                        Log.e("MenuActivity", "Null intent를 참조하였습니다");
                    }
                }
                break;
            case RESULT_CODE_SUB2:
                if (resultCode == RESULT_OK){
                    try{
                        Bundle bundle = data.getExtras();
                        String name = bundle.getString("name_sub2");
                        Toast.makeText(this, name + " 메뉴에서 응답함.", Toast.LENGTH_LONG).show();
                    } catch (NullPointerException e){
                        Log.e("MenuActivity", "Null intent를 참조하였습니다");
                    }
                }
                break;
            case RESULT_CODE_SUB3:
                if (resultCode == RESULT_OK){
                    try{
                        Bundle bundle = data.getExtras();
                        String name = bundle.getString("name_sub3");
                        Toast.makeText(this, name + " 메뉴에서 응답함.", Toast.LENGTH_LONG).show();
                    } catch (NullPointerException e){
                        Log.e("MenuActivity", "Null intent를 참조하였습니다");
                    }
                }
                break;
        }
    }
}
