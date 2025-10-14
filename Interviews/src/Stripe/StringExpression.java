package Stripe;

import java.util.*;
import java.util.stream.Collectors;

/*

You are given a string expression which consists of several comma separated tokens
enclosed within opening ('{') and closing ('}') curly braces.
The string expression might or might not have a prefix before opening curly brace('{') and
a suffix after closing curly brace ('}').
You have to return a list of strings as output for each comma separated item as shown below in the examples.

Example 1:
Input = "/2022/{jan,feb,march}/report"
Output = "/2022/jan/report"
		 "/2022/feb/report"
		 "/2022/march/report"

Example 2:
Input = "over{crowd,eager,bold,fond}ness"
Output = "overcrowdness"
		 "overeagerness"
		 "overboldness"
		 "overfondness"

Example 3:
Input = "read.txt{,.bak}"
Output = "read.txt"
		 "read.txt.bak"


		 If there are less than 2 tokens enclosed within curly braces or incorrect expression
(eg. opening and closing braces not present, only opening brace present,
closing brace present before opening brace etc) return the output same as input

Example 1:
Input: sun{mars}rotation
Output: sun{mars}rotation

Example 2:
Input: minimum{}change
Output: minimum{}change

Example 3 (Incorrect Input):
Input: hello-world
Output: hello-world

Example 4 (Incorrect Input):
Input: hello-{-world
Output: hello-{-world

Example 5 (Incorrect Input):
Input: hello-}-weird-{-world
Output: hello-}-weird-{-world
 */
public class StringExpression {

    public StringExpression(String expression) {

        System.out.println("result: " + getExpression(expression));

    }

    public List<String> getExpression(String expression) {

        // check string only contains one { and }
        List<String> result;
        if (expression.contains("{") && expression.contains("}")) {
            if (expression.indexOf("}") > expression.indexOf("{")) {
                String firstInput = expression.substring(0, expression.indexOf("{"));
                String secondInput = expression.substring(expression.indexOf("}") + 1);

                List<String> inputValue = Arrays.asList(expression.substring(expression.indexOf("{") + 1, expression.indexOf("}"))
                        .split(","));


                if (inputValue.size() < 2) {
                    // No much content to split. Return original
                    return List.of(expression);
                }

                result = inputValue.stream().map(data -> firstInput + data + secondInput).collect(Collectors.toList());

            } else {
                // error with parenthesis
                return List.of(expression);
            }
        } else {
            // error with parenthesis
            return List.of(expression);
        }

        return result;
    }

    public static void main(String[] args) {
        StringExpression s = new StringExpression("/2022/{jan,feb,march}/report");
        StringExpression s1 = new StringExpression("over{crowd,eager,bold,fond}ness");
        StringExpression s2 = new StringExpression("read.txt{,.bak}");
        StringExpression s4 = new StringExpression("sun{mars}rotation");
        StringExpression s5 = new StringExpression("minimum{}change");
        StringExpression s6 = new StringExpression("hello-world");
        StringExpression s7 = new StringExpression("hello-{-world");
        StringExpression s8 = new StringExpression("hello-}-weird-{-world");

    }
}
