import java.util.*;

class Edge{
        int u, v ,w ;
        public Edge(int u, int v , int w){
            this.u = u;
            this.v = v;
            this.w = w;
        }
    };

class Graph{
    int V, E;
    LinkedList<Edge> edges;

    public Graph(){
        edges = new LinkedList<Edge>();
    }

    public void read(){

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();

        for(int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            Edge e = new Edge(u, v, w);

            edges.add(e);
        }
        sc.close();
    }
}