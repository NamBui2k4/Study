import java.util.*;

class AL extends Graph{
    LinkedList<Integer>[] al;

    @Override
    public void read() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        al = new LinkedList[V];
        for(int i = 0; i < V; i++) {
            al[i] = new LinkedList<>();
        }
        int u, v;
        for(int i = 0; i < E; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            
            al[u].add(v);
            al[v].add(u);
        }
        sc.close();
    }

    @Override
    public void print() {
        System.out.println(V + ", " + E);
        for(int i = 0; i < V; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < al[i].size(); j++) {
                if(j == al[i].size() - 1){
                    System.out.print( al[i].get(j) ); 
                    break;
                }
                System.out.print(al[i].get(j) + " -> ");    
            }
            System.out.print("\r\n");
        }
    }

    @Override
    public boolean isAdjacent(int u, int v) {
        return al[u].contains(v);
    }

}
