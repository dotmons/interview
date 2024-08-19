package leetcode;

import static java.lang.Math.abs;

/*
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.



Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.


Constraints:

-231 <= dividend, divisor <= 231 - 1
divisor != 0
 */



public class DivideTwoInteger {

    public DivideTwoInteger(){
        //System.out.println(divide(-2147483648, -1));
        //System.out.println(divide(8,4));
        bitwise();
    }


    void bitwise(){
        int d = 3;

        int mul = d*2^1;
        int mul2 = d<<(2+1);

        System.out.println("mul: " + mul);
        System.out.println("mul2: " + mul2);
    }
    int divideUpdate(int dividend, int divisor) {
        // Handle the case where dividend is equal to divisor
        if (dividend == divisor) return 1;

        int ans = 0;
        int sign = 1;

        // Determine the sign of the result
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0))
            sign = -1;

        // Convert both dividend and divisor to positive integers
        int n = abs(dividend), d = abs(divisor);

        // Perform the division
        while (n >= d) {
            int count = 0;
            while (n > (d << (count + 1)))
                count++;
            n -= d << count;
            ans += 1 << count;
        }

        // Handle overflow case
        if (ans == (1 << 31) && sign == 1) return Integer.MAX_VALUE;

        return sign * ans;
    }

    public int divide(int dividend, int divisor) {

        boolean isNegative = false;
        if ((divisor<0) && (dividend>0)){
            isNegative = true;
        }
        else if ((divisor>0) && (dividend<0)){
            isNegative = true;
        }
        if (divisor<0){
            divisor = convertToPositive(divisor);
        }
        if (dividend<0){
            dividend = convertToPositive(dividend);
        }

        if (convertToPositive(divisor)==1){
            if (isNegative){
                return -dividend;
            }
            return convertToPositive(dividend);
        }

        int counter=divisor;
        int remainder = 0;


        while (counter<=dividend){
            counter+= divisor;
            remainder++;
        };

        if (isNegative){
            return -1*remainder;
        }
        return remainder;
    }

    public int convertToPositive(int number) {
        if (number == Integer.MIN_VALUE) {
            System.out.println((long) Integer.MAX_VALUE );
            return Integer.MAX_VALUE ;
        } else {
            return abs(number);
        }
    }

    public static void main(String[] args) {
        new DivideTwoInteger();
    }
}
