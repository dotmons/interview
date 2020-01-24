package datastructure;

public class Queue {

	int[] queue = new int[100];
	int count = 0;

	// [7,4]
	// [1,2]

	// insert an item at the rear of the queue
	public void enqueue(int value) {
		count++;

		if (count > 0) {
			for (int i = count - 1; i > 0; i--) {
				queue[i] = queue[i - 1];
			}
		}
		queue[0] = value;

	}

	public int indexOf(int item) {
		return queue[item];
	}

	// Removes the object in front of the queue - decrementing queue size by one
	public void dequeue() {

		for (int i = 0; i < count - 1; i++) {
			queue[i] = queue[i + 1];
		}
		count--;
	}

	// returns an object in front of the queue
	public int peek() {

		return queue[count - 1];
	}

	public boolean isEmpty() {

		return false;
	}

	
	
	public int size() {
		
		return -1;
	}

	public void printQueue() {
		System.out.println("The total item in the queue is: ");
		for (int i = 0; i < count; i++) {
			System.out.print(queue[i] + " | ");
		}
		System.out.println();
	}
}
