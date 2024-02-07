import java.util.*;
public interface ListInterface<E> {
    public boolean isEmty();
    public int size();
    public E getFirst();
    public boolean contains(E item);
    public void addFirst(E item);
    public void removeFirst();
    public void print();
}