package com.naoya.slacker.model;

import com.naoya.slacker.data.disk.ProfileData;

import android.content.ContentValues;

import java.io.Serializable;

/**
 * Created by Naoya on 15-08-01.
 */
public class Profile implements Serializable{
    private String firstName;
    private String lastName;
    private String realName;
    private String email;
    private String skype;
    private String phone;
    private String image_24;
    private String image_32;
    private String image_48;
    private String image_72;
    private String image_192;

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getRealName() {
        return realName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setImage_192(String image_192) {
        this.image_192 = image_192;
    }

    public String getImage_192() {
        return image_192;
    }

    public ContentValues getContentValues(String userId) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ProfileData.ProfileColumns.USER_ID, userId);
        contentValues.put(ProfileData.ProfileColumns.REAL_NAME, realName);
        contentValues.put(ProfileData.ProfileColumns.EMAIL, email);
        contentValues.put(ProfileData.ProfileColumns.SKYPE, skype);
        contentValues.put(ProfileData.ProfileColumns.PHONE, phone);
        contentValues.put(ProfileData.ProfileColumns.IMAGE_24, image_24);
        contentValues.put(ProfileData.ProfileColumns.IMAGE_192, image_192);
        return contentValues;
    }
}
