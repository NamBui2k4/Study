
import java.util.*;

public class ex05{
    public static boolean CheckLeapYear(int year){
        if (year%4 == 0 && year%100 != 0 || year%400 == 0 )    
            return true ;
        else return false;
        }
        
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        int year = sc.nextInt();
        sc.close();
        if(CheckLeapYear(year))
            System.out.println(year + " la nam nhuan");
        else 
            System.out.println(year + " khong la nam nhuan");
       
    }
}