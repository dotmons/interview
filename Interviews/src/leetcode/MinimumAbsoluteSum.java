package leetcode;

import java.util.Arrays;

public class MinimumAbsoluteSum {
    public static void main(String[] args) {
        int[] arr = {3,2,5,11};

        int result = minimumAbsoluteSum(arr.length, arr);
        System.out.println("The minimum absolute sum is: " + result);

    }


    public static int minimumAbsoluteSum(int N, int[] A) {
        // Step 1: Sort the array
        //2,3,5,11
        Arrays.sort(A);

        int minSum = A[A.length-1];

        // Step 2: Check every pair of distinct elements in the array
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int x = A[i];
                int y = A[j];
                int currentSum = calculateSum(A, x, y);
                minSum = Math.min(minSum, currentSum);
            }
        }

        return minSum;
    }

    // Function to calculate the sum of absolute differences for two given values x and y
    private static int calculateSum(int[] A, int x, int y) {
        int sum = 0;
        for (int a : A) {
            sum += Math.min(Math.abs(a - x), Math.abs(a - y));
        }
        return sum;
    }
}