package chapter17;

public class BiNode {
	
	BiNode node1;
	BiNode node2;
	
	public void convert(BiNode node){
		if (node==null){
			return;
		}
		
		convert(node.node1);
		node.node1 = node.node1.node2;
		node.node2 = 
		
	}
	
	public void convert(BiNode parent, BiNode child){
		boolean isChildLeft = (child == parent.node1);
		if ()
		BiNode left = (isChildLeft) ? child : parent;
		BiNode right = (left == parent) ? child : parent;
		
		left.node2 = right;
		right.node1 = left;
	}

}
