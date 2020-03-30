package com.lutongbahay.rest.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("nearMe")
	private List<NearMeItem> nearMe;

	@SerializedName("topRated")
	private List<TopRatedItem> topRated;

	@SerializedName("scheduleMeals")
	private List<ScheduleMealsItem> scheduleMeals;

	@SerializedName("preOrdered")
	private List<PreOrderedItem> preOrdered;

	public void setNearMe(List<NearMeItem> nearMe){
		this.nearMe = nearMe;
	}

	public List<NearMeItem> getNearMe(){
		return nearMe;
	}

	public void setTopRated(List<TopRatedItem> topRated){
		this.topRated = topRated;
	}

	public List<TopRatedItem> getTopRated(){
		return topRated;
	}

	public void setScheduleMeals(List<ScheduleMealsItem> scheduleMeals){
		this.scheduleMeals = scheduleMeals;
	}

	public List<ScheduleMealsItem> getScheduleMeals(){
		return scheduleMeals;
	}

	public void setPreOrdered(List<PreOrderedItem> preOrdered){
		this.preOrdered = preOrdered;
	}

	public List<PreOrderedItem> getPreOrdered(){
		return preOrdered;
	}
}