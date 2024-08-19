package sample;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BfsLearning {

    public BfsLearning() {
    Graphs g = new Graphs(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);


        g.tranverse(0);


    }


    public static void main(String[] args) {
        new BfsLearning();
    }

}

class Graphs{
    int vertices;
    LinkedList[] adjacentList;

    public Graphs(int vertices){
        this.vertices = vertices;
        adjacentList = new LinkedList[vertices];

        for (int i=0; i<vertices; i++){
            adjacentList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int vertices, int neighbor){
       adjacentList[vertices].add(neighbor);
    }

    public void tranverse(int start){
        Queue<Integer> queue = new LinkedList<Integer>();

        boolean[] checked = new boolean[vertices];
        for (int i=0; i<vertices; i++){
            checked[i] = false;
        }

        checked[start] = true;
        queue.add(start);

        while (!queue.isEmpty()){
            int vert = queue.poll();
            System.out.println("Removed Vert: "  + vert);
            Iterator it = adjacentList[vert].listIterator();

            while (it.hasNext()){
                int neig = (int)it.next();
                if (!checked[neig]){
                    queue.add(neig);
                    checked[neig] = false;
                }
            }
        }

    }
}

    /*
    0 (Start)
   / \
  1   2
 / \   \
3   4   5
*/