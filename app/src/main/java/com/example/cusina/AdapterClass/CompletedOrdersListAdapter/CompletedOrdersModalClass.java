package com.example.cusina.AdapterClass.CompletedOrdersListAdapter;

public class CompletedOrdersModalClass {
    private Integer imageName,orderCount;
    private String productName,productPrice, productSubTotalPrice,deliveryFees;

    public CompletedOrdersModalClass(Integer imageName, Integer orderCount, String productName, String productPrice, String productSubTotalPrice, String deliveryFees) {
        this.imageName = imageName;
        this.orderCount = orderCount;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productSubTotalPrice = productSubTotalPrice;
        this.deliveryFees = deliveryFees;
    }

    public Integer getImageName() {
        return imageName;
    }

    public void setImageName(Integer imageName) {
        this.imageName = imageName;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductSubTotalPrice() {
        return productSubTotalPrice;
    }

    public void setProductSubTotalPrice(String productSubTotalPrice) {
        this.productSubTotalPrice = productSubTotalPrice;
    }

    public String getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(String deliveryFees) {
        this.deliveryFees = deliveryFees;
    }
}
