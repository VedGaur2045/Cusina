package com.lutongbahay.rest.request;

import com.google.gson.annotations.SerializedName;

public class RequestAddMenu{

	@SerializedName("name")
	private String name;

	@SerializedName("kitchen_id")
	private int kitchenId;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setKitchenId(int kitchenId){
		this.kitchenId = kitchenId;
	}

	public int getKitchenId(){
		return kitchenId;
	}
}