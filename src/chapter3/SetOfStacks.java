package chapter3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class SetOfStacks<E> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	ArrayList<Stack<E>> stacks;
	int threshold;
	
	public Stack<E> getLast(){
		return this.stacks.get(stacks.size()-1);
	}
	
	public void removeLast(){
		this.stacks.remove(this.stacks.size()-1);
	}
	
	public boolean isFull(){
		return getLast().size()==threshold;
	}
	
	public void push(E elem){
		if (this.isFull())
			this.stacks.add(new Stack<E>());;
		this.getLast().push(elem);
	}
	
	public E pop(){
		if (stacks.isEmpty())
			return null;
		return popAt(stacks.size()-1);
	}
	
	public E popAt(int index){
		if (stacks.size() <= index)
			return null;
		E elem = getLast().pop();
		if (getLast().isEmpty())
			removeLast();
		return elem;
	}
	

}
