package leetcode;

public class MinDominoRotations {

    public MinDominoRotations() {
        int [] tops =    {5,1,2,4,2,2};
        int [] bottoms = {2,2,6,2,3,2};

        System.out.println(minDominoRotations(tops,bottoms));
    }
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int result = check(tops[0], tops, bottoms);
        if (result != -1 || tops[0] == bottoms[0]) {
            return result;
        } else {
            return check(bottoms[0], tops, bottoms);
        }
    }

    private int check(int key, int[] tops, int[] bottoms) {
        int rotationsTops = 0;
        int rotationsBottoms = 0;

        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != key && bottoms[i] != key) {
                return -1;
            } else if (tops[i] != key) {
                rotationsTops++;
            } else if (bottoms[i] != key) {
                rotationsBottoms++;
            }
        }

        return Math.min(rotationsTops, rotationsBottoms);
    }

    public static void main(String[] args) {
        new MinDominoRotations();
    }
}
