package com.naoya.slacker.ui;

import com.naoya.slacker.model.User;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Naoya on 15-08-04.
 */
public class UserDetailActivity extends BaseActivity {
    private static final String USER_ID = "user_id";
    public static Intent getStartIntent(Context context, User user) {
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra(USER_ID, user.getId());
        return intent;
    }
}
