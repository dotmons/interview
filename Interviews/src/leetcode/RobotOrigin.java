package leetcode;

public class RobotOrigin {

	long x;
	long y;

	public RobotOrigin() {
		System.out.println(judgeCircle("UD"));
		System.out.println(judgeCircle("LL"));

	}

	public boolean judgeCircle(String moves) {
		for (char c : moves.toCharArray()) {
			if (c == 'U') {
				y++;
			} else if (c == 'D') {
				y--;
			} else if (c == 'L') {
				x--;
			} else if (c == 'R') {
				x++;
			}
		}
		return (x == 0 && y == 0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RobotOrigin RobotOrigin = new RobotOrigin();
	}

}
