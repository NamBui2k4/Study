import java.util.Scanner;
public class ex09 {
    public static int HailStone(int n){
        if (n%2==0)
            return n/2;
        else
            return n*3+1;          
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        while (n != 1) {
            n = HailStone(n);
            System.out.print(n + " ");
// dãy Hailstone là một dãy số giảm dần , bắt đầu từ một số bất kỳ và kết thúc là 1
    }
}
}