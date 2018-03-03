package chapter4.trees;

//question 4.2

public class MinimalTree {

	/**
	 * Given a sorted (increasing order) array with unique integer elements,
	 * this method creates a binary search tree with minimal height.
	 * 
	 * @param A
	 * @return return the root of the created binary search tree.
	 */
	static BinaryNode minimalTree(int[] A){
		if (A == null)
			return null;
		
		return minimalTree(A, 0, A.length-1);
		
	}
	
	static BinaryNode minimalTree(int[] A, int leftIndex, int rightIndex){
		
		if (leftIndex > rightIndex)
			return null;
		
		int middleIndex = (rightIndex+leftIndex)/2;
		BinaryNode root = new BinaryNode(A[middleIndex]);
		
		root.left = minimalTree(A, leftIndex, middleIndex-1);
		root.right = minimalTree(A, middleIndex+1, rightIndex);
		
		return root;
		
	}
	
}
