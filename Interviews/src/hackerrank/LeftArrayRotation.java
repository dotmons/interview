package hackerrank;

public class LeftArrayRotation {

	public LeftArrayRotation() {
		// TODO Auto-generated constructor stub
		int a[] = { 1, 2, 3, 4, 5 };

		for (int value : rotLeft(a,4)) {
			System.out.println(value);
		}

	}

	int[] rotLeft(int[] a, int d) {
		int totalSize = a.length;
		int counter = 0;

		int[] c = new int[totalSize];		

		for (int i = d; i < totalSize; i++) {
			c[counter++] = a[i];
		}

		for (int i = 0; i < d ; i++) {
			c[counter++] = a[i];
		}

		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LeftArrayRotation();
	}

}
