package chapter2;

/**
 * Delete Middle Node
 * Question 2.3 from CTCI
 * @author Gili
 *
 */
public class DeleteMiddleNode {
	
	/**
	 * Delete a node in the middle (i.e, any node but the first and the last node,
	 * not necessarily the exact middle) of a singly linked list, given only that node.
	 * @pre (node != null)
	 */
	public void deleteMiddleNode(Node node){
		Node nextNode = node.next;
		node.data = nextNode.data; /* Copy data from the next node to middle node */
		node.next = nextNode.next; /* Delete the next node from list */
	}
	
}
