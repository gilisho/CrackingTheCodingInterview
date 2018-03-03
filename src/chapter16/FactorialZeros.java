package chapter16;

public class FactorialZeros {

	public static int countTrailingZeros(int n){
		int count=0;;
		for (int i=5; i<=n; i+=5){
			count += factorsOf5(i);
		}
		return count;
	}
	
	public static int factorsOf5(int i){
		int count=0;
		while (i%5==0){
			count++;
			i /= 5;
		}
		return count;
	}
	
	public static void main(String[] args){
		System.out.println(countTrailingZeros(10));
	}
	
}
