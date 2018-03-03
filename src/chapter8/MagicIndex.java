package chapter8;

public class MagicIndex {
	
	public static int getMagicIndex(int[] array){
		for (int i=0; i<array.length; i++){
			if (array[i] > i)
				return -1;
			if (array[i] == i)
				return i;
			
		}
	}

}
