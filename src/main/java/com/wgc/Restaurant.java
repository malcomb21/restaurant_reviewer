package com.wgc;

public class Restaurant {
	private int id;
	private String name;
	private int thumbsUps;
	
	Restaurant(int id, String name){
		this.id = id;
		this.name = name;
	}
	
	Restaurant(int id, String name, int thumbsUp){
		this(id, name);
		this.thumbsUps = thumbsUp;
	}
}
