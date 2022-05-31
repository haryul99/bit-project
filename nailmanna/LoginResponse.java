package com.example.nailmanna;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private int id;
    private String username;
    private String nickname;
    private String access;

    public int getId() {
            return id;
            }

    public void setId(int id) { this.id = id; }

    public String getUsername() {
            return username;
            }

    public void setUsername(String username) {
            this.username = username;
            }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccess() {
            return access;
            }

    public void setAccess(String access) {
            this.access = access;
            }


}
