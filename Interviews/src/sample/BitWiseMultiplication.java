package sample;

public class BitWiseMultiplication {
    public static int multiply(int x, int y) {
        // Initialize result
        int result = 0;

        // Iterate through all bits of y
        while (y != 0) {
            // If the last bit of y is set, add x to the result

            if ((y & 1) != 0) {
                result = add(result, x);
            }

            // Shift x to the left by 1 bit (equivalent to multiplying by 2)
            x <<= 1;

            // Shift y to the right by 1 bit (equivalent to dividing by 2)
            y >>>= 1;
        }

        return result;
    }

    // Function to add two numbers using bitwise operators
    private static int add(int a, int b) {
        while (b != 0) {
            // Carry now contains common set bits of a and b
            int carry = a & b;

            // Sum of bits of a and b where at least one of the bits is not set
            a = a ^ b;

            // Carry is shifted by one so that adding it to a gives the required sum
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 3;
        System.out.println("Multiplication of " + x + " and " + y + " using bitwise operators is: " + multiply(x, y));
    }
}