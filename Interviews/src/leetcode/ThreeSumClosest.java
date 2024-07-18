package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).


Constraints:

3 <= nums.length <= 500
-1000 <= nums[i] <= 1000
-104 <= target <= 104
* */
public class ThreeSumClosest {

    public ThreeSumClosest(){
        int[] test = {-1,2,1,-4};
        System.out.println(threeSumClosest(test, 2));
    }

    public int threeSumClosest(int[] nums, int target) {

        //[-1,2,1,-4]


        int sum = 0;
        Arrays.sort(nums);
        int diff = 0;
        boolean isFirst=false;
        for (int i=0; i<nums.length-1; i++){
            int j = i+1;
            int k = nums.length-1;
            while (j<k){
                sum = nums[i] + nums[j] + nums[k];

                if (sum==target){
                    return target;
                }
                else if (sum<target){
                    j++;
                    if (isFirst){
                        int a = sum;
                        int b = diff;

                        int diff1 = Math.abs(a-target);
                        int diff2 = Math.abs(b-target);

                        if (diff1<diff2){
                            diff = a;
                        }
                        else if (diff1>diff2){
                            diff = b;
                        }
                        else{
                            diff = a;
                        }
                    }
                    else{
                        diff = sum;
                    }
                }
                else if (sum>target){
                    k--;
                    //System.out.println("Loading");
                    if (isFirst){

                        int a = sum;
                        int b = diff;

                        int diff1 = Math.abs(a-target);
                        int diff2 = Math.abs(b-target);

                        if (diff1<diff2){
                            diff = a;
                        }
                        else if (diff1>diff2){
                            diff = b;
                        }
                        else{
                            diff = a;
                        }
                    }
                    else{
                        diff = sum;
                    }
                }

                isFirst = true;

            }


        }


        return diff;
    }
    public static void main(String[] args) {
        new ThreeSumClosest();

    }
}
