package com.example.nailmanna;


import java.util.ArrayList;
import java.util.HashMap;

public class commonData {
    private String LastImageURL = "";
    private String LastLoginID = "";
    private String LastLoginNickname = "";
    private String LastAccess = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ0b2tlbl90eXBlIjoiYWNjZXNzIiwiZXhwIjoxNjUyOTQwMTI0LCJpYXQiOjE2NTI4NTM3MjQsImp0aSI6IjNiZjgyMzIyNWVmYTQxMzJiZjgyNWFkMzNkYWFkYzZjIiwidXNlcl9pZCI6Mn0.OT-ElZRAqNkJbnUTR8I6voIOPlFmWpC7mdeLr4ffJzw";
    private String My_Photo="";
    private String My_Photo_Title="";
    private String Re_Photo="";
    private String Re_Photo_Title="";


    private HashMap<String, String> My_Photo_info = null;

    private HashMap<String, String> My_Photo_Like = null;

    private HashMap<String, String> My_Photo_Made = null;

    private ArrayList<Integer> LikeCount = null;

    public void SetLastImageURL(String url){
        this.LastImageURL = url;
    }
    public String GetLastImageURL(){
        return LastImageURL;
    }

    public void SetLastLoginNickname(String nickname){ this.LastLoginNickname = nickname; }
    public String GetLastLoginNickname(){ return LastLoginNickname; }

    public void SetMyPhoto(String My_Photo) { this.My_Photo = My_Photo;}
    public String GetMyPhoto() { return My_Photo;}

    public void SetMyPhotoTitle (String My_Photo_Title) { this.My_Photo_Title = My_Photo_Title;}
    public String GetMyPhotoTitle() { return My_Photo_Title;}

    public void SetRePhotoTitle (String Re_Photo_Title ) { this.Re_Photo_Title = Re_Photo_Title; }
    public String GetRePhotoTitle() { return Re_Photo_Title; }

    public void SetLastLoginID(String ID){ this.LastLoginID = ID; }
    public String GetLastLoginID(){ return LastLoginID; }

    public void setLastAccess(String access){ this.LastAccess = access;}
    public String GetLastAccess(){ return LastAccess;}

    public void SetPhotoInfo(HashMap<String, String> hashMap ) {this.My_Photo_info = hashMap; }
    public HashMap<String, String> GetPhotoInfo(){ return My_Photo_info; }


    public void SetPhotoLike(HashMap<String, String> hashMap ) { this.My_Photo_Like = hashMap; }
    public HashMap<String, String> GetPhotoLike(){ return My_Photo_Like; }

    public void SetPhotoMade(HashMap<String, String> hashMap ) { this.My_Photo_Made = hashMap; }
    public HashMap<String, String> GetPhotoMade(){ return My_Photo_Made; }

    public void SetLikeCount(ArrayList<Integer> arrayList) { this.LikeCount = arrayList; }
    public ArrayList<Integer> GetLikeCount() {return LikeCount; }

    private static commonData instance = null;

    public static synchronized commonData getInstance(){
        if(null == instance){
            instance = new commonData();
        }
        return instance;
    }

}
