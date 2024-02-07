public class Ex03 {
    public static int P(int n){
        if(n==1)
            return 3;
        else
            return (int)(Math.pow(2,n) + Math.pow(n,2) + P(n-1));
    }
    public static void main(String[] args){
        MyStack<Integer> a = new MyStack();
        a.push(P(1));
        a.push(P(2));
        a.push(P(3));
        a.push(P(4));
        a.push(P(5));
        a.print();
        a.pop();
        a.print();
        System.out.println(a.contains(545));
        System.out.print(a.getPeek());
    }
}