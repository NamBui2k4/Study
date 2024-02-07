import java.util.*;
public class Ex03 {
    public static int countEven(MyLinkedList<Integer> list ) throws NoSuchElementException{
        if (list.size()==0)
            throw new NoSuchElementException("Err: list is empty");
        int count = 0;
        for(Node<Integer> n = list.getHead(); n != null; n = n.getNext()){
            if(n.getData()%2==0)
                count++;
        }
        return count;
    }
    public static boolean isPrime(Integer a){
        for(int i = 2; i< Math.sqrt(a) ; i++){
            return (a%i==0);
        }
        return false;
    }
    public static int countPrime(MyLinkedList<Integer> list) throws NoSuchElementException{
        if (list.size()==0)
            throw new NoSuchElementException("Err: list is empty");
        int count = 0;
        for(Node<Integer> n = list.getHead(); n != null; n = n.getNext()){
            if(isPrime(n.getData()))
                count++;
        }
        return count;
    }
    public static void addBeforeFirstEven(MyLinkedList<Integer> list, int item) throws NoSuchElementException{
        Node<Integer> pre = null, adding = list.getHead();
        if(adding.getData()%2==0){ // node đầu tiên là chẵn
            list.addFirst(item);
            return;
        }
        if (list.isEmpty())
            throw new NoSuchElementException("list is empty");

        while(adding!=null){
            pre = adding;
            adding = adding.getNext();
            if (adding.getData()%2==0){
                list.addAfter(pre,item);
                break;
            }
        }
    }
    public static int Maximum(MyLinkedList<Integer> list) throws NoSuchElementException{
       if(list.isEmpty())
           throw new NoSuchElementException("list is empty");
       if(list.size() == 1)
           return list.getFirst();


       Node<Integer> pre = list.getHead(), next = pre.getNext();
       int temp = pre.getData();
       while(next!=null){
           if(temp < next.getData())
               temp =  next.getData();
            pre = next;
            next = next.getNext();
       }
       return temp;
    }

    public static void main(String[]args){
        MyLinkedList <Integer> a = new MyLinkedList();
        a.addFirst(31);
        a.addFirst(52);
        a.addFirst(61);
        a.addFirst(47);
        a.addFirst(59);
        a.addFirst(68);
        a.addFirst(74);
        a.addFirst(80);
        a.addFirst(19);
        a.addFirst(120);
        a.print();

        System.out.println("count the even element: " + countEven(a));
        System.out.println("count the prime element: "+ countPrime(a));
        System.out.println("add 14 at first even element: ");
        addBeforeFirstEven(a,14);
        a.print();

        System.out.println("Maximum element in list: " + Maximum(a));

        System.out.println("reverse list: ");
        a.reverse();
        a.print();
    }



}
