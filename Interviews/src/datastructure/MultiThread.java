package datastructure;

public class MultiThread {

	public MultiThread() throws InterruptedException {
		counter c = new counter();
		StringBuilder st = new StringBuilder();

		StringBuffer sb = new StringBuffer();

		Thread t1 = new Thread(new Runnable() {
			public void run() {

				for (int i = 1; i <= 100000; i++) {

					sb.append("B");

					st.append("A");

					synchronized (c) {
						c.increment();
					}

				}

			}
		});

		Thread t2 = new Thread(new Runnable() {
			public void run() {

				for (int i = 1; i <= 100000; i++) {

					sb.append("B");

					st.append("A");

					synchronized (c) {
						c.increment();
					}
				}

			}
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Count: " + c.n + "::  ");
		System.out.println("StringBuilder: " + st.length());
		System.out.println("StringBuffer: " + sb.length());
	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		MultiThread c = new MultiThread();

	}

	class counter {

		int n;

		public void increment() {
			n++;
		}
	}

}
