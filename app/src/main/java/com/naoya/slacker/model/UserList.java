package com.naoya.slacker.model;

import java.util.List;

/**
 * Created by Naoya on 15-08-01.
 */
public class UserList {
    private Boolean ok;
    private List<User> members;

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
