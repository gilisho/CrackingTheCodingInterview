package chapter2;

import java.util.Iterator;
import java.util.LinkedList;

public class KToLast {
	
	public static <E> E getKToLast(LinkedList<E> list, int k){
		if (list==null || k>=list.size())
			return null;
		
		Iterator<E> iterLeft = list.iterator();
		Iterator<E> iterRight = list.iterator();
		E left = iterLeft.next();
		for (int i=0; i<k; i++)
			iterRight.next();
		
		while (iterRight.hasNext()){
			left = iterLeft.next();
			iterRight.next();
		}
		
		return left;
	}

}
