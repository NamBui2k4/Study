abstract class Graph {
    int V, E;

    public abstract void read();
    public abstract void print();
    public abstract boolean isAdjacent(int u, int v);
}