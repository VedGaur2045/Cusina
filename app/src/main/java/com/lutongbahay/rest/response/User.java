package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("name")
	private String name;

	@SerializedName("mobile")
	private String mobile;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMobile(String mobile){
		this.mobile = mobile;
	}

	public String getMobile(){
		return mobile;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}
}