package myschoolcode;

public class TwoDSpriral {

	public TwoDSpriral() {
		int A[][] = new int[4][4];
		A[0][0] = 2;
		A[0][1] = 4;
		A[0][2] = 6;
		A[0][3] = 8;

		A[1][0] = 5;
		A[1][1] = 9;
		A[1][2] = 12;
		A[1][3] = 16;

		A[2][0] = 2;
		A[2][1] = 11;
		A[2][2] = 5;
		A[2][3] = 9;

		A[3][0] = 3;
		A[3][1] = 2;
		A[3][2] = 1;
		A[3][3] = 8;

		A[0][0] = 1;
		A[0][1] = 2;
		A[0][2] = 3;
		A[0][3] = 4;

		A[1][0] = 5;
		A[1][1] = 6;
		A[1][2] = 7;
		A[1][3] = 8;

		A[2][0] = 9;
		A[2][1] = 10;
		A[2][2] = 11;
		A[2][3] = 12;

		A[3][0] = 13;
		A[3][1] = 14;
		A[3][2] = 15;
		A[3][3] = 16;

		printArrayInsSpriral(A);
	}

	public void printArrayInsSpriral(int A[][]) {

		int top = 0;
		int bottom = A[0].length - 1;
		int left = 0;
		int right = A.length - 1;
		int dir = 0;

		while (top <= bottom && left <= right) {
			if (dir == 0) {
				for (int i = left; i <= right; i++) {
					System.out.println("A: " + A[top][i]);
				}
				dir = 1;
				top++;
			} else if (dir == 1) {
				for (int i = top; i <= bottom; i++) {
					System.out.println("B: " + A[i][right]);
				}
				dir = 2;
				right--;
			} else if (dir == 2) {
				for (int i = right; i >= left; i--) {
					System.out.println("C: " + A[bottom][i]);
				}
				bottom--;
				dir = 3;
			} else if (dir == 3) {
				for (int i = bottom; i >= top; i--) {
					System.out.println("D: " + A[i][left]);
				}
				left++;
				dir = 0;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoDSpriral twoDSpriral = new TwoDSpriral();

	}

}
