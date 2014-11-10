package com.wgc;

interface RestaurantInfoManager {
	
	public void incrementThumbsUp(int id);
	
	public int getThumbsUps(int id);
	
	public Restaurant[] getRestaurants();
	
	public Restaurant getRestaurant(int id);
	
	public void addRestaurant(Restaurant r);
	
	public void removeRestaurant(int id);
}
