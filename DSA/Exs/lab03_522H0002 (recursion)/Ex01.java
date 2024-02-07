
public class Ex01{
    // a)
    public static int factorial(int n){

        if (n == 0)
            return 1;

        int temp = 1;
        for(int i = 1; i <= n; i++){
            temp *= i;
        }
        return temp;
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
        int temp = 0;

        while(n!=0){
            temp++;
            n/=10;
        }
        return temp;
    }
    // d)
    public static boolean isPrime(int n){
        if(n==1 || n==0)
            return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if (n%i==0)
                return false;
        }
        return true;
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
        boolean d; 
        d = isPrime(2);
        System.out.println("2 is prime: " + d);
        d = isPrime(3);
        System.out.println("3 is prime: " + d);
        d = isPrime(4);
        System.out.println("4 is prime: " + d);
        d = isPrime(5);
        System.out.println("5 is prime: " + d);
        d = isPrime(6);
        System.out.println("6 is prime: " + d);
    }
}