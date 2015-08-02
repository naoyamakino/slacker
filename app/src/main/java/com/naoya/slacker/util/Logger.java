package com.naoya.slacker.util;

import com.naoya.slacker.model.UserList;

import android.util.Log;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Naoya on 15-08-01.
 */
public class Logger {
    static final String TAG = Logger.class.getSimpleName();

    public static Observable.Transformer<UserList, UserList> logSource(final String source) {
        return new Observable.Transformer<UserList, UserList>() {
            @Override
            public Observable<UserList> call(Observable<UserList> observable) {
                return observable.doOnNext(new Action1<UserList>() {
                    @Override
                    public void call(UserList userList) {
                        if (userList == null) {
                            Log.d(TAG, source + " does not have any data.");
                        } else {
                            Log.d(TAG, source + " has data");
                        }
                    }
                });
            }
        };
    }

}
