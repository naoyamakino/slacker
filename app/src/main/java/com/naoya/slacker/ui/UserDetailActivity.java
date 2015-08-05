package com.naoya.slacker.ui;

import com.naoya.slacker.R;
import com.naoya.slacker.model.User;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Window;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Naoya on 15-08-04.
 */
public class UserDetailActivity extends BaseActivity {
    private static final String USER = "user";
    public static Intent getStartIntent(Context context, User user) {
        Intent intent = new Intent(context, UserDetailActivity.class);
        intent.putExtra(USER, user);
        return intent;
    }

    @Bind(R.id.toolBar)
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        ButterKnife.bind(this);
        User user = (User) getIntent().getExtras().getSerializable(USER);
        if (user == null) {
            throw new IllegalStateException("user must be supplied to a UserDetailActivity");
        }
        if (user.getColor() != null) {
            mToolbar.setBackgroundColor(Color.parseColor("#" + user.getColor()));
        }
    }
}
