package chapter4;
import java.util.LinkedList;

class Graph {
	public Node[] nodes;
	
	boolean rootBetweenNodes(Graph G, Node node1, Node node2){
		if (G == null)
			return false;
		if (node1 == node2)
			return true;
		
		LinkedList<Node> q = new LinkedList<>();
		
		q.add(node1);
		node1.state = State.visiting;
		
		while(!q.isEmpty()){
			Node dequeued = q.remove();
			if (dequeued == node2)
				return true;
			for (Node node : dequeued.Children){
				if (node == node2)
					return true;
			}
			dequeued.state = State.visited;	
		}
		
		return false;		
	}
	
	void visit(Node node, Node searchedNode, LinkedList q){
		node.state = State.visiting;
		for (Node neighbor : node.Children)
			if (neighbor.state == State.unvisited)
				q.add(neighbor);
		node.state = State.visited;
	}
}
