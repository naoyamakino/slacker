package com.naoya.slacker.data.disk;

import android.provider.BaseColumns;

/**
 * Created by Naoya on 15-08-04.
 */
public interface UserData {
    String TABLE = "users";
    interface UserColumns extends BaseColumns {
        String ID = "id";
        String NAME = "name";
        String DELETED = "deleted";
        String COLOR = "color";
        String IS_ADMIN = "isAdmin";
        String IS_OWNER = "isOwner";
        String HAS2FA = "has2fa";
        String HAS_FILES = "hasFiles";
    }
}
