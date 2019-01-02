package application;

import java.util.Calendar;

public class Book implements Hashable {
private LinkedList<Integer> characters = new LinkedList<Integer>();	//All  books will have their own list of associated characters/Or hash keys if change is needed.
	
private String title,author,genre,plot, publisher;
private int pubYear, numOfPages,hashNum, sort;


//book constructors

		public Book(String title, String author, String publisher, int pubYear, int numOfPages, String genre, String plot, int sort) {
		this.title = title;
		this.author = author;
		this.pubYear = pubYear;
		this.numOfPages = numOfPages;
		this.genre = genre;
		this.plot = plot;
		this.publisher = publisher;
		this.sort = sort;
	}
//
	
	
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
	public int getPubYear() {
		return pubYear;
	}
	public int getNumOfPages() {
		return numOfPages;
	}
//
	
//Setters
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
	public void addChar(Character toAdd) {
		characters.add(toAdd.getHashNum());
	}
//
	
	@Override
	public void setHashNum(int hash) {	
		this.hashNum =hash;
	}
	
	@Override
	public int getHashNum() {
		return this.hashNum;
	}

	public int getCharacters(int i) {
	return characters.get(i).getContents();
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
		return characters;
	}
	
	public String toString()
	{
		return title;
	}
}

