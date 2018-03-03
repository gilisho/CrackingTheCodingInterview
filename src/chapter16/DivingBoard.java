package chapter16;

import java.util.HashSet;
import java.util.Set;

//question 16.11
public class DivingBoard {
	
	Set<Integer> generatePossibleLengths(int longer, int shorter, int k){
		Set<Integer> set = new HashSet<Integer>();
		addPossibleLengths(longer, shorter,k,set,0);
		return set;
	}
	
	void addPossibleLengths(int longer, int shorter, int k, Set<Integer> set, int size){
		if (k==0)
			set.add(size);
		if (k==1){
			set.add(longer+size);
			set.add(shorter+size);
		}
		else {
			addPossibleLengths(longer, shorter, k-1, set, shorter+size);
			addPossibleLengths(longer, shorter, k-1, set, longer+size);
		}
	}

}
