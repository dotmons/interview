package sample;

import java.util.*;

public class BfsExample {

    /*
    0 (Start)
   / \
  1   2
 / \   \
3   4   5
*/


    static class Graph {
        private int vertices; // Number of vertices
        private LinkedList[] adjacencyList; // Adjacency list

        // Constructor
        Graph(int vertices) {
            this.vertices = vertices;
            adjacencyList = new LinkedList[vertices];
            for (int i = 0; i < vertices; ++i)
                adjacencyList[i] = new LinkedList<>();
        }

        // Function to add an edge into the graph
        void addEdge(int vertex, int neighbor) {
            adjacencyList[vertex].add(neighbor);
        }

        // BFS traversal from a given source 'startVertex'
        void BFS(int startVertex) {
            boolean visited[] = new boolean[vertices]; // Mark all vertices as not visited

            Queue<Integer> queue = new LinkedList<>(); // Create a queue for BFS

            // Mark the current node as visited and enqueue it
            visited[startVertex] = true;
            queue.add(startVertex);

            while (queue.size() != 0) {
                // Dequeue a vertex from queue and print it
                startVertex = queue.poll();
                System.out.print(startVertex + " ");

                // Get all adjacent vertices of the dequeued vertex startVertex
                // If an adjacent has not been visited, then mark it visited and enqueue it
                Iterator<Integer> iterator = adjacencyList[startVertex].listIterator();
                while (iterator.hasNext()) {
                    int neighbor = iterator.next();
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }

        public static void main(String args[]) {
            Graph g = new Graph(6); // Initialize a graph with 6 nodes

            g.addEdge(0, 1);
            g.addEdge(0, 2);
            g.addEdge(1, 3);
            g.addEdge(1, 4);
            g.addEdge(2, 5);

            System.out.println("Following is Breadth First Traversal " +
                    "(starting from vertex 0)");

            g.BFS(0); // Perform BFS starting from vertex 0
        }
    }
}