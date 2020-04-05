package com.lutongbahay.rest.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseGetKitchenMenuDishes{

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	@SerializedName("data")
	private List<DataGetKitchenMenuDishesItem> dataGetKitchenMenuDishes;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setDataGetKitchenMenuDishes(List<DataGetKitchenMenuDishesItem> dataGetKitchenMenuDishes){
		this.dataGetKitchenMenuDishes = dataGetKitchenMenuDishes;
	}

	public List<DataGetKitchenMenuDishesItem> getDataGetKitchenMenuDishes(){
		return dataGetKitchenMenuDishes;
	}
}