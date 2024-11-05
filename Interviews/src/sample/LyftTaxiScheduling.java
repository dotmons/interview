package sample;

import java.util.Objects;

public class LyftTaxiScheduling {

    int n = 10;
    int[] cabTravelTime = {1, 3, 5, 7, 8};

    public LyftTaxiScheduling() {

        if (cabTravelTime.length>0){
            int mult = n * cabTravelTime[0];

            for (int i=cabTravelTime.length-1;i>=0;i--){

                getTaxiTime(mult, cabTravelTime[i]);

            }

        }
    }

    private int getTaxiTime(int mult, int value){
        int n = 1;

        while (value*n < mult){
            n++;
        }
        return n;
    }

    public static void main(String[] args) {
        LyftTaxiScheduling scheduling = new LyftTaxiScheduling();
    }
}
