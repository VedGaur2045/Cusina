package com.example.lutongbahay.AdapterClass.ConfirmOrderAdapter;

public class ConfirmOrderModel {

    private double deliveryFees,subTotal,productPriceOrdered;
    private int quantityProduct;
    private String productName;

    public ConfirmOrderModel(String productName,double deliveryFees, double subTotal, double productPriceOrdered, int quantityProduct) {
        this.deliveryFees = deliveryFees;
        this.subTotal = subTotal;
        this.productPriceOrdered = productPriceOrdered;
        this.quantityProduct = quantityProduct;
        this.productName = productName;
    }

    public double getDeliveryFees() {
        return deliveryFees;
    }

    public void setDeliveryFees(double deliveryFees) {
        this.deliveryFees = deliveryFees;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getProductPriceOrdered() {
        return productPriceOrdered;
    }

    public void setProductPriceOrdered(double productPriceOrdered) {
        this.productPriceOrdered = productPriceOrdered;
    }

    public int getQuantityProduct() {
        return quantityProduct;
    }

    public void setQuantityProduct(int quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
