import java.util.*;
class DoubleNode{
    private double data;
    private DoubleNode next;

    public DoubleNode(){
        data = 0.0;
        next = null;
    }
    public DoubleNode(double data, DoubleNode next){
        this.data = data;
        this.next = next;
    }

    public DoubleNode getNext(){
        return next;
    }
    public double getData(){
        return data;
    }
    public void setData(double item ){
        data = item;
    }
    public void setNext(DoubleNode n){
        next = n;
    }

}
class MyDoubleList{
    private DoubleNode head;
    private int num;

    public MyDoubleList(){
        head = null;
        num = 0;
    }
    public void addFirst(double item){
       head = new DoubleNode(item,head);
        num++;
    }
    public double removeFirst() throws NoSuchElementException{
        if(num == 0){
            throw  new NoSuchElementException("List is empty");
        }
        Double temp = head.getData();
        head = head.getNext();
        return temp;
    }
    public double removeAfter(DoubleNode n){
        if(num == 0){
            throw  new NoSuchElementException("List is empty");
        }
        DoubleNode pre = n;
        DoubleNode  delete = n.getNext();
        while (delete != null){
            if (pre.getNext() == n) {
                n.setNext(delete.getNext());
                num--;
                pre = delete;
                delete = delete.getNext();
            }
        }
        return n.getData();
    }

    public double removeLast() throws NoSuchElementException{
        if(num == 0) {
            throw new NoSuchElementException("List is empty");
        }
        if(num == 1){
            double temp = head.getData();
            removeFirst();
            return  temp;
        }
        DoubleNode pre = null;
        DoubleNode curr = head;
        while (curr !=null ){
            pre = curr;
            curr = curr.getNext();
            if (curr.getNext() == null){
                double temp = pre.getData();
                removeAfter(pre);
                return temp;
            }else
                continue;
        }
        return 0;
    }
    public boolean isEmpty(){
        return (num == 0);
    }
    public DoubleNode getHead(){
        return head;
    }
    public int size(){
        return num;
    }
    public double removeCurr(DoubleNode delete){
        if(num == 0) {
            throw new NoSuchElementException("List is empty");
        }
        if(num == 1){
            double temp = head.getData();
            removeFirst();
            return  temp;
        }
        DoubleNode pre = null;
        DoubleNode curr = head;
        while(curr!=null){
            if(curr == delete){
                removeAfter(pre);
            }
            pre = curr;
            curr = curr.getNext();
        }
        return  delete.getData();
    }
    public void print() {
        if (head != null) {
            DoubleNode tmp = head;
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

}
public class Ex04 {
    public static void main(String[]args){
        MyDoubleList a = new MyDoubleList();
        a.addFirst(23.3);
        a.addFirst(212.1);
        a.addFirst(11.3);
        a.print();

    }
}
