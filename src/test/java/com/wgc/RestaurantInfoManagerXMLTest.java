package com.wgc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RestaurantInfoManagerXMLTest  {

	private RestaurantInfoManagerXML rimx;

	//TODO MG: Fix so that this is done only once
	@Before
	public void init() {
		try{
			rimx = 	new RestaurantInfoManagerXML(getClass().getClassLoader().getResource("restaurant_data.xml").getFile());
		}catch(Exception e){}
	}

	@Test
	public void testGetValue() throws Exception {
		assertEquals(rimx.getValue(0, "thumbsUp"), "15");
		assertEquals(rimx.getValue(1, "thumbsUp"), "17");
		assertEquals(rimx.getValue(15, "thumbsUp"), null);
		assertEquals(rimx.getValue(15, "fake"), null);
		assertEquals(rimx.getValue(0, "fake"), null);
		
	}
	
	@Test
	public void testUpdateValue() throws Exception {
		rimx.updateValue(0, "thumbsUp", "7");
		assertEquals(rimx.getValue(0, "thumbsUp"), "7");
		
		rimx.updateValue(15, "thumbsUp", "8");
		assertEquals(rimx.getValue(15, "thumbsUp"), null);

		rimx.updateValue(0, "fake", "15");
		assertEquals(rimx.getValue(0, "thumbsUp"), "7");

		rimx.updateValue(0, "thumbsUp", "15");
		assertEquals(rimx.getValue(0, "thumbsUp"), "15");
		
	}

	public void testGetRestaurants() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetRestaurant() throws Exception {
		Restaurant r = rimx.getRestaurant(0);
		assertEquals(r.getName(), "Olive Garden");
		assertEquals(r.getThumbsUpCnt(), 15);
		assertEquals(r.getId(), 0);
		
		r = rimx.getRestaurant(12);
		assertEquals(r.getName(), "Unos");
		assertEquals(r.getThumbsUpCnt(), 7);
		assertEquals(r.getId(), 12);
	}

	public void testAddRestaurant() {
		fail("Not yet implemented");
	}

	public void testRemoveRestaurant() {
		fail("Not yet implemented");
	}

}
