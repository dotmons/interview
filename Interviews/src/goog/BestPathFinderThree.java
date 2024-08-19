package goog;

import java.util.*;

public class BestPathFinderThree {

    public BestPathFinderThree(){
        char[][] grid = {
                {'A', 'B', 'C', 'D'},
                {'A', 'B', 'D', 'D'},
                {'A', 'B', 'K', 'X'},
                {'A', 'B', 'C', 'D'}
        };
        Cels maxCels = findMaxCels(grid); // Find the maximum character's position
        findPathFromMaxToRoot(grid, maxCels);
    }

    public static void main(String[] args) {
        new BestPathFinderThree();
    }

    void findPathFromMaxToRoot(char[][] grid, Cels startCels) {
        int rowSize = grid.length;
        int colSize = grid[0].length;
        boolean[][] visited = new boolean[rowSize][colSize];

        // BFS directions: up, down, left, right
        int[] ROW_VAL = {-1, 1, 0, 0};
        int[] COL_VAL = {0, 0, -1, 1};

        Queue<Cels> queue = new LinkedList<>();
        queue.add(startCels);
        visited[startCels.row][startCels.col] = true;

        while (!queue.isEmpty()) {
            Cels current = queue.poll();

            // If we reach the root (0,0), print the path
            if (current.row == 0 && current.col == 0) {
               // System.out.println("Rows: " + current.row + " " + current.col + current.path);
                return;
            }

            // Explore the neighboring Celss
            for (int i = 0; i < ROW_VAL.length; i++) {
                int newRow = current.row + ROW_VAL[i];
                int newCol = current.col + COL_VAL[i];

                if (isValid(newRow, newCol, rowSize, colSize) && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    System.out.println("rowcol: " + current.path);
                    queue.add(new Cels(newRow, newCol, current.path + " ---> " + grid[newRow][newCol]));
                }
            }
        }

        System.out.println("No path found to root (0,0)");
    }

    boolean isValid(int rowVal, int colVal, int rowSize, int colSize) {
        return rowVal >= 0 && colVal >= 0 && rowVal < rowSize && colVal < colSize;
    }

    // Find the Cels with the maximum character in the grid
    Cels findMaxCels(char[][] grid) {
        int maxRow = 0, maxCol = 0;
        char maxChar = 'A';

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > maxChar) {
                    maxChar = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new Cels(maxRow, maxCol, "Path starts at " + maxChar);
    }
}

class Cels {
    int row, col;
    String path;

    public Cels(int row, int col) {
        this.row = row;
        this.col = col;
        this.path = "";
    }

    public Cels(int row, int col, String path) {
        this.row = row;
        this.col = col;
        this.path = path;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Cels Cels = (Cels) obj;
        return row == Cels.row && col == Cels.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }
}