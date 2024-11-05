package leetcode;

import java.util.*;


public class RottenOranges {

    int row = 0;
    int col = 0;
    int[] ROW = {-1, 0, 1, 0};
    int[] COL = {0, -1, 0, 1};
    ArrayList<InnerPair> listPair = new ArrayList<>();
    int[][] grid = new int[3][3];

    int freshOranges = 0;
    //[[2,1,1],[1,1,1],[0,1,2]]
    public RottenOranges() {
        grid[0][0] = 2;
        grid[0][1] = 2;
       // grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        //grid[1][2] = 1;
        grid[2][0] = 0;
        grid[2][1] = 1;
        grid[2][2] = 2;



        System.out.println(orangesRotting(grid));
        //System.out.println(orangesRottings(grid));
    }


    public int orangesRotting(int[][] grid) {

        ArrayList<InnerPair> spoiltOranges = getSpoiltOranges(grid);

        if (spoiltOranges == null) {
            return -1;
        } else if (spoiltOranges.get(0).getMinutes() == -1) {
            return 0;
        }
        else if (freshOranges==0){
            return -1;
        }

        Queue<InnerPair> queue = new LinkedList<>(spoiltOranges);
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                visited[i][j] = false;
            }
        }
        int minutes = 0;

        while (!queue.isEmpty()) {
            InnerPair pair = queue.poll();
            visited[pair.getLeft()][pair.getRight()] = true;
            int rowLength = grid.length;
            int colLength = grid[0].length;
            for (int i = 0; i < ROW.length; i++) {
                int rowSum = ROW[i] + pair.getLeft();
                int colSum = COL[i] + pair.getRight();
                if (rowSum >= 0 && colSum >= 0 && rowSum < rowLength && colSum < colLength && !visited[rowSum][colSum]) {
                    if ((grid[rowSum][colSum] == 1) && (!queue.contains(new InnerPair(rowSum, colSum, 0)))) {
                        if (pair.getMinutes() == minutes) {
                            minutes++;
                        }
                        queue.add(new InnerPair(rowSum, colSum, pair.getMinutes() + 1));
                    }
                }
            }


        }

        if (!getUntouchedOranges(grid, visited)) {
            return -1;
        }

        return minutes;
    }

    private ArrayList<InnerPair> getSpoiltOranges(int[][] grid) {
        ArrayList<InnerPair> spoiltOranges = new ArrayList<>();
        boolean isZeroGoodOrange = false;
        boolean isOneGoodOrange = false;
        boolean isTwoGoodOrange = false;
        int minutes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    isTwoGoodOrange = true;
                    spoiltOranges.add(new InnerPair(i, j, 0));

                } else if (grid[i][j] == 0) {
                    isZeroGoodOrange = true;
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                    isOneGoodOrange = true;
                }

            }
        }
        if (!spoiltOranges.isEmpty() && isOneGoodOrange) {
            return spoiltOranges;
        }
        else if (freshOranges==0 && isZeroGoodOrange && !isOneGoodOrange && !isTwoGoodOrange){
            System.out.println("Working");
            spoiltOranges.clear();
            spoiltOranges.add(new InnerPair(0, 0, -1));
            return spoiltOranges;
        }
        else if (freshOranges==0 && isZeroGoodOrange && !isOneGoodOrange && isTwoGoodOrange){
            spoiltOranges.clear();
            spoiltOranges.add(new InnerPair(0, 0, -1));
            return spoiltOranges;
        }
        return null;
    }

    private boolean getUntouchedOranges(int[][] grid, boolean[][] visited) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if ((grid[i][j] == 1) && (!visited[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    static class InnerPair {
        int left;
        int right;
        int minutes;

        public InnerPair(int left, int right, int minutes) {
            this.left = left;
            this.right = right;
            this.minutes = minutes;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }

        public int getMinutes() {
            return minutes;
        }

        public void setMinutes(int minutes) {
            this.minutes = minutes;
        }
    }

    public static void main(String[] args) {
        RottenOranges oranges = new RottenOranges();
    }
}

