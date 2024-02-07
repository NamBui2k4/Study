import java.util.NoSuchElementException;

public interface ListInterface<E> {
    void addFirst(E item);
    void addAfter(Node<E> curr, E item);
    void addLast(E item);

    E removeFirst() throws NoSuchElementException;
    E removeAfter(Node<E> curr) throws NoSuchElementException;
    E removeLast() throws NoSuchElementException;

    E removeCurr(Node<E> curr) throws NullPointerException, NoSuchElementException;

    void print();
    boolean isEmpty();
    E getFirst() throws NoSuchElementException;
    Node<E> getHead();
    int size();
    boolean contains(E item);
}