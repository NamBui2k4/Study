
public class Ex02 {
    public static void main(String[] args){
        MyQueue<Fraction> a = new MyQueue();
        a.enQueue(new Fraction(12,2));
        a.enQueue(new Fraction(1,3));
        a.enQueue(new Fraction(4,5));
        a.enQueue(new Fraction(1,7));
        a.enQueue(new Fraction(9,5));
        a.print();
        a.deQueue();
        a.print();
    }
}