package com.lutongbahay.rest.request;

import com.google.gson.annotations.SerializedName;

public class RequestDocumentUpload{

    @SerializedName("user_id")
    private int userId;

	@SerializedName("id3_type")
	private String id3Type;

	@SerializedName("id1_type")
	private String id1Type;

	@SerializedName("id2_type")
	private String id2Type;

	public void setId3Type(String id3Type){
		this.id3Type = id3Type;
	}

	public String getId3Type(){
		return id3Type;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setId1Type(String id1Type){
		this.id1Type = id1Type;
	}

	public String getId1Type(){
		return id1Type;
	}

	public void setId2Type(String id2Type){
		this.id2Type = id2Type;
	}

	public String getId2Type(){
		return id2Type;
	}

}