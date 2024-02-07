import java.lang.*;
class Fraction {
    private int numer;
    private int denom;

    public Fraction() {
        numer = 1;
        denom = 0;
    }

    public Fraction(int x, int y) {
        numer = x;
        denom = y;
    }

    public Fraction(Fraction f) {
        this(f.numer, f.denom);
    }

    public String toString() {
        return String.format("%d/%d", numer, denom);
    }

    public boolean equals(Object a) {
        if (a instanceof Fraction) {
            Fraction b = (Fraction) a;
            return (b.numer * denom - b.denom * numer == 0);
        }
        return false;
    }

}
public class Ex01 {
    public static void main(String[]args){
        MyLinkedList <Integer> a = new MyLinkedList();
 
        a.insertAt(6, 4);
        a.insertAt(5, 4);
        a.insertAt(9, 7);
        a.print();
    }
}
