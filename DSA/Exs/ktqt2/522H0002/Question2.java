import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

class Question2 {
    public static boolean palindrome(String str){
    Stack<Character> a = new Stack<Character>();

    for(int i = 0 ; i < str.length(); i++){
        a.push(str.charAt(i));
    }

    for(Character c : str.toCharArray()){
        if(!c.equals(a.pop())){
            return false;
        }

    }
    
    return true;
}

public static boolean CheckPalindrone(String input){
    Stack<Character> listCharStack = new Stack<Character>();
    Queue<Character> ListCharQueue = new LinkedList<Character>();
    for(char i : input.toLowerCase().toCharArray()){
        if ( i<= 'z' && i >= 'a'){
            listCharStack.push(i); //  "hello" => o l l e h
            ListCharQueue.offer(i);  // "hello" => h e l l o 
        }
    }
    while(!listCharStack.isEmpty()){
        if(!listCharStack.pop().equals(ListCharQueue.poll()))
            return false;
    }
    return true;
}
     public static void main(String[] args) {
        String	str = "A man, a plan, a canal: Panama";
        System.out.print(CheckPalindrone(str));
     }   
    }
