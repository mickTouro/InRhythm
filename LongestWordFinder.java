import java.util.HashSet;
import java.util.Set;

public class LongestWordFinder 
{	
	// Returns a LongestWord object which contains the length of the
	// longest word in the sentence and the words.
	// If the longest word appears multiple times, it will only be
	// returned once.
	// This function assumes all sentences contain valid words.
	// Throws an IllegalArgumentException if sentence is null or empty.
	public static LongestWord findLongest(String sentence)
	{
		if(sentence == null || sentence.isBlank()) 
		{ 
			throw new IllegalArgumentException(); 
		}
		
		LongestWord longest = new LongestWord();
		
		// loop through each word split by regex word break
		for(String word : sentence.split("\\b"))
		{
			// found a new longest word...
			if(word.length() > longest.length)
			{
				// clear previous, and set new words and length
				longest = new LongestWord(word.length(), word);
			}
			
			// for the same length as longest word, add to list
			if(word.length() == longest.length)
			{
				longest.words.add(word);
			}
		}
		
		return longest;
	}
}

class LongestWord {
	public LongestWord()
	{
		length = 0;
		words = new HashSet<String>();
	}
	public LongestWord(int length, String word)
	{
		this.length = length;
		this.words = new HashSet<String>();
		this.words.add(word);
	}
	
	// longest word length
	int length;
	// the longest word(s)
	Set<String> words;
}
