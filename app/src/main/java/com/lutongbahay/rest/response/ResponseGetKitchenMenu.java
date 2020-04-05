package com.lutongbahay.rest.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseGetKitchenMenu{

	@SerializedName("data")
	private List<DataItemKitchenMenu> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemKitchenMenu> data){
		this.data = data;
	}

	public List<DataItemKitchenMenu> getData(){
		return data;
	}

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
}