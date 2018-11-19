package application;

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
	
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getGenra() {
		return Genra;
	}
	public void setGenra(String genra) {
		Genra = genra;
	}
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	public String getImageUrl() {
		return ImageUrl;
	}
	public void setImageUrl(String imageUrl) {
		ImageUrl = imageUrl;
	}
	public int getPubYear() {
		return PubYear;
	}
	public void setPubYear(int pubYear) {
		PubYear = pubYear;
	}
	public int getNumOfPages() {
		return NumOfPages;
	}
	public void setNumOfPages(int numOfPages) {
		NumOfPages = numOfPages;
	}
	public int getHashNum() {
		return HashNum;
	}
	public void setHashNum(int hashNum) {
		HashNum = hashNum;
	}
}
