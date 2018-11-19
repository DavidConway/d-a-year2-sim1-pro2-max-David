package application;

import java.util.Calendar;

public class Book {
private String title,author,genra,plot,imageUrl;
private int pubYear, numOfPages, hashNum;

	public Book(String title, String author, int pubYear, int numOfPages, String genra, String plot, String imageUrl) {
		this.title = title;
		this.author = author;
		this.pubYear = pubYear;
		this.numOfPages = numOfPages;
		this.genra = genra;
		this.plot = plot;
		this.imageUrl = imageUrl;
	}
	
	
	//getters
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public String getGenra() {
		return genra;
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
	public int getHashNum() {
		return hashNum;
	}
	//
	//seters
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setGenra(String genra) {
		this.genra = genra;
	}
	public void setPlot(String plot) {
		this.plot = plot;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public void setPubYear(int pubYear) {
		//makes sur the year has past or is the curent year else defalts to 0000
		if(pubYear <= Calendar.getInstance().get(Calendar.YEAR)) {
			this.pubYear = pubYear;
		}
		else {
			this.pubYear = 0000;
		}
		//
	}
	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}
	public void setHashNum(int hashNum) {
		this.hashNum = hashNum;
	}
	//
}

