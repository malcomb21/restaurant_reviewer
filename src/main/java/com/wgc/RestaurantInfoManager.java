package com.wgc;

interface RestaurantInfoManager {

	
	public String getValue(int id, String fieldName);
	
	public void updateValue(int id, String fieldName, String val);
	
	public Restaurant[] getRestaurants();
	
	public Restaurant getRestaurant(int id);
	
	public void addRestaurant(Restaurant r);
	
	public void removeRestaurant(int id);
}
