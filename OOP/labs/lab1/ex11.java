import java.util.Scanner;
public class ex11 {
    public static int Count(int n){
        int dem = 0;
        if (n<10)
            return 1;
        else{     
        while(n >=1){   
                n = n/10;
                dem++;
            }
        }
            return dem;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println("Number of digit: " + Count(n));
    }
}