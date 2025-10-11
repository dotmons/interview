package random;

import java.util.HashMap;
import java.util.Map;

public class SampleHashmap {

public SampleHashmap() {

    java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
    list.add(2);
    list.add(10);
    list.add(6);
    list.add(10);

//    hashmap {2 : 1}
//    hashmap {10 : 2}
//    hashmap {6 : 1}


    Map<Integer, Integer> sumCounts = new java.util.HashMap<>();

    for (int i : list){
        if (sumCounts.containsKey(i)){
            sumCounts.put(i, sumCounts.get(i) + 1);
        }
        else {
            sumCounts.put(i, 1);
        }
    }

    int max = -1;

    //    hashmap {2 : 1}
//    hashmap {10 : 2}
//    hashmap {6 : 1}

    for (Map.Entry<Integer,Integer> vl : sumCounts.entrySet()){
        if (vl.getValue() > max){
            max = vl.getValue();
        }
        //System.out.println("Key: " + vl.getKey() + " Value: " + vl.getValue());
    }

    //System.out.println("Max = " + max);

    int[] values = {2, 4, 1, 3, 2};
    System.out.println(maxSubarraysWithSameSum(values));


//    for (int start = 0; start < values.length; start++) {
//        int sum = 0;
//        for (int end = start; end < values.length; end++) {
//            sum += values[end];
//            sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);
//        }
//    }

}




    public int maxSubarraysWithSameSum(int[] values) {
        // Calculate all possible sums of subarrays and count their frequencies
        Map<Integer, Integer> sumCounts = new HashMap<>();

        for (int start = 0; start < values.length; start++) {
            int sum = 0;

            for (int end = start; end < values.length; end++) {
                sum += values[end];

                //sumCounts.put(sum, sumCounts.getOrDefault(sum, 0) + 1);

                if (sumCounts.containsKey(sum)){
                    sumCounts.put(sum, sumCounts.get(sum) + 1);
                }
                else {
                    sumCounts.put(sum, 1);
                }

            }
        }

        // Find the sum with the highest frequency
        int maxCount = 0;
        for (int count : sumCounts.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

public static void main(String[] args) {
    SampleHashmap sampleHashmap = new SampleHashmap();
}

}
