package random;

public class JosephusProblem {
    public static int josephusIterative(int n, int k) {
        int result = 0; // Base case for 1 person
        for (int i = 2; i <= n; i++) {
            result = (result + k) % i;
            System.out.println("result: " + result);
        }
        return result+1;
    }

    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int survivor = josephusIteratives(n, k) ; // Convert to 1-indexed result
        System.out.println("The last person standing is at position: " + survivor);
    }

    public static int josephusIteratives(int n, int k) {
        int result = 0;

        for (int i=2; i<=n; i++) {
            result = (result + k) % i;
        }
        return result+1;

    }
}