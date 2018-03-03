package chapter4.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//question 4.3
class ListOfDepths {
	
	//test
	public static void main(String[] args){
		int[] array = {1,2,3,4,5,6,7};
		BinaryNode node = MinimalTree.minimalTree(array);
		
		List<LinkedList<BinaryNode>> list = listOfDepths(node);
		
		System.out.println(Arrays.deepToString(list.toArray()));
		
	}
	
	static List<LinkedList<BinaryNode>> listOfDepths(BinaryNode root){
		List<LinkedList<BinaryNode>> list = new ArrayList<LinkedList<BinaryNode>>();
		listOfDepths(list, root, 0);
		return list;
	}
	
	static void listOfDepths(List<LinkedList<BinaryNode>> list, BinaryNode root, int depth){
		if (root == null)
			return;
		
		LinkedList<BinaryNode> currDepthList;
		if (list.size() == depth){
			currDepthList = new LinkedList<BinaryNode>();
			list.add(currDepthList);
		}
		else
			currDepthList = list.get(depth);
		
		currDepthList.add(root);
		listOfDepths(list, root.left, depth+1);
		listOfDepths(list, root.right, depth+1);
	}

}
