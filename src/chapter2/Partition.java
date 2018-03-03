package chapter2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class Partition {

	public static void partition(LinkedList<Integer> list, int x){
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		
		for (Integer num : list){
			if (num<x)
				left.add(num);
			else
				right.add(num);
		}
		for (int i=0; i<list.size(); i++){
			if (!left.isEmpty())
				list.set(i, left.remove(left.size()-1));
			else
				list.set(i, right.remove(left.size()-1));
		}
	}
	
}
