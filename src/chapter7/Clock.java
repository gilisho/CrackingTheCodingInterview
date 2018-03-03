package chapter7;

public class Clock {

	private final int numOfStates = 4;
	private int state;
	
	public void changeState(){
		state = (state + 1) % numOfStates;
	}
	
	private class Buttons {
		
		private void function(int state){
			
		}
		
	}
	
	
	
	
}
