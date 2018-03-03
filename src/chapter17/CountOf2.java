package chapter17;

public class CountOf2 {

	public static int getCountOf2(int n){
		
		int count=0;
		int curr=0;
		
		while (curr<=n){
			count += countCurr(curr);
			curr++;
		}
		
		return count;
		
	}
	
	public static int countCurr(int curr){
		int count=0;
		
		while (curr!=0){
			if (curr%10 == 2)
				count++;
			curr /= 10;
		}
		
		return count;
	}
	
}
