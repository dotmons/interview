package random;

import java.util.LinkedHashMap;
import java.util.NavigableMap;
import java.util.TreeMap;

public class MapExamples {
    public MapExamples() {
        NavigableMap<Integer,String> map=new TreeMap<Integer,String>();

        map.put(100,"Amit");
        map.put(102,"Ravi");
        map.put(101,"Vijay");
        map.put(103,"Rahul");
        //Maintains descending order
        System.out.println("descendingMap: "+map.descendingMap());
        //Returns key-value pairs whose keys are less than or equal to the specified key.
        System.out.println("headMap: "+map.headMap(102,true));
        //Returns key-value pairs whose keys are greater than or equal to the specified key.
        System.out.println("tailMap: "+map.tailMap(102,true));
        //Returns key-value pairs exists in between the specified key.
        System.out.println("subMap: "+map.subMap(100, false, 102, true));





        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(3, "Three");
        linkedHashMap.put(1, "One");
        linkedHashMap.put(2, "Two");

        System.out.println("LinkedHashMap: " + linkedHashMap);
        // Output: {3=Three, 1=One, 2=Two} (Maintains insertion order)
    }
    public static void main(String[] args) {
        new MapExamples();
    }
}
