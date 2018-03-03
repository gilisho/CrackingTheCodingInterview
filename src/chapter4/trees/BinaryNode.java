package chapter4.trees;

class BinaryNode {

	int key;
	
	BinaryNode parent; // for question 4.6 and 4.8 and 4.11
	BinaryNode left;
	BinaryNode right;
	
	int size; // for 4.11 - size of tree
	
	public BinaryNode(int key) {
		this.key = key;
	}
	
	public String toString(){
		return Integer.toString(key);
	}
	
	//question 4.6
	public BinaryNode getSuccessor(){
		BinaryNode currSuccessor = this.right;
		if (currSuccessor != null){
			while (currSuccessor.left != null)
				currSuccessor = currSuccessor.left;
		}
		
		else if (this.parent != null){
			BinaryNode node = this;
			currSuccessor = this.parent;
			while (currSuccessor != null && node == currSuccessor.right){
				node = currSuccessor;
				currSuccessor = node.parent;
			}
		}
		
		return currSuccessor;
	}
	
	public void insertInOrder(int key){ // for 4.11
	
		if (this.key <= key){
			if (left == null)
				left = new BinaryNode(key);
			else
				this.left.insertInOrder(key);
		}
		else {
			if (right == null)
				right = new BinaryNode(key);
			else
				this.right.insertInOrder(key);
		}
		size++;
	}
	
	public BinaryNode getKthNode(int k){ // for 4.11
		int leftSize = (this.left == null) ? 0 : left.size;
		if (k < leftSize){
			return this.left.getKthNode(k);
		}
		if (k == leftSize)
			return this;
		else {
			return this.right.getKthNode(k-(leftSize+1));
		}
	}
	
	public int pathsWithSum(int sum, int currSum){
		int count = 0;
		
		if (currSum == sum)
			count++;
		if (this.left != null)
			count += this.left.pathsWithSum(sum, currSum+this.left.key);
		if (this.right != null)
			count += this.right.pathsWithSum(sum, currSum+this.right.key);
		
		return count;
	}
	
}
