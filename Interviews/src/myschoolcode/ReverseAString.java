package myschoolcode;

public class ReverseAString {

	char stack[] = new char[5];
	char output[] = new char[5];

	int counter = 0;

	public ReverseAString() {

		stack[0] = 'A';
		stack[1] = 'B';
		stack[2] = 'C';
		stack[3] = 'D';
		stack[4] = 'E';

		reverseStringSwap(stack);
		// reverseAString(stack);
	}

	public void reverseAString(char[] data) {

		for (int i = 0; i < data.length; i++) {
			pushStack(data[i]);
		}

		for (char c : output) {
			System.out.print(c);
		}
	}

	public void pushStack(char item) {
		for (int i = counter; i > 0; i--) {
			output[i] = output[i - 1];
		}
		output[0] = item;
		counter++;
	}

	public void reverseStringSwap(char[] data) {

		int j = data.length - 1;

		for (int i = 0; i < (data.length - 1) / 2; i++) {
			char temp = data[j];

			data[j] = data[i];
			data[i] = temp;
			j--;
		}

		for (char c : data) {
			System.out.print(c);
		}
	}

	public static void main(String[] args) {
		ReverseAString reverseAString = new ReverseAString();
		// TODO Auto-generated method stub

	}

}
