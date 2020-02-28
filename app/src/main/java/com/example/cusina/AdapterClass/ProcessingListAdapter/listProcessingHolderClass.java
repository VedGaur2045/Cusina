package com.example.cusina.AdapterClass.ProcessingListAdapter;

public class listProcessingHolderClass {
    private String orderedProductName;
    private int imageStr,servingNumber;

    public listProcessingHolderClass(int imageStr, int servingNumber, String orderedProductName) {
        this.imageStr = imageStr;
        this.servingNumber = servingNumber;
        this.orderedProductName = orderedProductName;
    }

    public int getImageStr() {
        return imageStr;
    }

    public listProcessingHolderClass setImageStr(int imageStr) {
        this.imageStr = imageStr;
        return this;
    }

    public int getServingNumber() {
        return servingNumber;
    }

    public listProcessingHolderClass setServingNumber(int servingNumber) {
        this.servingNumber = servingNumber;
        return this;
    }

    public String getOrderedProductName() {
        return orderedProductName;
    }

    public listProcessingHolderClass setOrderedProductName(String orderedProductName) {
        this.orderedProductName = orderedProductName;
        return this;
    }
}
