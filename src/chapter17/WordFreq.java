package chapter17;

import java.util.HashMap;
import java.util.Scanner;


// 16.2

// how does the book represented
// do lower/upper case matter
public class WordFreq {

	/**
	 * 
	 */

	//BCR is O(n)
	public static int countOccurances(String book, String word){

		int count = 0;
		Scanner scn = new Scanner(book);
		scn.useDelimiter(" \t\n");

		while (scn.hasNext())
			if (word.equals(scn.next()))
				count++;

		scn.close();
		return count;

	}



	public static class Book {
		String book;
		HashMap<String, Integer> wordOccurances;

		public Book(String book){
			this.book = book;
			this.buildHashtable();
		}

		public void buildHashtable(){
			wordOccurances = new HashMap<>();
			Scanner scn = new Scanner(book);
			scn.useDelimiter(" \t\n");

			while (scn.hasNext()){
				String currWord = scn.next();
				if (wordOccurances.containsKey(currWord))
					wordOccurances.put(currWord, wordOccurances.get(currWord)+1);
				else {
					wordOccurances.put(currWord, 1);
				}
			}
			scn.close();
		}
	}



	public static int multipleCountOccurances(String book, String word){
		Book bookObj = new Book(book);
		if (bookObj.wordOccurances.containsKey(word))
			return bookObj.wordOccurances.get(word);
		return 0;
	}
}
