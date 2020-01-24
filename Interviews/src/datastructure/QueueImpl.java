package datastructure;

public class QueueImpl {

	public QueueImpl(){
		// [7,4]
		Queue queue = new Queue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(10);
		queue.enqueue(20);		
		
		
		queue.printQueue();
		queue.dequeue();
		queue.printQueue();
		
		System.out.println("The first value in queue is "+queue.indexOf(queue.count-1));
		System.out.println("The item in front of the queue: "+queue.peek());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueImpl queueImpl = new QueueImpl();

	}

}
