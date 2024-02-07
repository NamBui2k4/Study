class Node {
    int data;
    Node next;

    public Node() {}

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(int key) {
        this.data = key;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}