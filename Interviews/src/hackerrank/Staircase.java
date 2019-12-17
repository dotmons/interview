package hackerrank;

public class Staircase {

	public Staircase() {
		staircase(6);
	}

	static void staircase(int n) {

		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n; j++) {
				if (j >= i) {
					System.out.print("#");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		new Staircase();
	}
}
