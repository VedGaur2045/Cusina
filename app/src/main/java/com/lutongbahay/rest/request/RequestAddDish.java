package com.lutongbahay.rest.request;

import com.google.gson.annotations.SerializedName;

public class RequestAddDish{

	@SerializedName("image")
	private Image image;

	@SerializedName("min_qty")
	private int minQty;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("total_qty")
	private int totalQty;

	@SerializedName("description")
	private String description;

	@SerializedName("food_type")
	private int foodType;

	@SerializedName("time_available_to")
	private String timeAvailableTo;

	@SerializedName("dates_available_to")
	private String datesAvailableTo;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("price")
	private String price;

	@SerializedName("delivery_type")
	private int deliveryType;

	@SerializedName("time_available_from")
	private String timeAvailableFrom;

	@SerializedName("name")
	private String name;

	@SerializedName("preparation_time")
	private int preparationTime;

	@SerializedName("kitchen_id")
	private int kitchenId;

	@SerializedName("dates_available_from")
	private String datesAvailableFrom;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("delivery_price")
	private String deliveryPrice;

	public void setImage(Image image){
		this.image = image;
	}

	public Image getImage(){
		return image;
	}

	public void setMinQty(int minQty){
		this.minQty = minQty;
	}

	public int getMinQty(){
		return minQty;
	}

	public void setLatitude(double latitude){
		this.latitude = latitude;
	}

	public double getLatitude(){
		return latitude;
	}

	public void setTotalQty(int totalQty){
		this.totalQty = totalQty;
	}

	public int getTotalQty(){
		return totalQty;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setFoodType(int foodType){
		this.foodType = foodType;
	}

	public int getFoodType(){
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

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setPrice(String price){
		this.price = price;
	}

	public String getPrice(){
		return price;
	}

	public void setDeliveryType(int deliveryType){
		this.deliveryType = deliveryType;
	}

	public int getDeliveryType(){
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

	public void setPreparationTime(int preparationTime){
		this.preparationTime = preparationTime;
	}

	public int getPreparationTime(){
		return preparationTime;
	}

	public void setKitchenId(int kitchenId){
		this.kitchenId = kitchenId;
	}

	public int getKitchenId(){
		return kitchenId;
	}

	public void setDatesAvailableFrom(String datesAvailableFrom){
		this.datesAvailableFrom = datesAvailableFrom;
	}

	public String getDatesAvailableFrom(){
		return datesAvailableFrom;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public void setDeliveryPrice(String deliveryPrice){
		this.deliveryPrice = deliveryPrice;
	}

	public String getDeliveryPrice(){
		return deliveryPrice;
	}
}