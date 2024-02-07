public class Ex03 {
    public static boolean isPrime(int n, int divisor) {
        if(n==1){
            return true ;
        }
        return (n%divisor == 0) ? false : isPrime(n, divisor - 1);

        // n = 7, divisor = n - 1
        //      (7%6==0) => isPrime(7,5)
        //                          7%5==0  => isPrime(7,4)
        //                                          7%4==0 => isPrime(7,3)
        //                                                      .....
        //                                                          isPrime(7,1) => true
        //

    }
    public static boolean isPrime(int n){
        return isPrime(n,n-1);
    }
    public static void main(String[] args){
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