class MyStack<E> implements StackADT<E> {
    private Node<E> top;
    private int numNode;

    public MyStack(){
        top = null;
        numNode = 0;
    }
    @Override // getFirst
    public E getPeek() throws java.util.NoSuchElementException{
        if(top==null)
            throw new java.util.NoSuchElementException("list is empty");
        return top.getData();
    }

    @Override // addFirst
    public void push(E item){
        top = new Node(item,top);
        numNode++;
    }
    @Override // removeFirst
    public E pop() throws java.util.NoSuchElementException{
        if(top==null)
            throw  new java.util.NoSuchElementException("list is empty");

        Node<E> temp = top;
        top = top.getNext();
        numNode--;
        return temp.getData();
    }

    @Override
    public boolean isEmpty(){
        return (numNode == 0);
    }

    @Override
    public int size(){
        return numNode;
    }
    @Override
    public void print() {
        if (top != null) {
            Node<E> tmp = top;
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
    @Override
    public boolean contains(E item){
        for(Node<E> n = top ; n!=null ; n = n.getNext()){
            if(n.getData().equals(item)){
                return true;
            }
        }
        return false;
    }
}