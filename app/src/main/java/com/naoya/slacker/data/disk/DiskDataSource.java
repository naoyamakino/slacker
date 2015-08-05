package com.naoya.slacker.data.disk;

import com.naoya.slacker.data.DataFetcher;
import com.naoya.slacker.model.UserList;

import rx.Observable;

/**
 * Created by Naoya on 15-08-01.
 */
public class DiskDataSource implements DataFetcher{

    @Override
    public Observable<UserList> getUsers() {
        return null;
    }
}
