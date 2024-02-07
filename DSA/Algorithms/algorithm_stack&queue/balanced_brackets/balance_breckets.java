import java.util.Stack;
public class balance_breckets{
    public static boolean using_stack(String input){
        Stack<Character> s = new Stack<Character>();
        for(Character i : input.toCharArray()){
            if(i == '{' || i == '[' || i == '('){
                s.push(i);
            }
        }
        if(s.isEmpty()){
            return false;
        }
        for(Character i : input.toCharArray()){
            if(i == '}' && s.pop() != '{' ||
               i == ']' && s.pop() != '[' ||
               i == ')' && s.pop() != '(')
               return false;
        }
        return true;
    }
    public static boolean usingOnlyIter(String input){
        if(input.isEmpty())
            return false;

        boolean isBalanced = true;
        char listChar[] = input.toCharArray();

        int n = listChar.length;
        for(int i = 0 ; i < n ; i++){
                int j = n - 1 - i;
                if(listChar[i] == '{' && listChar[j] != '}'||
                   listChar[i] == '[' && listChar[j] != ']'||
                   listChar[i] == '(' && listChar[j] != ')')
                   isBalanced = false;
        }
        return isBalanced;

        // lưu ý: nếu không dùng stack sẽ có nhiều rủi ro, chẳng hạn "dljldfnvl" => true
    }
    public static void main(String[]args){
        String a = "{([a23cv])}";
        String b = "[(})]}";
        String c = "";
        String d = "dljldfnvl";
        System.out.println("{([a23cv])} is balanced: " + usingOnlyIter(a));
        System.out.println("[(})]} is balanced: " + usingOnlyIter(b));
        System.out.println(" __ is balanced: " + usingOnlyIter(c));
        System.out.println(" dljldfnvl is balanced: " + usingOnlyIter(d));

    }
}