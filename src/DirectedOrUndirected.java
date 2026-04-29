/*
4 (code) Directed or undirected [10 points] Write a program that takes the adjacency matrix
representation of a graph with n nodes as input and determines whether that matrix is the representation
of a weakly connected graph.
 */
import java.util.LinkedList;
import java.util.Queue;
public class DirectedOrUndirected {
    public static boolean isWeaklyConnected(int[][] graph){
        int n = graph.length;

        if (n == 0){
            return true;
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()){
            int current = queue.remove();
            for(int neighbor = 0; neighbor < n; neighbor++){
                if((graph[current][neighbor] == 1 || graph[neighbor][current] == 1) && !visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[][] graph1 = {
                {0,1,0},
                {0,0,1},
                {0,0,0}
        };
        int[][] graph2 = {
                {0,1,0},
                {0,0,0},
                {0,0,0}
        };
        System.out.println(isWeaklyConnected(graph1));
        System.out.println(isWeaklyConnected(graph2));
    }
}
