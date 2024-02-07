public class UFDS{
    int[] rank, parent;
    int n;
 
    // Constructor
    public UFDS(int n)
    {
        rank = new int[n];
        parent = new int[n];
        this.n = n;
        makeSet();
    }
 
    // Creates n sets with single item in each
    void makeSet()
    {
        for (int i = 0; i < n; i++) {
            // Initially, all elements are in
            // their own set.
            parent[i] = i;
        }
    }
 
    // Returns representative of x's set
    int find(int x)
    {
        // Finds the representative of the set
        // that x is an element of
        if (parent[x] != x) {
            // if x is not the parent of itself
            // Then x is not the representative of
            // his set,
            parent[x] = find(parent[x]);
 
            // so we recursively call Find on its parent
            // and move i's node directly under the
            // representative of this set
        }
 
        return parent[x];
    }
 
    // Unites the set that includes x and the set
    // that includes x
    void union(int x, int y)
    {
        // Find representatives of two sets
        int xRoot = find(x), yRoot = find(y);
 
        // Elements are in the same set, no need
        // to unite anything.
        if (xRoot == yRoot)
            return;
 
        // If x's rank is less than y's rank
        if (rank[xRoot] < rank[yRoot])
 
            // Then move x under y  so that depth
            // of tree remains less
            parent[xRoot] = yRoot;
 
        // Else if y's rank is less than x's rank
        else if (rank[yRoot] < rank[xRoot])
 
            // Then move y under x so that depth of
            // tree remains less
            parent[yRoot] = xRoot;
 
        else // if ranks are the same
        {
            // Then move y under x (doesn't matter
            // which one goes where)
            parent[yRoot] = xRoot;
 
            // And increment the result tree's
            // rank by 1
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
    public String toString(int temp){
        if (temp == 0)
            return parent[0] + " ";
        return toString(temp - 1) + " " + parent[temp] ;
    }
    public String toString() {
        return toString(n - 1);
    }

    public String rank(int temp){
        if (temp == 0)
            return rank[0] + " ";
        return rank(temp - 1) + " " + rank[temp] ;
    }
    public String rank() {
        return rank(n - 1);
    }
    
    public static void main(String[] args){
        UFDS a = new UFDS(Integer.parseInt(args[0]));
        System.out.println("do nothing: " + "parents: " + a.toString() + ", rank: " + a.rank());

        a.union(0, 2);
        System.out.println("union(0, 2) -> " + "parents: " + a.toString() + ", rank: " + a.rank());
        int xRoot = a.find(4);
        System.out.println(xRoot);
        int yRoot = a.find(2);
        System.out.println(yRoot);
        System.out.println(a.rank[xRoot]);
        System.out.println(a.rank[yRoot]);
        System.err.println(a.rank[xRoot] > a.rank[yRoot]);


        a.union(4, 2);
        System.out.println("union(4, 2) -> " + "parents: " + a.toString() + ", rank: " + a.rank());

        a.union(3, 1);
        System.out.println("union(3, 1) -> " + "parents: " + a.toString() + ", rank: " + a.rank());
        if (a.find(4) == a.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
 
        // Check if 1 is a friend of 0
        if (a.find(1) == a.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    
    }
}