package com.naoya.slacker.model;

import com.naoya.slacker.data.disk.Db;
import com.naoya.slacker.data.disk.ProfileData;
import com.naoya.slacker.data.disk.UserData;

import android.content.ContentValues;
import android.database.Cursor;

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

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Profile getProfile() {
        return profile;
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
        contentValues.put(UserData.UserColumns.ID, id);
        contentValues.put(UserData.UserColumns.COLOR, color);
        //TODO: added rest of values in content values
        return contentValues;
    }

    public User(Cursor cursor) {
        id = (Db.getString(cursor, UserData.UserColumns.ID));
        color = (Db.getString(cursor, UserData.UserColumns.COLOR));
        profile = new Profile();
        profile.setRealName(Db.getString(cursor, ProfileData.ProfileColumns.REAL_NAME));
    }
}
