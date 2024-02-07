public class Main {
    public static void main(String[] args) {
        AL g = new AL();
        g.read();
     
        Traversal a = new Traversal();
        a.bfs(g, 5);
    }
}
