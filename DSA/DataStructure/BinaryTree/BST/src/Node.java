public class Node {
    private Integer key;
    private Node left, right;

    public Node(Integer key) { // create leaf node or root(when the tree is empty)
        this.key = key;
        this.left = this.right = null; 
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    
}