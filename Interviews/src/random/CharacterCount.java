package random;

import java.util.Stack;

public class CharacterCount {

    public CharacterCount() {
        String input =  "2[a]3[bc]";
        int length = input.length();
        int counter = 0;
        StringBuilder builder = new StringBuilder();
        for (String da : input.split("]")) {
            builder.append(getCharacter(da));
        }
        System.out.println(builder);

        System.out.println(decodeString(input));

    }
    public String getCharacter(String input) {
        try{
            int count = Integer.parseInt(input.substring(0,input.indexOf("[")));
            String value = input.substring(input.indexOf("[")+1);
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < count; i++) {
                builder.append(value);
            }
            return builder.toString();
        }
        catch (Exception e){
            System.out.println("Exception: " + e);
        }
        return "";
    }

    public static String decodeString(String input) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> resultStack = new Stack<>();
        StringBuilder currentString = new StringBuilder();
        int count = 0;

        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                count = count * 10 + (ch - '0'); // To handle multi-digit numbers
            } else if (ch == '[') {
                countStack.push(count); // Store the current count
                resultStack.push(currentString); // Store the current result so far
                count = 0;
                currentString = new StringBuilder();
            } else if (ch == ']') {
                int repeatCount = countStack.pop(); // Get the last count
                StringBuilder previousString = resultStack.pop(); // Get the previous string
                // Append repeated current string
                previousString.append(currentString.toString().repeat(repeatCount));
                currentString = previousString;
            } else {
                currentString.append(ch); // Append characters inside the brackets
            }
        }

        return currentString.toString();
    }

    public static void main(String[] args) {
        CharacterCount c = new CharacterCount();
    }
}
