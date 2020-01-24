package myschoolcode;

import java.util.ArrayList;

public class CircularlySortedToSearchArray {

	public CircularlySortedToSearchArray() {

		ArrayList<Integer> dataset = new ArrayList<Integer>();

		dataset.add(12);
		dataset.add(14);
		dataset.add(18);
		dataset.add(21);
		dataset.add(3);
		dataset.add(6);
		dataset.add(8);
		dataset.add(9);

		System.out.println(getCirculySortedArraySearchedValue(dataset, 6));
	}

	int getCirculySortedArraySearchedValue(java.util.ArrayList<Integer> dataset, int searchx) {

		if (dataset.size() > 2 && dataset != null) {

			int low = 0;
			int high = dataset.size() - 1;

			while (low <= high) {
				int mid = (low + high) / 2;
				if (searchx == dataset.get(mid)) {
					return mid;
				}
				if (dataset.get(mid) <= dataset.get(high)) {
					if (searchx > dataset.get(mid) && searchx <= dataset.get(high)) {
						low = mid + 1;
					} else {
						high = mid - 1;
					}
				} else {
					if (dataset.get(low) <= searchx && (searchx < dataset.get(mid))) {
						high = mid - 1;
					} else {
						low = mid + 1;
					}
				}
			}
			System.out.println("Low: " + low);
			System.out.println("High: " + high);
		}

		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularlySortedToSearchArray circularlySortedToSearchArray = new CircularlySortedToSearchArray();
	}

}
