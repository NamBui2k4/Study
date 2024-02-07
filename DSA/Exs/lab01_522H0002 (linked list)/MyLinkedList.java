import java.util.NoSuchElementException;
public class MyLinkedList<E> implements ListInterface<E> {
    private Node<E> head;
    private int numNode;

    @Override
    public void addFirst(E item) {
        head = new Node<E>(item, head);
        numNode++;
    }

    @Override
    public void addAfter(Node<E> curr, E item) {
        if (curr == null) { // danh sach trong
            addFirst(item);
        } else {
            Node<E> newNode = new Node<E>(item, curr.getNext());
            curr.setNext(newNode);
            numNode++;
        }

    }

    @Override
    public void addLast(E item) {
        if (head == null) {
            addFirst(item);
        } else {
            Node<E> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            Node<E> newNode = new Node<E>(item, null);
            tmp.setNext(newNode);
            numNode++;
        }
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        } else {
            Node<E> tmp = head;
            head = head.getNext();
            numNode--;
            return tmp.getData();
        }
    }

    @Override
    public E removeAfter(Node<E> curr) throws NoSuchElementException {
        if (curr == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        } else {
            Node<E> delNode = curr.getNext();
            if (delNode != null) {
                curr.setNext(delNode.getNext());
                numNode--;
                return delNode.getData();
            } else {
                throw new NoSuchElementException("No next node to remove");
            }
        }
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't remove element from an empty list");
        } else {
            Node<E> preNode = null;
            Node<E> delNode = head;
            if (delNode.getNext() == null) {
                return removeFirst();
            }
            while (delNode.getNext() != null) {
                preNode = delNode;
                delNode = delNode.getNext();
            }
            preNode.setNext(delNode.getNext());
            numNode--;
            return delNode.getData();
        }
    }

    @Override
    public void print() {
        if (head != null) {
            Node<E> tmp = head;
            System.out.print("List: " + tmp.getData());
            tmp = tmp.getNext();
            while (tmp != null) {
                System.out.print(" -> " + tmp.getData());
                tmp = tmp.getNext();
            }
            System.out.println();
        } else {
            System.out.println("List is empty!");
        }
    }

    @Override
    public boolean isEmpty() {
        return numNode == 0;
    }

    @Override
    public E getFirst() throws NoSuchElementException {
        if (head == null) {
            throw new NoSuchElementException("Can't get element from an empty list");
        } else {
            return head.getData();
        }
    }

    @Override
    public Node<E> getHead() {
        return head;
    }

    @Override
    public int size() {
        return numNode;
    }

    @Override
    public boolean contains(E item) {
        Node<E> tmp = head;
        while (tmp != null) {
            if (tmp.getData().equals(item))
                return true;
            tmp = tmp.getNext();
        }
        return false;
    }


    @Override
    public E removeCurr(Node<E> curr) throws NullPointerException, NoSuchElementException {
        if (curr == null)
            throw new NullPointerException("can not remove null ");
        if (numNode == 0)
            throw new NoSuchElementException("can not remove element in empty list");
        if (curr == head){
            removeFirst();
            return head.getData();
        }
        Node<E> pre = null;
        Node<E> delete = head;
        while (delete != curr){
            pre = delete;
            delete = delete.getNext();
        }
        pre.setNext(curr.getNext());
        return curr .getData();
    }

    public Node<E> getCurr(E item) throws NoSuchElementException{
        for(Node<E> n = getHead(); n!=null; n = n.getNext()){
            if(n.getData().equals(item))
                return n;
        }
        throw new java.util.NoSuchElementException("no element founded");

    }

    public void reverse(){
        Node<E> prev = null;
        Node<E> curr = head ;
        Node<E> next = null;
        while (curr != null) {
            next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }
    public E insertAt(E key, int i ){
        int count = 0;
        Node<E> pre = null;
        Node<E> curr = head;
        while(count != i){
            if(head == null){
                head = new Node<E>(key,head);
                return null;  
            }
            if(curr == null){
                Node<E> n = new Node<E>(key, curr);
                pre.setNext(n);
                return pre.getData();
            }

            pre = curr;
            curr = curr.getNext();
            count++;
        }
        Node<E> n  = new Node<E>(key,curr.getNext());
        curr.setNext(n);
        return curr.getData();
    }
}
