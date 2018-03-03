package chapter1;

import java.util.Arrays;

class IsUnique {

	final static int possibleChars = 256;

	/**
	 * Checks if a string has all unique characters, assuming we can use additional data structures.
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @param string
	 * @return true if a string has all unique characters, false otherwise.
	 */
	static boolean isUnique(String string){
		if (string == null || string.length() > possibleChars)
			return false;

		boolean[] foundChars = new boolean[possibleChars];

		for (int i=0; i<string.length(); i++){
			int currChar = string.charAt(i);
			if (foundChars[currChar])
				return false;
			foundChars[currChar] = true;
		}
		return true;
	}

	/**
	 * Checks if a string has all unique characters, assuming we cannot use additional data structures.
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @param string
	 * @return true if a string has all unique characters, false otherwise.
	 */
	static boolean isUnique(String string, boolean yo){
		if (string == null || string.length() < possibleChars)
			return false;

		for (int i=0; i<possibleChars; i++){
			boolean foundChar = false;
			for (int j=0; j<string.length(); i++)
				if (string.charAt(j) == i){
					foundChar=true;
					break;
				}
			if (!foundChar)
				return false;
		}

		return true;
	}

}
