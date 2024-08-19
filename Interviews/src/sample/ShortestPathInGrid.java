package sample;

import java.util.LinkedList;
import java.util.Queue;

/*
1 1 0 1
0 1 1 0
1 1 0 1
1 0 1 1
* */
public class ShortestPathInGrid {

    // Directions for moving up, down, left, and right
    private static final int[] ROW_DIRECTIONS = {-1, 1, 0, 0};
    private static final int[] COL_DIRECTIONS = {0, 0, -1, 1};

    static class Cell {
        int row, col, distance;

        Cell(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 1},
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 0, 1, 1}
        };

        int startX = 0, startY = 0;
        int endX = 3, endY = 3;

        int shortestPathLength = findShortestPath(grid, startX, startY, endX, endY);
        if (shortestPathLength != -1) {
            System.out.println("The shortest path length is " + shortestPathLength);
        } else {
            System.out.println("No path exists from the start to the end point.");
        }
    }

    public static int findShortestPath(int[][] grid, int startX, int startY, int endX, int endY) {
        int rows = grid.length;
        int cols = grid[0].length;

        // If the starting or ending cell is blocked, return -1
        if (grid[startX][startY] == 0 || grid[endX][endY] == 0) {
            return -1;
        }

        boolean[][] visited = new boolean[rows][cols];
        Queue<Cell> queue = new LinkedList<>();

        // Start BFS from the starting cell
        queue.add(new Cell(startX, startY, 0));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Cell current = queue.poll();
            int row = current.row;
            int col = current.col;
            int distance = current.distance;

            // If we have reached the end cell, return the distance
            if (row == endX && col == endY) {
                return distance;
            }

            // Explore the neighbors
            for (int i = 0; i < 4; i++) {
                int newRow = row + ROW_DIRECTIONS[i];
                int newCol = col + COL_DIRECTIONS[i];

                // ROW_DIRECTIONS = {-1, 1, 0, 0};
                // COL_DIRECTIONS = {0, 0, -1, 1};
                if (isValid(newRow, newCol, rows, cols) && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    queue.add(new Cell(newRow, newCol, distance + 1));
                    visited[newRow][newCol] = true;
                }
            }
        }

        // If the end cell is not reachable, return -1
        return -1;
    }

    private static boolean isValid(int row, int col, int rows, int cols) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
}