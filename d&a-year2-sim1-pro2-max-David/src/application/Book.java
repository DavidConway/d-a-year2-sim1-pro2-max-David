package application;

import java.util.Calendar;

public class Book {
private String Title,Author,Genra,Plot,ImageUrl;
private int PubYear, NumOfPages, HashNum;

	public Book(String title, String author, int pubYear, int numOfPages, String genra, String plot, String imageUrl) {
		this.Title = title;
		this.Author = author;
		this.PubYear = pubYear;
		this.NumOfPages = numOfPages;
		this.Genra = genra;
		this.Plot = plot;
		this.ImageUrl = imageUrl;
	}
	
	
	//getters
	public String getTitle() {
		return Title;
	}
	public String getAuthor() {
		return Author;
	}
	public String getGenra() {
		return Genra;
	}
	public String getPlot() {
		return Plot;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public int getPubYear() {
		return PubYear;
	}
	public int getNumOfPages() {
		return NumOfPages;
	}
	public int getHashNum() {
		return HashNum;
	}
	//
	//seters
	public void setTitle(String title) {
		Title = title;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public void setGenra(String genra) {
		Genra = genra;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public void setPubYear(int pubYear) {
		//makes sur the year has past or is the curent year else defalts to 0000
		if(pubYear <= Calendar.getInstance().get(Calendar.YEAR)) {
			this.PubYear = pubYear;
		}
		else {
			this.PubYear = 0000;
		}
		//
	}
	public void setNumOfPages(int numOfPages) {
		NumOfPages = numOfPages;
	}
	public void setHashNum(int hashNum) {
		HashNum = hashNum;
	}
	//
}

