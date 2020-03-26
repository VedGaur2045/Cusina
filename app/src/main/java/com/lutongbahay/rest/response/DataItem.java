package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("images")
	private String images;

	@SerializedName("min_qty")
	private int minQty;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("food_type")
	private FoodType foodType;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("name")
	private String name;

	@SerializedName("preparation_time")
	private int preparationTime;

	@SerializedName("id")
	private int id;

	@SerializedName("user")
	private String user;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("status")
	private String status;

	public void setImages(String images){
		this.images = images;
	}

	public String getImages(){
		return images;
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

	public void setFoodType(FoodType foodType){
		this.foodType = foodType;
	}

	public FoodType getFoodType(){
		return foodType;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
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

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getUser(){
		return user;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}