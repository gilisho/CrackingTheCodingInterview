package chapter16;

import java.util.Stack;

public class Calculator {
	
	public static void main(String[] arg){
		System.out.println(calculate("2*3+5/6*3+15"));
	}
	
	static float calculate(String str){
		Stack<Float> stk = new Stack<Float>();
		int n = str.length();
		
		for (int i=0; i<n; i++){
			char currChar = str.charAt(i);
			if (currChar == '*' || currChar == '/'){
				float first = stk.pop();
				float[] nextNumber = getNumber(str, i+1);
				float second = nextNumber[0];
				float result = (currChar == '*') ? first*second : first/second;
				
				stk.push(result);
				i = (int) nextNumber[1];
			}
			
			else if (Character.isDigit(currChar)){
				float[] nextNumber = getNumber(str, i);
				stk.push(nextNumber[0]);
				i = (int) nextNumber[1];
			}
		}
		
		for (int i=n-1; i>=0; i--){
			char currChar = str.charAt(i);
			if (currChar == '+' || currChar == '-'){
				float second = stk.pop();
				float first = stk.pop();
				float result = (currChar == '+') ? first+second : first-second;
				stk.push(result);
			}
		}
		
		return stk.pop();
	}
	
	static float[] getNumber(String str, int i){
		float[] array = new float[2];
		int n = str.length();
		array[0] = 0;
	
		while (i<n && Character.isDigit(str.charAt(i))){
			array[0] = array[0]*10 + (int) (str.charAt(i)-'0');
			i++;
		}
		i--;
		
		array[1] = i;	
		return array;
	}

}
