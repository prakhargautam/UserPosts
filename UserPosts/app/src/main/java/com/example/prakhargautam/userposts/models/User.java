package com.example.prakhargautam.userposts.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by prakhargautam on 22/03/16.
 */
public class User implements Serializable{
    private int id;
    private String name;
    @SerializedName("username")
    private String userName;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
