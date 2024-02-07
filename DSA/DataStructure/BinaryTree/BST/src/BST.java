public class BST {
    // Based on the sections above, implement a BST class completely and write the main
    // function to check it. (Notice: the functions which giving in the sections above are private
    // so we need to implement the public functions to call them with root node)

    private Node root;
    public Node getRoot(){
        return root;
    }

    public Node insert(Node position, Integer key) { // position is left / right
        if (position == null) {
            position = new Node(key);
            return position;
        }
        int comp = key.compareTo(position.getKey());

        if (comp < 0) {
            position.setLeft(insert(position.getLeft(), key));
        }
        if (comp > 0) {
            position.setRight(insert(position.getRight(), key));
        }
        return position;
    }
    public Node insert(Integer key) {
        root =  insert(root, key);      // note !
        return root;
    }
    // note ! : " insert(root, key) " does not directly change the attribute "root" of the BST because
    // root now are an input parameter, when this method is called successfully, then
    // it will release root's memory and the "root" is still null. 
    // that's why we need "root = insert(Integer key)"

    public void NLR(Node x) {
        if (x != null) {
            System.out.print(x.getKey() + " ");
            NLR(x.getLeft());
            NLR(x.getRight());
        }
    }
    public void NLR(){
        NLR(root);
    }

    public void LNR(Node x) {
        if (x != null) {
            NLR(x.getLeft());
            System.out.print(x.getKey() + " ");
            NLR(x.getRight());
        }
    }
    public void LNR() {
        LNR(root);
    }

    public void LRN(Node x) {
        if (x != null) {
            NLR(x.getLeft());
            NLR(x.getRight());
            System.out.print(x.getKey() + " ");

        }
    }
    public void LRN(){
        LNR(root);
    }
   
    public Node search(Node x, Integer key) {
        if (x == null) {
            return null; // no node founded
        }

        int comp = key.compareTo(x.getKey());
        if (comp < 0) {
            return search(x.getLeft(), key);
        } else if (comp > 0) {
            return search(x.getRight(), key);
        } else // comp == 0 => x.key == key <=> founded key
            return x;
    }
    public Node search(Integer key) {
        return search(root, key);
    }

    public Node min(Node x) {
        if (x.getLeft() == null) {
            return x;
        }
        return min(x.getLeft());
    }
    public Node min() {
        return min(root);
    }

    public Node max(Node x) {
        if (x.getRight() == null) {
            return x;
        }
        return max(x.getRight());
    }
    public Node max() {
        return max(root);
    }

    public Node deleteMin(Node x) {
        if (x.getLeft() == null)
            return x.getRight();
        x.setLeft(deleteMin(x.getLeft()));
        return x;
    }
    public Node deleteMin() {
        return deleteMin(root);
    }

    public Node delete(Node x, Integer key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.getKey());
        if (cmp < 0)
            x.setLeft(delete(x.getLeft(), key));
        else if (cmp > 0)
            x.setRight(delete(x.getRight(), key));
        else {
            // node with only one child 
            if (x.getRight() == null)
                return x.getLeft();
            if (x.getLeft() == null)
                return x.getRight();

            // node with two children: Get the successor (smallest in
            // the right subtree)
            x.setKey(min(x.getRight()).getKey());
            x.setRight(deleteMin(x.getRight()));
        }
        return x;
    }
    public Node delete(Integer key) {
        return delete(root, key);
    }
    public int iCountNode(Node item) {
        if (item == null)
            return 0;
        return iCountNode(item.getLeft()) + iCountNode(item.getRight()) + 1;
    }

    public int getHeight(Node x) {
        if (x == null)
            return 0;
        int a = 1 + getHeight(x.getLeft());
        int b = 1 + getHeight(x.getRight());
        int max = a > b ? a : b;
        return max;
    }

    // Ex04
    // Write contains function with input is a key, the function returns true if the key in
    // the tree. Otherwise, it returns false.
    public boolean contains(Integer key){
        if(search(key) == null)
            return false;
        return true;
    }

    // Ex05
    public Node deleteMax(Node x){
        if (x.getRight() == null)
            return x.getLeft();
        x.setRight(deleteMax(x.getRight()));
        return x;
        
    }
    public void deleteMax(){
        deleteMax(root);
        return;
    }

    // Ex06
    // Write the function to delete a node in BST, but you must use the predecessor instead of the successor.
    public Node delete_pre(Node x,Integer key) {
        if(x == null)
            return null;
        int comp = key.compareTo(x.getKey());
        if(comp < 0){
            x.setLeft(delete_pre(x.getLeft(), key));
        }else if(comp > 0){
            x.setRight(delete_pre(x.getRight(), key));
        }else{
            // parent with one child
            if(x.getRight() == null){
                return x.getLeft();
            }
            if(x.getLeft() == null){
                return x.getRight();
            }

            x.setKey(max(x.getLeft()).getKey());
            x.setLeft(deleteMax(x.getLeft()));
            // parent with two children
            
        }
        return x;
    }
    public void delete_pre(Integer key){
        root = delete_pre(root,key);
        return;
    }

    // Ex08
    public Integer sum(Node x){
        if(x == null)
            return 0;
        int sum, leftSum ,rightSum;
        sum = leftSum = rightSum = 0;

        if(x.getLeft() != null){
            leftSum = sum(x.getLeft());
        }
        if(x.getRight() != null){
            rightSum = sum(x.getRight());
        }
        sum = x.getKey() + rightSum + leftSum;
        return sum;
    }
    public Integer SumAllNode(){
        return sum(root);
    }
    
    // Ex11
    public int sumEvenKeysAtLeaves(Node x) {
        if(x == null)
            return 0;

        if(x.getLeft() == null && x.getRight() == null){
            if(x.getKey()%2==0)
                return x.getKey();
            else 
                return 0;
        }
        int sum = 0;
        sum += + sumEvenKeysAtLeaves(x.getLeft()) + sumEvenKeysAtLeaves(x.getRight());
        
        return sum;
    }
    public int sumEvenKeysAtLeaves(){
        return sumEvenKeysAtLeaves(root);
    }

    public int sumEven(Node x){
        if(x == null){
            return 0;
        }
        int temp = sumEven(x.getLeft()) + sumEven(x.getRight());
        int key = x.getKey();
        return  (key%2 == 0) ? key + temp : temp;
    }
    public int sumEven(){
        return sumEven(root);
    }
}

    