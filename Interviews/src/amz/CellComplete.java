package amz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
  There is a colony of 8 cells arranged in a straight line where each day every cell competes with its adjacent cells(neighbour).
  Each day, for each cell, if its neighbours are both active or both inactive, the cell becomes inactive the next day,.
  otherwise it becomes active the next day.
  Assumptions: The two cells on the ends have single adjacent cell, so the other adjacent cell can be assumed to be always
  inactive. Even after updating the cell state. consider its previous state for updating the state of other cells.
  Update the cell information of all cells simultaneously.
  Write a function cellCompete which takes one 8 element array of integers cells representing the current state of
  8 cells and one integer days representing te number of days to simulate. An integer value of 1 represents an active cell
  and value of 0 represents an inactive cell.
*/

public class CellComplete {

    public CellComplete() {
        int[] lValue = {1, 0, 0, 0, 0, 1, 0, 0};
        // 1,0,0,1,0,0,0,0
        //
        int days = 1;
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
                } else if (states[i - 1] == states[i + 1]) {
                    outputList.add(0);
                } else {
                    outputList.add(1);
                }

            }

            if (states[states.length - 2] == 0) {
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
