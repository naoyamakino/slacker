package com.naoya.slacker.model;

/**
 * Created by Naoya on 15-08-01.
 */
public class Profile {
    private String firstName;
    private String lastName;
    private String email;
    private String skype;
    private String phone;
    private String image_24;
    private String image_32;
    private String image_48;
    private String image_72;
    private String image_192;

    private String mUserId;

    public String getUserId() {
        return mUserId;
    }

    public void setUserId(String userId) {
        mUserId = userId;
    }
}
