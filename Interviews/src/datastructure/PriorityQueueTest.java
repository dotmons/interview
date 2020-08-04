package datastructure;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public PriorityQueueTest() {
		// TODO Auto-generated constructor stub
		testInteger();
	}
	
	public void testInteger(){
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		
		pq.add(10);
		pq.add(20);
		pq.add(2);
		pq.add(3);
		pq.add(7);
		
		//getting the order
		while(!pq.isEmpty()){
			// this removes the head
			//System.out.print(pq.poll() + " ");
		}
		
		//throws nullif empty
		System.out.println("Head::"+pq.peek());
		//throws exception if empty
		//System.out.println("Head::"+pq.element());
		
		while(!pq.isEmpty()){
			System.out.println(pq);
			System.out.println("removing: " + pq.remove());
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new PriorityQueueTest();

	}

}
