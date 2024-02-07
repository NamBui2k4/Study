
import java.util.*;

public class ex07{
    public static Boolean Check(String str){
        for(int i=0 ; i < str.length() ; i++){
            char a = str.charAt(i);
            if (!( a >= 'A' && a <= 'Z' || a <= 'z' && a >= 'a' || a <= '9' && a >= '0' ) )
               return false;
    }    
    return true;
    }
        
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        String str = sc.nextLine();
        sc.close();
        if(Check(str))
            System.out.println(str + " is alphanumeric");
        else 
            System.out.println(str + " is not alphanumeric");
       
    }
}