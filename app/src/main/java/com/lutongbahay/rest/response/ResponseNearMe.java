package com.lutongbahay.rest.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseNearMe{

	@SerializedName("distance")
	private String distance;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("rating")
	private int rating;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("dates_available_to")
	private String datesAvailableTo;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("delivery_type")
	private String deliveryType;

	@SerializedName("price")
	private int price;

	@SerializedName("preparation_time")
	private int preparationTime;

	@SerializedName("id")
	private int id;

	@SerializedName("kitchen")
	private Kitchen kitchen;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("likes")
	private int likes;

	@SerializedName("images")
	private List<String> images;

	@SerializedName("min_qty")
	private int minQty;

	@SerializedName("total_qty")
	private int totalQty;

	@SerializedName("food_type")
	private FoodType foodType;

	@SerializedName("time_available_to")
	private String timeAvailableTo;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("time_available_from")
	private String timeAvailableFrom;

	@SerializedName("name")
	private String name;

	@SerializedName("dates_available_from")
	private String datesAvailableFrom;

	@SerializedName("user")
	private User user;

	@SerializedName("status")
	private String status;

	@SerializedName("delivery_price")
	private int deliveryPrice;

	public void setDistance(String distance){
		this.distance = distance;
	}

	public String getDistance(){
		return distance;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setRating(int rating){
		this.rating = rating;
	}

	public int getRating(){
		return rating;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDatesAvailableTo(String datesAvailableTo){
		this.datesAvailableTo = datesAvailableTo;
	}

	public String getDatesAvailableTo(){
		return datesAvailableTo;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setDeliveryType(String deliveryType){
		this.deliveryType = deliveryType;
	}

	public String getDeliveryType(){
		return deliveryType;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setPreparationTime(int preparationTime){
		this.preparationTime = preparationTime;
	}

	public int getPreparationTime(){
		return preparationTime;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setKitchen(Kitchen kitchen){
		this.kitchen = kitchen;
	}

	public Kitchen getKitchen(){
		return kitchen;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public void setLikes(int likes){
		this.likes = likes;
	}

	public int getLikes(){
		return likes;
	}

	public void setImages(List<String> images){
		this.images = images;
	}

	public List<String> getImages(){
		return images;
	}

	public void setMinQty(int minQty){
		this.minQty = minQty;
	}

	public int getMinQty(){
		return minQty;
	}

	public void setTotalQty(int totalQty){
		this.totalQty = totalQty;
	}

	public int getTotalQty(){
		return totalQty;
	}

	public void setFoodType(FoodType foodType){
		this.foodType = foodType;
	}

	public FoodType getFoodType(){
		return foodType;
	}

	public void setTimeAvailableTo(String timeAvailableTo){
		this.timeAvailableTo = timeAvailableTo;
	}

	public String getTimeAvailableTo(){
		return timeAvailableTo;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setTimeAvailableFrom(String timeAvailableFrom){
		this.timeAvailableFrom = timeAvailableFrom;
	}

	public String getTimeAvailableFrom(){
		return timeAvailableFrom;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDatesAvailableFrom(String datesAvailableFrom){
		this.datesAvailableFrom = datesAvailableFrom;
	}

	public String getDatesAvailableFrom(){
		return datesAvailableFrom;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setDeliveryPrice(int deliveryPrice){
		this.deliveryPrice = deliveryPrice;
	}

	public int getDeliveryPrice(){
		return deliveryPrice;
	}
}