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

        System.out.println("The minimum transport move is: " + getMinimumTransportPort(area));
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
