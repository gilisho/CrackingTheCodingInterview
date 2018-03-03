package chapter2;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Palindrome
 * Question 2.6 from CTCI
 * @author Gili
 *
 */
public class Palindrome {

	/**
	 * Check if a linked list is a palidrome.
	 * @return true if the linked list is a palindrome, otherwise false.
	 * Time complexity: O(N)
	 * Space complexity: O(N)
	 */
	public static boolean isPalindrome(LinkedList<Integer> list){
		Stack<Integer> stack = new Stack<>();
		int n = list.size();
		
		/* Add the first half of the list to a stack */
		for (int i=0; i<n/2; i++){
			Integer currNum = list.get(i); 
			stack.push(currNum);
		}
		
		/* Check if the second half is the same as the stack content */
		for (int i=n/2+n%2; i<n; i++){
			Integer currNum = list.get(i);
			if (currNum == stack.peek())
				stack.pop();
			else
				return false;
		}
		
		return true;
	}
	
}
