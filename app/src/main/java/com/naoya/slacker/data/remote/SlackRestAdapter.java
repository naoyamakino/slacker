package com.naoya.slacker.data.remote;

import com.naoya.slacker.model.UserList;


import retrofit.http.GET;
import rx.Observable;

/**
 * Created by Naoya on 15-08-01.
 */
public interface SlackRestAdapter {

    @GET("/users.list")
    Observable<UserList> getUsers();
}
