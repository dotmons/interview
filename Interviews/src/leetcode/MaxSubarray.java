package leetcode;

import java.util.ArrayList;

public class MaxSubarray {

    /*
    Given an integer array nums, find the
subarray
 with the largest sum, and return its sum.



Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.


Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104

    *
    */
    public MaxSubarray(){
        int[] nums = {-1,2,3,4,6,-5};
        System.out.println(maxSubArray(nums));
    }


    public int maxSubArray(int[] nums) {
        int currentSumValue = nums[0];
        int maxValue = nums[0];
        for (int i=1; i<nums.length; i++){
            currentSumValue = Math.max((currentSumValue + nums[i]), nums[i]);
            maxValue = Math.max(currentSumValue, maxValue);
        }
        return maxValue;

    }

    public static void main(String[] args) {
        new MaxSubarray();
    }
}
