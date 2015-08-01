package com.naoya.slacker.data;

import com.naoya.slacker.model.User;

import java.util.List;

import retrofit.http.GET;

/**
 * Created by Naoya on 15-08-01.
 */
public interface SlackRestAdapter {

    @GET("/users.list")
    List<User> getUsers();
}
