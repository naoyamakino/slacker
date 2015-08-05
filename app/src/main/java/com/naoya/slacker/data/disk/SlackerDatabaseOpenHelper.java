package com.naoya.slacker.data.disk;

import com.naoya.slacker.model.Profile;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Naoya on 15-08-04.
 */
public class SlackerDatabaseOpenHelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;

    public SlackerDatabaseOpenHelper(Context context) {
        super(context, "slacker.db", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + UserData.TABLE
                + " (" + UserData.UserColumns._ID + " INTEGER PRIMARY KEY,"
                + UserData.UserColumns.ID + " TEXT,"
                + UserData.UserColumns.NAME + " TEXT,"
                + UserData.UserColumns.DELETED + " INTEGER,"
                + UserData.UserColumns.COLOR + " TEXT,"
                + UserData.UserColumns.IS_ADMIN + " INTEGER,"
                + UserData.UserColumns.IS_OWNER + " INTEGER,"
                + UserData.UserColumns.HAS2FA + " INTEGER,"
                + UserData.UserColumns.HAS_FILES + " INTEGER"
                + ")");

        db.execSQL("CREATE TABLE " + ProfileData.TABLE
                + " (" + ProfileData.ProfileColumns._ID + " INTEGER PRIMARY KEY,"
                + ProfileData.ProfileColumns.USER_ID + " TEXT,"
                + ProfileData.ProfileColumns.FIRST_NAME + " TEXT,"
                + ProfileData.ProfileColumns.LAST_NAME + " TEXT,"
                + ProfileData.ProfileColumns.EMAIL + " TEXT,"
                + ProfileData.ProfileColumns.PHONE + " TEXT,"
                + ProfileData.ProfileColumns.SKYPE + " TEXT,"
                + ProfileData.ProfileColumns.IMAGE_24 + " TEXT,"
                + ProfileData.ProfileColumns.IMAGE_32 + " TEXT,"
                + ProfileData.ProfileColumns.IMAGE_48 + " TEXT,"
                + ProfileData.ProfileColumns.IMAGE_72 + " TEXT,"
                + ProfileData.ProfileColumns.IMAGE_192 + " TEXT"
                + ")");

        //TODO: add an index to profiles.userId
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
