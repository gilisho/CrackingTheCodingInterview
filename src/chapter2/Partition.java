package chapter2;

import java.util.LinkedList;

/**
 * Partition
 * Question 2.4 from CTCI
 * @author Gili
 *
 */
public class Partition {

	/**
	 * Partition a linked list around a value x, such that all nodes 
	 * less than x come before all nodes greater than or equal to x.
	 * If x is contained within the list, the values of x only need
	 * to be after the elements less than x. The partition element x
	 * can appear anywhere in the "right partition"; it doesn't need
	 * to appear between the left and right partition.
	 * @return the start of the left partition
	 */
	public static Node partition(LinkedList<Integer> list, int x){
		
		Node leftStart = null;
		Node leftEnd = null;
		Node rightStart = null;
		
		for (Integer num : list){
			Node curr = new Node(num);
			
			/* Add element to the suitable list */
			if (num<x){
				if (leftEnd == null){
					leftEnd = curr;
					leftStart = curr;
				}
				else {
					leftEnd.next = curr;
					leftEnd = curr;
				}
			}
			else {
				if (rightStart == null)
					rightStart = curr;
				else {
					curr.next = rightStart;
					rightStart = curr;
				}
			}
		}
		
		return mergeLists(leftStart, leftEnd, rightStart);
	}
	
	/**
	 * Merges two lists, so that otherList is added to the end of list.
	 * @return the start of the output list
	 */
	public static Node mergeLists(Node listStart, Node listEnd, Node otherListStart){
		if (listStart == null)
			return otherListStart;
		listEnd.next = otherListStart;
		return listStart;
	}
	
}
