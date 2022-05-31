package com.example.nailmanna;

public class NailItem {
    String num;
    String id;
    String resId;

    public NailItem(String num, String id, String resId) {
        this.num = num;
        this.id = id;
        this.resId = resId;
    }

    public String getNum() {
        return num;
    }
    public void setNum(String num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getResId() {
        return resId;
    }
    public void setResId(String resId) {
        this.resId = resId;
    }
}
