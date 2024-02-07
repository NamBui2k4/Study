public class Ex06 {
    public static void main(String[] args){
        BST a = new BST();
        int b[] = {48, 55,  46,45, 47, 68,42,43,41,36,38};
        for(int i : b){
            a.insert(i);
        }
        System.out.print("before: " );
        a.LNR();
        
        System.out.println();
        System.out.print(a.SumAllNode());
    }
}
