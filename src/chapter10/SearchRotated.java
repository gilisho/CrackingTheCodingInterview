package chapter10;

public class SearchRotated {
	
	public static void main(String[] args){
		int[] array = {15,16,19,20,25,1,3,4,5,7,10,14};
		System.out.println(search(array,16));
	}

	public static int search(int[] array, int num){
		if (array == null) return -1;
		return rotatedBinarySearch(array, num, 0, array.length-1);
	}
	
	public static int rotatedBinarySearch(int[] array, int num, int start, int end){
		int n = array.length;
		int lastNum = array[end];
		int middle = (start+end)/2;
		
		if (!(start < end)){
			if (start==end && array[start]==num)
				return start;
			return -1;
		}
		
		if (array[middle]==num)
			return middle;
		
		if (array[middle]<lastNum && num<=lastNum)
			return rotatedBinarySearch(array, num, middle+1, end);
		
		if (array[middle]>lastNum && num>lastNum)
			return rotatedBinarySearch(array, num, start, middle-1);
		
		if (array[middle]>lastNum && num<=lastNum)
			return rotatedBinarySearch(array, num, middle+1, end);
		
		//if (array[middle]<lastNum && num>lastNum)
		return rotatedBinarySearch(array, num, start, middle-1);
	}
}
