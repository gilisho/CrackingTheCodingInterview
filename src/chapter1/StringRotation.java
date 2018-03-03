package chapter1;

public class StringRotation {
	
	
	public static boolean isStringRotation(String s1, String s2){
		if (s1 == null || s2 == null || s1.length()!=s2.length())
			return false;
		String s2s2 = s2+s2;
		return isSubstring(s1,s2s2);
	}
	
	public static boolean isSubstring(String a, String b){
		return false;
	}
	
}
