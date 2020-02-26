package com.example.lutongbahay.AdapterClass.CancelledListAdapter;

public class listCancelledHolderClass {
    private String orderedNumber,orderedDate,serverTxtName,transactionId,trayQuantity,totalPrice;

    public listCancelledHolderClass(String orderedNumber, String orderedDate, String serverTxtName, String transactionId, String trayQuantity, String totalPrice) {
        this.orderedNumber = orderedNumber;
        this.orderedDate = orderedDate;
        this.serverTxtName = serverTxtName;
        this.transactionId = transactionId;
        this.trayQuantity = trayQuantity;
        this.totalPrice = totalPrice;
    }

    public String getOrderedNumber() {
        return orderedNumber;
    }

    public listCancelledHolderClass setOrderedNumber(String orderedNumber) {
        this.orderedNumber = orderedNumber;
        return this;
    }

    public String getOrderedDate() {
        return orderedDate;
    }

    public listCancelledHolderClass setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
        return this;
    }

    public String getServerTxtName() {
        return serverTxtName;
    }

    public listCancelledHolderClass setServerTxtName(String serverTxtName) {
        this.serverTxtName = serverTxtName;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public listCancelledHolderClass setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getTrayQuantity() {
        return trayQuantity;
    }

    public listCancelledHolderClass setTrayQuantity(String trayQuantity) {
        this.trayQuantity = trayQuantity;
        return this;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public listCancelledHolderClass setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
        return this;
    }
}
