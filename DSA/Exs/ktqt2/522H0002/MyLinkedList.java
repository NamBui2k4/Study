class MyLinkedList implements ListInterface {
    Node head;
    
    public Node getHead() {
        return head;
    }

    @Override
    public int sum(){
        if(head ==  null)
            return 0;
        int sum = 0;
        Node temp = getHead();
        while(temp != null){
            sum+= temp.getData();
            temp = temp.getNext();
        }
        return sum;
    }
    @Override
    public int countAfter(Node n){
        if(n==null)
            return 0;
        Node temp = n.getNext();
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.getNext();
        }
        return count;

    }
    @Override
    public int countKey(int k){
       if(head ==  null)
            return 0;

        Node temp = getHead();
        int count = 0;
        while(temp != null){
            if(temp.getData() == k)
                count++;
            temp = temp.getNext(); 
        }
        return count;
    }
    public void print() {
        System.out.println("[");
        for(Node n = head; n != null; n = n.getNext()) {
            System.out.print(n.getData() + ", ");
        }
        System.out.println("]");
    }


    public static void main(String[] args) {
        MyLinkedList a = new MyLinkedList();
        a.print();
    }
}