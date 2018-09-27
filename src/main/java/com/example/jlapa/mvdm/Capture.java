package com.example.jlapa.mvdm;

public class Capture {
    private  String mName;
    private  String mImageUrl;

    public Capture(){
         //empty constructor needed
    }

    public Capture(String name, String imageUrl){
        if (name.trim().equals("")){
            name = "no Name";
        }
        mName = name;
        mImageUrl = imageUrl;
    }

    public String getmName() {
        return mName;
    }

    public void setName(String name){
        mName = name;
    }

    public String getImageUrl(){
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl){
        mImageUrl = imageUrl;
    }
}
