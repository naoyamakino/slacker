package com.naoya.slacker.data.memory;

import com.naoya.slacker.data.DataFetcher;
import com.naoya.slacker.data.DataRetainer;
import com.naoya.slacker.model.UserList;
import com.naoya.slacker.util.Logger;

import rx.Observable;

/**
 * Created by Naoya on 15-08-01.
 */
public class MemoryDataSource implements DataFetcher, DataRetainer{
    private UserList mUserList;
    private boolean mIsCached;

    @Override
    public Observable<UserList> getUsers() {
        return Observable.just(mUserList).compose(Logger.logSource("MEMORY"));
    }

    @Override
    public void setUser(UserList userList) {
        mUserList = userList;
        if (mUserList != null) mIsCached = true;
    }

    @Override
    public boolean isCached() {
        return mIsCached;
    }
}
