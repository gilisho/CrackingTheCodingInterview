package chapter16;

import java.util.List;

public class LivingPeople {
	
	public static int startingYear = 1900;
	
	private static class People {
		public int birthYear;
		public int deathYear;
	}
	
	public static int LiveliestYear(List<People> list){
		int[] peopleCount = new int[101];
		for (People person : list)
			for (int i=person.birthYear; i<=person.deathYear; i++)
				peopleCount[i-startingYear]++;
		int maxPeople = Integer.MIN_VALUE;
		int maxYear = Integer.MIN_VALUE;
		for (int i=0; i<=101; i++)
			if (peopleCount[i] > maxPeople)
				maxYear = i+startingYear;
		return maxYear;
	}

}
