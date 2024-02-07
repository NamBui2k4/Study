import java.util.*;

public class BFS {
   
    public static void bfs(AL graph, int src) {

        int numVertice = graph.V;
        
        // bitmask technique
        boolean[] visited = new boolean[numVertice]; // all F
        
        // 
        int[] parent = new int[numVertice];
        
        // create queue
        Queue<Integer> queue = new LinkedList<>();

        // add source vertice into queue
        queue.offer(src);

        // check source visited
        visited[src] = true;

        // source has no parent
        parent[src] = -1;

        while (!queue.isEmpty()) {

            // get vertice from queue
            int u = queue.poll();

            // print vertice
            System.out.print(u + " ");

            // add adjacent vertices into queue
            for (Integer t : graph.al[u]) {
                if (!visited[t]) {
                    queue.offer(t);
                    visited[t] = true;
                    parent[t] = u;
                }
            }
        }
        System.out.println();
        // System.out.println(Arrays.toString(parent));
    }

    public static boolean isReachable(AL graph, int s, int v) {

        int numVertice = graph.V;

        boolean[] visited = new boolean[numVertice];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            // System.out.print(u + " ");
            for (Integer t : graph.al[u]) {
                if (t == v) {
                    return true;
                }
                if (!visited[t]) {
                    queue.offer(t);
                    visited[t] = true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        AL g = new AL();
        g.read();
        bfs(g, Integer.parseInt(args[0]));
        // System.out.println(isReachable(g, 0, 6));
    }
}
