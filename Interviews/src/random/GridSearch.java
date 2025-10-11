package random;

import java.util.*;

public class GridSearch {

    public static boolean question2(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();

        int startRow = -1, startCol = -1;
        int endRow = -1, endCol = -1;

        // Find start (S) and end (E) positions
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                char ch = grid[r].charAt(c);
                if (ch == 'S') {
                    startRow = r;
                    startCol = c;
                } else if (ch == 'E') {
                    endRow = r;
                    endCol = c;
                }
            }
        }

        // BFS setup
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][cols];
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        // Directions: up, down, left, right
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];

            if (r == endRow && c == endCol) {
                return true; // Found path
            }

            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];

                if (nr >= 0 && nr < rows && nc >= 0 && nc < cols &&
                        !visited[nr][nc] && grid[nr].charAt(nc) != '#') {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        return false; // No path
    }

    public static void main(String[] args) {
        String[] grid = {
                "S..#",
                ".##.",
                ".#E.",
                "...."
        };

        System.out.println(question2(grid)); // true or false
    }
}