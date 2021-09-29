package com.example.unit4demo.models;

import org.parceler.Parcel;

@Parcel
public class Movie {

    String title;
    String imageUrl;

    public Movie(){}

    public Movie(String title, String imageUrl){
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public String getTitle(){
        return title;
    }
    public String getImageUrl(){
        return imageUrl;
    }
}

