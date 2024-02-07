# Thuật toán duyệt đồ thị ưu tiên chiều rộng BFS (Breadth-first search)

Thuật toán duyệt đồ thị ưu tiên chiều rộng (Breadth-first search - BFS) là một trong những thuật toán tìm kiếm cơ bản và thiết yếu trên đồ thị. Mà trong đó, những đỉnh nào gần đỉnh xuất phát hơn sẽ được duyệt trước.

Ứng dụng của BFS có thể giúp ta giải quyết tốt một số bài toán trong thời gian và không gian tối thiểu. Đặc biệt là bài toán tìm kiếm đường đi ngắn nhất từ một đỉnh gốc tới tất cả các đỉnh khác. Trong đồ thị không có trọng số hoặc tất cả trọng số bằng nhau, thuật toán sẽ luôn trả ra đường đi ngắn nhất có thể. Ngoài ra, thuật toán này còn được dùng để tìm các thành phần liên thông của đồ thị, hoặc kiểm tra đồ thị hai phía, …

![](/pictures/breadth-first-search_img1.png)

# Ý tưởng

Với đồ thị không trọng số và đỉnh nguồn s. Đồ thị này có thể là đồ thị có hướng hoặc vô hướng, điều đó không quan trọng đối với thuật toán.

Có thể hiểu thuật toán như một ngọn lửa lan rộng trên đồ thị:

- Ở bước thứ 0, chỉ có đỉnh nguồn s đang cháy.
- Ở mỗi bước tiếp theo, ngọn lửa đang cháy ở mỗi đỉnh lại lan sang tất cả các đỉnh kề với nó.

Trong mỗi lần lặp của thuật toán, "vòng lửa" lại lan rộng ra theo chiều rộng. Những đỉnh nào gần s hơn sẽ bùng cháy trước.

Chính xác hơn, thuật toán có thể được mô tả như sau:

- Đầu tiên ta thăm đỉnh nguồn s.

- Việc thăm đỉnh s sẽ phát sinh thứ tự thăm các đỉnh $ (u_1,u_2,…u_n) $ kề với s 

- Tiếp theo ta thăm đỉnh $u_1$ , khi đó ta lại phát sinh thứ tự thăm các đỉnh $ (v_1, v_2,...,v_n) $ kề với $u_1$ → Lặp lại tương tự ở bước 2

_Chú ý: ta chỉ thăm các đỉnh $ (v_1, v_2,...,v_n) $ nếu đã thăm các đỉnh $ (u_1,u_2,…u_n) $ trước đó. Tức là thứ tự thăm các đỉnh sẽ là:_

$$ s → (u_1, u_2,…,u_n) → (v_1, v_2,…,v_n,…) → ...$$

![](/pictures/breadth-first-search_img2.png)

Thuật toán tìm kiếm theo chiều rộng sử dụng một __hàng đợi__ để chứa những đỉnh đang “chờ” thăm. Tại mỗi bước, ta thăm một đỉnh đầu danh sách, loại nó ra khỏi danh sách và cho những đỉnh kề với nó chưa được thăm xếp hàng vào cuối danh sách. Thuật toán sẽ kết thúc khi danh sách rỗng.

# Chi tiết Thuật toán

Thuật toán sử dụng một cấu trúc dữ liệu hàng đợi (queue) để chứa các đỉnh sẽ được duyệt theo thứ tự ưu tiên chiều rộng.

Bước 1: Khởi tạo

- Các đỉnh đều ở trạng thái chưa được đánh dấu ngoại trừ đỉnh nguồn s.

- Một hàng đợi ban đầu chỉ chứa 1 phần tử là s

Bước 2: Lặp lại các bước sau cho đến khi hàng đợi rỗng:

- Lấy đỉnh u ra khỏi hàng đợi.
- Xét tất cả những đỉnh v kề với u mà chưa được đánh dấu, với mỗi đỉnh v đó:
    + Đánh dấu v đã thăm.
    + Lưu lại vết đường đi từ u đến v
    + Đẩy v vào trong hàng đợi (đỉnh v sẽ chờ được duyệt tại những bước sau).

Bước 3: Truy vết tìm đường đi.

# Mô tả

Xét đồ thị sau đây, với đỉnh nguồn s=1:

![](/pictures/breadth-first-search_img3.png)

Quá trình thực thi:

![](/pictures/breadth-first-search_img4.png)

![](/pictures/breadth-first-search_gif1.gif)

# Cài đặt

Cấu trúc dữ liệu:

- Biến numVertice: số lượng đỉnh của đồ thị

-   mảng parent[] : lưu lại dấu vết đường đi. Mảng sẽ lưu parent của u nếu đã ghé thăm u. Mảng có kích thước bằng numVertice

- Mảng visited[] - Mảng đánh dấu các đỉnh đã thăm. Mảng cũng có kích thước bằng numVertice

- Hàng đợi queue - Chứa các đỉnh sẽ được duyệt theo thứ tự ưu tiên chiều rộng.

- Mảng d[] - Mảng lưu lại khoảng cách từ đỉnh nguồn đến mọi đỉnh (nếu cần thiết)

# Các đặc tính của thuật toán

Nếu sử dụng một ngăn xếp (stack) thay vì hàng đợi (queue) thì ta sẽ thu được thứ tự duyệt đỉnh của thuật toán tìm kiếm theo chiều sâu (Depth First Search – DFS). Đây chính là phương pháp khử đệ quy của DFS để cài đặt thuật toán trên các ngôn ngữ không cho phép đệ quy.

Việc sử dụng mảng visited[] để đánh dấu các đỉnh được ghé thăm được gọi là Kỹ thuật Bitmask

Định lí: 
- Thuật toán BFS cho ta độ dài đường đi ngắn nhất từ đỉnh nguồn tới mọi đỉnh (với khoảng cách tới đỉnh u bằng d[u] ). 
- Trong thuật toán BFS , nếu đỉnh u xa đỉnh nguồn hơn đỉnh v, thì u sẽ được thăm trước.

Chứng minh: Trong BFS, từ một đỉnh hiện tại, ta luôn đi thăm tất cả các đỉnh kề với nó trước, sau đó thăm tất cả các đỉnh cách nó một đỉnh, rồi các đỉnh cách nó hai đỉnh, v.v… Như vậy, nếu từ một đỉnh u khi ta chạy BFS, quãng đường đến đỉnh v luôn là quãng đường đi qua ít cạnh nhất

# Định lý Bắt tay (Handshaking lemma)

_Định lý: Trong một đồ thị bất kỳ, tổng số bậc của tất cả các đỉnh bằng gấp đôi số cạnh của đồ thị._

Cho đồ thị G=(V, E) gồm V đỉnh và E cạnh. Gọi $ v_1, v_2,...,v_n $ là các đỉnh của đồ thị G. Khi đó:

$$ ∑_{i = 1}^{n} deg(v_i)  = 2E $$

nhắc lại: $ deg(v_i) $ là bậc của đỉnh $v$ thứ $i$

ví dụ: Cho đồ thị sau với V = 8 và E = 7

![](/pictures/breadth-first-search_img5.png)

Dễ thấy, tổng số cạnh là 7 và tổng số bậc của đồ thị là 3 + 1 + 3 + 3 + 0 + 1 + 2 + 1 = 14. Tức là 14 = 7x2

Chứng minh: Vì mỗi một cạnh nối với đúng hai đỉnh của đồ thị, nên một cạnh sẽ đóng góp 2 đơn vị vào tổng số bậc của tất cả các đỉnh

Hệ quả: 
- _tổng số bậc của tất cả các đỉnh luôn là số chẵn_
- _Trong đồ thị, tổng số bậc của các đỉnh có bậc lẻ luôn là một số chẵn._

Chứng minh: Gọi L và C lần lượt là tập các đỉnh có bậc lẻ và các đỉnh có bậc chẵn của đồ thị. 

Ta có: 

Tổng số bậc của đồ thị bằng tổng bậc của các đỉnh từ tập L và tập C

$$ 2E=∑deg(v)= ∑_{v ∈ L}deg(v) + ∑_{v ∈ C}deg(v) $$

Vì bất cứ số nào nhân với 2 đều trả về kết quả chẵn nên 2E luôn chẵn

Mặt khác $ ∑_{v ∈ C}deg(v) $ luôn chẵn vì mỗi đỉnh $v$ đều có bậc chẵn
 
Do đó $ ∑_{v ∈ L}deg(v) $ chẵn

⇒ điều phải chứng minh

Nhận xét:

_Trong quá trình duyệt đồ thị được biểu diễn bằng danh sách kề, mỗi cạnh sẽ được duyệt chính xác hai lần đối với đồ thị vô hướng (vì mỗi cạnh sẽ được lưu trong 2 danh sách kề của 2 đỉnh). Còn đối với đồ thị có hướng, mọi cạnh của đồ thị chỉ được duyệt chính xác một lần._

# Độ phức tạp thuật toán

__Độ phức tạp thời gian (Time complexity)__

Gọi V là số lượng đỉnh và E là số lượng cạnh của đồ thị.

Trong quá trình BFS, cách biểu diễn đồ thị có ảnh hưởng lớn tới chi phí về thời gian thực hiện giải thuật

- Nếu đồ thị biểu diễn bằng danh sách kề:
    + Thuật toán sẽ được thực hiện một cách tối ưu nhất về mặt thời gian nhờ khả năng duyệt qua các đỉnh kề trong danh sách một cách hiệu quả.

    + Mảng visited[] sẽ ngăn chặn một đỉnh được ghé thăm nhiều lần để tối ưu hiệu suất. Do đó, độ phức tạp thời gian sẽ chỉ là O(V) 

    + Bất cứ khi nào một đỉnh được thăm, mọi cạnh kề với đỉnh đó đều được duyệt với thời gian dành cho mỗi cạnh là O(1). Từ phần nhận xét của __định lý Bắt tay (Handshaking lemma)__, ta sẽ mất thêm độ phức tạp thời gian O(E) dành cho việc duyệt các cạnh.

Nhìn chung, độ phức tạp thời gian của thuật toán trong trường hợp này là O(V+E). Đây là cách cài đặt tốt nhất.

- Nếu đồ thị được biểu diễn bằng ma trận kề:
    + Ta cũng sẽ mất độ phức tạp thời gian O(V) dành cho việc thăm các đỉnh (giải thích tương tự như trên).
    
    + Với mỗi đỉnh được thăm, ta sẽ phải duyệt qua toàn bộ các đỉnh của đồ thị để kiểm tra đỉnh kề với nó. Do đó, thuật toán sẽ mất tổng cộng $O(V^2)$

__Độ phức tạp không gian (Space complexity)__

Tại mọi thời điểm, trong hàng đợi queue có không quá V phần tử. Do đó, độ phức tạp bộ nhớ là O(V).

# Phần nâng cao

## Ứng dụng BFS để xác định thành phần liên thông

Nhắc lại: 
- Một đồ thị được gọi là liên thông (connected) nếu có đường đi giữa mọi cặp đỉnh phân biệt của đồ thị. 

- Mỗi một cặp đỉnh hoặc nhiều cặp đỉnh như vậy nối với nhau được gọi là __thành phần liên thông__ của đồ thị

- Các thành phần liên thông có thể có quan hệ "tương đương" với nhau

![](/pictures/TPLThong.png)


Nguồn: [_VNOI_](https://vnoi.info/wiki/algo/graph-theory/breadth-first-search.md)


