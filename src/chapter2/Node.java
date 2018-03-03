package chapter2;

public class Node {
	
	int data;
	Node next = null;
	
	public Node(int data){
		this.data = data;
	}
	
	/**
	 * Question 2.3
	 * Deletes a node in the middle (i.e, any node but the first and the last node,
	 * not necessarily the exact middle) of a singly linked list, given only that node.
	 * @param node
	 */
	public void deleteMiddleNode(Node node){
		Node next = node.next;
		
		node.data = next.data;
		node.next = next.next;
		
	}

}
