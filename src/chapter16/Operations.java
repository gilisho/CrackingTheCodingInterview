package chapter16;

//question 16.9
public class Operations {

	public static void main(String[] args){
		System.out.println(divide(100, 10));
	}

	static int multiply(int a, int b){
		if (a < 0 && b < 0)
			return multiply(-a, -b);

		int min = Math.min(a, b);
		int max = Math.max(a, b);
		
		if ((a<0 && Math.abs(a)>Math.abs(b)) || (b<0 && Math.abs(b)>Math.abs(a)))
			return multiply(-a, -b);
		
		int result=0;
		if (min < 0){
			min = -min;
			max = -max;
		}
		for (int i=0; i<min; i++)
			result += max;
		return result;
	}

	static int subtract(int a, int b){ // a-b
		return a + multiply(b, -1);
	}

	static int divide(int a, int b) throws ArithmeticException{ // a/b
		if (b == 0)
			throw new ArithmeticException("Division by zero.");
		if (a == 0 || a<b)
			return 0;
		if (b == 1)
			return a;

		boolean isNegative = ((a<0 || b<0) && !(a<0 && b<0));
		int result = 0;
		
		if (b<0)
			b = -b;
		if (a<0)
			a = -a;
		
		while (a>=b){
			a = subtract(a,b);
			result++;
		}
		return (isNegative) ? -result : result;		
	}

}
