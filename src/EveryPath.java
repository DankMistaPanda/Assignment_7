/*
5 (code) Every path [10 points] Write a program that takes as input a directed weighted graph and prints
every cycle of length 4 within the graph.
 */
import java.util.HashSet;
import java.util.Set;
public class EveryPath {
    public static void everyCycle(int[][] graph){
        int n = graph.length;

        Set<String> printed = new HashSet<>();

        for(int a = 0; a < n; a++){
            for(int b = 0; b < n; b++){
                for(int c = 0; c < n; c++){
                    for (int d = 0; d < n; d++){

                        if(a != b && a != c && a != d && b!= c && b != d && c != d){
                            if(graph[a][b] > 0 && graph[b][c] > 0 && graph[c][d] > 0 && graph[d][a] > 0){
                                String cycle = a + " -> " + b + " -> " + c + " -> " + d + " -> " + a;

                                String key = getKey(a,b,c,d);
                                if(!printed.contains(key)){
                                    printed.add(key);
                                    System.out.println(cycle);
                                }
                            }
                        }
                    }
                }
            }
        }
    }//end everyCyle
    private static String getKey(int a, int b, int c, int d){
        int[] cycle = {a, b, c, d};
        String smallest = "";
        for(int start = 0; start < 4; start ++){
            String current = "";
            for(int i = 0; i < 4; i++){
                current += cycle[(start + i) % 4] + ",";
            }
            if(smallest.equals("") || current.compareTo(smallest) < 0){
                smallest = current;
            }
        }
        return smallest;
    }

    public static void main(String[] args){
        int[][] graph = {
                {0,1,0,0,0},
                {0,0,1,0,0},
                {0,0,0,1,0},
                {1,0,0,0,1},
                {0,1,0,0,0}
        };
        everyCycle(graph);
    }
}//end EveryPath
