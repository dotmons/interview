package leetcode;

import java.util.ArrayList;

import javafx.util.Pair;

public class RottenOranges {

    int row = 0;
    int col = 0;
    int[] ROW = {-1, 0, 1, 0};
    int[] COL = {0, -1, 0, 1};
    ArrayList<Pair<Integer, Integer>> listPair = new ArrayList<>();
    int[][] grid = new int[3][3];
//        [[2,1,1],[1,1,0],[0,1,1]]
//        [[2,1,1],[0,1,1],[1,0,1]]
//        [[0,2]]

    //2 1 1
    //0 1 1
    //1 0 1
    public RottenOranges(){
        grid[0][0] = 1;
        grid[0][1] = 2;
        grid[0][2] = 1;
        grid[1][0] = 2;
//        grid[1][1] = 1;
//        grid[1][2] = 1;
//        grid[2][0] = 1;
//        grid[2][1] = 0;
//        grid[2][2] = 1;

        System.out.println(orangesRotting(grid));
    }

    private boolean checkValidGrid(ArrayList<Pair<Integer, Integer>> einval, int[][] grid) {
        int counter = 0;
        for (Pair<Integer, Integer> pair : einval) {
            if (grid[pair.getKey()][pair.getValue()] != 0) {
                //System.out.println("left: " + pair.getLeft() + " right: " + pair.getRight());
                counter++;
            }
        }
        return counter==0;
    }

    //[[2,1,1],[0,1,1],[1,0,1]]
    public int orangesRotting(int[][] grid) {


        row = grid.length;
        col = grid[0].length;

        boolean isZero = false;
        boolean isOne = false;
        int spoiltCount = 0;
        int minutes = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    spoiltCount = 1;
                    break;
                }
                else if (grid[i][j] == 1) {
                    if (checkValidGrid(isValidNeighborValue(i,j), grid)){
                        return -1;
                    }
                    isOne = true;
                }
                else if (grid[i][j] == 0) {
                    isZero = true;
                }
            }
        }

        if (isZero && !isOne && spoiltCount != 1){
            return 0;
        }
        else if (isOne && !isZero && spoiltCount != 1)
        {
            return -1;
        }
        if (spoiltCount == 0) {
            return -1;
        }

        while(spoiltCount!=0)
        {
            spoiltCount = 0;
            boolean isUpdated = false;
            for (int i=0; i<row; i++){
                for (int j=0; j<col; j++){
                    if (grid[i][j]==2){
                        isValidNeighbor(i, j);
                    }
                    else if ((listPair.contains(new Pair<>(i,j))) && (grid[i][j]!=0)){
                        isUpdated = true;
                        grid[i][j]=2;
                    }
                    else if (grid[i][j]==1){
                        spoiltCount++;
                    }
                }

            }

            if (isUpdated){
                minutes++;
            }

        }
        return minutes;
    }

    void isValidNeighbor(int i, int j){
        getListPairValue(i, j, listPair);
    }

    ArrayList<Pair<Integer, Integer>> isValidNeighborValue(int i, int j){
        ArrayList<Pair<Integer, Integer>> list = new ArrayList<>();
        getListPairValue(i, j, list);
        return list;
    }

    private void getListPairValue(int i, int j, ArrayList<Pair<Integer, Integer>> list) {
        for (int k=0; k<ROW.length; k++){
            int rowSum = ROW[k]+i;
            int colSum = COL[k]+j;
            if ( (rowSum>=0) && (colSum>=0) && (rowSum<row) && (colSum<col) ){
                list.add(new Pair<>(rowSum, colSum));
            }
        }
    }

    public static void main(String[] args) {
        new RottenOranges();
    }
}
