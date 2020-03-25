package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("images")
	private String images;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private String userId;

	@SerializedName("min_qty")
	private String minQty;

	@SerializedName("latitude")
	private String latitude;

	@SerializedName("name")
	private String name;

	@SerializedName("description")
	private String description;

	@SerializedName("preparation_time")
	private String preparationTime;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("food_type")
	private String foodType;

	@SerializedName("id")
	private int id;

	@SerializedName("longitude")
	private String longitude;

	public void setImages(String images){
		this.images = images;
	}

	public String getImages(){
		return images;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

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

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setPreparationTime(String preparationTime){
		this.preparationTime = preparationTime;
	}

	public String getPreparationTime(){
		return preparationTime;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setFoodType(String foodType){
		this.foodType = foodType;
	}

	public String getFoodType(){
		return foodType;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setLongitude(String longitude){
		this.longitude = longitude;
	}

	public String getLongitude(){
		return longitude;
	}
}