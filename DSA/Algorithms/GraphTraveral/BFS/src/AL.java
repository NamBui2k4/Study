import java.util.*;

class AL{
    int V, E;
    LinkedList<Integer>[]al;

    public void read(){
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        
        al = new LinkedList[V];
        for(int i = 0 ; i < V ; i++){
            al[i] = new LinkedList<Integer>();
        }
        for(int i = 0; i < E; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();

            al[u].add(v);
            al[v].add(u);
        }
        sc.close();
    }
    public void print(){
        for(int i = 0; i < al.length; i++){
            System.out.print(i + ": " + al[i].toString() + "\r\n");
        }
    }
}
