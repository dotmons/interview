package random;

import hackerrank.Character;

import java.sql.SQLOutput;

public class TicTacToe {

    public TicTacToe() {

        String[] grid = {
                "xox",
                "oxo",
                "x-o"
        };

        System.out.println(question4(grid));


    }

    public String question4(String[] grid) {

        char[][] board = new char[3][3];


        // Convert string array to 2D char array
        for (int i = 0; i < 3; i++) {
            board[i] = grid[i].toCharArray();
        }

                /*

        x[0,0] o[0,1] x[0,2]
        o[1,0] x[1,1] o[1,2]
        x[2,0] -[2,1] x[2,2]

        * */

        if ((checker(board, 0) == 'x') ||
                (checker(board, 1) == 'x') ||
                (checker(board, 2) == 'x') ||
                (checkerTwo(board, 0) == 'x') ||
                (checkerTwo(board, 1) == 'x') ||
                (checkerTwo(board, 2) == 'x') ||
                (checkerDim(board) == 'x') ||
                (checkerDim(board) == 'x')

        ) {
            return "x";
        } else if ((checker(board, 0) == 'o') ||
                (checker(board, 1) == 'o') ||
                (checker(board, 2) == 'o') ||
                (checkerTwo(board, 0) == 'o') ||
                (checkerTwo(board, 1) == 'o') ||
                (checkerTwo(board, 2) == 'o') ||
                (checkerDim(board) == 'o') ||
                (checkerDim(board) == 'o')

        ) {
            return "o";
        } else {
            return "-";
        }

    }

    public char checker(char[][] board, int checker) {

        boolean isLast = true;
        char xo = '\0';
        if (board[checker][0] == 'x' || board[checker][0] == 'o') {
            xo = board[checker][0];
        } else {
            return '-';
        }

        for (int i = 1; i < 3; i++) {

            if (board[checker][i] != xo) {
                isLast = false;
                break;
            }
        }
        return isLast ? xo : '-';
    }


    public char checkerTwo(char[][] board, int checker) {

        boolean isLast = true;
        char xo = '\0';

        if (board[0][checker] == 'x' || board[0][checker] == 'o') {
            xo = board[0][checker];
        } else {
            return '-';
        }

        for (int i = 1; i < 3; i++) {

            if (board[i][checker] != xo) {
                isLast = false;
                break;
            }
        }
        return isLast ? xo : '-';
    }

    public char checkerDim(char[][] board) {

        boolean isLast = true;
        char xo = '\0';

        if (board[0][0] == 'x' || board[0][0] == 'o') {
            xo = board[0][0];
        } else {
            return '-';
        }

        for (int i = 1; i < 3; i++) {

            if (board[i][i] != xo) {
                isLast = false;
                break;
            }
        }
        return isLast ? xo : '-';
    }

    public char checkerDimReverse(char[][] board) {

        boolean isLast = true;
        char xo = '\0';

        if (board[2][0] == 'x' || board[2][0] == 'o') {
            xo = board[2][0];
        } else {
            return '-';
        }
        int j = 2;


        for (int i = 0; i < 3; i++) {

            if (board[j--][i] != xo) {
                isLast = false;
                break;
            }
        }
        return isLast ? xo : '-';
    }


    public static void main(String[] args) {
        new TicTacToe();
    }
}
