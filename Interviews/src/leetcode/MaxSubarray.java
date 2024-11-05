package leetcode;

import javafx.util.Pair;

import java.util.*;

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
    public MaxSubarray() {
        int[] nums = {-1, 2, 3, 4, 6, -5};
        // System.out.println(maxSubArray(nums));
        System.out.println(binarySearch(nums, -1));
    }


    public int maxSubArray(int[] nums) {
        int currentSumValue = nums[0];
        int maxValue = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentSumValue = Math.max((currentSumValue + nums[i]), nums[i]);
            maxValue = Math.max(currentSumValue, maxValue);
        }
        return maxValue;
    }



    public int binarySearch(int[] nums, int target) {

        int firstPoint = 0;
        int lastPoint = nums.length - 1;
        int middlePoint;
        boolean isEndlessLoop = true;

        while ((firstPoint <= lastPoint) && isEndlessLoop) {
            middlePoint = ((lastPoint + firstPoint) / 2);
            if (target == nums[middlePoint]) {
                return middlePoint;
            } else if (target < nums[middlePoint]) {
                int temp = lastPoint;
                lastPoint = middlePoint;
                isEndlessLoop = checkDifference(temp, lastPoint) > 0;
            } else {
                int temp = firstPoint;
                firstPoint = middlePoint;
                isEndlessLoop = checkDifference(temp, firstPoint) > 0;
            }

        }
        return -1;
    }

    private int checkDifference(int firstPoint, int lastPoint) {
        return Math.abs(firstPoint - lastPoint);
    }


    private String reverseString(String data) {
        return new StringBuilder(data).reverse().toString();
    }
    private String reverseWord(String data){
        Stack<String> stack = new Stack<>();
        for (String content :  data.split(" ")){
            stack.push(content);
        }
        StringBuilder result = new StringBuilder();
       while (!stack.isEmpty()){
           result.append(stack.pop());
           result.append(" ");
       }
       // return String.join(" ", stack);
       return result.toString().trim();
    }

    public static String reverseWorkNonAlphanumbericValue(String data){
        StringBuilder queueStringer = new StringBuilder();
        Map<Integer, Character> mapLocation = new HashMap<>();
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        //97-122
        //48-57


        int counter = 0;
        for (char c : data.toCharArray()){
        //Im great, thanks!
            if (Character.isLetterOrDigit(c)) {
                queueStringer.append(c);
            }
            else{
                if (!queueStringer.isEmpty()) {
                    stack.push(queueStringer.toString());
                    counter++;
                    //queue.offer(String.valueOf(c));
                    if (c == ' ') {
                        stack.push(" ");
                        counter++;
                    }
                    else{
                        mapLocation.put(counter, c);
                    }
                    queueStringer = new StringBuilder();
                }else if (c == ' ') {
                    stack.push(" ");
                    counter++;
                }
            }
        }
        // This is, a good boy!
        // boy! good a is, This
        int counterSize = stack.size();
        while (!stack.isEmpty()){
            result.append(stack.pop());
            if (mapLocation.containsKey(counterSize)) {
                result.append(mapLocation.get(counterSize));
            }
            counterSize--;
        }
        return result.toString().trim();
    }

    public static String reverseWords(String s) {
        // List to store all alphanumeric words (considering ' as alphanumeric)
        List<String> words = new ArrayList<>();

        // StringBuilder to collect current word (including ')
        StringBuilder currentWord = new StringBuilder();
        //I'm great, thanks!
        // First pass: Extract words and store non-alphanumeric positions
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '\'') {
                // Collecting a word
                currentWord.append(c);
            } else {
                if (!currentWord.isEmpty()) {
                    // When a word ends, add it to the words list
                    words.add(currentWord.toString());
                    currentWord.setLength(0); // Reset for next word
                }
            }
        }

        // Add the last word if present
        if (!currentWord.isEmpty()) {
            words.add(currentWord.toString());
        }

        // Second pass: Build the result by placing words in reverse and keeping non-alphanumeric characters
        StringBuilder result = new StringBuilder();
        int wordIndex = words.size() - 1; // Start from the last word

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isLetterOrDigit(c) || c == '\'') {
                // Replace with reversed words
                if (wordIndex >= 0) {
                    result.append(words.get(wordIndex));
                    wordIndex--;
                }
                // Move i to the end of the word
                while (i < s.length() && (Character.isLetterOrDigit(s.charAt(i)) || s.charAt(i) == '\'')) {
                    i++;
                }
                i--; // Adjust i because the loop will increment it again
            } else {
                // Keep non-alphanumeric characters in place
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void getMultipleValue(){
        // [-6, 1, 2, 3, 4]
        int[] input =  {1, 2, -6, 3, 4};
        int[] result =  new int[input.length];
        int maxA = input[0]*input[0];
        for (int i=1; i<input.length; i++){

            int maxB = input[i]*input[i];
            int min = Math.min(maxA, maxB);
            maxA = Math.max(maxA, maxB);
            result[i-1] = min;
        }
        result[input.length-1] = maxA;

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        getMultipleValue();
        //System.out.println(reverseWorkNonAlphanumbericValue("Im great, thanks!"));
        //System.out.println(reverseWords("Im great, thanks!"));
        //getSortedLoginDetails();
    }
/*8gsuhbv
Part 1: Reverse a string
abc -> cba
Part 2: Reverse the words in a string
practice makes perfect -> perfect makes practice
Part 3: Reverse words in a string, but keep non-alphanumeric character placement.
Asked about ' and was told we can count that with alphanumeric
I'm great, thanks! -> Thanks I'm, great!

This is Dotun. He is a great man

He is a great man. This is Dotun


Input: "Th!s is a t#st"
Output: "ts!t a si T#hs"


life insurance / 50% coverage
disability insurance / 50% -
   - 60 days period

*/


}
