package leetcode;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        // Negative numbers and numbers ending with 0 (but not 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        // Reverse the number
        while (x > 0) {
            int lastDigit = x % 10;
            reversed = reversed * 10 + lastDigit;
            x /= 10;
        }

        // Check if the reversed number equals the original number
        return original == reversed;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1234)); // Output: true
        //System.out.println(isPalindrome(-121)); // Output: false
        //System.out.println(isPalindrome(10)); // Output: false
    }
}
