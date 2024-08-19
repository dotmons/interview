/*
 
 
 */

package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SingleNumber {

	int nums[] = { 2, 2, 1 };
	int num[] = { 4, 1, 2, 1, 2 };

	public SingleNumber() {
		System.out.println(singleNumber(nums));
		System.out.println(singleNumber(num));
		System.out.println(singleNumberSet(num));

	}

	public int singleNumberSet(int[] nums) {

		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			if (set.contains(i)) {
				set.remove(i);
			} else {
				set.add(i);
			}

		}
		for (int i : set) {
			return i;
		}
		return -1;
	}

	public int singleNumber(int[] nums) {

		Map<Integer, Integer> mapValue = new HashMap<Integer, Integer>();

		for (int n : nums) {
			if (!mapValue.containsKey(n)) {
				mapValue.put(n, 1);
			} else {
				mapValue.put(n, -1);
			}
		}




		Set<Entry<Integer, Integer>> sEntry = mapValue.entrySet();

		for (Entry<Integer, Integer> en : sEntry) {
			if (en.getValue() == 1) {
				return en.getKey();
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SingleNumber singleNumber = new SingleNumber();

	}

}
