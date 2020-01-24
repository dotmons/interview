package myschoolcode;

public class BinarySearch {

	public BinarySearch() {
		java.util.List<Integer> dataset = new java.util.ArrayList<Integer>();
		dataset.add(3);
		dataset.add(5);
		dataset.add(8);
		dataset.add(12);
		dataset.add(20);
		dataset.add(45);
		dataset.add(90);
		dataset.add(99);
		// 3 5 8 12 20 45 90 99
		// 0 1 2 3 4 5 6 7

		System.out.println(getBinarySearch(22, dataset));
	}

	// 90

	int getBinarySearch(int searchValue, java.util.List<Integer> dataset) {

		if (dataset == null || dataset.size() < 2) {
			return -1;
		}

		int firstPoint = 0;
		int secondPoint = dataset.size() - 1;
		int midpoint = (firstPoint + secondPoint) / 2;

		// 3 5 8 12 20 45 90 99
		// 0 1 2 3 4 5 6 7

		while ((firstPoint <= secondPoint)) {

			if (searchValue == dataset.get(midpoint)) {
				return midpoint;
			} else if (dataset.get(midpoint) < searchValue) {
				firstPoint = midpoint + 1;
			} else {
				secondPoint = midpoint - 1;
			}
			midpoint = (firstPoint + secondPoint) / 2;
		}

		if (firstPoint > secondPoint) {
			return -1;
		}

		return midpoint;

	}

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
	}

}
