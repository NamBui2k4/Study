public class Ex04 {
//Write contains function with input is a key, the function returns true if the key in
//the tree. Otherwise, it returns false.

// Solve: in BST file
    public static void main(String[] args){
        BST a = new BST();
        int b[] = {40, 25, 10, 32, 78, 90};
        for(int i : b){
            a.insert(i);
        }
        System.out.println(a.contains(25));
    }
}
