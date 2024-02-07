import java.util.Scanner;
public class ex12 {
    public static String Reverse(int n ){
        String NumStr = Integer.toString(n);
        String NewNumStr = "";
        for (int i = NumStr.length() -1; i >= 0  ; i-- ){
            NewNumStr += NumStr.charAt(i);
        }
    return NewNumStr; 
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        System.out.println("Reverse : " + Reverse(n));
        }      
}
