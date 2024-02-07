public class Edge {
    int u, // src
        v, // dest
        w; // weight

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %d)",
        u, v, w);
    }
}
