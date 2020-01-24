package datastructure;

public class StackImpl {

	public StackImpl(){
		Stack stack = new Stack();
		
		System.out.println(stack.isEmpty());
		
		stack.push(4);
		stack.push(9);
		stack.push(48);
		System.out.println(stack.pop());
		stack.push(87);
		stack.push(5);
		
		System.out.println(stack.isEmpty());		
		
		System.out.println(stack.count);
		
		System.out.println("The peek value is : " + stack.peek());
		System.out.println("The total stack values are:");
		stack.show();
	}
	public static void main(String[] args) {
		StackImpl stackImpl = new StackImpl();
		// TODO Auto-generated method stub

	}

}
