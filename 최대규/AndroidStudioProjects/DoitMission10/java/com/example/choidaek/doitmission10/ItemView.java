package com.example.choidaek.doitmission10;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ItemView extends LinearLayout {

    private ImageView imageView;
    private TextView nameView;
    private TextView priceView;
    private TextView commentView;

    public ItemView(Context context) {
        super(context);

        init(context);
    }

    public ItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.item_activity, this, true);

        imageView = findViewById(R.id.clothesView);
        nameView = findViewById(R.id.nameText);
        priceView = findViewById(R.id.priceText);
        commentView = findViewById(R.id.commentText);
    }

    public void setImageView(int resId) {
        this.imageView.setImageResource(resId);
    }

    public void setNameView(String name) {
        this.nameView.setText(name);
    }

    public void setPriceView(String price) {
        this.priceView.setText(price);
    }

    public void setCommentView(String comment) {
        this.commentView.setText(comment);
    }
}
