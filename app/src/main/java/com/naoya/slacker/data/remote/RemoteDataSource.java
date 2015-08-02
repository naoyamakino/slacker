package com.naoya.slacker.data.remote;

import com.naoya.slacker.data.DataFetcher;
import com.naoya.slacker.model.UserList;

import rx.Observable;

/**
 * Created by Naoya on 15-08-01.
 */
public class RemoteDataSource implements DataFetcher{
    private SlackRestAdapter mRestAdapter;

    public RemoteDataSource(SlackRestAdapter restAdapter) {
        mRestAdapter = restAdapter;
    }

    @Override
    public Observable<UserList> getUsers() {
        return mRestAdapter.getUsers();
    }
}