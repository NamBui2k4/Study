public class AVL {
    private Node root;
    
    public int getHeightNode(Node node) {
        if (node == null)
            return -1;
        return node.height;
    }
   
    public int getHeight(Node x){
        if(x == null){
            return -1;
        }
        int a = getHeight(x.left);
        int b = getHeight(x.right);
        return a > b ? a + 1  : b + 1;
    }
    public int getHeight(){
        return getHeight(root);
    }

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

    public Node insert(Integer key) {
        root = insert(root, key);
        return root;
    }

    public int checkBalance(Node x) {
        return getHeight(x.left) - getHeight(x.right);
    }

    public int checkBalance() {
        return checkBalance(root);
    }

    public Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        return y;
    }

    public void rotateLeft() {
        rotateLeft(root);
        return;
    }

    public Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = 1 + Math.max(getHeight(x.right), getHeight(x.left));
        y.height = 1 + Math.max(getHeight(y.right), getHeight(y.left));
        return y;
    }

    public void rotateRight() {
        rotateRight(root);
        return;
    }

    public Node balance(Node x) {
        if (checkBalance(x) < -1) {
            if (checkBalance(x.right) > 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        } else if (checkBalance(x) > 1) {
            if (checkBalance(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    }
    public int calSumEvenNode(Node x) {
        if(x == null) return 0;
        int temp = calSumEvenNode(x.left) + calSumEvenNode(x.right);
        return (x.key % 2 == 0) ? x.key + temp : temp;
    }
    public int calSumEvenNode() {
        return calSumEvenNode(root);
    }

    public int calSumEvenLeaf(Node x){
        if(x == null) return 0;
        int temp = calSumEvenLeaf(x.left) + calSumEvenLeaf(x.right);
        return (x.key % 2 == 0 && x.left == null && x.right == null) ? x.key + temp : temp;   
    }
    public int calSumEvenLeaf(){
        return calSumEvenLeaf(root);
    }
    public static void main(String[] args) {
        AVL a = new AVL();
        for (String i : args) {
            a.insert(Integer.parseInt(i));
        }
        System.err.println(a.calSumEvenLeaf());
        a.NLR();
        System.out.println();
        System.out.println(" height: " + a.getHeight());
    }

    public void NLR(Node x) {
        if (x != null) {
            System.out.print(x.key + " ");
            NLR(x.left);
            NLR(x.right);
        }
    }

    public void NLR() {
        NLR(root);
        return;
    }
    public Node getRoot() {
        return root;
    }
}
