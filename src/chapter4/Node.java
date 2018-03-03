package chapter4;

class Node {
	State state;
	public String name;
	public Node[] Children;
	boolean visited;
	
	public Node(){
		state = State.unvisited;
	}
	
}
