package goog;


import java.util.*;

public class BestPathFinderTwo {

    public BestPathFinderTwo() {
        char[][] grid = {
                {'A', 'B', 'C', 'D'},
                {'A', 'B', 'D', 'D'},
                {'A', 'B', 'K', 'X'},
                {'A', 'B', 'C', 'D'}
        };
        Cell cell = new Cell(2, 3, ""+grid[2][3]);
        //(1,1)
        findPathFromMaxToRoot(grid, cell);
    }

    public static void main(String[] args) {
        new BestPathFinderTwo();
    }

    void findPathFromMaxToRoot(char[][] grid, Cell cell) {

        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] checked = new boolean[rowSize][colSize];

        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                checked[i][j] = false;
            }

        }

        int[] ROW_VAL = {-1, 1, 0, 0};
        int[] COL_VAL = {0, 0, -1, 1};
        Queue<Cell> queue = new LinkedList<>();
        queue.add(cell);
        checked[2][3] = true;

        while (!queue.isEmpty()) {

            Cell topCell = queue.poll();

            if (topCell.row == 0 && topCell.col == 0) {
                System.out.println("Path: " + topCell.path);
                //return;
            }

            for (int i = 0; i < ROW_VAL.length; i++) {
                if (isValid((topCell.row + ROW_VAL[i]), (topCell.col + COL_VAL[i]), rowSize, colSize) && !checked[(topCell.row + ROW_VAL[i])][(topCell.col + COL_VAL[i])]) {
                    if (topCell.sumCell() > ((topCell.row + ROW_VAL[i]) + (topCell.col + COL_VAL[i]))) {
                        if ((grid[topCell.row][topCell.col] > grid[(topCell.row + ROW_VAL[i])][(topCell.col + COL_VAL[i])])) {
                            //System.out.println("grid: " + grid[topCell.row][topCell.col] + " > " + grid[(topCell.row + ROW_VAL[i])][(topCell.col + COL_VAL[i])]);
                            checked[(topCell.row + ROW_VAL[i])][(topCell.col + COL_VAL[i])] = true;
                            //System.out.println("Path: " + topCell.path + grid[topCell.row][topCell.col]);
                            queue.add(new Cell((topCell.row + ROW_VAL[i]), (topCell.col + COL_VAL[i]), topCell.path + grid[(topCell.row + ROW_VAL[i])][(topCell.col + COL_VAL[i])]));
                            //System.out.println("rowcol: "+(topCell.row + ROW_VAL[i]) +" "+ (topCell.col + COL_VAL[i]) );
                        }
                    }

                }
            }

            /*
            for (int i=0; i<ROW_VAL.length; i++){
                if (isValid(topCell.row+ROW_VAL[i],topCell.col+COL_VAL[i], rowSize, colSize )){

                    if (!checked[topCell.row+ROW_VAL[i]][topCell.col+COL_VAL[i]])
                    {
                        //System.out.println("Cell>>: " + (topCell.row + ROW_VAL[i]) + " " + (topCell.col + COL_VAL[i]));
                        if (grid[(topCell.row+ROW_VAL[i])][(topCell.col+COL_VAL[i])]>grid[topCell.row][topCell.row]){
                            hashSet.add(new Cell((topCell.row + ROW_VAL[i]), (topCell.col + COL_VAL[i])));
                            //System.out.println("Cell: " + (topCell.row + ROW_VAL[i]) + " " + (topCell.col + COL_VAL[i]));
                            queue.add(new Cell(topCell.row + ROW_VAL[i], topCell.col + COL_VAL[i]));
                            checked[topCell.row + ROW_VAL[i]][topCell.col + COL_VAL[i]] = true;
                        }
                        else{
                            System.out.println(">>>>>>" + (topCell.row+ROW_VAL[i]) + " >>>>>>>>>" + (topCell.col+COL_VAL[i]));
                            if (hashSet.contains(new Cell((topCell.row+ROW_VAL[i]), (topCell.col+COL_VAL[i])))){
                                hashSet.remove((new Cell((topCell.row+ROW_VAL[i]), (topCell.col+COL_VAL[i]))));
                            }
                        }
                    }
                }


            }
            */
        }

    }

    boolean isValid(int rowVal, int colVal, int rowSize, int colSize) {
        if ((rowVal < rowSize) && (colVal < colSize) && (rowVal >= 0) && colVal >= 0) {
            return true;
        }
        return false;
    }

}

class Cell {
    int row;
    int col;
    String path;

    public Cell(int row, int col, String path) {
        this.row = row;
        this.col = col;
        this.path = path;
    }

    public int sumCell() {
        return (row + col);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cell cell = (Cell) obj;
        return row == cell.row && col == cell.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}

//int[] ROW_VAL = {-1, 1, 0, 0};
//int[] COL_VAL = {0, 0, -1, 1};
//        00 01 02 03
//        10 11 12 13
//        20 21 22 23
//        30 31 32 33

//               {'A', 'B', 'C', 'D'},
//                {'A', 'B', 'D', 'D'},
//                {'A', 'B', 'K', 'X'},
//                {'A', 'B', 'C', 'D'}