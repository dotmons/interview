package sample;

import java.util.HashMap;
import java.util.Map;

public class IsPermutation {

    public IsPermutation() {
        System.out.println(isPermutation("hello", "lloeh")); // should be true
        System.out.println(isPermutation("hello", "bye")); // should be false
        System.out.println(isPermutation("", "")); // should be true
        System.out.println(isPermutation("", "sscs")); // should be false
        System.out.println(isPermutation("hello", "hello")); // should be true
        System.out.println(isPermutation("helloo", "llloeh")); // should be false
    }

    boolean isPermutations(String s1, String s2) {

        if (s1.length() != s2.length()) {
            return false;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : s2.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }
            else{
                map.put(c, 1);
            }
        }

        for (Character c : s1.toCharArray()) {
            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    map.put(c, map.get(c)-1);
                }
            }
            else{
                return false;
            }
        }

       for (Map.Entry<Character, Integer> a :  map.entrySet()){
           if (a.getValue() == 0) {
               return false;
           }
       }
//        for (Character c : map.keySet()) {
//            if (map.get(c) > 0) {
//                return false;
//            }
//        }

        return true;
    }

    public static boolean isPermutation(String first, String second) {

        if (first.length() != second.length())
            return false;

        Map<Character, Integer> firstMap = getCharacterApperanceCount(first);
        Map<Character, Integer> secondMap = getCharacterApperanceCount(second);

        return firstMap.equals(secondMap);
    }

    private static Map<Character, Integer> getCharacterApperanceCount(String str) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            map.merge(str.charAt(i), 1, (oldV, newV) -> ++oldV);
        }

        return map;
    }

    public static void main(String[] args) {
        //new IsPermutation();
        for (int i=1; i<=30; i++){
            System.out.println(i + " " + isPrime(i));
        }
    }

    //1,3,5,7,11
    static boolean isPrime(int n) {
        for (int i = n-1; i>=2; i--) {
            if (n%i==0){
                return false;
            }
        }
        return true;
    }
}
