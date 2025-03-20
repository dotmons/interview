package random;

import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int removedElement = stack.pop();
            if (minStack.peek().equals(removedElement)) {
                minStack.pop();
            }
        }
    }

    public int top() {
        return stack.isEmpty() ? -1 : stack.peek();
    }

    public int get_min() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(30);
        minStack.push(35);
        minStack.push(10);
        minStack.push(13);
        minStack.push(10);
        System.out.println(minStack.get_min());
        minStack.pop();
        System.out.println(minStack.get_min()); // still prints 10
    }
}