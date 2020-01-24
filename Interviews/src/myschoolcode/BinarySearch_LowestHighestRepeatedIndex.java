package myschoolcode;

public class BinarySearch_LowestHighestRepeatedIndex {

	public BinarySearch_LowestHighestRepeatedIndex() {

	}

	public BinarySearch_LowestHighestRepeatedIndex(int a) {
		java.util.List<Integer> dataset = new java.util.ArrayList<Integer>();
		dataset.add(2);
		dataset.add(3);
		dataset.add(3);
		dataset.add(3);
		dataset.add(20);
		dataset.add(45);
		dataset.add(90);
		dataset.add(99);
		// 3 5 8 12 20 45 90 99
		// 0 1 2 3 4 5 6 7
		System.out.println("Lowest search for 3 : " + getBinaryLowestSearch(3, dataset));
		System.out.println("Highest search for 3 : " + getBinaryHighestSearch(3, dataset));
	}
	// 90

	int getBinaryLowestSearch(int searchValue, java.util.List<Integer> dataset) {

		if (dataset == null || dataset.size() < 2) {
			return -1;
		}

		int low = 0;
		int high = dataset.size() - 1;
		int midpoint = 0;
		int result = -1;

		while ((low <= high)) {
			midpoint = (low + high) / 2;

			if (searchValue == dataset.get(midpoint)) {
				// midpoint;
				result = midpoint;
				high = midpoint - 1;
			} else if (searchValue < dataset.get(midpoint)) {
				high = midpoint - 1;
			} else {
				low = midpoint + 1;
			}
		}
		return result;

	}

	int getBinaryHighestSearch(int searchValue, java.util.List<Integer> dataset) {

		if (dataset == null || dataset.size() < 2) {
			return -1;
		}

		int firstPoint = 0;
		int secondPoint = dataset.size() - 1;
		int midpoint = 0;
		int result = -1;

		// 3 5 8 12 20 45 90 99
		// 0 1 2 3 4 5 6 7

		while ((firstPoint <= secondPoint)) {
			midpoint = (firstPoint + secondPoint) / 2;

			if (searchValue == dataset.get(midpoint)) {
				// midpoint;
				result = midpoint;
				firstPoint = midpoint + 1;
			} else if (searchValue < dataset.get(midpoint)) {
				secondPoint = midpoint - 1;
			} else {

				firstPoint = midpoint + 1;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		BinarySearch_LowestHighestRepeatedIndex binarySearch = new BinarySearch_LowestHighestRepeatedIndex(2);
	}

}
