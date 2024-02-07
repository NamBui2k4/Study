
import java.util.*;

public class ex06{
    public static int   Minnimum(int a, int b , int c){
        int [] arr = {a,b,c};
        int min = arr[0];
        for (int i = 0; i <=2 ; i++)
            {   if (min > arr[i])
                    min = arr[i];

            }
        return min;
    }
        
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        sc.close();
        System.out.println("min = " + Minnimum(a,b,c));
       
    }
}