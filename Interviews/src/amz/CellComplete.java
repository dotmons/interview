package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CellComplete {

	public CellComplete() {
		int[] lValue = { 1, 0, 1, 1 };
		int days = 2;
		System.out.println(cellCompete(lValue, days));

	}

	public List<Integer> cellCompete(int[] states, int days) {

		List<Integer> outputList = new ArrayList<Integer>();

		while (days != 0) {

			for (int i = 0; i < states.length - 1; i++) {
				if (i == 0) {
					if (states[i + 1] == 0) {
						outputList.add(0);
					} else {
						outputList.add(1);
					}
				} else {
					if (states[i - 1] == states[i + 1]) {
						outputList.add(0);
					} else {
						outputList.add(1);
					}
				}

			}

			if (states[states.length - 1] == 0) {
				outputList.add(0);
			} else {
				outputList.add(1);
			}
			states = outputList.stream().mapToInt(Integer::intValue).toArray();
			outputList = new ArrayList<Integer>();
			days--;
		}
		outputList = Arrays.stream(states).boxed().collect(Collectors.toList());
		return outputList;
	}

	public static void main(String[] args) {
		CellComplete cellComplete = new CellComplete();
	}

}
