package com.naoya.slacker.data;


import com.naoya.slacker.model.UserList;


import rx.Observable;

/**
 * Created by Naoya on 15-08-01.
 */
public interface DataFetcher {

    Observable<UserList> getUsers();
}
