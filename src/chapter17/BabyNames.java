package chapter17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class BabyNames {

	public static HashMap<String, String> wordsKeysInFreq;

	public static class Pair {
		String name1;
		String name2;
	}

	public HashMap<String, Integer> getFreq(HashMap<String, Integer> freqs, ArrayList<Pair> pairs){
		HashMap<String, HashSet<String>> nameToSynonyms = new HashMap<>();
		HashMap<String, String> synonymToName = new HashMap<>();

		for (Pair pair : pairs){
			String name1 = pair.name1;
			String name2 = pair.name2;
			if (nameToSynonyms.containsKey(name1) && nameToSynonyms.containsKey(name2)){
				//merge name2 synonyms to name1 synonyms
				merge(nameToSynonyms, synonymToName, name1, name2);
			}
			
			else if (nameToSynonyms.containsKey(name1) || nameToSynonyms.containsKey(name2)){
				// if one name is real
				String real = nameToSynonyms.containsKey(name1) ? name1 : name2;
				String other = nameToSynonyms.containsKey(name1) ? name2 : name1;
				
				if (synonymToName.containsKey(other)){
					merge(nameToSynonyms, synonymToName, real, synonymToName.get(other));
				}
				else {
					synonymToName.put(other, real);
					nameToSynonyms.get(real).add(other);
				}
			}
			
			else {
				// both are not real
				if (synonymToName.containsKey(name1) && synonymToName.containsKey(name2)){
					if (!synonymToName.get(name1).equals(synonymToName.get(name2)))
						merge(nameToSynonyms, synonymToName, synonymToName.get(name1), synonymToName.get(name2));
				}
				else if (synonymToName.containsKey(name1) || synonymToName.containsKey(name2)){
					String real = synonymToName.containsKey(name1) ? synonymToName.get(name1) : synonymToName.get(name2);
					String other = synonymToName.containsKey(name1) ? name2 : name1;
					synonymToName.put(other, real);
					nameToSynonyms.get(real).add(other);
				}
				else {
					String real = name1;
					String other = name2;
					synonymToName.put(other, real);
					nameToSynonyms.put(real, new HashSet<String>());
					nameToSynonyms.get(real).add(other);
				}	
			}
		}
		return createFreqMap(freqs, nameToSynonyms);
	}
	
	public static void merge(HashMap<String, HashSet<String>> nameToSynonyms, HashMap<String, String> synonymToName, String name1, String name2){
		for (String synonym : nameToSynonyms.get(name2)){
			synonymToName.put(synonym, name1);
		}
		nameToSynonyms.get(name1).addAll(nameToSynonyms.get(name2));
		nameToSynonyms.remove(name2);
		synonymToName.put(name2, name1);
	}
	
	public static HashMap<String, Integer> createFreqMap(HashMap<String, Integer>freqs, HashMap<String, HashSet<String>> nameToSynonyms){
		HashMap<String, Integer> realFreqs = new HashMap<>();
		for (String realName : nameToSynonyms.keySet()){
			int freq=freqs.get(realName);
			for (String synonym : nameToSynonyms.get(realName)){
				freq += freqs.get(synonym);
			}
			realFreqs.put(realName, freq);
		}
		return realFreqs;
	}
}
