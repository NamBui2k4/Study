public class Ex05{
    public static void main(String[] args){
        BST a = new BST();
        int b[] = {40, 25, 10, 32, 78, 90};
        for(int i : b){
            a.insert(i);
        }
        System.out.print("before: " );
        a.LNR();
        
        System.out.println();

        a.deleteMax();
        System.out.print("after: " );
        a.LNR();

        
        
    }
}