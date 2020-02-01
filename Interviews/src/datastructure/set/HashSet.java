package datastructure.set;

public class HashSet {

	public HashSet() {
		java.util.HashSet<Integer> hashSet = new java.util.HashSet<Integer>();

		hashSet.add(4);
		hashSet.add(4);
		hashSet.add(3);
		hashSet.add(2);
		hashSet.add(1);
		
		for (int a : hashSet){
			System.out.println(a);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new HashSet();

	}

}
