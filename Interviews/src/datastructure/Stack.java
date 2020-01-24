package datastructure;

public class Stack {

	int data[] = new int[100];
	int count = 0;

	public void push(int n) {
		data[count++] = n;
	}

	public int pop() {
		return data[--count];
	}

	public int getSize() {
		return count;
	}

	public boolean isEmpty() {
		return count > 0;
	}

	public int peek() {
		return data[count-1];
	}
	
	public void show(){
		int i = count;
		while (i>0){
			System.out.println(data[--i]);
		}
	}

}
