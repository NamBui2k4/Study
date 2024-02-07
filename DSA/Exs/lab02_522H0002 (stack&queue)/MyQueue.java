class MyQueue<E> implements QueueInterface<E>{
    private Node<E> front;
    private Node<E> rear;
    private int numNode;
    public MyQueue(){
        front = null;
        rear = null;
        numNode = 0;
    }

    @Override // addLast
    public void enQueue(E item){
        if(numNode==0){
            front = new Node(item,rear);
            numNode++;
            return;
        }
        Node<E> temp = front;
        while (temp.getNext()!=null){
            temp = temp.getNext();
        }
        rear = new Node(item,null);
        temp.setNext(rear);
        numNode++;
        return;
    }

    @Override // removeFirst
    public E deQueue() throws java.util.NoSuchElementException{
        if(numNode == 0)
            throw new java.util.NoSuchElementException("List is empty");
        Node<E> temp = front;
        front = front.getNext();
        numNode--;
        return  temp.getData();
    }
    @Override
    public boolean isEmpty(){
        return (numNode == 0);
    }
    @Override
    public void print() {
        if (front != null) {
            Node<E> tmp = front;
            System.out.print("List: " + tmp.getData() + " | ");
            tmp = tmp.getNext();
            while (tmp != null) {
                System.out.print(tmp.getData() + " | ");
                tmp = tmp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("List is empty!");
        }
    }
    @Override // getFirstl
    public E getFront(){
        return front.getData();
    }
    @Override
    public boolean contains(E item){
        for(Node<E> n = front ; n!=null ; n = n.getNext()){
            if(n.getData().equals(item)){
                return true;
            }
        }
        return false;
    }
    @Override
    public int size(){
        return numNode;
    }
}