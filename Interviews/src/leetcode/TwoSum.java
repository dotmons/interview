package leetcode;

import java.util.*;

public class TwoSum {

	public TwoSum() {

		int nums[] = { 2,11,15,7 };
		int target = 9;
		//System.out.println(Arrays.toString(twoBestSum(nums, target)));
		System.out.println(getSumCompliment(nums, target));
		// 2 =
//		System.out.println(Arrays.toString(twoSumHashMap(nums, target)));
//		System.out.println(Arrays.toString(twoSum(nums, target)));
//		System.out.println(Arrays.toString(twoSumSolution(nums, target)));
//		System.out.println(Arrays.toString(twoSumWorkingSolution(nums, target)));
	}

	public boolean getSumCompliment(int [] nums, int target){

		// int i = 0;
		// int j = nums.length - 1;
		Set setValue = new HashSet<Integer>();

		for (int i=0; i<nums.length; i++){

			int diff = target - nums[i];
			if (setValue.contains(nums[i])){
				return true;
			}
			else{
				setValue.add(diff);
			}

		}
		return false;

	}

	public int[] twoBestSum(int[] nums, int target) {
		int i = 0, j = nums.length - 1;
		if (nums.length>1){
			while (i<j){
				int sum = nums[j]+nums[i];
				if (sum<target){
					i++;
				}
				else if (sum>target){
					j--;
				}
				else{
					return new int[]{nums[i],nums[j]};
				}
			}
			return new int[]{nums[i],nums[j]};
		}
		return new int[]{};
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



	public int[] twoSumWorkingSolution(int[] nums, int target) {
		Map<Integer, Integer> numMap = new HashMap<>();
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int complement = target - nums[i];
			if (numMap.containsKey(complement)) {
				return new int[]{numMap.get(complement), i};
			}
			numMap.put(nums[i], i);
		}

		return new int[]{}; // No solution found
	}



	public int[] twoSumSolution(int[] nums, int target) {

		java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
		HashMap<Integer, Integer> hashList = new HashMap<>();

		for (int i=0; i<nums.length; i++){
			//if (nums[i]<=target)
			{
				list.add(nums[i]);
				//System.out.println("ind " + i + " val " + nums[i]);
				hashList.put(i, nums[i]);
			}
		}

		for (int dat=0; dat<list.size(); dat++){
			int temp = target - list.get(dat);
			if (hashList.containsValue(temp)){
				if (Objects.nonNull(getKeyFromValue(hashList, temp))) {
					int temp2 = getKeyFromValue(hashList, temp);
					if (dat!=temp2)
						return new int[]{dat, temp2};
				}
			}
		}

		return new int[]{0,0};
	}


	private static Integer getKeyFromValue(HashMap<Integer, Integer> map, Integer value) {
		// Iterating through the HashMap
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			// Checking if the current entry's value matches the given value
			if (entry.getValue().equals(value)) {
				// Returning the key
				return entry.getKey();
			}
		}

		// Returning null if the value is not found
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TwoSum();
	}

}
