import java.util.*;
class ListUsingArray<E> implements  ListInterface<E>{
    private static final int MAXIMIZE = 1000;
    private int num_node = 0;
    private E[] listArray = (E[]) new Object[MAXIMIZE];
    
    @Override
    public boolean isEmty() {
        return num_node == 0;
    }
    @Override
    public int size(){
        return num_node;
    }
    @Override
    public E getFirst() throws NoSuchElementException{
        if (num_node == 0)
            throw new NoSuchElementException("Can't get element in empty list");
        return listArray[0];
    }
    @Override
    public void addFirst(E item) throws IndexOutOfBoundsException{
        if(num_node == MAXIMIZE)
            throw new IndexOutOfBoundsException("can not add element in full list");
        for(int i = num_node - 1; i >= 0; i--)
            listArray[i+1] = listArray[i];
        num_node++;
        listArray[0] = item;
    }

    @Override
    public void print() {
        for (int i =0; i < num_node; i++)
            System.out.print(listArray[i] + " ");
    }
    @Override
    public void removeFirst() throws NoSuchElementException{
        if(num_node == 0)
            throw new NoSuchElementException("can't remove element in empty list");
        for(int i = 0; i < num_node - 1; i++)
            listArray[i] = listArray[i+1];
        listArray[num_node] = null;
    }
    @Override
    public boolean contains(E item){
        for(E element : listArray){
            if (element.equals(item)) return true;
        }
        return false;
    }


}