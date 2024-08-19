package leetcode;

import java.util.*;

public class ArrayDoublePair {

    public ArrayDoublePair() {
        int[] arr = {4, -2, 2, -4};
        int[] arr1 = {2,1,2,6};
        int[] arr2 = {2,1,2,1,1,1,2,2};
        //1,1,1,1,2,2,2,2
        System.out.println(canReorderDoubledTwo(arr2));
        System.out.println(canReorderDoubled(arr1));
        System.out.println(canReorderDoubled(arr2));
    }
    public boolean canReorderDoubledTwo(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(-1*arr[i])) {
                map.remove(arr[i]);
                map.remove(-1*arr[i]);
            }
            else{
                map.put(arr[i], i);
            }

        }
        System.out.println(map.size());
        return map.isEmpty();
    }
    public boolean canReorderDoubled(int[] arr) {
        {
            int[] arrResult = new int[arr.length];

            ArrayList<Integer> listAsc = new ArrayList<Integer>();
            ArrayList<Integer> listDesc = new ArrayList<Integer>();

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    listDesc.add(arr[i]);
                } else {
                    listAsc.add(arr[i]);
                }
            }
            Collections.sort(listAsc);
            Collections.sort(listDesc, Collections.reverseOrder());

            for (int i = 0; i < listDesc.size(); i++) {
                arrResult[i] = listDesc.get(i);
            }
            for (int i = 0; i < listAsc.size(); i++) {
                arrResult[i] = listAsc.get(i);
            }

            for (int i = 0; i < arrResult.length / 2; i++) {
                if ((arrResult[2 * i + 1]) != (2 * arrResult[2 * i])) {
                    return false;
                }

            }
        }
        return true;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new ArrayDoublePair();
    }

}
