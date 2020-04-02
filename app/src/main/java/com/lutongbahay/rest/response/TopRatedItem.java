package com.lutongbahay.rest.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopRatedItem{

	@SerializedName("images")
	private List<String> images;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
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