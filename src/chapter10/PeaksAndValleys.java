package chapter10;

import java.util.Arrays;

public class PeaksAndValleys {

	public static void main(String[] args){
		int[] array = {5,8,6,2,3,4,6};
		peaksAndValleys(array);
		System.out.println(Arrays.toString(array));
	}
	
	
	public static void peaksAndValleys(int[] array){
		int n = array.length;
		if (n<=1)
			return;
		boolean isPeak = (array[0] <= array[1]);
		for (int i=1; i<n-1; i++){
			if ((isPeak && array[i]<array[i+1]) ||
				(!isPeak && array[i]>array[i+1]))
				swap(array, i, i+1);
			isPeak=!isPeak;
		}
	}
	
	public static void swap(int[] array, int index1, int index2){
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}
	
}
