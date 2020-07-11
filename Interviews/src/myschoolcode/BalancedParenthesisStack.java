package myschoolcode;

import java.util.Stack;

public class BalancedParenthesisStack {

	Stack<Character> stack = new Stack<Character>();

	public BalancedParenthesisStack() {
		String value = "{}([[[]]][])[](1221)";
		char leftA = '(';
		char leftB = '{';
		char leftC = '[';
		char rightA = ')';
		char rightB = '}';
		char rightC = ']';

		for (char data : value.toCharArray()) {

			if ((data == leftA) || (data == leftB) || (data == leftC)) {
				stack.push(data);
			} else {
				if ((data == rightA) && (stack.peek().toString().charAt(0) == leftA)) {
					stack.pop();
				} else if ((data == rightB) && (stack.peek().toString().charAt(0) == leftB)) {
					stack.pop();
				} else if ((data == rightC) && (stack.peek().toString().charAt(0) == leftC)) {
					stack.pop();
				}
			}

		}

		System.out.println(stack.isEmpty() ? true : false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BalancedParenthesisStack balancedParenthesisStack = new BalancedParenthesisStack();

	}

}
