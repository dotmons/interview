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
		//BalancedParenthesisStack balancedParenthesisStack = new BalancedParenthesisStack();
		String value = "{}([[[]]][])[](1221)";
		System.out.println(isParen(value));

	}

	public static boolean isParen(String data){
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < data.length(); i++) {

			if (!stack.empty() && stack.peek().equals(getOppositeChar(data.charAt(i)))) {
				stack.pop();
			}
			else{
				stack.push(data.charAt(i));
			}
		}
		return stack.isEmpty();
	}

	public static char getOppositeChar(char ch) {
		if (ch == '(') {
			return ')';
		}
		else if (ch == '{'){
			return '}';
		}
		else if (ch == '['){
			return ']';
		}
		else if (ch == ')') {
			return '(';
		}
		else if (ch == '}'){
			return '{';
		}
		else if (ch == ']'){
			return '[';
		}
		return ch;
	}



}
