import java.util.LinkedList;

public class BellmanFord {
    void findShortestPath(Graph graph, int start){
        int V = graph.V, E = graph.E;
        int distance[] = new int[V];
        int parent[] = new int[V];
        
        if (start > V){
            System.out.println("Unavailable vertex");
            return;
        }

        // Step 1: initialize weights and parents of vertices
        for(int i = 0; i < V; i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[start] = 0;
        parent[start] =  -1;

        // Step 2: Relax all edges "N - 1 times
        //  each time we traverse edges
        for(int j = 0; j < V - 1 ; j++){
            for(int i = 0; i < E; i++){
                int u = graph.edges.get(i).u;
                int v = graph.edges.get(i).v;
                int w = graph.edges.get(i).w;

                if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]){
                    distance[v] = distance[u] + w;

                    if(v != start){
                        parent[v] = u;
                    }
                }
                
            }   
        }
        
        // Step 3: check for negative-weight cycles. The
        // above step guarantees shortest distanceances if graph
        // doesn't contain negative weight cycle. If we get
        // a shorter path, then there is a cycle.
        for(int i = 0; i < E; i++){  
            int u = graph.edges.get(i).u;
            int v = graph.edges.get(i).v;
            int w = graph.edges.get(i).w;
            
            if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]){
                System.out.println(
                    "Graph contains negative weight cycle");
                return;
            } 
        }   

        // Step 4: Print the results
        LinkedList<Integer>[] results = new LinkedList[V];
        for(int i = 0; i < results.length; i++){
            results[i] = new LinkedList<Integer>();
            buildPath(parent, i, results[i]);
            System.out.println("from " + start + " to " + i + ": " + results[i] + "\t total cost: " + distance[i]);
        }
    }   

    void buildPath(int parent[], int current, LinkedList<Integer> path){
        if(current != -1){
            buildPath(parent, parent[current], path);
            path.add(current);
        }
    }
}

