package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

public class TopRatedItem{

	@SerializedName("images")
	private String images;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setImages(String images){
		this.images = images;
	}

	public String getImages(){
		return images;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}