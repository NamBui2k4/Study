import java.util.Scanner;
public class ex10 {
    public static int FirstDigit(int n){
        if( n<10 )
            return n;
        return FirstDigit(n/10);    
    }
    public static int LastDigit(int n){
        if ( n<10 )
            return n;
    return LastDigit(n%10);  
    }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println("Last Digit: " + LastDigit(n));
        System.out.println("First Digit: " + FirstDigit(n));
        int a = LastDigit(n) +  FirstDigit(n);
        System.out.println("Sum = " + a) ;

    }
}
