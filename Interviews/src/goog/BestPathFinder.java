package goog;import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BestPathFinder {

    public static void main(String[] args) {
        char[][] matrix = {
                {'A', 'B', 'C', 'D'},
                {'A', 'B', 'D', 'D'},
                {'A', 'B', 'K', 'X'},
                {'A', 'B', 'C', 'D'}
        };

        List<String> path = findPathFromMaxToRoot(matrix);
        System.out.println("Path from the maximum character to the root (0,0): " + path);
    }

    public static List<String> findPathFromMaxToRoot(char[][] matrix) {
        // Step 1: Find the maximum character and its position
        int maxRow = 0, maxCol = 0;
        char maxChar = 'A';

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > maxChar) {
                    maxChar = matrix[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        // Step 2: Use BFS to find the path to the root (0,0)
        Queue<Cells> queue = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        // Start BFS from the maximum character's position
        queue.add(new Cells(maxRow, maxCol, maxChar + " (" + maxRow + "," + maxCol + ")"));
        visited[maxRow][maxCol] = true;

        while (!queue.isEmpty()) {
            Cells current = queue.poll();

            // If we reach the root (0,0), return the path
            if (current.row == 0 && current.col == 0) {
                return List.of(current.path.split(" -> "));
            }

            // Explore the possible directions: up and left
            if (current.row > 0 && !visited[current.row - 1][current.col]) {
                queue.offer(new Cells(current.row - 1, current.col, current.path + " -> " +
                        matrix[current.row - 1][current.col] + " (" + (current.row - 1) + "," + current.col + ")"));
                visited[current.row - 1][current.col] = true;
            }

            if (current.col > 0 && !visited[current.row][current.col - 1]) {
                queue.offer(new Cells(current.row, current.col - 1, current.path + " -> " +
                        matrix[current.row][current.col - 1] + " (" + current.row + "," + (current.col - 1) + ")"));
                visited[current.row][current.col - 1] = true;
            }
        }

        // If no path is found, return an empty list
        return new LinkedList<>();
    }


}

class Cells {
    int row;
    int col;
    String path;

    public Cells(int row, int col, String path) {
        this.row = row;
        this.col = col;
        this.path = path;
    }
}