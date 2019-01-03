package application;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CharacterTest {
	
	private Character character;

	@BeforeEach
	void setUp() throws Exception {
		character = new Character();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSetName() {
		character.setName("Tony");
		assertTrue(character.getName().equals("Tony"));
	}
	@Test
	void testSetGender() {
		character.setGender("What");
		assertTrue(character.getGender().equals("Other"));
		character.setGender("male");
		assertTrue(character.getGender().equals("male"));
		character.setGender("f");
		assertTrue(character.getGender().equals("f"));
	}
	@Test
	void testSetDescription() {
		character.setDescription("Story-time");
		assertTrue(character.getDescription().equals("Story-time"));
	}
	@Test
	void testSetSort() {
		character.setSort(23);
		assertTrue(character.getSort()==(23));
	}
	@Test
	void testSetHashNum() {
		character.setHashNum(23);
		assertTrue(character.getHashNum()==(23));
	}

}
