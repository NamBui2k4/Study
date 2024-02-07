public class BST {
    
    private Node root;

    public Node insert(Node x, Integer key) {
        if (x == null)
            return new Node(key);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = insert(x.left, key);
        else if (cmp > 0)
            x.right = insert(x.right, key);
        else
            x.key = key;
        return x;
    }

    public void NLR(Node x) {
        if (x != null) {
            System.out.print(x.key + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    public void LNR(Node x) {
        if (x != null) {
            NLR(x.left);
            System.out.print(x.key + " ");
            NLR(x.right);
        }
    }

    public void LRN(Node x) {
        if (x != null) {
            NLR(x.left);
            NLR(x.right);
            System.out.print(x.key + " ");
        }
    }

    public Node search(Node x, Integer key) {
        if (x == null)
            return null;

        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return search(x.left, key);
        else if (cmp > 0)
            return search(x.right, key);
        else
            return x;
    }

    public Node min(Node x) {
        if (x.left == null)
            return x;
        else
            return min(x.left);
    }

    public Node max(Node x) {
        if (x.right == null)
            return x;
        else
            return min(x.right);
    }

    public Node deleteMin(Node x) {
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    public Node delete(Node x, Integer key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            // node with only one child or no child
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;

            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
        }
        return x;
    }
}
