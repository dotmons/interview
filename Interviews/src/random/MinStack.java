package random;

import java.util.Stack;
public class MinStack {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> aux = new Stack<>();

    void push(int x) {
        s.push(x);

        if (aux.empty() || aux.peek() >= x) {
            aux.push(x);
        }
    }

    void pop() {
        if (s.empty()) {
            System.out.println("Stack is empty");
            return;
        }

        if (s.peek().equals(aux.peek())) {
            aux.pop();
        }
        s.pop();
    }

    int top() {
        return (s.empty()) ? -1 : s.peek();
    }

    int getMin() {
        return (aux.empty()) ? -1 : aux.peek();
    }

    public static void main(String[] args)
    {
        MinStack s = new MinStack();

        s.push(6);
        System.out.println(s.getMin());

        s.push(7);
        System.out.println(s.getMin());

        s.push(5);
        System.out.println(s.getMin());

        s.push(3);
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());

        s.pop();
        System.out.println(s.getMin());
    }
}