public class Ex04 {
    public static String reverse(String input){
        String result = "";
        MyStack<Character> listString = new MyStack();
        for(char i : input.toCharArray()){
            listString.push(i);
        }
        while(!listString.isEmpty()){
            result += listString.getPeek();
            listString.pop();
        }
        return result;
    }
    public static void main(String[] args){
        String input = "Hello World";
        String output = reverse(input);
        System.out.println(output);
    }
}