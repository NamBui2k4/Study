public class Ex03 {
    // Write the function that prints on the screen the values of the tree in descending order.

    // Solve:
    public static void printDescen(BST a, Node b){
        if(b != null){
            printDescen(a, b.getRight());
            System.out.print(b.getKey() + ", ");
            printDescen(a, b.getLeft());
            
        }
    }   
    public static void printDescen(BST a){
        printDescen(a, a.getRoot());
    }
    public static void main(String[] args){
        BST a = new BST();
        int b[] = {40, 25, 10, 32, 78, 90};
        for(int i : b){
            a.insert(i);
        }
        printDescen(a);
    }
}
