package chapter3;

import java.util.Stack;

public class MyQueue <E> {
	
	Stack<E> stackNewest;
	Stack<E> stackOldest;
	
	public MyQueue(){
		this.stackNewest = new Stack<>();
		this.stackOldest = new Stack<>();
	}
	
	public boolean isEmpty(){
		return this.size()==0;
	}
	
	public int size(){
		return this.stackNewest.size()+this.stackOldest.size();
	}
	
	public E peek(){
		if (stackOldest.isEmpty())
			transferStacks();
		return stackOldest.peek();
	}
	
	public E pop(){
		if (stackOldest.isEmpty())
			transferStacks();
		return stackOldest.pop();
	}
	
	public void push(E elem){
		stackNewest.push(elem);
	}
	
	private void transferStacks(){
		while (!stackNewest.isEmpty())
			stackOldest.push(stackNewest.pop());
	}

}
