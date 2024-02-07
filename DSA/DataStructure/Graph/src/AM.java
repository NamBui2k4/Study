import java.util.Scanner;

class AM extends Graph{
    int[][] am;

    @Override
    public void read() {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        am = new int[V][V];
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                am[i][j] = sc.nextInt();
            }
        }
        sc.close();
    }

    @Override
    public void print() {
        System.out.println(V + ", " + E);
        for(int i = 0; i < V; i++) {
            for(int j = 0; j < V; j++) {
                System.out.printf("%-3d", am[i][j]);
            }
            System.out.println();
        }
    }

    @Override
    public boolean isAdjacent(int u, int v) {
        return am[u][v] > 0;
    }
    
}
