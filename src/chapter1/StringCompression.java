package chapter1;

import java.util.LinkedList;

//question 1.6
class StringCompression {
	
	public static String compress(String string){
		if (string == null)
			return null;
		
		if (string.length() < 3)
			return string;
		
		LinkedList<CharacterCount> characterList = new LinkedList<CharacterCount>();
		char currChar = string.charAt(0);
		int count = 1;
		
		for (int i=1; i<string.length(); i++){
			if (currChar != string.charAt(i)){
				characterList.add(new CharacterCount(currChar, count));
				if (characterList.size() == string.length() / 2)
					return string;
				currChar = string.charAt(i);
				count = 1;
			}
			else
				count++;
		}
		
		characterList.add(new CharacterCount(currChar, count));
		if (((string.length()%2 == 0) && characterList.size() >= (string.length()/2)) ||
			((string.length()%2 == 1) && characterList.size() > string.length()/2))
			return string;
		
		String compressed = "";
		for (int i=0; i<characterList.size(); i++)
			compressed+=characterList.get(i).toString();
		return compressed;
		
	}

}
