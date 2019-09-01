import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestWordFinderTest {

	// supplied example sentence and answer
	@Test
	void givenTestCase() {
		String sentence = "The cow jumped over the moon.";
		
		LongestWord result = LongestWordFinder.findLongest(sentence);
		
		assertEquals(6, result.length);

		assertEquals(1, result.words.size());
		
		assertTrue(result.words.contains("jumped"));
	}

	// duplicate answers
	@Test
	void multipleLongestTestCase() {
		String sentence = "I know how to code if code is life.";
		
		LongestWord result = LongestWordFinder.findLongest(sentence);
		
		assertEquals(4, result.length);

		assertEquals(3, result.words.size());
		
		assertTrue(result.words.contains("code"));
		assertTrue(result.words.contains("life"));
		assertTrue(result.words.contains("know"));
	}

	// all words same length
	@Test
	void sameLengthTestCase() {
		String sentence = "The big bad cow had fun and ate hey.";
		
		LongestWord result = LongestWordFinder.findLongest(sentence);
		
		assertEquals(3, result.length);

		assertEquals(9, result.words.size());
		
		assertTrue(result.words.contains("The"));
		assertTrue(result.words.contains("big"));
		assertTrue(result.words.contains("bad"));
		assertTrue(result.words.contains("cow"));
		assertTrue(result.words.contains("had"));
		assertTrue(result.words.contains("fun"));
		assertTrue(result.words.contains("and"));
		assertTrue(result.words.contains("ate"));
		assertTrue(result.words.contains("hey"));
	}
	
	// empty string as sentence 
	@Test
	void emptySentenceTestCase() {
		String sentence = "      ";
		
		assertThrows(
				IllegalArgumentException.class, 
				() ->{LongestWordFinder.findLongest(sentence);});
	}
	
	// tests exception is thrown for passing in null
	@Test
	void nullTestCase() {
		String sentence = null;
		
		assertThrows(
				IllegalArgumentException.class, 
				() ->{LongestWordFinder.findLongest(sentence);});
	}

}
