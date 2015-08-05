package com.naoya.slacker.model;

/**
 * Created by Naoya on 15-08-01.
 */
public class User {
    private String id;
    private String name;
    private Boolean deleted;
    private String color;
    private Profile profile;
    private Boolean isAdmin;
    private Boolean isOwner;
    private Boolean has2fa;
    private Boolean hasFiles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
