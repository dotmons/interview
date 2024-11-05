package leetcode;

import java.util.*;

public class LetterCombination {

    public List<String> letterCombinations(String digits) {
        //23
        List<String> data = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("");
        for (int i = 0; i < digits.length(); i++) {
            //abc
            ArrayList<String> res = getString(Integer.parseInt(String.valueOf(digits.charAt(i))));
            int queueSize = queue.size();
            for (int j = 0; j < queueSize; j++) {
                String letter = queue.poll();

                for (String result : res) {
                    String value = letter + result;
                    queue.add(value);
                }

            }

        }
        while (!queue.isEmpty()) {
            String phoneString = queue.poll();
            if (!Objects.equals(phoneString, "") && phoneString != null) {
                data.add(phoneString);
            }
        }

        return data;
    }

    ArrayList<String> getString(int n) {
        ArrayList<String> res = new ArrayList<>();
        if (n == 2) {
            res.add("a");
            res.add("b");
            res.add("c");
        } else if (n == 3) {
            res.add("d");
            res.add("e");
            res.add("f");
        } else if (n == 4) {
            res.add("g");
            res.add("h");
            res.add("i");
        } else if (n == 5) {
            res.add("j");
            res.add("k");
            res.add("l");
        } else if (n == 6) {
            res.add("m");
            res.add("n");
            res.add("o");
        } else if (n == 7) {
            res.add("p");
            res.add("q");
            res.add("r");
            res.add("s");
        } else if (n == 8) {
            res.add("t");
            res.add("u");
            res.add("v");
        } else if (n == 9) {
            res.add("w");
            res.add("x");
            res.add("y");
            res.add("z");
        }
        return res;
    }

    public static void main(String[] args) {
        LetterCombination solver = new LetterCombination();

        // Example 1
        String digits1 = "23";
        List<String> result1 = solver.letterCombinations(digits1);
        System.out.println("Combinations for '23': " + result1);

//        // Example 2
//        String digits2 = "";
//        List<String> result2 = solver.letterCombinations(digits2);
//        System.out.println("Combinations for '': " + result2);
//
//        // Example 3
//        String digits3 = "2";
//        List<String> result3 = solver.letterCombinations(digits3);
//        System.out.println("Combinations for '2': " + result3);
    }
}
