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
public final class TransportSystem {

    public TransportSystem() {

        System.out.println(getMinimumTransportPortPost(testCaseA()));
        System.out.println(getMinimumTransportPortPost(testCaseB()));
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

                if (dp[i][j] == 9) {

                    if (i > 0 && j > 0) {
                        int tempValue = (dp[i - 1][j] > 0) ? dp[i - 1][j] : dp[i][j - 1];
                        finalDestination = tempValue > 0 ? tempValue : -1;
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
                } else if (i > 0) {
                    if ((dp[i][j] > 0) && (dp[i - 1][j] > 0)) {
                        dp[i][j] += dp[i - 1][j];
                    }
                } else if (j > 0) {
                    if ((dp[i][j] == 1) && (dp[i][j - 1] == 1)) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }
        }
        return finalDestination;
    }

    public List<List<Integer>> testCaseA() {
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

        return area;
    }

    public List<List<Integer>> testCaseB() {
        List<List<Integer>> area = new ArrayList<>();
        List<Integer> listValues = new ArrayList();
        listValues.add(1);
        listValues.add(1);
        listValues.add(1);
        listValues.add(1);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(0);
        listValues.add(1);
        listValues.add(1);
        listValues.add(1);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(0);
        listValues.add(1);
        listValues.add(0);
        listValues.add(1);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(1);
        listValues.add(1);
        listValues.add(9);
        listValues.add(1);
        area.add(listValues);

        listValues = new ArrayList();
        listValues.add(0);
        listValues.add(0);
        listValues.add(1);
        listValues.add(1);
        area.add(listValues);

        return area;
    }

    public static void main(String[] args) {
        TransportSystem transportSystem = new TransportSystem();
    }
}
