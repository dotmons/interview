package myschoolcode;

import java.util.ArrayList;

public class CircularlySortedArray {

	public CircularlySortedArray() {
		ArrayList<Integer> dataset = new ArrayList<Integer>();

		dataset.add(8);
		dataset.add(11);
		dataset.add(12);
		dataset.add(15);
		dataset.add(18);
		dataset.add(2);
		dataset.add(5);
		dataset.add(6);

		System.out.println(getCircularLowestIndexValue(dataset));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CircularlySortedArray CircularlySortedArray = new CircularlySortedArray();

	}

	// 11,12,15,18,2,5,6,8
	// 2,5,6,8,11,12,15,18

	// 18,2,5,6,8,11,12,15

	int getCircularLowestIndexValue(java.util.ArrayList<Integer> dataSet) {

		if (dataSet != null && dataSet.size() > 2) {

			int midPoint = (dataSet.size() - 1) / 2;
			int lowPoint = 0;
			int highPoint = dataSet.size() - 1;

			while (lowPoint <= highPoint) {

				if (dataSet.get(lowPoint) <= dataSet.get(highPoint)) {
					return lowPoint;
				}

				else if (dataSet.get(midPoint - 1) > dataSet.get(midPoint)
						&& dataSet.get(midPoint + 1) > dataSet.get(midPoint)) {
					return midPoint;
				} else if (dataSet.get(midPoint) >= dataSet.get(lowPoint)) {
					lowPoint = midPoint + 1;
				} else if (dataSet.get(highPoint) >= dataSet.get(midPoint)) {
					highPoint = midPoint - 1;
				}

				midPoint = (lowPoint + highPoint) / 2;

			}
		}
		return -1;

	}

}
