package goog;

import java.util.Objects;

public class MetaString {

    public MetaString(){
        System.out.println(isMetaString("geeks", "keegs"));
        System.out.println(isMetaString("abcd", "bacd"));
        System.out.println(isMetaString("python", "typhon"));
        System.out.println(isMetaString("apple", "paple"));

        System.out.println(isMetaString("hello", "ohell"));
        System.out.println(isMetaString("python", "python"));
        System.out.println(isMetaString("abcd", "bcda"));
        System.out.println(isMetaString("apple", "aplle"));

    }
    public boolean isMetaString(String original, String altValue) {
        char tempA = 0;
        char tempB = 0;

        if ((original.length()!=altValue.length()) || (original.equals(altValue))){
            return false;
        }
        int count=0;
        for (int i = 0; i < original.length(); i++) {
            if(count>2)
                return false;
            if (original.charAt(i)!=altValue.charAt(i)){
                if ((count>1) && ((original.charAt(i)!=tempB) || (altValue.charAt(i)!=tempA))) {
                    return false;
                }
                tempA = original.charAt(i);
                tempB = altValue.charAt(i);
                count++;
            }
        }

        return count != 1;
    }
    public static void main(String[] args) {
        new MetaString();
    }
}
