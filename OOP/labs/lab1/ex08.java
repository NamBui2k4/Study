import java.util.*;
public class ex08 {
    public static int S(int n){
        if (n==0)
            return 1;
        return n + S(n-1);    
    }
    public static long P(int n){
        if (n==0)
            return 1;
        return n*P(n-1);
    }
    public static double S1(int n){
        if (n ==0)
            return 1;
        return Math.pow(2,n)  + S1(n-1);
    }
    public static double E(int n){
        if (n ==0)
            return 1;
        return Math.pow(n,2)  + S1(n-1);
    }
    public static double S2(int n){
        if (n==0)
            return 1/2;
        return 1.0/(2*n) + S2(n-1);
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        

        System.out.println(S(n));
        System.out.println(P(n));
        System.out.println(S1(n));
        System.out.println(S2(n));
        System.out.println(E(n));
    }
}
