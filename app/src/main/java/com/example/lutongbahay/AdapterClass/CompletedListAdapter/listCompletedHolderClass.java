package com.example.lutongbahay.AdapterClass.CompletedListAdapter;

public class listCompletedHolderClass {
    private String orderedNumber,orderedDate,serverTxtName,transactionId,trayQuantity,totalPrice;

    public listCompletedHolderClass(String orderedNumber, String orderedDate, String serverTxtName, String transactionId, String trayQuantity, String totalPrice) {
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

    public void setOrderedNumber(String orderedNumber) {
        this.orderedNumber = orderedNumber;
    }

    public String getOrderedDate() {
        return orderedDate;
    }

    public void setOrderedDate(String orderedDate) {
        this.orderedDate = orderedDate;
    }

    public String getServerTxtName() {
        return serverTxtName;
    }

    public void setServerTxtName(String serverTxtName) {
        this.serverTxtName = serverTxtName;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTrayQuantity() {
        return trayQuantity;
    }

    public void setTrayQuantity(String trayQuantity) {
        this.trayQuantity = trayQuantity;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
