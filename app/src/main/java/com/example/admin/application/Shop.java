package com.example.admin.application;

public class Shop {
    private String name;
    private String imageId;
    public Shop(String name, String imageId){
        this.name=name;
        this.imageId=imageId;
    }
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getImageId(){return imageId;}
    public void setImageId(String imageId){this.imageId=imageId;}
}
