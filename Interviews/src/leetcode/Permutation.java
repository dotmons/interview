package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, res);
        return res;
    }

    private void backtrack(int[] nums, int start, List<List<Integer>> res) {
        if (start == nums.length) {
            res.add(arrayToList(nums));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, res);
            swap(nums, start, i);
        }
    }

    private List<Integer> arrayToList(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            list.add(num);
        }
        return list;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        //System.out.println(new Permutation().permute(new int[]{1, 2, 3}));
        System.out.println(fib(6));
    }

   static int binSearch(int start, int search, int[] arr){

        int size = (arr.length/2)-1;
        if (size==1){
            return search;
        }
        if (search>arr[size]){
            int[] arrval = Arrays.copyOf(arr, size);
            return binSearch(start, search, arrval);
        }
        else{
            int[] arrval = Arrays.copyOfRange(arr, 0,size);
            return binSearch(start, search, arrval);
        }
        //return 1;
   }

    static int fib(int n) {
        if (n==1)
            return 1;
        if (n==0)
            return 0;

        return fib(n-1) + fib(n-2);
    }
}
