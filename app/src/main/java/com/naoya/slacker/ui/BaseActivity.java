package com.naoya.slacker.ui;

import com.naoya.slacker.SlackerApplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Naoya on 15-08-01.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SlackerApplication application = (SlackerApplication) getApplicationContext();
        application.getObjectGraph().inject(this);
    }
}
