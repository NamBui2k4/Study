# Lý thuyết về cây tìm kiếm nhị phân

Trong khoa học máy tính, __cây nhị phân__ (tiếng Anh: binary tree) là một cấu trúc dữ liệu lưu trữ các node giống như linkedlist nhưng có hình dạng cây. Trong cây nhị phân có tính chất: mỗi node có nhiều nhất hai nút con, được gọi là con trái (left child) và con phải (right child).

Cây tìm kiếm nhị phân(TA: Binary Search Tree – viết tắt: BST) – là một __cây nhị phân__ mang các ràng buộc:

1.  con trái < __gốc cây__ < con phải
3. Tất cả các lá cây(bao gồm con trái và con phải) cũng đều phải đảm bảo tính chất trên.

## Minh họa trực quan

![](/picture/cay_nhi_phan.png)


## Minh họa ràng buộc của BST

![](/picture/rang_buoc.png)

__Gốc của cây nhị phân là ranh giới chia thành 2 bên,__
__lá cây bên trái <  gốc và lá cây bên phải > gốc__

![](/picture/cay_con.png)
__đồng thời, lá của cây cũng đóng vai trò là một gốc cây của một cây con__ 

## Nhận biết BST

![](/picture/nhanbiet.png)
Nhận biết cây tìm kiếm nhị phân. Hình thứ 2 không phải BST  (35 > 33 nên 33 phải nằm bên trái so với 35)

## Tính chất

1. mỗi gốc cây/lá cây của BST có tối đa 2 con (trái và phải)
2. mỗi gốc cây/lá cây được triển khai bằng đệ quy
3. độ phức tạp khi thêm, xóa, tìm kiếm, duyệt dao động từ O(log n) --> O(n) 
tùy thuộc vào chiều cao của cây
4. lá cây có giá trị nhỏ nhất là __nút trái nhất__
   lá cây có giá trị lớn nhất là __nút phải nhất__
5. các gốc cây/lá cây không được trùng giá trị

## Các thao tác với BST

1. thêm (insert)
2. xóa  (delete)
3. tìm kiếm (search)
4. duyệt (traverse)

### 1. Thêm (insert)

Khi muốn thêm một giá trị x vào BST, ta bắt đầu tìm kiếm từ gốc (root), nếu x < gốc thì tìm vị trí trống của cây con __bên trái__ nút gốc, nếu x > gốc ta tìm vị trí trống của cây con __bên phải__ nút gốc. Trường hợp tìm được 1 node trong cây bằng với x thì xác nhận x đã tồn tại trong cây.

![](/picture/insert.png)

### 2. Xóa (delete)

Trong hoạt động xóa 1 node của cây nhị phân, chúng ta sẽ gặp phải 3 trường hợp sau:
 - Node cần xóa có 1 con (trái hoặc phải)
 - Node cần xóa không có con nào
 - Node cần xóa có 2 con

Với trường hợp đầu tiên node cần xóa có 1 node con, ta chỉ cần thay vị trí của node con đó với node cần xóa.

![](/picture/XoaTH1.png) (1 thay cho 3)

Với trường hợp node cần xóa không có con thì chúng ta đơn giản chỉ cần xóa vị trí node đó khỏi cây.

![](/picture/XoaTH2.png)

Trường hợp cuối cùng, node cần xóa có cả 2 con, ta sẽ tìm successor __hoặc__  predecessor để thay thế cho node cần xóa 
 - successor: đi về cây con bên phải, tìm nút trái nhất  (left-most của cây con bên phải)

![](/picture/successor.png)

 - predecessor: đi về cây con bên trái, tìm nút phải nhất (right-most tree của cây con bên trái)

![](/picture/predecessor.png)

Note: predecessor và successor luôn có tối đa 1 con

_"Ba má đi làm thì đưa con cho ông bà ngoại giữ"_

Có thể nói, trường hợp cuối cùng là phức tạp nhất, nên ta xét một ví dụ sau để hiểu rõ hơn 
về cách xóa node 2 con trong BST

![](/picture/ExampleDelete.png)

Trong ví dụ trên, ta có:
- 55 là node có 1 con
- 40 là node có 2 con
- 47 là node không con
với 2 trường hợp đầu tiên, ta sẽ dùng kỹ thuật đệ quy như sau

``````
    Node delete(Node x, Integer key) {
        // nếu cây không có gì thì không xóa
        if (x == null)
            return null;

        // nếu node < gốc thì ta đệ quy và làm cho gốc trỏ về bên trái
        if (key < x.key )
            x.left = delete(x.left, key); 
        
        //  nếu node > gốc thì đệ quy và làm cho gốc trỏ về bên phải
        if ( key > x.key )
            x.right = delete(x.right, key);   
            
        else {
            // nếu node có 1 con, ta chỉ cần lấy con của nó thay thế cho nó
            if (x.left == null)  
                return x.right;
            if (x.left == null)
                return x.right; 
        }
        return x;
    }
``````
Minh họa cách code hoạt động bằng hình vẽ

![](/picture/OneChild.png)



### 3. Tìm kiếm (Search)
Để bắt đầu tìm kiếm một giá trị x cho trước, chúng ta bắt đầu từ gốc.
-  So sánh x với gốc
   + nếu x = gốc thì trả về x
   + Nếu x < gốc thì so sánh x với con bên trái của gốc, nếu x = con trái thì trả về con trái => hoàn thành tìm kiếm
   + nếu x > gốc thì so sánh với con phải của root, nếu x = con phải thì trả về con phải => hoàn thành tìm kiếm
- Làm tương tự với các cây con cho đến khi nào tìm ra thì thôi. Nếu không tìm thấy, ta trả về null
![](/picture/search.png)
### 4. Duyệt (traverse)
Duyệt là thao tác phức tạp nhất đối với một cây nhị phân. Bản chất của duyệt chính là đi qua từng phần tử của một cây và thực hiện thao tác trên các phần tử đó. 

Người ta đã chứng minh có 6 kiểu duyệt BST phát sinh từ đoạn mã nguồn giả sau:

```
    Traverse( node ){
        if node is not null{
           solve node;           // xử lý node
           Traverse(node.left);   // đi về bên trái
           Traverse(node.right);  // đi về bên phải
        }
    }
``````
Bản chất của 6 kiểu duyệt chính là hoán vị 3 dòng code chính trong mã nguồn. Trong đó, có 3 kiểu duyệt đem lại hiệu quả nhất gồm Pre-order, In-order, post-order

Dưới đây là mô tả các kiểu duyệt trên. Chú ý: mô tả có thể rất phức tạp, hãy xem kỹ hình ảnh để hiểu rõ hơn

   - Pre-order (NLR - Node left right): thao tác với gốc -> đi qua trái và thao tác với cây con trái, đi qua phải và thao tác với node lá phải

   ![](/picture/Pre-order.png)

   - In-order  (LNR - Left node right): đi sang trái -> thao tác với cây con trái rồi về gốc -> đi sang phải và thao tác với cây con phải
   
   ![](/picture/In-order.png)
   
   - Post-order (LRN - left right node): đi sang trái -> đi sang phải với mỗi lá cây, thao tác với từng lá
   ![](/picture/Post-order.png)



## PostCase của các thao tác
post case là trường hợp xấu nhất khi các thao tác trên BST có độ phức tạp thuật toán lớn nhất.Giả một cây BST có độ cao là n, thông thường ta có phân bố post case như sau
   O(log n):
   - insert
   - xóa  
   - tìm kiếm
   
   O(n): duyệt (traverse)

![](/picture/complexityDistribution.png)
   

![](/picture/PostCase.png)




------------------------------------------------
 tài liệu được xây dựng từ tham khảo các nguồn:
-  https://blog.luyencode.net/cay-tim-kiem-nhi-phan-binary-search-tree/#1-ly-thuyet-ve-cay-tim-kiem-nhi-phan

- https://drive.google.com/drive/u/1/folders/11W7XOTDMTWr6tl5j-Aob7h_zXItQ4zmu

- https://codelearn.io/sharing/5-phut-thong-thao-binary-search-tree#:~:text=V%E1%BB%9Bi%20c%C3%A2y%20t%C3%ACm%20ki%E1%BA%BFn%20nh%E1%BB%8B%20ph%C3%A2n%20ch%C3%BAng%20ta,c%C6%A1%20b%E1%BA%A3n%3A%20pre-oder%20traversal%2C%20In-order%20traversal%2C%20post-order%20traversal.


