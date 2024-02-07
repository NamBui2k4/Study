
public class Ex02{
    // a)
    public static int factorial(int n){
        return (n==0) ? 1 : n*factorial(n-1);
    }

    // b_
    public static double pow(double x,int n){
        if (x == 0)
            return 0;
        double temp = 1;
        for(int i = 1; i <= n; i++){
            temp *= x;
        }
        return temp;
    }

    // c)
    public static int count(int n ){
       return (n==0) ? 1 : 1+count(n/10);
    }

    public static void main(String[]args){
        int a ;
        a =  factorial(0);
        System.out.println(a);
        a =  factorial(4);
        System.out.println(a);
        double b;
        b = pow(4,2);
        System.out.println(b);
        int c;
        c = count(123456);
        System.out.println(c);
       
    }
}