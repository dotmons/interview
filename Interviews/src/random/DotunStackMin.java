package random;

import java.util.Stack;

public class DotunStackMin {


    /*

    20, 51, 9, 4,13,90

    * */

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public DotunStackMin(){

    }

    void push(int x){
        stack.push(x);
        if (minStack.isEmpty() || x<minStack.peek()){
            minStack.push(x);
        }
    }

    int peek(){
        return minStack.peek();
    }

    int pop(){
        if (!stack.isEmpty()){
            int temp = stack.pop();

            if (minStack.peek() == temp){
                minStack.pop();
            }
            return temp;
        }
        return -1;
    }

    int getMin(){

      return minStack.isEmpty()? -1 : minStack.peek();
    }



    public static void main(String[] args) {
        new DotunStackMin();
    }
}
