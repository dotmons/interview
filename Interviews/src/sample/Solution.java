package sample;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

    // Directions for 4-way movement: up, down, left, right
    private static final int[] ROW = {-1, 1, 0, 0};
    private static final int[] COL = {0, 0, -1, 1};
    int[][] grid = new int[3][3];
    public Solution(){

        grid[0][0] = 2;
        grid[0][1] = 2;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 0;
        grid[2][0] = 0;
        grid[2][1] = 1;
        grid[2][2] = 1;

        System.out.println(orangesRotting((grid)));

    }
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        int freshOranges = 0;  // Count of fresh oranges

        // Step 1: Initialize queue with all rotten oranges and count fresh oranges
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});  // Add rotten orange's position to the queue
                } else if (grid[i][j] == 1) {
                    freshOranges++;  // Count fresh oranges
                }
            }
        }

        // Edge case: If there are no fresh oranges to begin with, return 0
        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;

        // Step 2: Perform BFS to rot fresh oranges
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;

            // Process all rotten oranges currently in the queue
            for (int q = 0; q < size; q++) {
                int[] current = queue.poll();
                int row = current[0];
                int col = current[1];

                // Explore 4-directionally adjacent cells
                for (int k = 0; k < 4; k++) {
                    int newRow = row + ROW[k];
                    int newCol = col + COL[k];

                    // If the neighboring cell contains a fresh orange, rot it
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2;  // Mark as rotten
                        queue.offer(new int[]{newRow, newCol});  // Add new rotten orange to the queue
                        freshOranges--;  // Reduce the fresh orange count
                        rottedThisMinute = true;
                    }
                }
            }

            // Only increment minutes if any fresh orange got rotten in this minute
            if (rottedThisMinute) {
                minutes++;
            }
        }

        // Step 3: If there are still fresh oranges left, return -1 (impossible to rot all)
        return freshOranges == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        new Solution();
    }
}