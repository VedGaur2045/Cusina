package com.lutongbahay.rest.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAddDish {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("message")
    @Expose
    private String message;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public class Data {

        @SerializedName("user_id")
        @Expose
        private String userId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("min_qty")
        @Expose
        private String minQty;
        @SerializedName("food_type")
        @Expose
        private String foodType;
        @SerializedName("price")
        @Expose
        private String price;
        @SerializedName("preparation_time")
        @Expose
        private String preparationTime;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("delivery_type")
        @Expose
        private String deliveryType;
        @SerializedName("delivery_price")
        @Expose
        private String deliveryPrice;
        @SerializedName("dates_available_to")
        @Expose
        private String datesAvailableTo;
        @SerializedName("dates_available_from")
        @Expose
        private String datesAvailableFrom;
        @SerializedName("time_available_to")
        @Expose
        private String timeAvailableTo;
        @SerializedName("time_available_from")
        @Expose
        private String timeAvailableFrom;
        @SerializedName("total_qty")
        @Expose
        private String totalQty;
        @SerializedName("images")
        @Expose
        private String images;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("id")
        @Expose
        private Integer id;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getMinQty() {
            return minQty;
        }

        public void setMinQty(String minQty) {
            this.minQty = minQty;
        }

        public String getFoodType() {
            return foodType;
        }

        public void setFoodType(String foodType) {
            this.foodType = foodType;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPreparationTime() {
            return preparationTime;
        }

        public void setPreparationTime(String preparationTime) {
            this.preparationTime = preparationTime;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getDeliveryType() {
            return deliveryType;
        }

        public void setDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
        }

        public String getDeliveryPrice() {
            return deliveryPrice;
        }

        public void setDeliveryPrice(String deliveryPrice) {
            this.deliveryPrice = deliveryPrice;
        }

        public String getDatesAvailableTo() {
            return datesAvailableTo;
        }

        public void setDatesAvailableTo(String datesAvailableTo) {
            this.datesAvailableTo = datesAvailableTo;
        }

        public String getDatesAvailableFrom() {
            return datesAvailableFrom;
        }

        public void setDatesAvailableFrom(String datesAvailableFrom) {
            this.datesAvailableFrom = datesAvailableFrom;
        }

        public String getTimeAvailableTo() {
            return timeAvailableTo;
        }

        public void setTimeAvailableTo(String timeAvailableTo) {
            this.timeAvailableTo = timeAvailableTo;
        }

        public String getTimeAvailableFrom() {
            return timeAvailableFrom;
        }

        public void setTimeAvailableFrom(String timeAvailableFrom) {
            this.timeAvailableFrom = timeAvailableFrom;
        }

        public String getTotalQty() {
            return totalQty;
        }

        public void setTotalQty(String totalQty) {
            this.totalQty = totalQty;
        }

        public String getImages() {
            return images;
        }

        public void setImages(String images) {
            this.images = images;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

    }

}
