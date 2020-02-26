package com.example.cusina.AdapterClass.productListRecyclerAdapterPackage;

public class viewHolderFile {
    private String productName,productRating,productPrice,servingLeft,productPlace,productShopName;
    private String minimumOrder,distance,deliveryFee,productFavCount,time;
    private Integer productImage;

    public viewHolderFile(String productName, String productRating, String productPrice, String servingLeft, String productPlace, String productShopName, String minimumOrder, String distance, String deliveryFee, String productFavCount, String time, Integer productImage) {
        this.productName = productName;
        this.productRating = productRating;
        this.productPrice = productPrice;
        this.servingLeft = servingLeft;
        this.productPlace = productPlace;
        this.productShopName = productShopName;
        this.minimumOrder = minimumOrder;
        this.distance = distance;
        this.deliveryFee = deliveryFee;
        this.productFavCount = productFavCount;
        this.time = time;
        this.productImage = productImage;
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

    public String getServingLeft() {
        return servingLeft;
    }

    public void setServingLeft(String servingLeft) {
        this.servingLeft = servingLeft;
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

    public String getMinimumOrder() {
        return minimumOrder;
    }

    public void setMinimumOrder(String minimumOrder) {
        this.minimumOrder = minimumOrder;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDeliveryFee() {
        return deliveryFee;
    }

    public void setDeliveryFee(String deliveryFee) {
        this.deliveryFee = deliveryFee;
    }

    public String getProductFavCount() {
        return productFavCount;
    }

    public void setProductFavCount(String productFavCount) {
        this.productFavCount = productFavCount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getProductImage() {
        return productImage;
    }

    public void setProductImage(Integer productImage) {
        this.productImage = productImage;
    }
}
