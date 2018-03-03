package chapter17;

import java.util.ArrayList;

public class ContiguousSeq {
	
	public static int getSum(int[] array){
		int n=array.length;
		int maxSum=0;
		int sum=0;
		
		ArrayList<Integer> array_new = new ArrayList<>();
		for (int i=0; i<n; i++){
			if (array[i]<=0){
				do {
					sum += array[i];
					i++;
				} while (i<n && array[i]<=0);
			}
			else if (array[i]>=0){
				do {
					sum += array[i];
					i++;
				} while (i<n && array[i]>=0);
			}
			array_new.add(sum);
			i--;
		}
		
		for (int i=0; i<array_new.size(); i++){
			int elem = array_new.get(i);
			sum += elem;
			if (sum>maxSum){
				maxSum=sum;
			}
			if (sum < 0){
				sum = 0;
			}
		}
		
		return maxSum;
	}

}
