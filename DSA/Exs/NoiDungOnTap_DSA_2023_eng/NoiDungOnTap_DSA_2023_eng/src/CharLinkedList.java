class CharLinkedList implements ListInterface {
    private Node head;

    public CharLinkedList() {
    }

    @Override
    public Node getHead() {
        return  head;
    }

    @Override
    public void addFirst(char data) {
        head = new Node(data,head);
    }

    @Override
    public boolean addAfterFirstKey(char data, char key) {
        boolean checkSuccess = false;
        for(Node i = head ; i != null; i = i.getNext()){
            if(i.getData() == data){
                Node temp = new Node(key,i.getNext());
                i.setNext(temp);
                return true;
            }
        }

        return checkSuccess;
    }

    @Override
    public int largestCharPostition() {

        int count = 0;
        char temp = head.getData();
        for(Node i = head ; i != null ; i = i.getNext()){
            if(temp < i.getData()){
                temp = i.getData();
                count++;
            }
        }
        return count;
    }
    public static void main(String[]args){
        CharLinkedList a = new CharLinkedList();
        a.addFirst('c');
        a.addFirst('b');
        a.addFirst('A');
        for(Node i = a.getHead() ; i != null ; i = i.getNext()){
            System.out.print(i.getData() + " ");
        }

        a.addAfterFirstKey('b', 'E');
        System.out.println(" ");
         for(Node i = a.getHead() ; i != null ; i = i.getNext()){
            System.out.print(i.getData() + " ");
        }
    }
}
