package com.naoya.slacker.data.disk;

import com.naoya.slacker.data.DataFetcher;
import com.naoya.slacker.data.DataRetainer;
import com.naoya.slacker.model.User;
import com.naoya.slacker.model.UserList;
import com.naoya.slacker.util.Logger;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.functions.Func1;

/**
 * Created by Naoya on 15-08-01.
 */
public class DiskDataSource implements DataFetcher, DataRetainer{
    private BriteDatabase mDatabase;

    public DiskDataSource(BriteDatabase db) {
        mDatabase = db;
    }

    @Override
    public Observable<UserList> getUsers() {
        return mDatabase.createQuery(UserData.TABLE, "select * from users", null)
                .map(new Func1<SqlBrite.Query, UserList>() {
                    @Override
                    public UserList call(SqlBrite.Query query) {
                        UserList userList = new UserList();
                        Cursor cursor = query.run();
                        List<User> users = new ArrayList<User>(cursor.getCount());
                        try {
                            while (cursor.moveToNext()) {
                                User user = new User();
                                user.setName(Db.getString(cursor, UserData.UserColumns.NAME));
                                //TODO: set rest of data
                                users.add(user);
                            }
                            userList.setMembers(users);
                        } finally {
                            cursor.close();
                        }
                        return userList;
                    }
                })
                .compose(Logger.logSource("DISK"));
    }

    @Override
    public void retainUserList(UserList userList) {
        for (User user: userList.getMembers()) {
            mDatabase.insert(UserData.TABLE, user.getContentValues());
        }
    }

    @Override
    public boolean isCached() {
        return false;
    }
}
