package com.example.admin.application;

public class Orders {
    private String name;
    private Integer price;
    private int imageId;
    public Orders(){
    }
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public int getImageId(){return imageId;}
    public void setImageId(int imageId){this.imageId=imageId;}
    public int getPrice(){return price;}
    public void setPrice(Integer price){this.price=price;}
}
