import java.util.Vector;
import java.util.Scanner;
class test{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print
        ("nhap so: ");
        int n = sc.nextInt();
        Vector<Integer> X = new Vector<Integer>(n);

        for(int i = 0; i < n ;i++){
            X.add(i);
        }
        System.out.print("X: ");
        System.out.println(X);

        // Y = 2X^2 + 1

        Vector<Integer> Y = new Vector<Integer>(n);
        for(int i = 0; i < n ; i++){
            Y.add((int)(2*Math.pow(X.get(i),2) + 1));   
        }
        System.out.print("Y: ");
        System.out.println(Y);
    }

}