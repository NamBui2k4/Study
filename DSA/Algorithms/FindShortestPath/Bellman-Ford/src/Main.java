public class Main {
    public static void main(String[] args) {
        Graph g = new Graph();
        g.read();
        BellmanFord a = new BellmanFord();
        a.findShortestPath(g,1);
    }
}
