package com.wgc;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

class RestaurantInfoManagerXML implements RestaurantInfoManager{
	private Document restaurantsDoc;
	private String fileName;
	
	public RestaurantInfoManagerXML(String fileName) throws Exception{
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
		restaurantsDoc = docBuilder.parse(fileName);
		this.fileName = fileName;
	}

	public String getValue(int id, String fieldName){
		XPath xpath = XPathFactory.newInstance().newXPath();
		Node node = null;
		try {
			node = (Node) xpath.evaluate("/restaurants/restaurant[@id='" + String.valueOf(id) + "']/" + fieldName, restaurantsDoc, XPathConstants.NODE);
		}catch(Exception e){}
	
		if(node != null)
			return node.getTextContent();
	
		return null;
	}
	
	//TODO MG: Handle failed updates
	public void updateValue(int id, String fieldName, String val){
		XPath xpath = XPathFactory.newInstance().newXPath();
		Node node = null;
		try {
			node = (Node) xpath.evaluate("/restaurants/restaurant[@id='" + String.valueOf(id) + "']/" + fieldName, restaurantsDoc, XPathConstants.NODE);
			node.setTextContent(val);
			if(node != null){
				node.setTextContent(val);;
				updateXML();
			}
		} catch (Exception e){}
	}
	
	//TODO MG: Add implementation
	public Restaurant[] getRestaurants(){
		XPath xpath = XPathFactory.newInstance().newXPath();
		Restaurant[] r;
		try{
			NodeList list = (NodeList) xpath.evaluate("/restaurants/restaurant/@*", restaurantsDoc, XPathConstants.NODESET);
			r = new Restaurant[list.getLength()];
			for(int i = 0; i < list.getLength(); i++){
				r[i] = getRestaurant(Integer.valueOf(list.item(i).getTextContent()));
			}
		}catch(Exception e){}
		
		return new Restaurant[]{new Restaurant(0, "")};
	}
	
	//TODO MG: Add implementation
	public Restaurant getRestaurant(int id){
		XPath xpath = XPathFactory.newInstance().newXPath();
		Node node = null;
		String name = "", thumbsUp = "0";
		try {
			node = (Node) xpath.evaluate("/restaurants/restaurant[@id='" + String.valueOf(id) + "']/" + "name", restaurantsDoc, XPathConstants.NODE);
			if(node != null)
				name =  node.getTextContent();
			
			node = (Node) xpath.evaluate("/restaurants/restaurant[@id='" + String.valueOf(id) + "']/" + "thumbsUp", restaurantsDoc, XPathConstants.NODE);
			if(node != null)
				thumbsUp =  node.getTextContent();
			
			return new Restaurant(id, name, Integer.valueOf(thumbsUp));
		}catch(Exception e){}
		
		return null;
	}
	
	//TODO MG: Add implementation
	public void addRestaurant(Restaurant r){
		
	}
	
	//TODO MG: Add implementation
	public void removeRestaurant(int id){
		
	}
	
	private void updateXML() throws Exception{
		// write the content into xml file
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(restaurantsDoc);
		StreamResult result = new StreamResult(new File(fileName + ".tmp"));
		transformer.transform(source, result);
	}
}
