package com.ak.project.model;

/**
 * Created by Mayank on 12,August,2021
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    private int id;
    private String username, email, gender;

    public UserModel(int id, String username, String email, String gender) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }
}
