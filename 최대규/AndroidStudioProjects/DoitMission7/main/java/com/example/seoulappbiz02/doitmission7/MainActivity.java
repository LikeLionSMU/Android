package com.example.seoulappbiz02.doitmission7;


import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button birthButton;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        long now = System.currentTimeMillis();
        Date date = new Date(now);

        SimpleDateFormat sdf = new SimpleDateFormat(" yyyy년 MM월 dd일 ");
        String getTime = sdf.format(date);

        birthButton = findViewById(R.id.birthButton);
        birthButton.setText(getTime);
        birthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoDialog();
            }
        });

        final EditText name = findViewById(R.id.editText2);
        final EditText age = findViewById(R.id.editText3);

        saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "이름 : " + name.getText().toString() + "\n" +
                        "나이 : " + age.getText().toString() + "\n" +
                        "생년월일 : " + birthButton.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void showInfoDialog(){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_birth_info, null);
        builder.setTitle("생년월일 입력");
        builder.setView(view);

        final Button submit = view.findViewById(R.id.submitButton);
        final Button cancel = view.findViewById(R.id.cancelButton);
        final EditText yearEdit = view.findViewById(R.id.yearEdit);
        final EditText monthEdit = view.findViewById(R.id.monthEdit);
        final EditText dayEdit = view.findViewById(R.id.dayEdit);

        final AlertDialog dialog = builder.create();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String buttonString = "";
                String year = yearEdit.getText().toString();
                String month = monthEdit.getText().toString();
                String day = dayEdit.getText().toString();
                buttonString = buttonString + " " + year + "년 " + month + "월 " +
                        day + "일 ";
                birthButton.setText(buttonString);
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

}
