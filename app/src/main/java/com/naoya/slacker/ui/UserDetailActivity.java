package com.naoya.slacker.ui;

import com.naoya.slacker.R;
import com.naoya.slacker.data.disk.ProfileImageCache;
import com.naoya.slacker.model.Profile;
import com.naoya.slacker.model.User;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import javax.inject.Inject;

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

    @Bind(R.id.toolBarNameTextView)
    TextView mToolBarName;

    @Bind(R.id.emailTextView)
    TextView mEmailTextView;

    @Bind(R.id.phoneTextView)
    TextView mPhoneTextView;

    @Bind(R.id.profileImage)
    ImageView mProfileImage;

    @Inject
    ProfileImageCache mImageCache;

    private User mUser;

    private Target mTarget = new Target() {
        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            File file = mImageCache.saveImage(UserDetailActivity.this, bitmap, mUser);
            Picasso.with(UserDetailActivity.this).load(file).fit().into(mProfileImage);
        }

        @Override
        public void onBitmapFailed(Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);

        ButterKnife.bind(this);
        mUser = (User) getIntent().getExtras().getSerializable(USER);
        if (mUser == null) {
            throw new IllegalStateException("user must be supplied to a UserDetailActivity");
        }
        if (mUser.getColor() != null) {
            mToolbar.setBackgroundColor(Color.parseColor("#" + mUser.getColor()));
        }

        Profile profile = mUser.getProfile();
        if (profile != null) {
            mToolBarName.setText(profile.getRealName());
            if (profile.getEmail() != null) {
                mEmailTextView.setText(profile.getEmail());
            }

            if (profile.getPhone() != null) {
                mPhoneTextView.setText(profile.getPhone());
            }

            File profileImage = mImageCache.getFile(this, mUser);
            if (profileImage.exists()) {
                Picasso.with(this).load(profileImage).fit().into(mProfileImage);
            } else {
                Picasso.with(this).load(profile.getImage_192()).into(mTarget);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Picasso.with(this).cancelRequest(mTarget);
    }
}
