
import java.util.*;

public class ex04{
    public static double Convert(int Fahrenheit){
            return ( Fahrenheit - 32)*(5.0/9);
        }
        
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        int Fahrenheit = sc.nextInt();
        sc.close();
        System.out.println(Fahrenheit + " F  = " + Convert(Fahrenheit) + " C");
       
    }
}