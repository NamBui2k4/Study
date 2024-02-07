public class Ex02 {
    public static void main(String[]args){
        MyLinkedList <Integer> a = new MyLinkedList();
        a.addFirst(23);
        a.addFirst(212);
        a.addFirst(121);
        a.print();
        a.removeCurr(a.getCurr(121));
        a.print();

    }
}
