package com.naoya.slacker.data.disk;

import android.provider.BaseColumns;

/**
 * Created by Naoya on 15-08-04.
 */
public interface ProfileData {
    String TABLE = "profiles";

    interface ProfileColumns extends BaseColumns {
        String USER_ID = "userId";
        String FIRST_NAME = "firstName";
        String LAST_NAME = "lastName";
        String REAL_NAME = "realName";
        String EMAIL = "email";
        String PHONE = "phone";
        String SKYPE = "skype";
        String IMAGE_24 = "image_24";
        String IMAGE_32 = "image_32";
        String IMAGE_48 = "image_48";
        String IMAGE_72 = "image_72";
        String IMAGE_192 = "image_192";
    }
}
