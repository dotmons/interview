package datastructure;

class counter {

	int n;

	public void increment() {
		n++;
	}
}

public class MultiThread {

	public MultiThread() throws InterruptedException {
		counter c = new counter();
		StringBuilder st = new StringBuilder();

		StringBuffer sb = new StringBuffer();

		Thread t1 = new Thread(new Runnable() {
			public void run() {

				for (int i = 1; i <= 100000; i++) {
					st.append("A");
					sb.append("B");
					// System.out.println("AAA");
					c.increment();
				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {

				for (int i = 1; i <= 100000; i++) {
					st.append("A");
					sb.append("B");
					// System.out.println("BBB");
					c.increment();
				}

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Count: " + c.n + "::  " + st.length());
		System.out.println("StringBuilder: " + st.length());
		System.out.println("StringBuffer: " + sb.length());
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		MultiThread c = new MultiThread();

	}

}
