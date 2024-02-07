import java.util.*;
public class Ex05{
    public static boolean areBalanced(String input){
        Stack<Character> stackChar = new Stack<Character>();
        for(char ch: input.toCharArray()){
            if(ch == '{' || ch == '(' || ch == '[')
                stackChar.push(ch);
        }
        
        if(stackChar.isEmpty()){
            return false;
        }

        for(char ch: input.toCharArray()){
            if (ch == ']' || ch == ')' || ch == '}') {
                char popped = stackChar.pop();
                if(ch == ']' && popped != '[' ||
                   ch == ')' && popped != '(' ||
                   ch == '}' && popped != '{'   )
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String input1 = "{[()]}";
        String input2 = "{[(])}";
        String input3 = "[(])";
        String input4 = "   ";
        System.out.println("Input '{[()]}' is balanced: " + areBalanced(input1));
        System.out.println("Input '{[(])}' is balanced: " + areBalanced(input2));
        System.out.println("Input '[(])'   is balanced: " + areBalanced(input3));
        System.out.println("Input ''       is balanced: " + areBalanced(input4));


}
}