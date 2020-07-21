package amz;

public class ClimbStairs {

	public ClimbStairs() {

		// TODO Auto-generated constructor stub
		// System.out.println(climbStrairs(10));
		// System.out.println(fibo(10));
		/*
		 * You are climbing a stair case. It takes n steps to reach to the top.
		 * 
		 * Each time you can either climb 1 or 2 steps. In how many distinct
		 * ways can you climb to the top?
		 * 
		 * Example 1:
		 * 
		 * Input: 2 Output: 2 Explanation: There are two ways to climb to the
		 * top. 1. 1 step + 1 step 2. 2 steps Example 2:
		 * 
		 * Input: 3 Output: 3 Explanation: There are three ways to climb to the
		 * top. 1. 1 step + 1 step + 1 step 2. 1 step + 2 steps 3. 2 steps + 1
		 * step
		 */
	}

	public int climbStrairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
	}

	public int fibo(int n) {
		if ((n == 0) || (n == 1)) {
			return 1;
		} else {
			return (fibo(n - 1) + fibo(n - 2));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClimbStairs climbStairs = new ClimbStairs();
	}

}
