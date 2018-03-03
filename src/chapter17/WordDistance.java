package chapter17;

import java.util.Scanner;

public class WordDistance {
	
	public static void main(String[] args){
		System.out.println(getDistance("hey i bored. i want am to play", "i", "am"));
	}

	public static int getDistance(String book, String str1, String str2){
		if (book==null||str1==null||str2==null)
			return -1;
		
		// does lower case matter?
		
		Scanner scn = new Scanner(book);
		int index1=-1;
		int index2=-1;
		int distance=Integer.MAX_VALUE;
		int minDistance=Integer.MAX_VALUE;
		int i=0;
		while (scn.hasNext()){
			String curr = scn.next();
			if (curr.equals(str1)){
				index1=i;
				distance=index1-index2;
			}
			else if (curr.equals(str2)){
				index2=i;
				distance=index2-index1;
			}
			if (distance<minDistance)
				minDistance = distance;
			i++;
		}
		
		
		scn.close();

		if (index1==-1 || index2==-1)
			return Integer.MAX_VALUE;
		
		return minDistance;
	}
	
}
