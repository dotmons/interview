package myschoolcode;

public class BalancedParenthesis {

	private class Stack {
		
		int count = 0;
		String[] dataStack = new String[100];

		public void push(String data) {
			dataStack[count++] = data;
		}

		public void pop() {
			dataStack[--count] = "";
		}

		public String peek() {
			return dataStack[count - 1];
		}

	}

	String leftA = "(";
	String leftB = "{";
	String leftC = "[";

	String rightA = ")";
	String rightB = "}";
	String rightC = "]";

	String test = "{(a+b)}";

	public BalancedParenthesis() {

		System.out.println(checkForBalancedParenthesis(test));

	}

	public boolean checkForBalancedParenthesis(String data) {

		Stack stack = new Stack();

		for (int i = 0; i < data.length(); i++) {
			
			if (data.substring(i, i + 1).contains(leftA) || (data.substring(i, i + 1).contains(leftB))
					|| (data.substring(i, i + 1).contains(leftC))) {
				stack.push(data.substring(i, i + 1));

			} else if (data.substring(i, i + 1).contains(rightA)) {
				if (!stack.peek().equals(leftA)) {
					return false;
				}
				stack.pop();
			} else if (data.substring(i, i + 1).contains(rightB)) {
				if (!stack.peek().equals(leftB)) {
					return false;
				}
				stack.pop();
			} else if (data.substring(i, i + 1).contains(rightC)) {
				if (!stack.peek().equals(leftC)) {
					return false;
				}
				stack.pop();
			}
		}
		return true;
	}

	/*
	public boolean checkForBalancedParenthesis(String data) {

		Stack stack = new Stack();
		
		for (char valueChar : data.toCharArray()) {
			System.out.println(valueChar);
			if ((valueChar == leftA) || (valueChar== leftB)	|| (valueChar==leftC)) {
				stack.push(String.valueOf(valueChar));

			} else if (valueChar==rightA) {
				if (!stack.peek().equals(leftA)) {
					return false;
				}
				stack.pop();
			} else if (valueChar==rightB) {
				if (!stack.peek().equals(leftB)) {
					return false;
				}
				stack.pop();
			} else if (valueChar==rightC) {
				if (!stack.peek().equals(leftC)) {
					return false;
				}
				stack.pop();
			}
		}
		return true;
	}
	  */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedParenthesis balancedParenthesis = new BalancedParenthesis();

	}

}
