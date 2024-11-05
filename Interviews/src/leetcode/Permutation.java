package leetcode;

import java.util.*;

public class Permutation {
    List<List<Integer>> rest = new LinkedList<>();
    public List<List<Integer>> permute(int[] nums) {
        //List<List<Integer>> res = new ArrayList<>();
        //backtrack(nums, 0, res);
        List<Integer> dt = new LinkedList<>();
        for (int num : nums){
            dt.add(num);
        }
        dfs(new LinkedList<>(), dt);
        return rest;
    }

    private void dfs(List<Integer> permutation, List<Integer> dt){
        if (dt.size()==0){
            rest.add(permutation);
            return;
        }

        for (Integer num: dt){
            List<Integer> tempP = new LinkedList<>(permutation);
            List<Integer> tempDt = new LinkedList<>(dt);
            tempP.add(num);
            tempDt.remove(num);
            dfs(tempP, tempDt);
        }
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
        //System.out.println(fib(3));
        System.out.println(fib2(7));
        System.out.println(fib3(7));
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

    static int fib2(int n) {
        if ((n==1) || (n==2)){
            return 1;
        }else if (n==0){
            return 0;
        }
        int init = 1;
        int temp = 0;
        int fibCount = 1;
        int counter = 0;

        while (counter < n-2) {
            temp = fibCount;
            fibCount += init;
            init = temp;
            counter++;
        }
        return fibCount;
    }

    static int fib3(int n) {

        int target = 0;
        if ((n==1) || (n==2)){
            return 1;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        target += fib3(n-1) + fib3(n-2);
        map.put(n, target);

        if (map.containsKey(n)){
            return map.get(n);
        }
        return target;
    }
}
