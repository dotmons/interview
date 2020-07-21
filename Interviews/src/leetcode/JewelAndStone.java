package leetcode;

import java.util.HashSet;
import java.util.Set;

public class JewelAndStone {

	public JewelAndStone() {
		// TODO Auto-generated constructor stub
		String jewel = "aA";
		String stone = "aAAbbbb";

		System.out.println(numJewelsInStones(jewel, stone));

	}
//goldcommerce
	public int numJewelsInStones(String J, String S) {
		int n = 0;

		Set<Character> set = new HashSet<Character>();

		for (Character ab : J.toCharArray()) {
			set.add(ab);
		}

		for (Character ab : S.toCharArray()) {
			if (set.contains(ab)) {
				n++;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JewelAndStone();
	}

}
