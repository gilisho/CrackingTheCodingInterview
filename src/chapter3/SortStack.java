package chapter3;

import java.util.Stack;

public class SortStack {

	//question 3.5
	static <E extends Comparable<E>> void sortStack(Stack<E> stack){

		if (stack == null)
			return;
		
		Stack<E> tempStack = new Stack<E>();
		int n = stack.size();
		E min = stack.peek();
		
		for (int i=0; i<n; i++){
			// move all the elements to the temp stack while saving a pointer to the minimum
			while (!stack.isEmpty()){
				E currElem = stack.pop();
				if (currElem.compareTo(min) < 0)
					min = currElem;
				tempStack.push(currElem); 
			}

			// move all the unsorted elements back to the original stack, except for the minimum
			while (tempStack.size() != i){
				E currElem = tempStack.pop();
				if (currElem != min)
					stack.push(currElem);
			}
			tempStack.push(min); // keep the minimum element in the temp stack
		}
	
		for (int i=0; i<n; i++) 
			// transfer the elements from the temp stack to the original stack
			stack.push(tempStack.pop());

	}

}