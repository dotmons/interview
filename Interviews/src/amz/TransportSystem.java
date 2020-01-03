/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amz;

import java.util.ArrayList;
import java.util.List;

/**
 * 1` ` `
 *
 * @author Dotmons
 */
public class TransportSystem {

    public TransportSystem() {

        List<List<Integer>> area = new ArrayList<>();
        List<Integer> listValues = new ArrayList();
        listValues.add(1);
        listValues.add(0);
        listValues.add(0);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(1);
        listValues.add(0);
        listValues.add(0);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(1);
        listValues.add(9);
        listValues.add(1);
        area.add(listValues);

        System.out.println(getMinimumTransportPortPost(area));
       // System.out.println("The minimum transport move is: " + getMinimumTransportPortPost(area));
    }

    public int getMinimumTransportPortPost(List<List<Integer>> area) {
        int finalDestination = 0;
        if (area == null || area.isEmpty()) {
            return -1;
        }
        int[][] dp = new int[area.size()][area.get(0).size()];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = area.get(i).get(j);

                int temp = dp[i][j];

                if (dp[i][j] == 9) {

                    if (i > 0 && j > 0) {
                        int tempValue = (dp[i - 1][j] > 0) ? dp[i - 1][j] : dp[i][j - 1];                         
                        finalDestination = tempValue > 0 ? tempValue: -1;
                    } else if (i > 0) {
                        finalDestination = dp[i - 1][j] > 0 ? dp[i - 1][j] : -1;
                    } else if (j > 0) {
                        finalDestination = dp[i][j - 1] > 0 ? dp[i][j - 1] : -1;
                    }
                } else if (i > 0 && j > 0) {
                    if (((dp[i - 1][j] > 0) || (dp[i][j - 1] > 0)) && (dp[i][j] > 0)) {
                        int tempValue = (dp[i - 1][j] > 0) ? dp[i - 1][j] : dp[i][j - 1];
                        dp[i][j] += tempValue;
                    }
                    //System.out.println("Value:: " + dp[i][j]);
                    //System.out.println("IIJJ: " + temp + "  dp[i][j]: " + dp[i][j] + ";  i: " + i + ";  j: = " + j);
                } else if (i > 0) {

                    if ((dp[i][j] > 0) && (dp[i - 1][j] > 0)) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    //System.out.println("IIII: " + temp + "  dp[i][j]: " + dp[i][j] + ";  i: " + i + ";  j: = " + j);
                } else if (j > 0) {
                    if ((dp[i][j] == 1) && (dp[i][j - 1] == 1)) {
                        dp[i][j] += dp[i][j - 1];
                    }
                    //System.out.println("JJJJ: " + temp + "  dp[i][j]: " + dp[i][j] + ";  i: " + i + ";  j: = " + j);
                } else {
                    //System.out.println("NULL: " + temp + "  dp[i][j]: " + dp[i][j] + ";  i: " + i + ";  j: = " + j);
                }
            }
        }
        return finalDestination;
    }

    public int getMinimumTransportPort(List<List<Integer>> area) {
        boolean isFirst = false;
        boolean isFinal = false;
        int initialValue = 1;
        int finalValue = 0;

        int numColumns = area.size();

        for (List<Integer> ll : area) {
            for (int i = 0; i < numColumns; i++) {
                if (isFirst) {
                    if (ll.get(i) == 1) {
                        initialValue++;
                    } else if (ll.get(i) == 9) {
                        if (!isFinal) {
                            finalValue = initialValue;
                        }
                        isFinal = true;
                    }
                }
                isFirst = true;
            }
        }
        return finalValue;
    }

    public static void main(String[] args) {
        TransportSystem transportSystem = new TransportSystem();
    }
}
