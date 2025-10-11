package random;

public class BubbleSort {





    public BubbleSort(){


        //[2,9,3,6,9]
        int[] value = {12,9,3,6,1};

        //9,12,3,6,1
        //9,3,12,6,1
        //9,3,6,12,1
        //9,3,6,1,12


        //3,9,6,1,12
        //3,6,9,1,12
        //3,6,1,9,12
        //3,6,1,9,12

        //3,6,1,9,12
        //3,1,6,9,12
        //3,1,6,9,12
        //3,1,6,9,12

        //1,3,6,9,12
        //1,3,6,9,12
        //1,3,6,9,12
        //1,3,6,9,12

        //1,3,6,9,12
        //1,3,6,9,12
        //1,3,6,9,12
        //1,3,6,9,12









        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value.length - i - 1; j++) {
                if (value[j] > value[j + 1]) {
                    int tmp = value[j];
                    value[j] = value[j + 1];
                    value[j + 1] = tmp;

                }
            }
        }
    }



}
