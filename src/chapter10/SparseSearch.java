package chapter10;

/**
 * Question 10.5 in CTCI
 * @author Gili
 *
 */
public class SparseSearch {
	
	/**
	 * Finds the location of a given string in a sorted array of strings that is interspersed with empty string.
	 * @param array
	 * @param str
	 * @return the location of a given string.
	 */
	public static int search(String[] array, String str){
		
		if (array == null || str == null)
			return -1;
		
		return binarySearch(array,str,0,array.length);
		
	}
	
	/**
	 * @pre - (array != null) && (str != null)
	 * @param array
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 */
	public static int binarySearch(String[] array, String str, int start, int end){
		
		int middle = (start+end)/2;
		
		if (str.compareTo(array[middle])==0)
			return middle;
		
		if (!(start<end))
			return -1;
		
		if (array[middle].isEmpty()){
			int index = binarySearch(array,str,start,middle-1);
			if (index == -1)
				index = binarySearch(array,str,middle+1,end);
			return index;
		}
		
		if (str.compareTo(array[middle])<0)
			return binarySearch(array,str,start,middle-1);
		
		//if (str.compareTo(array[middle])>0)
		return binarySearch(array,str,middle+1,end);
		
	}
	
}
