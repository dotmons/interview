package MongoDB;

import java.util.ArrayList;
import java.util.HashSet;

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // Create a HashSet to store ArrayLists for rows, columns, and boxes
        HashSet<ArrayList<Character>> rows = new HashSet<>();
        HashSet<ArrayList<Character>> cols = new HashSet<>();
        HashSet<ArrayList<Character>> boxes = new HashSet<>();

        // Initialize ArrayLists for rows, columns, and boxes
        ArrayList<Character>[] rowLists = new ArrayList[9];
        ArrayList<Character>[] colLists = new ArrayList[9];
        ArrayList<Character>[] boxLists = new ArrayList[9];

        for (int i = 0; i < 9; i++) {
            rowLists[i] = new ArrayList<>();
            colLists[i] = new ArrayList<>();
            boxLists[i] = new ArrayList<>();
        }

        // Add the empty ArrayLists to the respective HashSets
        for (int i = 0; i < 9; i++) {
            rows.add(rowLists[i]);
            cols.add(colLists[i]);
            boxes.add(boxLists[i]);
        }

        // Iterate through each cell in the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];

                // Skip empty cells
                if (num == '.') {
                    continue;
                }

                // Check the row
                if (rowLists[i].contains(num)) {
                    return false;
                }
                rowLists[i].add(num);

                // Check the column
                if (colLists[j].contains(num)) {
                    return false;
                }
                colLists[j].add(num);

                // Check the 3x3 box
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (boxLists[boxIndex].contains(num)) {
                    return false;
                }
                boxLists[boxIndex].add(num);
            }
        }

        // If no duplicates are found, the board is valid
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        ValidSudoku validator = new ValidSudoku();
        boolean isValid = validator.isValidSudoku(board);
        System.out.println("Is the Sudoku board valid? " + isValid);
    }

}
