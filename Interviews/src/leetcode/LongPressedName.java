package leetcode;

public class LongPressedName {

    public static void main(String[] args){
        new LongPressedName();
    }

    public LongPressedName(){
        System.out.println(isLongPressedName("alex", "aaleexa" ));
    }
    public boolean isLongPressedName(String name, String typed) {


        int i=0,j=0;

        char[] nameChar = name.toCharArray();
        char[] typeChar = typed.toCharArray();

        if ((nameChar.length==0) || (typeChar.length==0) || (nameChar[0]!=typeChar[0])){
            return false;
        }

        while (j<typeChar.length){
            if ((i<nameChar.length) && (nameChar[i]==typeChar[j])){
                i++;
                j++;
            }
            else if (typeChar[j]==nameChar[i-1]){
                j++;
            }
            else{
                return false;
            }
        }

        return i == nameChar.length;
        //return true;

    }
}
