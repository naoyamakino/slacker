package com.naoya.slacker.model;

import com.naoya.slacker.data.disk.UserData;

import android.content.ContentValues;

/**
 * Created by Naoya on 15-08-01.
 */
public class User {
    private String id;
    private String name;
    private Boolean deleted;
    private String color;
    private Profile profile;
    private Boolean isAdmin;
    private Boolean isOwner;
    private Boolean has2fa;
    private Boolean hasFiles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public ContentValues getContentValues() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserData.UserColumns.NAME, name);
        //TODO: added rest of values in content values
        return contentValues;
    }
}
