/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amz;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dotmons
 */
public class ServerAmazon {

    int n = 0;

    public ServerAmazon() {
        System.out.println(minimumDays(4, 5, testCaseA()));

    }

    int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        // WRITE YOUR CODE HERE
        int finalDestination = 0;
        if (grid == null || grid.isEmpty()) {
            return -1;
        }
        boolean checkResult = false;
        int[][] dp = new int[grid.size()][grid.get(0).size()];
        int[][] dpi = new int[grid.size()][grid.get(0).size()];

        while (checkResult != true) {

            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    dp[i][j] = grid.get(i).get(j);

                    if (i > 0 && i < rows - 1 && j > 0 && j < columns - 1) {
                        if ((grid.get(i - 1).get(j) == 1) || (grid.get(i + 1).get(j) == 1) || (grid.get(i).get(j + 1) == 1) || (grid.get(i).get(j - 1) == 1)) {
                            dpi[i][j] = 1;
                        }

                    } else if (j == columns - 1) {

                        if (i == 0) {
                            if ((grid.get(i).get(j - 1) == 1) || (grid.get(i + 1).get(j) == 1)) {
                                dpi[i][j] = 1;
                            }
                        } else if (j == columns - 1) {
                            if ((grid.get(i - 1).get(j) == 1) || (grid.get(i).get(j - 1) == 1)) {
                                dpi[i][j] = 1;
                            }
                        } else if ((grid.get(i - 1).get(j) == 1) || (grid.get(i).get(j - 1) == 1)) {
                            dpi[i][j] = 1;
                        }
                    } else if (i == rows - 1) {
                        if ((grid.get(i - 1).get(j) == 1) || (grid.get(i).get(j + 1) == 1) || (grid.get(i).get(j - 1) == 1)) {
                            dpi[i][j] = 1;
                        }
                    } else if (i > 0) {
                        if ((grid.get(i - 1).get(j) == 1) || (grid.get(i).get(j + 1) == 1)) {
                            dpi[i][j] = 1;
                        }
                    } else if (j > 0) {
                        if ((grid.get(i + 1).get(j) == 1) || (grid.get(i).get(j - 1) == 1)) {
                            dpi[i][j] = 1;
                        }
                    } else if ((grid.get(0).get(1) == 1) || ((grid.get(1).get(0) == 1))) {
                        dpi[0][0] = 1;
                    }
                    if (dp[i][j] == 1) {
                        dpi[i][j] = 1;
                    }
                }

            }

            finalDestination++;
            checkResult = checkResult(dpi);
            grid = new ArrayList();
            List<Integer> listValues = new ArrayList();
            
            for (int i = 0; i < dpi.length; i++) {
                for (int j = 0; j < dpi[i].length; j++) {
                    listValues.add(dpi[i][j]);
                }
                grid.add(listValues);
                listValues = new ArrayList<>();
            }

        }

        return finalDestination;
    }

    public boolean checkResult(int[][] dpi) {
        n++;
        if (n == 100) {
            return true;
        }
        for (int i = 0; i < dpi.length; i++) {
            for (int j = 0; j < dpi[i].length; j++) {
                //System.out.print(dpi[i][j] +" ");
            }
           // System.out.println();
        }
        //System.out.println();
        for (int i = 0; i < dpi.length; i++) {
            for (int j = 0; j < dpi[i].length; j++) {
                if (dpi[i][j] != 1) {                	
                    return false;
                }
            }
        }
        return true;
    }

    public List<List<Integer>> testCaseA() {
        List<List<Integer>> area = new ArrayList<>();
        List<Integer> listValues = new ArrayList();
        listValues.add(0);
        listValues.add(1);
        listValues.add(1);
        listValues.add(0);
        listValues.add(1);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(0);
        listValues.add(1);
        listValues.add(0);
        listValues.add(1);
        listValues.add(0);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(0);
        listValues.add(0);
        listValues.add(0);
        listValues.add(0);
        listValues.add(1);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(0);
        listValues.add(1);
        listValues.add(0);
        listValues.add(0);
        listValues.add(0);
        area.add(listValues);

        return area;
    }

    public static void main(String[] args) {
        ServerAmazon serverAmazon = new ServerAmazon();
    }
}
