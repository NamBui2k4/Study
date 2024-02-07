class Fraction {
    private int numer;
    private int denom;
    public Fraction(){
        numer = 0;
        denom = 1;
    }
    public Fraction(int x, int y){
        numer = x;
        denom = y;
    }
    @Override
    public String toString(){
        return String.format("%d/%d",numer,denom);
    }
    @Override
    public boolean equals(Object a){
        if(a instanceof Fraction){
            Fraction temp = (Fraction) a;
            return (temp.numer*denom == temp.denom*numer);
        }
        return false;
    }

}
public class Ex01 {
    public static void main(String[] args){
        MyStack<Fraction> a = new MyStack();
        a.push(new Fraction(12,2));
        a.push(new Fraction(1,3));
        a.push(new Fraction(4,5));
        a.push(new Fraction(1,7));
        a.push(new Fraction(9,5));
        a.print();
        a.pop();
        a.print();
        System.out.println(a.contains(new Fraction(12,2)));
        System.out.print(a.getPeek());
    }
}