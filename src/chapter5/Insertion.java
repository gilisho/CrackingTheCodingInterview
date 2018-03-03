package chapter5;

// question 5.1

public class Insertion {
	
	static int insert(int N, int M, int i, int j){

		N = clearBits(N, i, j);
		M = M << i;
		
		return N | M;
		
	}
	
	/**
	 * Clears the bits i through j.
	 * @param num
	 * @param i
	 * @param j
	 * @return
	 */
	static int clearBits(int num, int i, int j){
		int allOnes = ~0;
		int left = allOnes << (j+1);
		int right = ((1 << i) - 1);
		
		int mask = left | right;
		
		return num &= mask;
		
	}


	static int clearBit(int num, int i) {
		int mask = ~(1 << i);
		return num & mask;
	}

}
