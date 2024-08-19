package sample;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

public class EncodeDecode {
    public EncodeDecode() {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("hello");
        arr.add("world");
        System.out.println(encode(arr));
        System.out.println(decode("5#hello5#world").get(2));
    }

    public String encode(ArrayList<String> str) {
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append("5#");
            sb.append(s);
        }
        return sb.toString();
    }

    public ArrayList<String> decode(String str) {
        ArrayList<String> arr = new ArrayList<>();
        for (String s : str.split("5#")) {
           if (Objects.nonNull(s))
               arr.add(s);
        }
        return arr;

    }

    public static void main(String[] args) {
        new EncodeDecode();
    }
}
