package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NonRepeatingCharacter {

	public NonRepeatingCharacter() {
		String s = "loveleetcode";
		//System.out.println(firstUniqChar(s));
		//System.out.println(firstUniqChar("loveleetcode"));
		Map<Character, Integer> mapValue = new HashMap<Character, Integer>();
		int n = 0;
		
		for (char c : s.toCharArray()) {
			if (mapValue.get(c) == null) {
				mapValue.put(c, n++);
			} else {
				mapValue.put(c, -1);
			}
		}

		n = Integer.MAX_VALUE;
		int min = 0;
		//System.out.println(n);
		for (char c : mapValue.keySet()) {
			min = mapValue.get(c);
			if ((min>-1) && (n>min)) {
				n = min;
			}
		}
		//return min == Integer.MAX_VALUE ? -1 : min;
		System.out.println("Min: " + n);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new NonRepeatingCharacter();

	}
	/*
	 * Problem description: Given a string, find the first non-repeating
	 * character in it and return it's index. If it doesn't exist, return -1.
	 * 
	 * Examples:
	 * 
	 * s = "leetcode" return 0.
	 * 
	 * s = "loveleetcode", return 2.
	 */
}
