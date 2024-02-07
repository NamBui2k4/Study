public class Ex04{

    // a)
    public static int sum_2i_plus_1(int n){
        if(n==1)
            return n;
        return 2*n + 1 + sum_2i_plus_1(n-1);
    }

    // b)
    public static int Factorial( int n){
        if(n==0)
            return 1;
        return n*Factorial(n-1);
    }
    public static int SumFactorial(int n){
        if (n == 1)
            return 1;
        return Factorial(n) + SumFactorial(n-1);
    }

    //  n = 1 => S(1) = 1
    //  n > 1 => n! + (n-1)! + ... +  1 =  n! + S(n-1)
    //

    // d)
    public static int P_n_r(int n, int r){
        if(n<=r || r <= 0 || n<=0 )
            return 1;
        return n*P_n_r(n-1,r-1);       
    }



    public static void main(String[] args){
        int a = sum_2i_plus_1(2);
        System.out.println(a);
        int d = P_n_r(6,2);
        System.out.println(d);
        int b = SumFactorial(4);
        System.out.println(b);
    }
}