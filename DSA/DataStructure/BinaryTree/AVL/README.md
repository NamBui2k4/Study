Nguồn bài viết: [_luyencode.net_](https://blog.luyencode.net/cay-avl-phan-1-insertion/)

# Cây AVL (AVL Tree) – Phần 1 (Insertion)

Cây AVL (tiếng Anh là AVL Tree, AVL là viết tắt tên của các tác giả phát minh ra nó Adelson-Velsky và Landis) là một cây tìm kiếm nhị phân có khả năng __tự cân bằng__, điều đó giúp cho cây AVL tối ưu hơn rất nhiều so với cây tìm kiếm nhị phân (vd. Cây tìm kiếm nhị phân của dãy số tăng dần và node gốc là phần tử đầu tiên). Chúng ta hãy cùng đi tìm hiểu về AVL tree (phần 1 – Insertion) trong bài viết này nhé.

![](/pictures/AVL.png)

## 1. Tại sao lại sử dụng cây AVL?
Cây AVL chính sự nâng cấp của cây BST (Binary Search Tree) nên nếu bạn chưa biết gì về cây BST thì hãy đọc bài viết cây tìm kiếm nhị phân này trước khi bắt đầu.

Vậy thì BST có điểm yếu gì mà phải nâng cấp, hãy cùng nhìn:

![](/pictures/BST-weakness.gif)

Có thể thấy rằng, khi ta thêm các phần tử theo thứ tự tăng dần (giảm dần) thì cây không khác gì một Linked List (Danh sách liên kết). Khi đó, độ phức tạp của thuật toán tìm kiếm của cây là O(n) chứ không phải O(log n). Như vậy, ưu điểm của BST so với Linked List coi như cũng không còn.

## 2. Cây AVL là gì?
Cây AVL là cây nhị phân tìm kiếm cân bằng với “chiều cao” giữa cây con bên trái và cây con bên phải chênh nhau không vượt quá 1. Hay nói cách khác, BST mà cây con bên trái và phải của mọi Node có “chiều cao” chênh lệch không vượt 1 thì chính là cây AVL.

![](/pictures/AVLvsBST.png)

Để xây dựng được cây AVL thì các bạn nắm rõ các yếu tố sau:

1. Khái niệm “chiều cao” và cách tính.
2. Các kỹ thuật quay cây AVL
3. Các trường hợp cây bị lệch

## 3. Xây dựng cây AVL

__a. Định nghĩa 1 node:__

```
    class Node {
        int  data;
        Node left;
        Node right;
        int  height;
    };
```

__b. Chiều cao của một cây:__

_Lưu ý: có nhiều quan điểm về việc quy ước chiều cao của một cây nhị phân. Người thì cho rằng chiều cao lớn nhất là n - 1 (với n là số node của nhánh cây dài nhất) nhưng cũng có người cho rằng chiều cao lớn nhất của cây là n (nghĩa là nhánh dài nhất có bao nhiêu node thì chiều cao là bấy nhiêu). Đối với một cây nhị phân không có node nào , có người cho rằng cây sẽ có chiều cao là 0, một số khác lại nói rằng chiều cao là -1. Trong bài viết này, ta quy ước chiều cao thấp nhất là 0 và lớn nhất là n_

Chiều cao của một Node chính là số các node trên một đường dẫn dài nhất từ Node đó đến Node = NULL. Và quy ước Node = NULL có chiều cao bằng 0.

![](/pictures/AVL-heigh.png)

Bạn có thể tính độ cao qua hàm đệ quy như cách dưới đây. Tuy nhiên, mình sẽ không áp dụng vào code chính bởi vì khi dữ liệu đầu vào cực lớn thì việc đệ quy để tính chiều cao một Node bằng cách dựa vào tất cả các Node con là rất mất thời gian.

```
    int getHeight(Node root) {
    	if (root == null)
    		return 0;
    	return 1 + max( getHeight(root.left) , getHeight(root.right) );
    }
```

__c. Các kỹ thuật quay cây AVL__

1. Kỹ thuật quay phải – áp dụng khi cây bị lệch trái

Có thể thấy cây BST khi không cân bằng sẽ bị lệch sang phía bên trái hoặc bên phải. Để điều chỉnh lại ta cần phải quay cây sang phía ngược lại.

Gọi x, y lần lượt là các con trái, phải của root. Bây giờ, ta chỉ cần chú ý đến 3 Node: root, x, x.right.

![](/pictures/left-rotate.png)

Con trái của root không còn là x nữa mà là x.right: ``` root.left = x.right```
X sẽ lên làm cha với con phải là root: ```x.right = root```
Về chiều cao, có thể thấy chỉ có 2 Node bị thay đổi chiều cao đó là root và x. Vì root là con của x nên phải tính chiều cao của root trước.
-    ```root.height = 1 + max(root.left, root.right)```
-    ```x.height = 1 + max(x.left, x.right)```


2. Kỹ thuật quay trái – áp dụng khi cây bị lệch phải

![](/pictures/right-rotate.png)

Hoàn toàn tương tự, gọi x y lần lượt là các con trái phải của root. Và ta chỉ cần quan tâm 3 Node: root, y, y.left

```
    Node leftRotate(Node root) {
        Node y = root.right;

        // Bắt đầu quay trái
        root.right = y.left;
        y.left = root;

        // Thiết lập chiều cao
        root.height = 1 + max( getHeight(root.left) , getHeight(root.right) );
        y.height = 1 + max( getHeight(y.left) , getHeight(y.right) );

        // trả về root mới
        return y;
    }
```

## 4. Các trường hợp cây bị mất cân bằng

Gọi a là số node của nhánh cây dài nhất bên trái
Gọi b là số node của nhánh cây dài nhất bên phải
Khi đó, Một cây được gọi là mất cân bằng khi: $ | a - b | ≧ 2 $
Vậy, một cây được gọi là cân bằng khi: $ 0 ≦ | a - b | ≦ 1 $

Bản chất của việc cân bằng cây là làm sao cho chênh lệch giữa 2 nhánh dài nhất ở bên trái và bên phải không vượt quá 1

_Lưu ý: có một số quan điểm khác cho rằng chênh lệch chỉ cần bằng 1 cũng đủ làm cho cây mất cân bằng_

Có 4 trường hợp cây bị mất cân bằng:

- Trường hợp “Trái trái” – Left left
- Trường hợp “Phải phải” – Right right
- Trường hợp “Trái phải” – Left right
- Trường hợp “Phải trái” – Right left

__Trường hợp “Trái trái” – Left left__

Quy tắc cần bằng: _xoay right tại root_

![](/pictures/left-left.png)

__Trường hợp “Phải phải” – Right right__

Quy tắc cần bằng: _xoay left tại root_

![](/pictures/right-right.png)

__Trường hợp “Trái phải” – Left right__

Quy tắc cân bằng: _xoay left tại left, xoay right tại root_

![](/pictures/left-right.png)

__Trường hợp “Phải trái” – Right left__

Quy tắc cân bằng: _xoay right tại right, xoay lefr tại root_

![](/pictures/right-left.png)
