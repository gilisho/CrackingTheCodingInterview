package chapter16;

import java.util.HashSet;
import java.util.Set;

public class DivingBoard2 {

	Set<Integer> generatePossibleLengths(int longer, int shorter, int k){
		
		Set<Integer> set = new HashSet<Integer>();
		
		int result = longer*k;
		set.add(result);
		for (int i=0; i<k; i++){
			result = result - longer + shorter;
			set.add(result);
		}
		
		return set;
	}
}
