package chapter8;

import java.util.HashSet;
import java.util.Set;

public class PowerSet {
	
	public static <E> Set<Set<E>> subsets(Set<E> set){
		if (set == null)
			return null;
		
		HashSet<Set<E>> subsets = new HashSet<Set<E>>();
		subsets.add(set);
		if (set.isEmpty())
			return subsets;
		
		
			
		}
		
	}

}
