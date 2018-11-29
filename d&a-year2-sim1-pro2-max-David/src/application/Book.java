package application;

import java.util.Calendar;

public class Book implements Hashable {
private LinkedList<Integer> characters = new LinkedList<>();	//All  books will have their own list of associated characters/Or hash keys if change is needed.
	
private String title,author,genre,plot,imageUrl, publisher;
private int pubYear, numOfPages,hashNum, sort;




	public Book(String title, String author, String publisher, int pubYear, int numOfPages, String genre, String plot, String imageUrl) {
		this.title = title;
		this.author = author;
		this.pubYear = pubYear;
		this.numOfPages = numOfPages;
		this.genre = genre;
		this.plot = plot;
		this.imageUrl = imageUrl;
		this.publisher = publisher;
	}
	
	
	//getters
	public String getPublisher() {
		return publisher;
	}
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getGenre() {
		return genre;
	}
	public String getPlot() {
		return plot;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public int getPubYear() {
		return pubYear;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
	//
	//seters
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setPubYear(int pubYear) {
		//makes sure the year has past or is the current year else defaults to 0
		if(pubYear <= Calendar.getInstance().get(Calendar.YEAR)) {
			this.pubYear = pubYear;
		}
		else {
			this.pubYear = 0;
		}
		//
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	//
	// adds the hash of the charicter to list
	public void addChar(String name) {
		for (Hashable i : Main.chars.hashArray) {// gose trow all known chatractors
			if(i != null) {
				if(((Character)i).getName().equals(name)) {//checks to see if the name matches
					characters.add(i.getHashNum());// get the charactors hash and adds it to the list
				}
			}
		}
	}
	//
	public String toString()
	{
		return title;
	}


	@Override
	public void setHashNum(int hash) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getHashNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	public LinkedList<Integer> getCharacters() {
	return characters;
	}
	
	
	public void setCharacters(LinkedList<Integer> characters) {
		this.characters = characters;
	}
	
	
	public int getSort() {
		return sort;
	}
	
	
	public void setSort(int sort) {
		this.sort = sort;
	}


	@Override
	public LinkedList<Integer> getList() {
		// TODO Auto-generated method stub
		return characters;
	}
}

