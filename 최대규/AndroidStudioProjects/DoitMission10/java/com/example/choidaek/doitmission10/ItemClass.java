package com.example.choidaek.doitmission10;

public class ItemClass {
    private int resId;
    private String name;
    private String price;
    private String comment;

    public ItemClass(int resId, String name, String price, String comment) {
        this.resId = resId;
        this.name = name;
        this.price = price;
        this.comment = comment;
    }

    public int getResId() {
        return resId;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getComment() {
        return comment;
    }
}
