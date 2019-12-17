/**
 * 
 */
package hackerrank;

/**
 * @author OAdeoye
 *
 */
public class MiniMax {

	/**
	 * 
	 */
	public MiniMax() {
		// TODO Auto-generated constructor stub
		miniMaxSum(new int[] { 5, 5, 5, 5, 5 });
		 //miniMaxSum(new int[] {256741038, 623958417, 467905213, 714532089, 938071625});
	}

	static void miniMaxSum(int[] arr) {

		int min = arr[0];
		int max = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		java.math.BigInteger minCount = new java.math.BigInteger("0");
		java.math.BigInteger maxCount = new java.math.BigInteger("0");

		System.out.println("min: " + min + " max : " + max);

		boolean isMin = false;
		boolean isMax = false;

		for (int i = 0; i < arr.length; i++) {

			
			if (arr[i] != max || isMax) {
				minCount = minCount.add(java.math.BigInteger.valueOf(arr[i]));
			}
			else
			{
				isMax = true;
			}

			if (arr[i] != min || isMin) {
				maxCount = maxCount.add(new java.math.BigInteger(String.valueOf(arr[i])));
			}
			else
			{
				isMin = true;
			}
		}

		System.out.println(minCount + " " + maxCount);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiniMax mm = new MiniMax();
	}

}
