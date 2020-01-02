/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interview.Interviews.src.hackerrank;

import Training.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Dotmons
 */
public class Applyboard {

    public Applyboard() {
        List<String> s = new ArrayList<String>();
        s.add("code");
        s.add("aaagmrs");
        s.add("anagrams");
        s.add("doce");

        List<String> ss = funWith(s);

        for (String d : ss) {
            //System.out.println(d);
        }

    }

    public static List<String> funWith(List<String> s) {

        //Collections.sort(s);
        
        for (int i=0; i<s.size(); i++){
            
            for (int j=1; j<s.size(); j++){
                
               if (s.get(i).equals(new StringBuilder(s.get(j)).reverse().toString())){
                   System.out.println(s);
                  // s.remove(i);
                  // s.remove(j);
               }
            }
          
        }
        
        return s;
    }

    public static void main(String[] args) {
        new Applyboard();
    }
}
