package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

public class ResponseAddMenu{

	@SerializedName("success")
	private boolean success;

	@SerializedName("dataAddMenu")
	private DataAddMenu dataAddMenu;

	@SerializedName("message")
	private String message;

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setDataAddMenu(DataAddMenu dataAddMenu){
		this.dataAddMenu = dataAddMenu;
	}

	public DataAddMenu getDataAddMenu(){
		return dataAddMenu;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}
}