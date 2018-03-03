package chapter2;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Return Kth to Last
 * Question 2.2
 * @author Gili
 *
 */
public class KToLast {
	
	/**
	 * Find the Kth to last element of a singly linked list,
	 * assuming the size of the list is unknown.
	 * Time complexity: O(N)
	 * Space complexity: O(1)
	 */
	public static <E> E getKToLast(LinkedList<E> list, int k){
		if (list==null)
			return null;
		
		Iterator<E> iterLeft = list.iterator();
		Iterator<E> iterRight = list.iterator();
		E left = iterLeft.next();
		for (int i=0; i<k; i++){
			/* Move iterRight k elements ahead of iterLeft */
			if (!iterRight.hasNext()){
				/* list doesn't have k elements or more */
				return null;
			}
			iterRight.next(); //
		}
		
		while (iterRight.hasNext()){ // while the end hasn't been reached
			left = iterLeft.next();
			iterRight.next();
		}
		
		return left;
	}

}
