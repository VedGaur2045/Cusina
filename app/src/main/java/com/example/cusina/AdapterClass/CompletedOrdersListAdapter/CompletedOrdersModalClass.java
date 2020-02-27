package com.example.cusina.AdapterClass.CompletedOrdersListAdapter;

public class CompletedOrdersModalClass {
    private Integer imageName,orderCount;
    private double productPrice, productSubTotalPrice,deliveryFees;
    private String productName;

    public CompletedOrdersModalClass(Integer imageName, Integer orderCount, String productName, double productPrice, double productSubTotalPrice, double deliveryFees) {
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

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public double getProductSubTotalPrice() {
        return productSubTotalPrice;
    }

    public void setProductSubTotalPrice(double productSubTotalPrice) {
        this.productSubTotalPrice = productSubTotalPrice;
    }

    public double getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(double deliveryFees) {
        this.deliveryFees = deliveryFees;
    }
}
