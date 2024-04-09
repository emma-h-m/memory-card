package models;

public class Card {
	
	private String title;
	private String path;
	
	public Card(String description, String filePath){
		title = description;
		path = filePath;	
	}
	
	
	//Getters
	public String getTitle() {
		return title;
	}
	
	public String getPath() {
		return path;
	}
}
