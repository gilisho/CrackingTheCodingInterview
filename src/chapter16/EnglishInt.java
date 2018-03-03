package chapter16;

import java.util.LinkedList;

//question 16.8

public class EnglishInt {

	final static String[] smalls = {"", "One", "Two","Three","Four","Five","Six","Seven", "Eight", "Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	final static String[] tens = {"", "Ten", "Twenty","Thirty","Fourty","Fifteen","Sixty","Seventy","Eighty","Ninety"};
	final static String[] bigs = {"", "Thousand", "Million", "Billion"};
	
	final static String zero = "Zero";
	final static String hundred = "Hundred";
	final static String negative = "Negative";
	
	public static void main(String[] args){
		System.out.println(printEnglishInt(-312132129));
	}

	public static String printEnglishInt(int num){
		if (num == 0){
			return zero;
		}
		if (num < 0){
			return negative + " " + printEnglishInt(-1*num);
		}
		LinkedList<String> list = new LinkedList<String>();
		int chunkCount=0;
		while(num>0){
			if (num%1000 != 0){
				list.addFirst(convert(num%1000)+" "+bigs[chunkCount]);
			}
			num /= 1000;
			chunkCount++;
		}
		return listToString(list);
	}
	
	public static String listToString(LinkedList<String> list){
		StringBuilder strB = new StringBuilder();
		for (int i=0; i<list.size()-1; i++){
			strB.append(list.get(i)+" ");
		}
		strB.append(list.getLast());
		return strB.toString();
	}
	
	public static String convert(int num){
		StringBuilder strB = new StringBuilder();
		if (num>=100){
			strB.append(smalls[num/100]);
			strB.append(" "+hundred);
			num = num % 100;
			if (num != 0)
				strB.append(" ");
		}
		if (num < 20)
			strB.append(smalls[num]);
		else {
			strB.append(tens[num/10]);
			if (num%10 != 0) {
				strB.append(" "+ smalls[num % 10]);
			}
		}
		return strB.toString();
	}

}
