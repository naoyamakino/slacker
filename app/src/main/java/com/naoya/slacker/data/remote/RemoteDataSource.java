package com.naoya.slacker.data.remote;

import com.naoya.slacker.data.DataFetcher;
import com.naoya.slacker.data.memory.MemoryDataSource;
import com.naoya.slacker.model.UserList;
import com.naoya.slacker.util.Logger;

import rx.Observable;
import rx.functions.Action1;

/**
 * Created by Naoya on 15-08-01.
 */
public class RemoteDataSource implements DataFetcher{
    private SlackRestAdapter mRestAdapter;
    private MemoryDataSource mMemoryDataSource;

    public RemoteDataSource(SlackRestAdapter restAdapter, MemoryDataSource memoryDataSource) {
        mRestAdapter = restAdapter;
        mMemoryDataSource = memoryDataSource;
    }

    @Override
    public Observable<UserList> getUsers() {
        return mRestAdapter.getUsers().doOnNext(new Action1<UserList>() {
            @Override
            public void call(UserList userList) {
                mMemoryDataSource.setUser(userList);
            }
        }).compose(Logger.logSource("NETWORK"));
    }
}
