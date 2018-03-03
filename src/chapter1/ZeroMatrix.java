package chapter1;

import java.util.ArrayList;
import java.util.Iterator;

class ZeroMatrix {

	public void ZeroMatrix(int[][] matrix){
		int m = matrix.length; // number of rows
		int n = matrix[0].length; // number of columns

		ArrayList<Integer> rows = new ArrayList<Integer>();
		ArrayList<Integer> cols = new ArrayList<Integer>();

		for (int i=0; i<m; i++)
			for (int j=0; j<n; j++)
				if (matrix[i][j] == 0){
					if (!rows.contains(i))
						rows.add(i);
					if (!cols.contains(j))
						cols.add(j);
				}

		Iterator<Integer> rowsIter = rows.iterator();
		
		
		Integer row;
		for (int index=0; index<rows.size(); index++){
			row = rowsIter.next();
			ZeroRow(matrix, row, true);
		}


		Iterator<Integer> iter = cols.iterator();
		Integer currElement;
		for (int index=0; index<cols.size(); index++){
			currElement = iter.next();
			ZeroRow(matrix, currElement, false);
		}


	}

	public void ZeroRow(int[][] matrix, int rowOrCol, boolean isRows){
		if (isRows)
			for (int i=0; i<matrix[rowOrCol].length; i++)
				matrix[rowOrCol][i] = 0;
		else
			for (int i=0; i<matrix[0].length; i++)
				matrix[i][rowOrCol] = 0;
	}
}