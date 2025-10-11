package sample;

import java.util.ArrayList;

public class Bigram {

    public Bigram(){
        String sentence = """
                Have free hours and love children?
                Drive kids to school, soccer practice
                and other activities.
                """;

        ArrayList<String> content = new ArrayList<>();

        int k = 0;
        for (String res : sentence.split(" ")) {
            System.out.println(res + " ::: " + k);
            content.add(res);
            k++;

        }

        for (int i=0; i<content.size(); i++){
           // System.out.println(content.get(i) + " :: " + i);
            if (i!=0)
            {
               // System.out.println(content.get(i-1) + ", " + content.get(i));
            }
        }

    }

    public static void main(String[] args) {
        new Bigram();
    }
}
