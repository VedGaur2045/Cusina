package com.example.cusina.AdapterClass.DishLoookingRecyclerHolder;

public class dishHolderClass {
    private int productImg,favImg;
    private String productName,productRating,productPrice,productPlace,productShopName;
    private String distance,productAvailibility,pickUpOnly,preOrder;

    public dishHolderClass(int productImg, String productName, String productRating, String productPrice, String productPlace, String productShopName, String distance, String productAvailibility, String pickUpOnly) {
        this.productImg = productImg;
        //this.favImg = favImg;
        this.productName = productName;
        this.productRating = productRating;
        this.productPrice = productPrice;
        this.productPlace = productPlace;
        this.productShopName = productShopName;
        this.distance = distance;
        this.productAvailibility = productAvailibility;
        this.pickUpOnly = pickUpOnly;
        //this.preOrder = preOrder;
    }

    public int getProductImg() {
        return productImg;
    }

    public void setProductImg(int productImg) {
        this.productImg = productImg;
    }

    public int getFavImg() {
        return favImg;
    }

    public void setFavImg(int favImg) {
        this.favImg = favImg;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductRating() {
        return productRating;
    }

    public void setProductRating(String productRating) {
        this.productRating = productRating;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductPlace() {
        return productPlace;
    }

    public void setProductPlace(String productPlace) {
        this.productPlace = productPlace;
    }

    public String getProductShopName() {
        return productShopName;
    }

    public void setProductShopName(String productShopName) {
        this.productShopName = productShopName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getProductAvailibility() {
        return productAvailibility;
    }

    public void setProductAvailibility(String productAvailibility) {
        this.productAvailibility = productAvailibility;
    }

    public String getPickUpOnly() {
        return pickUpOnly;
    }

    public void setPickUpOnly(String pickUpOnly) {
        this.pickUpOnly = pickUpOnly;
    }

    public String getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(String preOrder) {
        this.preOrder = preOrder;
    }
}
