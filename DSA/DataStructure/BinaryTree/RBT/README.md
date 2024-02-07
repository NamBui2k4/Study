Nguồn bài viết: [_luyencode.net_](https://blog.luyencode.net/cay-do-den-red-black-tree-phan-1/?swcfpc=1)
Note: Bài viết đã có một vài chỉnh sửa 
# Cây Đỏ Đen (Red-Black Tree) – Phần 1 (Giới thiệu)

![](/pictures/RBT.png)

Cây đỏ đen (Red-Black Tree) là một loại cây tìm kiếm nhị phân tự cân bằng do Rudolf Bayer phát minh vào năm 1972. __Điểm đặc biệt ở đây là mọi node của cây đều có thêm thuộc tính bit và nó quy định màu sắc của node đó (màu đỏ hoặc đen)__. Cái tên “cây đỏ đen” cũng từ đây mà ra

Trước khi bắt đầu, mình xin cảm ơn trang [Geeks For Geeks](https://www.geeksforgeeks.org/introduction-to-red-black-tree/?ref=header_search) vì đã viết một bài về Red-Black Tree cực kì hay và dễ hiểu. Mình sẽ viết bài dựa trên nền tảng đó và xin phép sử dụng các hình ảnh minh họa của web. À…ngoài ra, bạn nào chưa biết đến Cây AVL (cũng là một loại tìm kiếm nhị phân tự cân bằng) thì nên tìm hiểu trước nhé. Như vậy mới đúng quy trình.

## 1. Tại sao lại có cây đỏ đen?
Khi ta thêm các phần tử vào cây tìm kiếm nhị phân (Binary Search Tree – BST) theo thứ tự tăng dần/giảm dần thì độ phức tạp của thuật toán tìm kiếm sẽ dao động từ O(log n) đến O(n). Trong trường hợp xấu nhất, cây sẽ trở thành một danh sách liên kết (linked list) và độ phức tạp của thuật toán sẽ là O(n). Đây chính là điểm yếu chí mạng của BST, và nhờ đó các cây tìm kiếm nhị phân tự cân bằng mới được ra đời.

![](/pictures/BST-weakness.gif)

Ủa? Cây AVL đã là BST tự cân bằng được phát minh vào năm 1962. Vậy thì tại sao năm 1972 lại phải tạo ra thêm cây đỏ đen làm gì nữa? Đúng là sự cân bằng của cây AVL thuộc dạng hoàn hảo khi chênh lệch về chiều cao của 2 cây con trái phải luôn luôn nhỏ hơn hoặc bằng 1. Tuy nhiên, không phải khi nào hoàn hảo cũng tốt. Khi ta thêm rất nhiều Node vào cây thì sẽ khiến cây phải quay (cân bằng) liên tục. Cây có càng nhiều phần tử thì việc cân bằng lại cây sẽ càng mất công hơn. Cây đỏ đen sẽ khắc phục yếu điểm này.

_Tóm lại, cây đỏ đen là một loại cây nhị phân tìm kiếm tự cân bằng khắc phục điểm yếu của BST. Và nếu dữ liệu đầu vào của bạn lớn thì bạn nên sử dụng cây đỏ đen, ngược lại nếu có ít phần tử thì nên sử dụng cây AVL._

## 2. Các quy tắc cần tuân thủ
Sau đây là các 5 quy tắc mà tất cả các cây đỏ đen phải tuân theo:

1. Mọi node đều phải có màu đỏ hoặc đen.
2. Node gốc (root) luôn luôn màu đen.
3. Không có hai node đỏ liền kề (Một node đỏ thì không thể có cha đỏ hoặc con đỏ).

Vd:
![](/pictures/Rule_3.png)

4. Mọi đường dẫn từ một node đến bất kì node NULL (thuộc con của nó ) thì đều có cùng số lượng node đen.
5. Tất cả các node lá (NULL) đều màu đen.

_Rất là nhiều quy tắc đúng không nào. Nó thực sự phức tạp hơn cây AVL nhiều lắm luôn. Tuy nhiên… nếu bạn để ý kĩ thì các quy tắc 1 2 5 rất đơn giản và dễ nhớ. Quy tắc 3 thường được áp dụng khi thêm một node vào cây, còn quy tắc 4 thì dùng khi xóa node. Khi bạn học tới phần nào (Insert/Delete) thì để ý quy tắc ấy thật kĩ nha._

## 3. Cây đỏ đen bảo đảm sự cân bằng ra sao?
Theo quy tắc số 3 thì hai node đỏ không được ở vị trí liền kề nhau. Như vậy tức là 2 node đen có thể ở liền kề. Nhưng nếu có 3 node đen liền kề nhau thì sao? Chuyện đó có thể xảy ra không?

Có thể thấy từ node root đến node NULL đầu tiên có 3 node đen là 18, 12 và 10. Nhưng từ node root đến node NULL thứ ba thì chỉ có 2 node đen là 18 và 12. Như vậy thì đã vi phạm quy tắc số 4.

_Vì vậy, __không thể có 3 node đen liên tiếp__. Vì thế số lượng node đen từ root đến tất cả các node NULL luôn luôn bằng nhau. Sự khác biệt giữa các đường đi là các node đỏ, tuy nhiên vẫn không đáng kể để ảnh hưởng đến sự cân bằng của cây._

## 4. Những điểm thú vị (tham khảo)
Chiều cao đen: là số lượng node đen từ root -> NULL. Vì thế nếu cây đỏ đen có chiều cao là h thì có chiều cao đen >= h / 2.
Chiều cao cây đỏ đen có n node là h thì: h <= 2 * log2(n + 1)
Tất cả các node lá (NULL) đều có màu đen – quy tắc 5.
Độ sâu đen của một node là số lượng node đen từ node đó -> NULL. (Khá tương tự chiều cao đen)
Mỗi cây đỏ đen đều là một trường hợp đặc biệt của cây tìm kiếm nhị phân BST.
## 5. Tổng kết
Cây đỏ đen là một cây tìm kiếm nhị phân tự cân bằng theo 5 quy tắc trên. Do đó các thao tác như tìm kiếm (search), in ra màn hình (print), tìm giá trị lớn nhất (findMax),… hoàn toàn giống như cây BST. Điểm khác biệt đó chính là thao tác thêm một node vào cây (insert) và xóa một node khỏi cây (delete).

Như đã đề cập: Cây đỏ đen là cây nhị phân được phát triển từ cây AVL. Do đó, để làm được 2 thao tác rất khó này (insert và delete) thì các bạn phải nắm rõ tất cả các thao tác và trường hợp lệch của cây AVL. Cụ thể là: quay trái cây – turn Left, quay phải cây – turn Right, và các trường hợp cây bị lệch trái trái, trái phải, phải phải, phải trái (Left left, left right, right right, right left).

Một ứng dụng của cây đỏ đen – Red Black Tree:

Hầu hết các chức năng của thư viện cây BST tự cân bằng trong C++ (hoặc TreeSet và TreeMap trong Java) đều sử dụng cấu trúc cây đỏ đen.
Lập lịch tiến trình CPU cho hệ điều hành Linux.
Áp dụng vào trong thuật toán phân cụm K-mean nhằm giảm độ phức tạp về thời gian.
Ngoài ra MySQL cũng sử dụng cây đỏ đen cho các chỉ mục trên bảng.
Bài viết về cây đỏ đen sẽ tiếp tục còn các phần tiếp theo, các bạn nhớ theo dõi và ủng hộ bài viết này nhé. Nếu có bất kỳ thắc mắc nào, đừng ngần ngại đặt câu hỏi, mọi góp ý về bài viết đều rất được hoan nghênh, cảm ơn các bạn!

