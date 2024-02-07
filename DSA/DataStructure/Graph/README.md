# Đồ thị (Graph)
Trong thực tế, có nhiều đối tượng hoặc thực thể tồn tại dưới dạng các hình học đặc biệt như mạng lưới (ví dụ mạng xã hội, bản đồ, phân tử, mạng thần kinh nơ-ron ,...) mà ta không thể biểu diễn dưới dạng danh sách, cây, hay mảng các đối tượng. Tuy nhiên, ta có thể biểu diễn chúng dưới dạng đồ thị.
![](/pictures/Application.png)

## 1. Đồ thị là gì?
Graph (đồ thị) là một dạng cấu trúc dữ liệu lưu trữ các đối tượng, trong đó các đối tượng được kết nối với nhau bởi các link. Trong một đồ thị, mỗi đối tượng được biểu diễn bởi một thứ gọi là đỉnh (vertices), và các link mà chúng dùng để kết nối với nhau được gọi là các cạnh (edges).

![](/pictures/Graph.png)

__Định nghĩa:__
Một đồ thị G = (V, E) trong đó 
 - V là tập các đỉnh (vertices) 
 - E là tập các cạnh (edges) 
Một cạnh E<sub>i</sub> = (u , v) là một cặp đỉnh u và v kết nối với nhau

VD: 
![](/pictures/Example.png)

Trong hình trên, ta có đồ thị G = (V, E) trong đó:
- V = {a, b, c, d, e}
- E = {(a, b), (a, c), (d, a), (e, b), (d, e)}

__Tính chất__
- Hai đỉnh là kề nhau nếu chúng được kết nối với nhau thông qua một cạnh. 
- Các đỉnh cùng kết nối với một đỉnh khác thì chúng gọi là láng giềng của đỉnh đó

## 2. Bậc của một đỉnh trong đồ thị
Bậc của một đỉnh v trong đồ thị là số cạnh nối với đỉnh đó/ hoặc số láng giềng của nó. Ký hiệuu là $deg(v)$

__Tính chất__
- Đỉnh có $deg(v) = 0 $ gọi là đỉnh cô lập 
- Đỉnh có $deg(v) = 1 $ gọi là nút 
- Đối với đồ thị có hướng, bậc được chia làm 2 loại:
    * Bậc trong: Số cạnh kết thúc tại đỉnh v, ký hiệu $ deg^{-}(v) $
    * Bậc ngoài: Số cạnh xuất phát từ đỉnh v, ký hiệu $ deg^{+}(v) $
- tổng số bậc của đồ thị: $ deg(v) = deg^{-}(v) + deg^{+}(v) $
- đỉnh chỉ có $ deg^{+}(v) $ là đỉnh phát
- đỉnh chỉ có $ deg^{-}(v) $ là đỉnh thu

![](/pictures/dinh-ke-nhau.png)

## 3. phân loại đồ thị

Một đồ thị có thể có hướng (directed) hoặc vô hướng (undirected)
- Đồ thị vô hướng là đồ thị đơn giản nhất. 

- Đồ thị có hướng là đồ thị mà giữa các đỉnh sẽ được nối với nhau bởi một vector. Từ một đỉnh, sẽ có một hoặc nhiều vector trỏ đến đỉnh khác hoặc không có vector nào (tức là ngõ cụt)
![](/pictures/direct-undirected.jpg)

Một đồ thị có thể có trọng số(weighted) hoặc không có trọng số (unweighted). Trọng số  là độ dài của các cạnh kết nối 2 đỉnh với nhau. 
![](/pictures/weighted-unweighted.png)

Như vậy, khi hoán vị các điều kiện ràng buộc trên, ta có 4 loại đồ thị cơ bản:

- undirected unweighted graph

- directed unweighted graph

- directed weighted graph

- undirected weighted graph

Ngoài ra, còn có nhiều loại đồ thị đa dạng khác như:

__Đồ thị thưa thớt (Sparse Graph)__

Đồ thị thưa thớt là một loại đồ thị mà số lượng cạnh trong đồ thị rất ít so với số lượng đỉnh. Điều này có nghĩa là các đỉnh trong đồ thị thưa thớt không có nhiều kết nối với nhau

![](/pictures/sparse-graph.png)

__Đồ thị dày đặc (Dense Graph)__

Ngược lại với đồ thị thưa thớt, đồ thị dày đặc là một loại đồ thị có số cạnh lớn so với số đỉnh. Một đồ thị dày đặc thường có nhiều mối quan hệ giữa các đỉnh, và có thể được sử dụng để biểu diễn các dữ liệu phức tạp như mạng xã hội, mạng sinh học, hợp chất hóa học, v.v.

![](/pictures/Dense-graph.png)

__Đồ thị đầy đủ__

Giống như một phiên bản hoàn chỉnh của đồ thị dày đặc, đồ thị đầy đủ là đồ thị mà giữa 2 cạnh bất kỳ luôn có đỉnh nối với nhau.

![](/pictures/Complete-graph.png)

Đồ thị đầy đủ giống như một đa giác lồi có các đường chéo. Khi đó, công thức tính số cạnh của đồ thị là $ \frac{n(n - 1)}{2} $


__đồ thị có chu trình__

![](/pictures/circle-graph.png)
 
chu trình trong đồ thị là một dây chuyền đóng. Nói cách khác,  trong một chu trình, ta có thể xuất phát từ một đỉnh và quay lại đỉnh đó nhiều lần 

- Các loại chu trình:
    * Chu trình chẵn: là chu trình có tổng trọng số là chẵn.
    * Chu trình lẻ: là chu trình có tổng trọng số là lẻ.
    * Chu trình đơn: là chu trình không đi qua một cạnh quá một lần.
    * Chu trình có hướng: là một chu trình đơn mà mọi cung trong đó đều cùng hướng, nghĩa là mọi đỉnh đều có bậc trong và bậc ngoài bằng 1.
    * Chu trình sơ cấp: là chu trình không chứa cùng một đỉnh quá một lần (trừ đỉnh đầu và đỉnh cuối)
    * Chu trình Euler: là chu trình qua tất cả các cạnh, mỗi cạnh đúng một lần

__đồ thị liên thông__

Một đồ thị được gọi là liên thông (connected) nếu có đường đi giữa mọi cặp đỉnh phân biệt của đồ thị. Ngược lại, đồ thị này được gọi là không liên thông (disconnected).

![](/pictures/connectivity-graph.png)

__đồ thị lưỡng phân (bipartite graph)__

 Đồ thị lưỡng phân (bipartite graph) phân là một đồ thị đặc biệt, trong đó các đỉnh sẽ được gom lại thành nhiều tập hợp thỏa điều kiện:
 * các tập không giao nhau
 * các đỉnh trong một tập không link với nhau
 * tuy nhiên, các đỉnh của tập này có thể link với các đỉnh của tập kia


![](/pictures/Simple-bipartite-graph.svg.png)

# Biểu diễn đồ thị 
## 1. Sử dụng Ma trận kề (adjacenct matrix)

__Ma trận kề là gì ?__

    Ma trận kề biểu diễn một đồ thị (graph) dưới
    dạng một mảng 2 chiều có cùng hàng và cột, mảng
    sẽ chứa các con số nhị phân 0 và 1. Trong đó,
    số 1 mang ý nghĩa là "có 1 cạnh giữa 2 đỉnh u
    và v", còn 0 thì ngược lại là "không có".

__Định nghĩa__

Xét đồ thị G = (V, E) vô hướng hoặc có hướng. Giả sử tập V chứa n đỉnh $ v_1, v_2, v_3,..., v_n $ và tập E chứa m cạnh $ e_1, e_2, e_3,..., e_m $ . Khi đó, ta có thể biểu diễn đồ thị bằng ma trận kề $ a[n][n] $ thỏa điều kiện:
\[
\begin{cases}
    a[i][j] = 0 \text{ nếu không có cạnh nối từ 2 đỉnh } v_i \text{ và } v_j \\
    a[i][j] = 1 \text{ nếu có cạnh nối từ 2 đỉnh } v_i \text{ và } v_j
\end{cases}
\]


Ma trận kề có Space complexity (độ phức tạp không gian) là $ O(V^2) $
![](/pictures/AM.png)

__Triển khai ma trận kề__

Trong lập trình, để triển khai ma trận kề, ta chỉ cần quan tâm tham số duy nhất là số đỉnh n. 
Để cho tiện, ta sẽ cần một bảng có n hàng và n cột trong file .txt sau đó đưa bảng vào mã nguồn bằng cách: duyệt qua từng phần tử của ma trận và dùng phương thức nhập chuẩn với phần tử đó. 


Cách thực hiện:
- xác định n đỉnh của một đồ thị
- Khởi tạo một ma trận a[n] [n] . 
- duyệt qua từng phần tử a[i] [j] và nhập giá trị cho chúng theo nguyên tắc:

    + Khi đồ thị vô hướng, nếu giữa đỉnh i và đỉnh j có một cạnh thì nhập $ a[i][j] = a[j][i] = 1 $, ngược lại nếu giữa chúng không có cạnh nào thì  $ a[i][j] = a[j][i] = 0 $. 
    
    VD:
    ```
    java AM 4 4
        0  1  0  1
        1  0  1  0
        0  1  0  1 
        0  1  0  0
    ```
    
    Minh họa kết quả dưới hình sau:
    ![](/pictures/AM-undirected.jpeg)

    Trong hình trên, vì đồ thị vô hướng, giữa 2 và 0 có một cạnh nên phần tử $ [2][0] = [0][2] = 1 $ . Và ngoài ra, ta nhận thấy tất cả các ô $ [i][j] $ và $ [j][i] $ đều bằng nhau ( ví dụ cặp ô $ [0][1] = [1][0] = 1 $)

    Từ đây, ta rút ra một tính chất mới:

        Đối với đồ thị vô hướng, các phần tử [i][j]
         và [j][i] đối xứng với nhau qua đường
        chéo chính
 
    + khi đồ thị có hướng, nếu đỉnh i có cạnh hướng tới đỉnh j thì ta gán $ a[i][j] $ = 1 nhưng ngược lại thì chưa chắc (tức là nếu j __không__ hướng  đến i thì ta gán $ a[j][i] = 0 $)
    
    VD:

    ```
    java AM 4 4
        0  1  1  0
        0  0  0  0
        0  1  0  0 
        0  1  0  0
    ```

    Minh họa kết quả dưới hình sau:
    ![](/pictures/AM-directed.jpeg)

    Có thể thấy, mặc dù giữa 0 và 2 đều có một cạnh nhưng đường đi chỉ có duy nhất từ 0 đến 2 mà không có hướng ngược lại, nghĩa là $ [0][2] = 1 $ còn $ [2][0] = 0 $

## 2. Sử dụng Danh sách kề (adjacenct linkedlist)

__Danh sách kề là gì?__

    Danh sách kề (Adjacency list) biểu diễn một đồ
    thị (graph) dưới dạng một mảng các danh sách
    liên kết. Trong đó, chỉ số mảng đại diện cho
    đỉnh của đồ thị và các phần tử trong danh sách
    liên kết ứng với chỉ số đó chính là các láng
    giềng của đỉnh đó 

Danh sách kề có Space complexity là O(V + E)

Lấy ví dụ với một đồ thị dưới đây:

![](/pictures/do-thi.png)

Với đồ thị phía trên, chúng ta có thể biểu diễn nó vào bộ nhớ máy tính dưới dạng một mảng các danh sách liên kết như hình vẽ dưới đây:

![](/pictures/AL.png)

Đồ thị của chúng ta có 4 đỉnh (0, 1, 2 và 3). Do đó, chúng ta cũng sẽ có 4 danh sách liên kết cho 4 đỉnh đó. Trong mỗi danh sách liên kết, node head chính là đỉnh của đồ thị, các node phía sau head là các láng giềng của đỉnh đó. Thứ tự các node phía sau head được sắp xếp theo thứ tự tăng dầng mỗi đỉnh

VD: 
- xét danh sách đầu tiên: ```0 -> 1 -> 2 -> 3```
ý nghĩa của nó là " đỉnh 0 có các láng giềng (2, 1 ,3). Các láng giềng có thứ tự là 1 -> 2 -> 3
    
- xét danh sách thứ 2: ```1 -> 0 -> 2```
ý nghĩa của nó là " đỉnh 1 có các láng giềng (2, 0). Thứ tự của láng giềng là 0-> 2

- xét danh sách thứ 3: ```2 -> 0 -> 1```
ý nghĩa của nó là " đỉnh 2 có các láng giềng (1, 0). Thứ tự của láng giềng là 0-> 1

- xét danh sách thứ 4: ```3 -> 0```
ý nghĩa của nó là " đỉnh 3 chỉ có một láng giềng là 0. Do đó, Không có có thứ tự

__Ưu điểm của danh sách kề__

- So với ma trận kề (adjacency matrix), biểu diễn đồ thị dưới dạng danh sách kề giúp tiết kiệm bộ nhớ hơn. Ta sẽ thấy rõ điều này khi biểu diễn đồ thị có số lượng lớn đỉnh nhưng có ít số cạnh (kết nối).
- Việc duyệt các đỉnh kề với một đỉnh nào đó cũng cực kỳ nhanh chóng do mỗi đỉnh chỉ kết nối tới các đỉnh kề với nó.

__Nhược điểm của danh sách kề__
- Việc remove cạnh sẽ tốn chi phí để duyệt danh sách.
- Chi phí kiểm tra 2 cạnh có kết nối nhau không sẽ lớn hơn ma trận kề do phải duyệt danh sách.

__Triển khai danh sách kề__

Tương tự ma trận kề, ta cũng chỉ cần quan tâm đồ thị có bao nhiêu đỉnh để tạo một mảng chứa bấy nhiêu linkedlist. 

Duyệt quả từng danh sách trong mảng. Tuy nhiên, việc duyệt  có chút khác biệt so với ma trận kề: 

_thay vì duyệt từng phần tử [i] [j], ta sẽ duyệt theo cạnh._

Giải thích: _mục đích của danh sách kề là tìm ra các láng giềng của một đỉnh cho trước. Mà theo lý thuyết, đỉnh b được gọi là láng giềng của a nếu giữa chúng có một cạnh. Như vậy, muốn biết một đỉnh có bao nhiều láng giềng thì căn cứ vào số cạnh chứa đỉnh đó. Việc duyệt theo số cạnh sẽ đem lại kết quả chính xác nhất_

Cách thực hiện:

- xác định n đỉnh của một đồ thị
- Khởi tạo một mảng a[n] chứa n linkedlist và khởi tạo từng linkedlist trong mảng đó. 
- Trong file .txt, khởi tạo các cạnh bằng một bảng có 2 cột:
    - cột 1: danh sách đỉnh_nguồn
    - cột 2: danh sách đỉnh_đích

Mỗi một hàng trong bảng chính là một cạnh của 2 đỉnh
Số hàng trong bảng chính là số_cạnh của đồ thị

- Đưa bảng vào mã nguồn theo thuật toán:
```
    for i < số_cạnh:
        u = đỉnh_nguồn[i]
        v = đỉnh_đích[i]

        a[u] : thêm v vào a[u]  // a[u] là linkedlist thứ u
        a[v] : thêm u vào a[v] // a[v] là linkedlist thứ v
```
Minh họa:
- input:

```
       
        0    1   
        0    2   
        1    2   
        1    3   
        2    4   
        3    4   
        4    5   
```
- output:

```
        0: 1 -> 2
        1: 0 -> 2 -> 3
        2: 0 -> 1 -> 4
        3: 1 -> 4
        4: 2 -> 3 -> 5
        5: 4
        6:
```
## 3. Sử dụng Danh sách cạnh (Edges LinkedList)

So với 2 cách trên, biểu diễn danh sách cạnh có vẻ đơn giản hơn nhiều 

    Trong trường hợp biết trước đồ thị có N đỉnh và
    M cạnh, ta có thể biểu diễn đồ thị dưới dạng
    một danh sách các cạnh (u,v) của đồ thị. 
    Nếu là đồ thị có hướng thì mỗi cặp đỉnh (u,v)
    ứng với một vector u  → v .Trong lập trình,
    Vector hoặc mảng là một kiểu dữ liệu rất phù
    hợp để lưu trữ danh sách cạnh

Danh sách cạnh có Space comlexity là O(E)

Vi du: đồ thị G(V, E) duới đây có 5 đỉnh, 6 cạnh theo thứ tự là:

(1,3), (1,4), (3, 4), (3, 2), (5, 3), (2, 5):

![](/pictures/EL-graph.png)

Biểu diễn các cạnh của đồ thị, ta được bảng sau:

![](/pictures/EL-table.png)

Cách triển khai của danh sách cạnh sẽ giống như danh sách kề. Khác biệt ở chỗ, ta sẽ tạo một đối tượng Edge để lưu ba tham số (u,v,w), trong đó u và v là 2 đỉnh của một cạnh và w là trọng số của cạnh đó.

Cách thực hiện:
- Khởi tạo một linkedlist
- Trong file .txt, ta khởi tạo một bảng có 3 cột:
    - cột 1: danh sách đỉnh_nguồn
    - cột 2: danh sách đỉnh_đích
    - cột 3: danh sách trọng_số (nếu có)

Mỗi một hàng trong bảng chính là một cạnh của 2 đỉnh
Số hàng trong bảng chính là số_cạnh của đồ thị

- Đưa bảng vào mã nguồn theo thuật toán:
```
    for i < số_cạnh:
        u = đỉnh_nguồn[i]
        v = đỉnh_đích[i]
        w = trọng_số[i]

        Khởi tạo đối tượng Edge(u,v,w)
        thêm Edge(u,v,w) vào linkedlist
```
\
__Ưu điểm của danh sách cạnh__

-   Trong trường hợp đồ thị ít cạnh, cách biểu diễn này sẽ giúp tiết kiệm không gian lưu trữ.
-   Ở một số trường hợp đặc biệt, ta phải xét tất cả các cạnh trên đồ thị thì phương pháp cài đặt này giúp việc duyệt cạnh dễ dàng hơn trong O(M) (ví dụ giải thuật tìm cây khung nhỏ nhất Kruskal).

__Nhược điểm của danh sách cạnh__
 Trong trường hợp cần duyệt các đỉnh kề với một đỉnh u, bắt buộc phải duyệt qua mọi cạnh, lọc ra các cạnh có chứa đỉnh u và xét đỉnh còn lại. Điều này sẽ tốn thời gian nếu đồ thị có nhiều cạnh.

__Phù hợp khi nào:__ Trong các bài toán cần duyệt toàn bộ cạnh, tiêu biểu như trong giải thuật Kruskal.