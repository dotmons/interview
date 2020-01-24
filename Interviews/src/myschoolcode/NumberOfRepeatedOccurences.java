package myschoolcode;

import java.util.ArrayList;

public class NumberOfRepeatedOccurences {

	BinarySearch_LowestHighestRepeatedIndex binarySearch_LowestHighestRepeatedIndex = new BinarySearch_LowestHighestRepeatedIndex();

	public NumberOfRepeatedOccurences() {

		ArrayList<Integer> dataset = new ArrayList<Integer>();

		dataset.add(1);
		dataset.add(1);
		dataset.add(3);
		dataset.add(3);
		dataset.add(5);
		dataset.add(5);
		dataset.add(5);
		dataset.add(5);
		dataset.add(5);
		dataset.add(9);
		dataset.add(9);
		dataset.add(11);
		dataset.add(11);
		dataset.add(11);

		int searchValue = 11;

		System.out.println(
				"Lowest:  " + binarySearch_LowestHighestRepeatedIndex.getBinaryLowestSearch(searchValue, dataset));
		System.out.println(
				"Highest: " + binarySearch_LowestHighestRepeatedIndex.getBinaryHighestSearch(searchValue, dataset));

		int a = binarySearch_LowestHighestRepeatedIndex.getBinaryHighestSearch(searchValue, dataset)
				- binarySearch_LowestHighestRepeatedIndex.getBinaryLowestSearch(searchValue, dataset) + 1;

		System.out.println("Total number of occurence in " + searchValue + " is " + a);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NumberOfRepeatedOccurences numberOfRepeatedOccurences = new NumberOfRepeatedOccurences();
	}

}
