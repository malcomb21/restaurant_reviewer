package com.wgc;

public class Restaurant {
	private int id;
	private String name;
	private int thumbsUp;
	
	Restaurant(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	Restaurant(int id, String name, int thumbsUp){
		this(id, name);
		this.thumbsUp = thumbsUp;
	}
	
	public int getThumbsUpCnt(){
		return thumbsUp;
	}
	
	public String getName(){
		return this.name;
	}
	
	public int getId(){
		return this.id;
	}
	
	//TODO MG: Handle failed updates
	public void incrementThumbsUp() throws Exception{
		RestaurantManager.getInstance().getRIM().updateValue(id, "thumbsUp", String.valueOf(++thumbsUp));
	}
}
