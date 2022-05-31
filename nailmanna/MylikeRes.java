package com.example.nailmanna;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;

public class MylikeRes {
    @SerializedName("user")
    @Expose
    private Integer user;
    @SerializedName("my_photo_title")
    @Expose
    private String my_photo_title;
    @SerializedName("my_photo")
    @Expose
    private String my_photo;
    @SerializedName("like_users")
    @Expose
    private Array like_users;

    public Integer getUser() {
        return user;
    }

    public void setUser(Integer user) {
        this.user = user;
    }

    public String getMyphototitle() {
        return my_photo_title;
    }

    public void setMyphototitle(String my_photo_title) {
        this.my_photo_title = my_photo_title;
    }

    public String getMyphoto() {
        return my_photo;
    }

    public void setMyphoto(String my_photo) {
        this.my_photo = my_photo;
    }

    public void setLikeusers(Array like_users) { this.like_users = like_users; }

    public Array GetLikeusers() { return like_users; }
}
