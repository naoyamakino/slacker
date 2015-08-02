package com.naoya.slacker.data.memory;

import com.naoya.slacker.data.DataFetcher;
import com.naoya.slacker.data.DataRetainer;
import com.naoya.slacker.model.UserList;

import rx.Observable;

/**
 * Created by Naoya on 15-08-01.
 */
public class MemoryDataSource implements DataFetcher, DataRetainer{
    private UserList mUserList;

    @Override
    public Observable<UserList> getUsers() {
        return Observable.just(mUserList);
    }

    @Override
    public void setUser(UserList userList) {
        mUserList = userList;
    }
}
