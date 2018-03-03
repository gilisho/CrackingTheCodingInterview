package chapter2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Remove Dups
 * Question 2.1 from CTCI
 * @author Gili
 *
 */
public class RemoveDups {
	
	/**
	 * Remove duplicates from an unsorted linked list.
	 * Temporary buffer is allowed.
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 */
	public static <T> void removeDups(LinkedList<T> list){
		if (list == null)
			return;
		Iterator<T> iter = list.iterator();
		HashSet<T> seenElems = new HashSet<>();
		while (iter.hasNext()){
			T currElem = iter.next();
			if (seenElems.contains(currElem))
				iter.remove();
			else
				seenElems.add(currElem);
		}
	}

	/**
	 * Remove duplicates from an unsorted linked list.
	 * Temporary buffer is NOT allowed.
	 * Time complexity: O(N**2)
	 * Space complexity: O(1)
	 */
	public static <T> void removeDupsNoBuffer(LinkedList<T> list){
		for (int index1 = 0, index2 = 1; index1<list.size(); index1++, index2=index1+1){
			while (index2<list.size()){
				if (list.get(index1) == list.get(index2))
					list.remove(index2);
				else
					index2++;
			}
		}
	}

}
