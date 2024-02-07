public class Ex11 {
    public static void main(String[] args){
        BST a = new BST();
        int b[] = {2,4,5,7,11,12,6};
        for(int i : b){
            a.insert(i);
        }
        System.out.print("before: " );
        a.LNR();
        
        System.out.println();
        System.out.print( a.sumEvenKeysAtLeaves());  
    }
    
}
