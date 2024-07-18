package leetcode;

public class Strobogrammatic {
    //Remains the same when rotated by 180 degrees.	69, 818, 1001

    public Strobogrammatic() {
        String value = "9696";

        System.out.println(isStobogrammatic(value));
    }

    boolean isStobogrammatic(String value){


        int k = value.length() - 1;
        for (int i = 0; i < value.length()/2; i++) {

            if (!checkNum(value.charAt(i)).equals(String.valueOf(value.charAt(k)))) {
                return false;
            }
            k--;
        }
        if (value.length()%2 != 0){
            char midValue = value.charAt(value.length()/2);
            return midValue == '1' || midValue == '8' || midValue == '0';
        }

        return true;
    }

    private String checkNum(char a){

        if (a=='6'){
            return "9";
        }
        else if (a=='9'){
            return "6";
        }
        else if (a=='0'){
            return "0";
        }
        else if (a=='1'){
            return "1";
        }
        else if (a=='8'){
            return "8";
        }
        return String.valueOf(a);
    }

    public static void main(String[] args) {
        new Strobogrammatic();
    }
}
