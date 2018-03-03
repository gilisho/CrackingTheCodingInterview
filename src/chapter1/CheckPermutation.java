package chapter1;

//question 1.2

class CheckPermutation {
	
	private static int possibleChars = 256; // assumption: extended ASCII
	
	/**
	 * Given two strings, this method decides if one is a permutation of the other.
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 * 
	 * @param str1
	 * @param str2
	 * @return true if one is a permutation of the other, false otherwise.
	 */
	static boolean isPerm(String str1, String str2){
		if (str1 == null || str2 == null || (str1.length() != str2.length()))
			return false;
		
		int[] count = new int[possibleChars];
		
		for (int i=0; i<str1.length(); i++)
			count[str1.charAt(i)]++;
		
		for (int i=0; i<str2.length(); i++)
			if ((--count[str2.charAt(i)]) < 0)
				return false;
		
		return true; // no negative values, therefore all values are non-positive => zeros
		
	}

}
