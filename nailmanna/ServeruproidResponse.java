package com.example.nailmanna;

import java.io.Serializable;

public class ServeruproidResponse implements Serializable {
    // 전송할 액세스 선언 // 입력하는란
    private String my_photo_title;
    private String my_photo;

    public String getMyphototitle() {
        return my_photo_title;
    }

    public void setMyphototitle(String my_photo_title) {
        this.my_photo_title = my_photo_title;
    }

    public String getMyphoto() {
        return my_photo;
    }

    public void setMyphoto(String myp_hoto) {
        this.my_photo = my_photo;
    }
}
