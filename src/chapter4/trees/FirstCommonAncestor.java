package chapter4.trees;

public class FirstCommonAncestor {
	
	
	//assuming there's a parent pointer in BinaryNode class
	public static BinaryNode getLCA(BinaryNode root, BinaryNode node1, BinaryNode node2){
		if (root==null || node1==null ||node2==null)
			return null;
		int node1Dep = getDepth(node1);
		int node2Dep = getDepth(node2);
		if (node2Dep!=node1Dep){
			int diff = Math.abs(node1Dep-node2Dep);
			if (node2Dep>node1Dep)
				node2 = moveUp(node2,diff);
			else
				node1 = moveUp(node1,diff);
		}
		while (node1 != node2){
			node1 = node1.parent;
			node2 = node2.parent;
		}
		
		return node1;
		
	}
	
	public static BinaryNode moveUp(BinaryNode node, int diff){
		for (int i=0; i<diff; i++)
			node = node.parent;
		return node;
	}
	
	public static int getDepth(BinaryNode node){
		int depth=0;
		while (node!=null){
			node = node.parent;
			depth++;
		}
		return depth;
	}

}
