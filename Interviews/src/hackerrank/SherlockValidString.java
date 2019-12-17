package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class SherlockValidString {

	public SherlockValidString() {

		System.out.println((isValid_("aabbcd")));

		// System.out.println(assertEquals(isValid("ABC"), "YES"));
		// System.out.println(assertEquals(isValid("aabbcd"), "NO"));
		// System.out.println(assertEquals(isValid("aabbccddeefghi"), "NO"));
		// System.out.println(assertEquals(isValid("abcdefghhgfedecba"),
		// "YES"));
		// System.out.println(assertEquals(isValid("aabbccddeefghi"), "YES"));

	}

	public boolean assertEquals(String expected, String finalOutput) {
		return expected.equals(finalOutput);
	}

	public static ArrayList<String> castStringToList(String data) {

		ArrayList<String> output = new ArrayList<String>();
		for (int i = 0; i < data.length(); i++) {
			output.add(String.valueOf(data.charAt(i)).toUpperCase());
		}
		return output;
	}

	static String isValid(String s) {

		NavigableMap<String, Integer> hashMap = new TreeMap<>();
		// HashMap<String, Integer> hashMap = new HashMap<>();
		ArrayList<String> listVal = castStringToList(s);
		java.util.Collections.sort(listVal);

		for (String data : listVal) {
			if (!hashMap.containsKey(data)) {
				hashMap.put(data.toString(), 1);
			} else {
				int sizer = hashMap.get(data.toString()) + 1;
				hashMap.remove(data.toString());
				hashMap.put(data.toString(), sizer);
			}
		}

		int difference = hashMap.get(String.valueOf(s.charAt(0)).toUpperCase());
		int counterDifference = 0;

		int prevVal = 0;

		for (Map.Entry<String, Integer> e : hashMap.entrySet()) {
			Map.Entry<String, Integer> next = hashMap.higherEntry(e.getKey()); // next
			Map.Entry<String, Integer> prev = hashMap.lowerEntry(e.getKey()); // previous

			if (prev == null) {
				prevVal = hashMap.get(String.valueOf(s.charAt(0)).toUpperCase());
			} else {
				prevVal = prev.getValue();
			}

			// do work with next and prev
			if (counterDifference >1) {
				System.out.println("counterDiffernce>1");
				return "NO";
			}
			if (next == null && prev != null) {
				difference = Math
						.abs(hashMap.get(String.valueOf(s.charAt(s.length() - 1)).toUpperCase()) - prev.getValue());
			} else if (next != null && prev == null) {
				difference = Math.abs(hashMap.get(String.valueOf(s.charAt(0)).toUpperCase()) - next.getValue());
			} else if (next != null && prev != null) {
				difference = Math.abs(next.getValue() - prev.getValue());
			}
			System.out.println("Difference: "+ difference);
			if (difference == 1) {
				counterDifference++;
			}
		}

		return "YES";
	}

	
	static String isValid_(String s) {
	    final String GOOD = "YES";
	    final String BAD = "NO";

	    if(s.isEmpty()) return BAD;
	    if(s.length() <= 3) return GOOD;

	    int[] letters = new int[26];
	    for(int i = 0; i < s.length(); i++){
	        letters[s.charAt(i) - 'a']++;
	    }
	    Arrays.sort(letters);
	    int i=0;
	    while(letters[i]==0){
	        i++;
	    }
	    System.out.println(i);
	    //System.out.println(Arrays.toString(letters));
	    int min = letters[i];   //the smallest frequency of some letter
	    int max = letters[25]; // the largest frequency of some letter
	    String ret = BAD;
	    if(min == max) ret = GOOD;
	    else{
	        // remove one letter at higher frequency or the lower frequency 
	        if(((max - min == 1) && (max > letters[24])) ||
	            (min == 1) && (letters[i+1] == max))
	            ret = GOOD;
	    }
	    return ret;
	}
	public static void main(String[] args) {
		SherlockValidString sv = new SherlockValidString();
	}
}
