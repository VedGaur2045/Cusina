package com.example.cusina.AdapterClass.ReviewMsgAdapterCLass;

public class ReviewMsgModalClass {
    private String reviewedUserName,reviewedTime,message;
    private int rating;

    public ReviewMsgModalClass(String reviewedUserName, String reviewedTime, String message, int rating) {
        this.reviewedUserName = reviewedUserName;
        this.reviewedTime = reviewedTime;
        this.message = message;
        this.rating = rating;
    }

    public String getReviewedUserName() {
        return reviewedUserName;
    }

    public void setReviewedUserName(String reviewedUserName) {
        this.reviewedUserName = reviewedUserName;
    }

    public String getReviewedTime() {
        return reviewedTime;
    }

    public void setReviewedTime(String reviewedTime) {
        this.reviewedTime = reviewedTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
