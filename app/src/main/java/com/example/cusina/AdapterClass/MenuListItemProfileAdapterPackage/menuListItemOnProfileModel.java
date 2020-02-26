package com.example.cusina.AdapterClass.MenuListItemProfileAdapterPackage;

public class menuListItemOnProfileModel {
    private String productName,listtime,imageStr; // imageStr required on API calling
    private Integer image,likesCount,servingLeft;
    private double productPrice;
    private boolean check;

    public menuListItemOnProfileModel(String productName, double productPrice, Integer likesCount, String listtime, Integer servingLeft, Integer image,boolean check) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.likesCount = likesCount;
        this.listtime = listtime;
        this.servingLeft = servingLeft;
        this.image = image;
        this.check = check;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(Integer likesCount) {
        this.likesCount = likesCount;
    }

    public String getListtime() {
        return listtime;
    }

    public void setListtime(String listtime) {
        this.listtime = listtime;
    }

    public Integer getServingLeft() {
        return servingLeft;
    }

    public void setServingLeft(Integer servingLeft) {
        this.servingLeft = servingLeft;
    }

    public String getImageStr() {
        return imageStr;
    }

    public void setImageStr(String imageStr) {
        this.imageStr = imageStr;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
