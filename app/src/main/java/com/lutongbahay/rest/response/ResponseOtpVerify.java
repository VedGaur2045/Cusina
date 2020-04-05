package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

public class ResponseOtpVerify{

	@SerializedName("data")
	private DataOtpVerify dataOtpVerify;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setDataOtpVerify(DataOtpVerify dataOtpVerify){
		this.dataOtpVerify = dataOtpVerify;
	}

	public DataOtpVerify getDataOtpVerify(){
		return dataOtpVerify;
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