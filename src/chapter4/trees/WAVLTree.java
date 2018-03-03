package chapter4.trees;

public class WAVLTree {
	private WAVLNode root;
	private int size;

	public WAVLTree() {
		this.root=null;
		this.size=0;
	}

	public WAVLTree(WAVLNode root){
		this.root=root;
		this.size=1;
	}

	/**
	 * public boolean empty()
	 * @return true if and only if the tree is empty
	 * O(1)
	 */
	public boolean empty() {
		return (this.root == null);
	}

	/**
	 * public int size()
	 * @return the number of nodes in the tree.
	 * O(1)
	 */
	public int size(){
		return this.size;
	}
	
	public WAVLNode find(int key){
		WAVLNode currNode = this.root;
		while (currNode != null && currNode.key != key){
			currNode = (currNode.key > key) ? currNode.left : currNode.right;
		}
		return currNode;
	}

	/**
	 * public int insert(int key, String info)
	 * inserts an item with key k and info i to the WAVL tree.
	 * @param key
	 * @param info
	 * @return the number of rebalancing operations, or 0 if no rebalancing operations were necessary. 
	 * -1 if an item with key k already exists in the tree.
	 * O(log(n))
	 */
	public int insert(int key) {
		WAVLNode node = new WAVLNode(key);
		
		if (this.empty()){
			this.root=node;
			this.size++;
			return 0; //no rebalancing is needed
		}
		
		else { //the tree is not empty
			WAVLNode parent = searchNode(key, true);
			if (parent.key == node.key){return -1;} // the key is already in the tree
			
			if (parent.key > node.key) //node will be a left-child
				parent.left = node;
			else // node will be a right-child
				parent.right=node;
			node.parent = parent;
		}
		this.size++;
		int balanceCounter = node.rebalanceAfterInsertion();
		while (this.root.parent != null){ 
			this.root = this.root.parent;
		} //root update
		return balanceCounter;
	}

	/**
	 * public int delete(int key)
	 * deletes an item with key k from the binary tree, if it is there;
	 * @param key
	 * @return the number of rebalancing operations, or 0 if no rebalancing operations were needed.
	 * -1 if an item with key k was not found in the tree.
	 * O(log(n))
	 */
	public int delete(int key){
		WAVLNode node = searchNode(key, false);
		if (node == null || node.key != key) return -1;
		
		if (node.right != null && node.left != null) { //the node is a binary node
			WAVLNode successor = node.right;
			if (successor != null)
				while (successor.left != null)
					successor = successor.left;
			//switching the key between the binary node and the successor node
			int successorKey = successor.key;
			int nodeKey = node.key;
			node.key = successorKey;
			successor.key = nodeKey;
			node = successor; //node is now pointing at the successor node, after switching the data 
		}
		
		if (node == this.root){
			if (getRank(node) == 0) //The node is the tree root without children
				this.root = null;
			else {
				//The node is the root and an unary node
				if (node.right != null && node.left==null){ //The node has a right-child
					this.root = node.right;
					node.right.parent = null;
				}
				if (node.left != null && node.right==null){ //The node has a left-child
					this.root = node.left;
					node.left.parent = null;
				}
			}
			this.size--;
			return 0; //no rebalancing is needed
		} 
		else { //The node is not the tree root
			node.rank = Math.max(getRank(node.left), getRank(node.right));
			int rebalanceCounter = node.rebalanceBeforeDeletion();
			WAVLNode Father = node.parent;
			if (Father.right == node){ //The node is a right-child
				if (getRank(node) == -1){Father.right = null;} //The replacing node is a leaf
				else if (node.right != null && node.left == null){ //The node is unary with a right-child
					Father.right = node.right;
					node.right.parent = Father;
				}
				else if (node.left != null && node.right==null){ //The node is unary with a left-child
					Father.right = node.left;
					node.left.parent = Father;
				}
			} 
			else { //The node is a left-child
				if (getRank(node) == -1){Father.left = null;} //The replacing node is a leaf
				else if (node.right != null && node.left == null){ //The node is unary with a right-child
					Father.left = node.right;
					node.right.parent = Father;
				} 
				else if (node.left != null && node.right==null){ //The node is unary with a left-child
					Father.left = node.left;
					node.left.parent = Father;
				}
			}
			this.size--;
			while (this.root.parent != null){
				this.root=this.root.parent;
			}
			return rebalanceCounter;
		}
	}

	public class WAVLNode{
		private int key;
		private WAVLNode right;
		private WAVLNode left;
		private int rank;
		private WAVLNode parent;
		private int sizeOfLeftSubtree;

		public WAVLNode(int key){
			this.key=key;
		}

		/**
		 * private void promote()
		 * this.Rank++;
		 * O(1)
		 */
		private void promote(){this.rank++;}

		/**
		 * private void demote()
		 * this.Rank--;
		 * O(1)
		 */
		private void demote(){this.rank--;}

		/**
		 * private void rotate(boolean bol)
		 * @param bol
		 * rotates a node to the Right if bol==true (or left otherwise)
		 * this function does not rebalance the ranks
		 */
		private void rotate(boolean bol){
			WAVLNode Son;
			WAVLNode Grandfather=this.parent.parent;
			WAVLNode Father=this.parent;
			if (bol){ //right rotation
				Son=this.right;
				this.right=Father;
				Father.left=Son;
			} 
			else { //left rotation
				Son=this.left;
				this.left=Father;
				Father.right=Son;
			}
			if (Son != null) Son.parent = Father;
			Father.parent = this;
			this.parent=Grandfather;
			if (Grandfather != null){ //Updates the grandfather's new child.
				if (this.key > Grandfather.key) Grandfather.right = this;
				else Grandfather.left = this;
			}
		}

		/**
		 * private int rebalanceAfterInsert()
		 * @return the number of rebalancing operations
		 */
		private int rebalanceAfterInsertion(){
			int rebalanceCounter=0;
			WAVLNode parent = this.parent;
			
			if (parent == null)
				return 0; //The node is the tree root --> no rebalancing actions needed
			
			boolean isNodeLeftChild = parent.left==this;
			WAVLNode grandparent = this.parent.parent;
			WAVLNode sibling = (isNodeLeftChild) ? parent.right : parent.left;
			WAVLNode child = (isNodeLeftChild) ? this.right : this.left;
			
			if (getRankDif(parent, this)==0 && getRankDif(parent, sibling)==1){
				//Case 1: The parent is a (0,1) or (1,0) node
				parent.promote(); // the parent now is (1,2) or (2,1) node
				rebalanceCounter++;
				if (grandparent != null && getRankDif(grandparent, parent)==1){ 
					//if the parent is a 1-child--> end the balancing.
					return rebalanceCounter;
				}
				return rebalanceCounter+parent.rebalanceAfterInsertion();
			}
			
			if (getRankDif(parent, this)==0 && getRankDif(parent, sibling)==2 && getRankDif(this, child)==2){
				//Case 2: The parent is a (0,2) or (2,0) node 
				//		  and the Node is a (2,2) or (2,1) or (1,2) node:
				this.rotate(isNodeLeftChild);
				parent.demote();
				rebalanceCounter++;
				return rebalanceCounter;
			}

			if (getRankDif(parent, this)==0 && getRankDif(parent, sibling)==2 && getRankDif(this,child)==1){
				//Case 3: The parent is a (0,2) or (2,0) node 
				// 		  and the Node is a (1,1) or (2,1) or (1,2) node:
				child.parent.demote();
				child.rotate(!isNodeLeftChild);
				child.parent.demote();
				child.rotate(isNodeLeftChild);
				child.promote();
				rebalanceCounter+=2;
				return rebalanceCounter;
			}
			return rebalanceCounter;
		}

		private int rebalanceBeforeDeletion(){
			int rebalanceCounter=0;
			WAVLNode Father=this.parent;
			if (Father==null){
				return 0;
			}
			WAVLNode Grandfather=this.parent.parent;
			WAVLNode Brother=Father.right;
			boolean bol=true;
			if (Father.right==this){ //The node is a right-child - mirror Objects.
				Brother=Father.left;
				bol=false;
			}
			if ((getRankDif(Father,this)==3 && getRankDif(Father,Brother)==2)
					||(getRank(this)==-1 && getRank(Brother)==-1 && getRank(Father)==1)){
				//Case 1: The Father is a (2,3) or (3,2) node or ((2,2) node and a leaf)
				Father.demote();
				rebalanceCounter++;
				if (Grandfather!=null && getRankDif(Grandfather,Father)==2){ 
					return rebalanceCounter; //The Father is a 2-child and not a 3-child-->rebalancing ended.
				}
				return rebalanceCounter+Father.rebalanceBeforeDeletion();
			}
			if (getRankDif(Father,this)==3 && getRankDif(Father,Brother)==1){
				WAVLNode Nephew=Brother.right;
				WAVLNode otherNephew=Brother.left;
				if (Father.right==this){
					Nephew=Brother.left;
					otherNephew=Brother.right;
				}

				if(getSonsRanks(Brother)==22){
					//Case 2: The Father is a (3,1) or (1,3) node and the Node's brother is a (2,2) node
					Father.demote();
					Brother.demote();
					rebalanceCounter+=2;
					if (Grandfather!=null && getRankDif(Grandfather,Father)==2){ 
						return rebalanceCounter; //if the Father is a 2-child and not a 3-child-->rebalancing ended.
					} 
					return rebalanceCounter+Father.rebalanceBeforeDeletion();
				}
				if (getRankDif(Brother,Nephew)==1){
					//Case 3: The Father is a (3,1) and the Brother is (1/2,1) or the Father is a (1,3) the node and the Brother is (1,1/2)
					Brother.rotate(!bol); //rotate Brother against the Father
					Father.demote();
					Brother.promote();
					rebalanceCounter++;
					if (getSonsRanks(Father)>=22){
						Father.demote();
						rebalanceCounter++;
					}
					return rebalanceCounter;
				}
				if (getRankDif(Brother,Nephew)==2){
					//Case 4: The Father is a (3,1) and the Brother is (1/2,1) or the Father is a (1,3) the node and the Brother is (1,1/2)
					otherNephew.rotate(bol); //Rotate otherNephew against the Brother
					Brother.demote();
					otherNephew.promote();
					otherNephew.rotate(!bol); //Rotate otherNephew against the Father
					Father.demote();
					otherNephew.promote();
					rebalanceCounter+=2;
					if (getSonsRanks(Father)>=22){
						Father.demote();
						rebalanceCounter++;
					}
					return rebalanceCounter;
				}
			}
			return rebalanceCounter;
		}
		
		public int rank(){
			int rank = 0;
			if (this.left != null)
				rank += 1+this.left.sizeOfLeftSubtree;
			
			if (this.parent != null && this.parent.right == this)
				rank += 1+this.parent.sizeOfLeftSubtree;
			return rank;
		}
		
	}

	/**
	 * public static int getRank(WAVLNode node)
	 * @param node
	 * @return node.Rank or -1 if the node is an external leaf.
	 * O(1)
	 */
	public static int getRank(WAVLNode node){
		return (node != null) ? node.rank : -1;
	}

	/**
	 * public static int getRankDif(WAVLNode node1,WAVLNode node2)
	 * @param node1,node2
	 * @return the rank difference between node1 and node2.
	 * O(1)
	 */
	public static int getRankDif(WAVLNode node1,WAVLNode node2){
		return getRank(node1)-getRank(node2);
	}

	/** 
	 * public static int getSonsRanks()
	 * @return two (or one for rank dif of 0 between node and right child) digit int: the Rank differences between this and its children.  
	 * O(1)
	 */
	public static int getSonsRanks(WAVLNode node){
		if (node==null) return -1;
		return Integer.parseInt(new String (""+getRankDif(node,node.left)+getRankDif(node,node.right)));
	}

	/**
	 *  public WAVLNode searchNode
	 *  @param node from which we start to search for the key node
	 *  @param key
	 *  @return WAVLNode which has minimum ABS(WAVLNode.Key-key)
	 *  O(log(n))
	 *  */
	public WAVLNode searchNode(int key, boolean forInsertion){
		WAVLNode currNode = this.root;
		while (currNode != null){
			if (currNode.key == key)
				return currNode;
			
			WAVLNode nextNode;
			if (currNode.key > key){
				currNode.sizeOfLeftSubtree = (forInsertion) ? currNode.sizeOfLeftSubtree+1 : currNode.sizeOfLeftSubtree-1 ;
				nextNode = currNode.left;
			}
			else
				nextNode = currNode.right;
			
			if (nextNode == null) 
				return currNode;
			currNode = nextNode;
		}
		return currNode;
	}
	
	public WAVLNode getRandomNode(){
		int k = (int) Math.random()*this.size();
		return getKthNode(k);
	}
	
	public WAVLNode getKthNode(int k){
		if (k >= this.size())
			return null;
		
		WAVLNode currNode = this.root;
		int currRank = currNode.rank();

		while (currRank != k){
			if (currRank < k)
				currNode = currNode.right;
			else { // currRank > k
				if (currNode.right == null || currNode.right.rank() > k)
					currNode = currNode.left;
				else
					currNode = currNode.right;
			}
		}
		return currNode;
	}

}
