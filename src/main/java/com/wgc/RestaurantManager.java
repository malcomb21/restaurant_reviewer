package com.wgc;

public class RestaurantManager {
	
	private static final RestaurantManager INSTANCE = new RestaurantManager();
	
	private RestaurantInfoManager rim;
	
	//TODO MG: Add implementation
	private RestaurantManager(){
		
	}
	
	public static RestaurantManager getInstance(){
		return INSTANCE;
	}
	
	//TODO MG: Initialize rim
	public RestaurantInfoManager getRIM() {
		return rim;
	}
}
