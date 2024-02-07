public class Ex02 {
    // In the class containing the main function, define a function call createTree(String strKey). 
    // Giving a string of integers (separated by a space character), this function will
    // create a BST tree with the keys of integers following the input string.
    public static BST createTree(String strKey){
        BST result = new BST();
        String a[] = strKey.split(" ");
        for(String i : a){
            result.insert(Integer.parseInt(i));
        }
        return result;
    }

    public static void main(String[] args){
        BST a = createTree("40 25 10 32 78");

        System.out.print("LNR: ");
        a.LNR();
        System.out.println();

        System.out.print("NLR: ");
        a.NLR();
        System.out.println();

        System.out.print("LRN: ");
        a.LRN();
        System.out.println();

        System.out.print(a.getRoot().getKey());

    }
}
