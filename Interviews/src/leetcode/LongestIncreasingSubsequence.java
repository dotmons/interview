package leetcode;

public class LongestIncreasingSubsequence {

    public LongestIncreasingSubsequence() {
        int[] arr = {0,1,0,3,2,3};
        int [] arr2 = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(arr));
        //System.out.println(lengthOfLIS(arr2));
    }
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int[] dp = new int[n];  // dp[i] will hold the length of the LIS ending at index i
        int maxLength = 1;  // To store the final result

        // Initialize all dp values as 1 because the minimum subsequence length is 1
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
        }
//0,1,0,3,2,3
        // Fill the dp array using the logic described
        for (int i = 1; i < n; i++) {
            System.out.println("i: " + i);

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    System.out.println("dp[i] " + dp[i] + " i: " + i + " dp[j] " + dp[j] + " j: " + j);
                    System.out.println();
                    dp[i] = Math.max(dp[i], dp[j] + 1);

                }
            }

            maxLength = Math.max(maxLength, dp[i]);  // Update maxLength with the maximum dp value
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
    }
}
