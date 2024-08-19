package leetcode;

public class LongestTurbulentSubarray {

    public LongestTurbulentSubarray() {
        //int[] arr = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0};
        //int[] arr = {9,4,2,10,7,8,8,1,9};
        int[] arr = {1,1,2};
        System.out.println(maxTurbulenceSize(arr));
    }

    public int maxTurbulenceSize(int[] arr) {

        if (arr.length < 2)
            return 1;
        else if ((arr.length == 2) && (arr[0] == arr[1])) {
            return 1;
        }

        boolean sign = (arr[0] - arr[1]) < 0;
        if (arr[0]== arr[1]) {
            sign = true;
        }
        //[9,4,2,10]
        int res = 0;
        int counter = 1;
        int maxVal = 0;
        for (int i = 0; i < arr.length - 1; i++) {

            res = getSignedValue(arr[i], arr[i + 1], sign);
            if (res == 1) {
                counter++;
                maxVal = Math.max(maxVal, counter);
                sign = !sign;
            } else if (res == 0){
                counter = 1;
                maxVal = Math.max(maxVal, counter);
            } else {
                counter = 2;
            }

        }
        return maxVal;
    }

    public int getSignedValue(int a, int b, boolean sign) {

        if ((sign && (b > a)) || (!sign && (a > b))) {
            return 1;
        }
        else if (a==b){
            return 0;
        }
        return -1;

    }

    public static void main(String[] args) {
        LongestTurbulentSubarray longestTurbulentSubarray = new LongestTurbulentSubarray();
    }
}
