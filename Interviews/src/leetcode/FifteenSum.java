package leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class FifteenSum {

    public FifteenSum() {
        int test[] = {-1, 0, 1, 2, -1, -4};


        for (int i = 0; i < test.length; i++) {
            ArrayList<Integer> arrayList = Arrays.stream(test).boxed().collect(Collectors.toCollection(ArrayList::new));
            ArrayList<Integer> temp = arrayList;
            temp.remove(i);
            System.out.println(temp + "   target:" + test[i]);
            twoSumWorkingSolution(temp, test[i]);
        }

    }

    public List<List<Integer>> threeSum(int[] nums) {

        return null;
    }

    public void twoSumWorkingSolution(ArrayList<Integer> nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();
        //[-1, 0, 1, -1, -4]   target:2
        //before: sum of possible two, not found
        //

        for (int i = 0; i < nums.size(); i++) {
            int complement = (target*-1) - nums.get(i);
            if (numMap.containsKey(complement))// && (nums.get(numMap.get(complement)) + nums.get(i) + target == 0))
            {

                System.out.println("valA " + target + " valB " + nums.get(numMap.get(complement)) + " valC : " + nums.get(i) + "\n\n");
            }
            numMap.put(nums.get(i), i);
        }

        //return new int[]{}; // No solution found
    }


    public static void main(String[] args) {
        new FifteenSum();
    }


}
