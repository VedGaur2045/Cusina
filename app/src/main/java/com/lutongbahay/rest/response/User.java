package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

public class User{

	@SerializedName("image")
	private Object image;

	@SerializedName("name")
	private String name;

	@SerializedName("mobile")
	private Object mobile;

	@SerializedName("id")
	private int id;

	@SerializedName("email")
	private String email;

	public void setImage(Object image){
		this.image = image;
	}

	public Object getImage(){
		return image;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setMobile(Object mobile){
		this.mobile = mobile;
	}

	public Object getMobile(){
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