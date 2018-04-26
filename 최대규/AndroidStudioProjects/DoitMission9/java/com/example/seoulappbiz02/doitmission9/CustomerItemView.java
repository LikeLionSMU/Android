package com.example.seoulappbiz02.doitmission9;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomerItemView extends LinearLayout {

    private ImageView imageView;
    private TextView nameText;
    private TextView birthText;
    private TextView phoneText;

    public CustomerItemView(Context context) {
        super(context);

        init(context);
    }

    public CustomerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
       LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
       inflater.inflate(R.layout.item_customer, this, true);

       imageView = findViewById(R.id.imageView);
       nameText = findViewById(R.id.nameText);
       birthText = findViewById(R.id.birthText);
       phoneText = findViewById(R.id.phoneText);
    }

    public void setImageView(int ResId) {
        this.imageView.setImageResource(ResId);
    }

    public void setNameText(String name) {
        this.nameText.setText(name);
    }

    public void setBirthText(String birthday) {
        this.birthText.setText(birthday);
    }

    public void setPhoneText(String phoneNumber) {
        this.phoneText.setText(phoneNumber);
    }
}
