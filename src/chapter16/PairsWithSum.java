package chapter16;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

// question 16.24

public class PairsWithSum {

	public static void main(String[] args){
		int[] A = {-1, 7, 5, 4, 0, 6, 2, -2, -3};
		System.out.println(pairsWithSumNospace(A, 2));
	}
	
	/*
	// works with postive integers only
	public HashSet<Integer> pairsWithSum(int[] A, int sum){

		HashSet<Integer> hashset = new HashSet<Integer>();
		boolean B[] = new boolean[sum+1]; // indexes are 0 to sum

		for (int i=0; i<A.length; i++)
			if (A[i] <= sum)
				B[A[i]] = true;

		for (int i=0; i<B.length; i++)
			if (B[sum-i]){
				hashset.add(i);
				hashset.add(sum-i);
			}

		return hashset;

	}
	 */

	public static HashSet<Integer> pairsWithSum(int[] A, int sum){

		HashSet<Integer> hashset = new HashSet<Integer>();
		Arrays.sort(A);
		for (int i=0; i<A.length; i++)
			if (!(hashset.contains(A[i]) || hashset.contains(sum-A[i]))){
				int index = Arrays.binarySearch(A, sum-A[i]);
				if (index >=0 && A[index] + A[i] == sum){
					hashset.add(A[i]);
					hashset.add(A[index]);
				}
			}

		return hashset;

	}

	public static HashSet<Integer> pairsWithSumNospace(int[] A, int sum){

		HashSet<Integer> hashset = new HashSet<Integer>();
		Arrays.sort(A);
		
		int rightIndex = A.length-1;
		int leftIndex = 0;
		int currSum = A[leftIndex] + A[rightIndex];
		
		while (rightIndex > leftIndex){
			if (currSum == sum){
				hashset.add(A[leftIndex]);
				hashset.add(A[rightIndex]);
				leftIndex++;
				rightIndex--;
			}
			if (currSum < sum)
				leftIndex++;
			if (currSum > sum)
				rightIndex--;
			currSum = A[leftIndex] + A[rightIndex];
		}

		return hashset;

	}


}
