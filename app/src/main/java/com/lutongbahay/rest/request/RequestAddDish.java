package com.lutongbahay.rest.request;

import com.google.gson.annotations.SerializedName;

public class RequestAddDish{

	@SerializedName("min_qty")
	private String minQty;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("total_qty")
	private String totalQty;

	@SerializedName("description")
	private String description;

	@SerializedName("food_type")
	private String foodType;

	@SerializedName("time_available_to")
	private String timeAvailableTo;

	@SerializedName("dates_available_to")
	private String datesAvailableTo;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("price")
	private String price;

	@SerializedName("delivery_type")
	private String deliveryType;

	@SerializedName("time_available_from")
	private String timeAvailableFrom;

	@SerializedName("name")
	private String name;

	@SerializedName("preparation_time")
	private String preparationTime;

	@SerializedName("dates_available_from")
	private String datesAvailableFrom;

	@SerializedName("longitude")
	private String longitude;

	@SerializedName("delivery_price")
	private String deliveryPrice;

	public void setMinQty(String minQty){
		this.minQty = minQty;
	}

	public String getMinQty(){
		return minQty;
	}

	public void setLatitude(String latitude){
		this.latitude = latitude;
	}

	public String getLatitude(){
		return latitude;
	}

	public void setTotalQty(String totalQty){
		this.totalQty = totalQty;
	}

	public String getTotalQty(){
		return totalQty;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setFoodType(String foodType){
		this.foodType = foodType;
	}

	public String getFoodType(){
		return foodType;
	}

	public void setTimeAvailableTo(String timeAvailableTo){
		this.timeAvailableTo = timeAvailableTo;
	}

	public String getTimeAvailableTo(){
		return timeAvailableTo;
	}

	public void setDatesAvailableTo(String datesAvailableTo){
		this.datesAvailableTo = datesAvailableTo;
	}

	public String getDatesAvailableTo(){
		return datesAvailableTo;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setDeliveryType(String deliveryType){
		this.deliveryType = deliveryType;
	}

	public String getDeliveryType(){
		return deliveryType;
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

	public void setPreparationTime(String preparationTime){
		this.preparationTime = preparationTime;
	}

	public String getPreparationTime(){
		return preparationTime;
	}

	public void setDatesAvailableFrom(String datesAvailableFrom){
		this.datesAvailableFrom = datesAvailableFrom;
	}

	public String getDatesAvailableFrom(){
		return datesAvailableFrom;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}

	public void setDeliveryPrice(String deliveryPrice){
		this.deliveryPrice = deliveryPrice;
	}

	public String getDeliveryPrice(){
		return deliveryPrice;
	}
}