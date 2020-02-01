package myschoolcode;

import java.util.HashSet;

import myschoolcode.LinkedListMerge.Node;

public class LinkedListMergeImpl {

	public LinkedListMergeImpl() {
		// TODO Auto-generated method stub
		LinkedListMerge linkedListMerge = new LinkedListMerge();
		linkedListMerge.addList(10);
		linkedListMerge.addList(20);
		linkedListMerge.addList(30);
		linkedListMerge.addList(40);
		linkedListMerge.addList(50);

		LinkedListMerge linkedListMerge_1 = new LinkedListMerge();
		linkedListMerge_1.addList(5);
		linkedListMerge_1.addList(12);
		linkedListMerge_1.addList(30);
		linkedListMerge_1.addList(40);
		linkedListMerge_1.addList(50);

		// System.out.println("Size: " + linkedListMerge.count);
		System.out.println(getMergePoint(linkedListMerge, linkedListMerge_1));
	}

	public Node getMergePoint(LinkedListMerge mergerA, LinkedListMerge mergerB) {

		HashSet<Node> hashSetLinkedA = mergerA.getLinkedSet();


		for (int i = 0; i < mergerB.count - 1; i++) {
			if (hashSetLinkedA.contains(mergerB.first)) {
				return mergerB.first;
			}
		}

		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new LinkedListMergeImpl();

	}

}
