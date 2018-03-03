package chapter17;

public class MissingTwo {

	public static int missingOne(int[] array, int N){
		int sum = getSum(array);
		int expectedSum = N*(N+1)/2;
		return expectedSum-sum;
	}
	
	public static int getSum(int[] array){
		int sum=0;
		for (int num : array)
			sum+=num;
		return sum;
	}
	
	public static int getProduct(int[] array){
		int product = 1;
		for (int num : array)
			product*=num;
		return product;
	}
	
	public static int factorial(int N){
		int factorial = 1;
		for (int i=2; i<=N; i++)
			factorial *= i;
		return factorial;
	}
	
	public static int[] missingTwo(int[] array, int N){
		int[] result = new int[2];
		int sum = missingOne(array, N);
		int product = factorial(N)/getProduct(array);
		
		result[0] = (int)(sum+Math.sqrt(Math.pow(sum, 2)-4*product))/2;
		result[1] = sum-result[0];
		return result;
	}
	
}
