
import java.util.Scanner;

public class ex01{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        sc.close();
        int age = sc.nextInt();
        int id = sc.nextInt();
        System.out.println("name" + name);
        System.out.println("id : " + id );
        System.out.println("date of birth: " + age);
    }
}