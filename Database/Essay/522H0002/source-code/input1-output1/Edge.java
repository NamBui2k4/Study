public class Edge {
    int u, // dinh u
        v; // dinh v
    String qh; // quan he

    public Edge(int u, int v, String qh) {
        this.u = u;
        this.v = v;
        this.qh = qh;
    }

    @Override
    public String toString() {
        return String.format("(%d, %d, %s)",
        u, v, qh);
    }
}
