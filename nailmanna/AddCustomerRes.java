package com.example.nailmanna;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddCustomerRes {

    @SerializedName("user")
    @Expose
    private Integer user;
    @SerializedName("my_photo_title")
    @Expose
    private String my_photo_title;
    @SerializedName("my_photo")
    @Expose
    private String my_photo;
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("like_count")
    @Expose
    private int like_count;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }
}
