package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

public class DataItem{

	@SerializedName("country")
	private String country;

	@SerializedName("gender")
	private String gender;

	@SerializedName("city")
	private String city;

	@SerializedName("latitude")
	private double latitude;

	@SerializedName("description")
	private String description;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("password")
	private Object password;

	@SerializedName("user_type")
	private String userType;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("preparation_time")
	private int preparationTime;

	@SerializedName("id")
	private int id;

	@SerializedName("remember_token")
	private Object rememberToken;

	@SerializedName("email")
	private String email;

	@SerializedName("longitude")
	private double longitude;

	@SerializedName("images")
	private String images;

	@SerializedName("address2")
	private Object address2;

	@SerializedName("min_qty")
	private int minQty;

	@SerializedName("address1")
	private String address1;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("email_verified_at")
	private Object emailVerifiedAt;

	@SerializedName("otp")
	private String otp;

	@SerializedName("food_type")
	private int foodType;

	@SerializedName("zipcode")
	private String zipcode;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("name")
	private String name;

	@SerializedName("status")
	private String status;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setGender(String gender){
		this.gender = gender;
	}

	public String getGender(){
		return gender;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
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

	public void setPassword(Object password){
		this.password = password;
	}

	public Object getPassword(){
		return password;
	}

	public void setUserType(String userType){
		this.userType = userType;
	}

	public String getUserType(){
		return userType;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
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

	public void setRememberToken(Object rememberToken){
		this.rememberToken = rememberToken;
	}

	public Object getRememberToken(){
		return rememberToken;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setLongitude(double longitude){
		this.longitude = longitude;
	}

	public double getLongitude(){
		return longitude;
	}

	public void setImages(String images){
		this.images = images;
	}

	public String getImages(){
		return images;
	}

	public void setAddress2(Object address2){
		this.address2 = address2;
	}

	public Object getAddress2(){
		return address2;
	}

	public void setMinQty(int minQty){
		this.minQty = minQty;
	}

	public int getMinQty(){
		return minQty;
	}

	public void setAddress1(String address1){
		this.address1 = address1;
	}

	public String getAddress1(){
		return address1;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setEmailVerifiedAt(Object emailVerifiedAt){
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public Object getEmailVerifiedAt(){
		return emailVerifiedAt;
	}

	public void setOtp(String otp){
		this.otp = otp;
	}

	public String getOtp(){
		return otp;
	}

	public void setFoodType(int foodType){
		this.foodType = foodType;
	}

	public int getFoodType(){
		return foodType;
	}

	public void setZipcode(String zipcode){
		this.zipcode = zipcode;
	}

	public String getZipcode(){
		return zipcode;
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

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataItem{" + 
			"country = '" + country + '\'' + 
			",gender = '" + gender + '\'' + 
			",city = '" + city + '\'' + 
			",latitude = '" + latitude + '\'' + 
			",description = '" + description + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",password = '" + password + '\'' + 
			",user_type = '" + userType + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",preparation_time = '" + preparationTime + '\'' + 
			",id = '" + id + '\'' + 
			",remember_token = '" + rememberToken + '\'' + 
			",email = '" + email + '\'' + 
			",longitude = '" + longitude + '\'' + 
			",images = '" + images + '\'' + 
			",address2 = '" + address2 + '\'' + 
			",min_qty = '" + minQty + '\'' + 
			",address1 = '" + address1 + '\'' + 
			",mobile = '" + mobile + '\'' + 
			",email_verified_at = '" + emailVerifiedAt + '\'' + 
			",otp = '" + otp + '\'' + 
			",food_type = '" + foodType + '\'' + 
			",zipcode = '" + zipcode + '\'' + 
			",user_id = '" + userId + '\'' + 
			",name = '" + name + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}