package application;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {
	
	private Book book;

	@BeforeEach
	void setUp() throws Exception {
		book = new Book();
	}

	@Test
	void testSetAuthor() {
		book.setAuthor("author");
		assertTrue(book.getAuthor().equals("author"));
	}
	@Test
	void testSetTitle() {
		book.setTitle("title");
		assertTrue(book.getTitle().equals("title"));
	}
	@Test
	void testSetGenre() {
		book.setGenre("genre");
		assertTrue(book.getGenre().equals("genre"));
	}
	@Test
	void testSetPubYear() {
		book.setPubYear(2018);
		assertTrue(book.getPubYear()==(2018));
		book.setPubYear(2020);
		assertTrue(book.getPubYear()==(0));
		book.setPubYear(-2020);
		assertTrue(book.getPubYear()==(-2020));
	}
	@Test
	void testSetNumOfPages() {
		book.setNumOfPages(200);
		assertTrue(book.getNumOfPages()==(200));
	}
	@Test
	void testSetPlot() {
		book.setPlot("Loads of Plot");
		assertTrue(book.getPlot().equals("Loads of Plot"));
	}
	@Test
	void testSetSort() {
		book.setSort(23);
		assertTrue(book.getSort()==(23));
	}
	@Test
	void testSetHashNum() {
		book.setHashNum(23);
		assertTrue(book.getHashNum()==(23));
	}

}
