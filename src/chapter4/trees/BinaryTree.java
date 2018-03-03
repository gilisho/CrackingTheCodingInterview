package chapter4.trees;

public class BinaryTree {
	
	private int size;
	private BinaryNode root;
	
	public int size(){
		return size;
	}
	
	void insert(int key){
		if (this.root == null) 
			this.root = new BinaryNode(key);
		
		
		BinaryNode currNode = this.root;
		while (currNode != null){
			
		}
	}
	
	BinaryNode find(int key){
		BinaryNode currNode = this.root;
		while (currNode != null){
			if (currNode.key == key)
				return currNode;
			if (currNode.key < key)
				currNode = currNode.right;
			else
				currNode = currNode.left;
		}
		return currNode;
	}
	
	public BinaryNode getRandomNode(){
		if (root == null)
			return null;
		int k = (int) Math.random()*this.size;
		return this.root.getKthNode(k);
	}
	
	public int pathsWithSum(int sum){
		int count = this.root.pathsWithSum(sum, this.root.key)+pathsWithSum(sum, this.root);
		return count;
	}
	
	public static int pathsWithSum(int sum, BinaryNode node){
		if (node == null)
			return 0;
		
		int count = 0;
		count += (node.right == null) ? 0 : node.right.pathsWithSum(sum, node.right.key);
		count += (node.left == null) ? 0 : node.left.pathsWithSum(sum, node.left.key);
		count += pathsWithSum(sum, node.left);
		count += pathsWithSum(sum, node.right);
		
		return count;
	}
	
	

}
