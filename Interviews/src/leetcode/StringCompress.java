package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class StringCompress {

	public StringCompress() {
		// TODO Auto-generated constructor stub
		char chars[] = { 'a', 'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b' };
		// char input[] = { 'a', 'a', 'b', 'b', 'c', 'c', 'c' };
		// char input[] = { 'a', 'b', 'c' };
		System.out.println(compress(chars));
		System.out.println(chars);

	}
	
	public int compress_(char[] chars) {
		
		if (chars == null){
			return -1;
		}
		if (chars.length==1){
			return 1;
		}
		
		int n=1;
		for (int i=0; i<chars.length-1; i++){
			if (chars[i] != chars[i+1]){
				if (n==1){
					
				}
				else{
					
				}
				n=1;
			}
			else{
				n++;
			}
		}
		
		return -1;
	}

	public int compress(char[] chars) {

		Map<Character, Integer> hmap = new HashMap<Character, Integer>();

		for (char ch : chars) {
			if (hmap.containsKey(ch)) {
				hmap.put(ch, hmap.get(ch) + 1);
			} else {
				hmap.put(ch, 1);
			}
		}

		Set<Entry<Character, Integer>> sett = hmap.entrySet();

		int n = 0;

		for (Entry<Character, Integer> ee : sett) {

			if (ee.getValue() == 1) {
				n++;
			} else {
				n = n + getDigit(ee.getValue()) + 1;
			}
		}
		chars = new char[n + 1];
		int d = 0;
		for (Entry<Character, Integer> ee : sett) {
			chars[d++] = ee.getKey();
			if (ee.getValue() > 1) {
				for (int i = 0; i < getDigit(ee.getValue()); i++) {
					chars[d++] = ee.getValue().toString().charAt(i);
				}
			}
		}
		return n;
	}

	public int getDigit(int n) {
		int count = 0;
		while (n > 0) {
			n = n / 10;
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringCompress stringCompress = new StringCompress();
	}

}
