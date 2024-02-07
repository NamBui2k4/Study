import java.util.Scanner;

public class ex03{
    public static double remainder( int a, int b ){
            return a%b;
        }

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        sc.close();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(remainder(a,b));
       
    }
}