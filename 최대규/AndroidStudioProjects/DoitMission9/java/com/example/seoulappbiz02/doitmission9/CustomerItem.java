package com.example.seoulappbiz02.doitmission9;

public class CustomerItem {
    private final int resId = R.drawable.user_man_male_profile_account_person_people;
    private String name;
    private String phoneNumber;
    private String birthday;

    public CustomerItem() {
        this.name = null;
        this.phoneNumber = null;
        this.birthday = null;
    }

    public CustomerItem(String name, String phoneNumber, String birthday) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public int getResId() {
        return resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
