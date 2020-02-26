package com.example.cusina.AdapterClass.ProcessingListAdapter;

public class listProcessingHolderClass {
    private String imageStr,servingNumber,orderedProductName;

    public listProcessingHolderClass(String imageStr, String servingNumber, String orderedProductName) {
        this.imageStr = imageStr;
        this.servingNumber = servingNumber;
        this.orderedProductName = orderedProductName;
    }

    public String getImageStr() {
        return imageStr;
    }

    public listProcessingHolderClass setImageStr(String imageStr) {
        this.imageStr = imageStr;
        return this;
    }

    public String getServingNumber() {
        return servingNumber;
    }

    public listProcessingHolderClass setServingNumber(String servingNumber) {
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
