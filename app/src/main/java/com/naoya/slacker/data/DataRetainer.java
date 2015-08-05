package com.naoya.slacker.data;

import com.naoya.slacker.model.UserList;

/**
 * Created by Naoya on 15-08-01.
 */
public interface DataRetainer {

    void retainUserList(UserList userList);

    boolean isCached();
}
