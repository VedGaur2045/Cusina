package com.lutongbahay.rest.response;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDishDetail {

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

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("user_id")
        @Expose
        private Integer userId;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("images")
        @Expose
        private List<Object> images = null;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("min_qty")
        @Expose
        private Integer minQty;
        @SerializedName("food_type")
        @Expose
        private Integer foodType;
        @SerializedName("preparation_time")
        @Expose
        private Integer preparationTime;
        @SerializedName("latitude")
        @Expose
        private Double latitude;
        @SerializedName("longitude")
        @Expose
        private Double longitude;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("created_at")
        @Expose
        private String createdAt;
        @SerializedName("updated_at")
        @Expose
        private String updatedAt;
        @SerializedName("delivery_type")
        @Expose
        private String deliveryType;
        @SerializedName("delivery_price")
        @Expose
        private Integer deliveryPrice;
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
        private Integer totalQty;
        @SerializedName("price")
        @Expose
        private Integer price;
        @SerializedName("distance")
        @Expose
        private String distance;
        @SerializedName("seller")
        @Expose
        private List<Object> seller = null;
        @SerializedName("kitchen")
        @Expose
        private List<Object> kitchen = null;
        @SerializedName("foodtype")
        @Expose
        private Foodtype foodtype;
        @SerializedName("rating")
        @Expose
        private Integer rating;
        @SerializedName("likes")
        @Expose
        private Integer likes;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Object> getImages() {
            return images;
        }

        public void setImages(List<Object> images) {
            this.images = images;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getMinQty() {
            return minQty;
        }

        public void setMinQty(Integer minQty) {
            this.minQty = minQty;
        }

        public Integer getFoodType() {
            return foodType;
        }

        public void setFoodType(Integer foodType) {
            this.foodType = foodType;
        }

        public Integer getPreparationTime() {
            return preparationTime;
        }

        public void setPreparationTime(Integer preparationTime) {
            this.preparationTime = preparationTime;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public String getDeliveryType() {
            return deliveryType;
        }

        public void setDeliveryType(String deliveryType) {
            this.deliveryType = deliveryType;
        }

        public Integer getDeliveryPrice() {
            return deliveryPrice;
        }

        public void setDeliveryPrice(Integer deliveryPrice) {
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

        public Integer getTotalQty() {
            return totalQty;
        }

        public void setTotalQty(Integer totalQty) {
            this.totalQty = totalQty;
        }

        public Integer getPrice() {
            return price;
        }

        public void setPrice(Integer price) {
            this.price = price;
        }

        public String getDistance() {
            return distance;
        }

        public void setDistance(String distance) {
            this.distance = distance;
        }

        public List<Object> getSeller() {
            return seller;
        }

        public void setSeller(List<Object> seller) {
            this.seller = seller;
        }

        public List<Object> getKitchen() {
            return kitchen;
        }

        public void setKitchen(List<Object> kitchen) {
            this.kitchen = kitchen;
        }

        public Foodtype getFoodtype() {
            return foodtype;
        }

        public void setFoodtype(Foodtype foodtype) {
            this.foodtype = foodtype;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public Integer getLikes() {
            return likes;
        }

        public void setLikes(Integer likes) {
            this.likes = likes;
        }

    }
    public class Foodtype {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }
}