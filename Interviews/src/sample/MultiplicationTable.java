package sample;

import java.util.HashMap;
import java.util.Map;

public class MultiplicationTable {

    public MultiplicationTable() {

        //Non repeated String in a character
        //String data = "ADEOYEDAO";
        //System.out.println(getFirstNonRepeatingChar(data));

//        System.out.println(isPalindrome("madam"));    // true
//        System.out.println(isPalindrome("racecar"));  // true
//        System.out.println(isPalindrome("hello"));    // false
//        System.out.println(isPalindrome(""));         // true
//        System.out.println(isPalindrome("a"));        // true

       // System.out.println(">>>"+"aba".substring(0,getLastSubstring("aba")));
       // System.out.println("abcabcabcabc".substring(0,3));
       // System.out.println("abcabcabcabc".substring(3,6));

        System.out.println(repeatedSubstringPattern("abcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {

        int len = s.length();
        String stringDoubled = s+s;
        System.out.println("stringDoubled " + stringDoubled);
        String stringFormatted = stringDoubled.substring(1, stringDoubled.length() - 1);
        System.out.println("stringFormatted " + stringFormatted);
        return stringFormatted.contains(s);
    }

    //bcabcabcab
    //bcabcabcab


    public int getLastSubstring(String s)
    {
        //aabaab
        int i=0; int j=1;
        boolean isChanged = false;
        while (j<s.length()){
            if (s.charAt(i)!=s.charAt(j)){
                j++;
                isChanged = true;
            }
            else if (s.charAt(i)==s.charAt(j) && isChanged){
                return j;
            }
            else {
                j++;
            }

        }
        return 0;
    }

    public boolean isPalindrome(String a) {
        return a.contentEquals(new StringBuilder(a).reverse());
    }
    public char getFirstNonRepeatingChar(String str) {

        Map<String, Integer> hashMap = new HashMap<>();

        for (String dataRow : str.split("")) {
            if (!hashMap.containsKey(dataRow)) {
                hashMap.put(dataRow, 1);
            } else {
                hashMap.put(dataRow, hashMap.get(dataRow) + 1);
            }
        }

        for (String dataRow : str.split("")) {
            if (hashMap.get(dataRow) == 1) {
                return dataRow.charAt(0);
            }
        }
        return '1';
    }


    public static void main(String[] args) {
        new MultiplicationTable();
    }
}

class Stack {
    int arr[] = new int[100];
    int top = 0;

    // 1 2 3 4
    //
    public Stack() {
    }
    public void push(int x) {
        arr[top++] = x;
    }
    public int pop() {
        return arr[--top];
    }
    public int peek() {
        return arr[top];
    }
}

class Queues{
    int arr[] = new int[100];
    int top = 0;
    public Queues(){

    }
    public void push(int x) {
        arr[top++] = x;
    }
    public int pop() {
        int last = arr[0];
        for (int i = 0; i < top; i++) {
            arr[i] = arr[i + 1];
        }
        return last;
    }
    public int peek() {
        return arr[top];
    }



}


