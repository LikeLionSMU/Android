package org.androidtown.doitmission5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int RESULT_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.loginPage_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*
                  Activity.getApplicationContext(): 현재 활성화된 액티비티만이 아닌 어플리케이션 전체에 대한 [incl. all of its activities?] context가 필요한 경우에 사용
                  View.getContext(): 현재 활성화된 activity에 대한 context 참조 시 사용. this를 사용하는 것과 같은 맥락.
                  ContextWrapper.getBaseContext(): 어느 context에서 다른 context를 참조해야 하는 경우 ContextWrapper 객체를 사용하는데, 그 ContextWrapper 안에 있는 context를 참조하는 경우에 사용.
                */

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                startActivityForResult(intent, RESULT_CODE);
            }
        });

    }

    //Alt + Insert => 자동 삽입 단축키


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RESULT_CODE){
            if (resultCode == RESULT_OK){
                String name = data.getStringExtra("name");
                Toast.makeText(this, "선택되었던 메뉴: " + name, Toast.LENGTH_LONG).show();
            }
        }
    }
}
