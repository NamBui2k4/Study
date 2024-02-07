import java.util.*;
public class Ex07 {
    public static boolean CheckPalindrone(String input){
        Stack <Character> s = new Stack<Character>();
        for(char i : input.toLowerCase().toCharArray()){
            if ( i<= 'z' && i >= 'a'){
                s.push(i);
            }
        }
        for(int i = 0 ; i< input.length(); i++){
            Character c = input.toLowerCase().charAt(i);
            if(c <= 'z' && c >= 'a' && !s.pop().equals(c))
                return false;
        }
        return true;
    
    }
    public static boolean CheckPalindrone1(String s){
        char c[] = s.toLowerCase().toCharArray();
        for(int i = 0; i < c.length/2; i++){
            int j = c.length - 1 - i;
            if(!(c[i] == c[j]))
                return false;
        }
        return true;
    }
    public static void main(String[]args){
        String a = "dad";
        System.out.println(a + "=> " + CheckPalindrone1(a));
        String b = "radar";
        System.out.println(b + "=> " + CheckPalindrone1(b));

    }
}