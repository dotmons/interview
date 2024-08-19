package leetcode;

import java.util.Arrays;


/*
Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.



Example 1:

Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2:

Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation:
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]


*/
public class RotateArray {

    public RotateArray(){
        int[] nums = {1,2};
        rotate(nums,3);
    }
    public void rotate(int[] nums, int k) {

        if (k>nums.length)
            k = k % nums.length;

        int[] res = new int[nums.length];
        int count = 0;

        for (int i=nums.length-k; i<nums.length; i++){
            res[count++] = nums[i];
        }
        for (int i=0; i<nums.length-k; i++){
            res[count++] = nums[i];
        }
        count = 0;
        for (int re : res) {
            nums[count++] = re;
        }
    }
    public static void main(String[] args) {
        new RotateArray();
    }
}
