package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public TwoSum() {

		int nums[] = { 2, 7, 11, 15 };
		// 2 =
		System.out.println(twoSumHashMap(nums, 9)[0]);
		System.out.println(twoSumHashMap(nums, 9)[1]);

	}

	public int[] twoSum(int[] nums, int target) {

		int num[] = new int[2];

		for (int i = 0; i < nums.length; i++) {

			if (Arrays.binarySearch(nums, (target - nums[i])) == 0) {

				num[0] = i;
				num[1] = target - nums[i];
			}
		}

		return num;

	}

	public int[] twoSumHashMap(int[] nums, int target) {

		int num[] = new int[2];

		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			hashMap.put(nums[i], i);
		}
		for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
			int diff = target - entry.getKey();
			if (hashMap.containsKey(diff)){
				num[0] = hashMap.get(diff);
				num[1] = entry.getValue();
			}
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TwoSum();
	}

}
