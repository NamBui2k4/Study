import java.util.*;

public class Traversal {
    public static void dfs(AM g, int src) {
        boolean[] visited = new boolean[g.V]; // F
        int[] parent = new int[g.V]; // 0
        parent[src] = -1;
        dfs(src, visited, g, parent);
    }

    private static void dfs(int u, boolean[] visited, AM g, int[] parent) {
        System.out.println(u);
        visited[u] = true;
        for (int i = 0; i < g.V; i++) {
            if (g.am[u][i] > 0 && !visited[i]) {
                parent[i] = u;
                dfs(i, visited, g, parent);
            }
        }
    }

    public static void bfs(AL g, int src) {
        boolean[] visited = new boolean[g.V]; // F
        int[] parent = new int[g.V]; // 0
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(src);
        visited[src] = true;
        parent[src] = -1;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            System.out.print(u + " ");
            for (Integer t : g.al[u]) {
                if (!visited[t]) {
                    queue.offer(t);
                    visited[t] = true;
                    parent[t] = u;
                }
            }
        }
        System.out.println();
        System.out.println(Arrays.toString(parent));
    }

    public static boolean isReachable(AL g, int s, int v) {
        boolean[] visited = new boolean[g.V];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            // System.out.print(u + " ");
            for (Integer t : g.al[u]) {
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
        // AM g = new AM();
        // g.read();
        // g.print();
        // dfs(g, Integer.parseInt(args[0]));

        AL g = new AL();
        g.read();
        g.print();
        bfs(g, Integer.parseInt(args[0]));
        System.out.println(isReachable(g, 0, 6));
    }
}
