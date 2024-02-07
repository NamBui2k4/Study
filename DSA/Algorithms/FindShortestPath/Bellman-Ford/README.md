## Thuật toán của Bellman Ford

Thuật toán Bellman Ford giúp chúng ta tìm đường đi ngắn nhất từ ​​một đỉnh tới tất cả các đỉnh khác của đồ thị có trọng số.

Nó tương tự như thuật toán Dijkstra nhưng nó có thể hoạt động với các đồ thị trong đó các cạnh có thể có trọng số âm.

_Lưu ý: Thuật toán Bellman-Ford chỉ nên áp dụng cho đồ thị có hướng. Trong  quá trình chạy thuật toán, ta sẽ phải duyệt qua tất cả các cạnh. Đồ thị vô hướng đồng nghĩa với việc ta phải duyệt mỗi cạnh đến 2 lần, và điều đó nghĩa là nếu ta có n cạnh thì ta sẽ phải duyệt $2^n$ lần_

## Tại sao người ta lại có những cạnh với trọng số âm trong đời thực?
Các cạnh mang trọng số âm thoạt đầu có vẻ vô dụng nhưng chúng có thể giải thích rất nhiều hiện tượng như dòng tiền, nhiệt giải phóng / hấp thụ trong phản ứng hóa học, v.v.

Ví dụ, nếu có nhiều cách khác nhau để tiếp cận từ hóa chất A này sang hóa chất B khác, mỗi phương pháp sẽ có các phản ứng phụ liên quan đến tản nhiệt và hấp thụ.

Nếu chúng ta muốn tìm tập hợp các phản ứng trong đó năng lượng tối thiểu là cần thiết, thì chúng ta sẽ cần tính đến sự hấp thụ nhiệt là trọng số âm và tản nhiệt là trọng số dương.

## Tại sao chúng ta cần phải cẩn thận với trọng số âm?

Các cạnh trọng số âm có thể tạo ra các chu trình trọng số âm, tức là một chu trình sẽ làm giảm tổng khoảng cách đường đi khi quay lại đỉnh đã ghé thăm.

![](/pictures/bellman_fords_algorithm.png)

Chu trình trọng số âm có thể cho kết quả không chính xác khi cố gắng tìm ra con đường ngắn nhất

Các thuật toán đường đi ngắn nhất như Thuật toán Dijkstra không có khả năng phát hiện một chu trình như vậy và có thể đưa ra kết quả không chính xác vì chúng có thể trải qua chu trình trọng số âm và giảm độ dài đường đi.

## Ý tưởng của thuật toán Bellman Ford

    Thuật toán Bellman Ford hoạt động bằng cách
    đánh giá độ dài của đường đi trong quá trình
    duyệt đồ thị từ một đỉnh tới các đỉnh còn lại.
    Sau đó, nó lặp đi lặp lại các bước tính đó để
    tìm các đường đi mới ngắn hơn các đường được
    đánh giá trước đó.

__Nguyên tắc của thuật toán__:

-  Nếu như một đồ thị có N đỉnh thì số lần lặp lại các bước tính sẽ là N - 1. Điều này đảm bảo rằng các đỉnh luôn được cập nhật trọng số liên tục

-  Sau khi tính toán xong xuôi, để xác định xem có tồn tại chu trình âm hay không, ta lặp lại bước tính đó một lần nữa nhưng với mục đích là kiểm tra xem trọng số có bị giảm đi trong quá trình duyệt hay không

Cụ thể hơn, ta sẽ có:

Bước 1: Xác định đồ thị ban đầu


![](/pictures/step1.png)

Bước 2: Xác định đỉnh bắt đầu. Ta sẽ đánh dấu đỉnh bắt đầu bằng con số 0 và các đỉnh còn lại tạm thời chưa biết thì sẽ được đánh dấu bằng giá trị $ \infty $ . 


![](/pictures/step2.png)

Bước 3: ghé thăm các láng giềng của đỉnh bắt đầu. Khi ghé thăm, mỗi láng giềng sẽ được cập nhật lại bằng cách lấy đỉnh bắt đầu + trọng số của cạnh nối với nó. 

![](/pictures/step3.png)

Tuy nhiên, việc cập nhật chỉ xảy ra với điều kiên:

    đỉnh bắt đầu + trọng số < láng giềng

\
![](/pictures/condition.png)

\
Hay nói cách khác:
```
    if ( đỉnh bắt đầu + trọng số < láng giềng ){

        láng giềng = đỉnh bắt đầu + trọng số
    }
```
\
Điều kiện trên rất quan trọng. Ngoài việc đảm bảo các láng giềng sẽ có trọng số nhỏ nhất thì ở bước kiểm tra chu trình âm, ta có thể xác định xem sự suy giảm có tiếp tục tái diễn hay không. Nếu đều đó xảy ra thì tồn tại chu trình âm. Lúc đó ta sẽ rơi vào nghịch thế của bài toán và không thể tìm ra được đường đi ngắn nhất

Bước này cần được lặp lại N - 1 lần để đảm bảo rằng các đỉnh được cập nhật liên tục

![](/pictures/step3.1.png)

\
![](/pictures/step3.2.png)

\
![](/pictures/step3.3.png)

\
![](/pictures/step3.4.png)
\
_Lưu ý: ở mỗi lần lặp, một đỉnh chỉ được cập nhật giá trị một lần, nếu phát hiện một giá trị tối ưu hơn thì ta nhường lại cho lần lặp tiếp theo_

Ta có thể tóm tắt các lần lặp trên qua bảng sau:

![](/pictures/table.png)

Bước 4: Sau khi hoàn thành các bước tính, thực hiện duyệt đồ thị một lần nữa để kiểm tra xem có tồn tại chu trình âm hay không. Việc duyệt tương tự như Bước 3 nhưng khác ở chỗ:

```
    if ( đỉnh bắt đầu + trọng số < láng giềng ){

        Báo lỗi "Tồn tại trọng số âm"
    }
```


## Triển khai thuật toán

Nếu để ý thì ta thấy toàn bộ quá trình tìm đường đi ngắn nhất bằng Bellman-Ford chỉ xoay quanh 3 thứ:

-   Đỉnh bắt đầu
-   Trọng số
-   Láng giềng

Do đó, trong quá trình triển khai thuật toán bằng code, ta sẽ sử dụng danh sách cạnh để biểu diễn đồ thị. Tất nhiên, vì một cạnh sẽ có cả 3 thuộc tính trên nên việc duyệt đồ thị sẽ đơn giản hơn rất nhiều 

__Các cấu trúc hỗ trợ thuật toán__:
- Lớp Edge → Biễu diễn một cạnh

- Danh sách cạnh → biểu diễn đồ thị

- Mảng parents → lưu trữ các đỉnh bắt đầu của mỗi láng 
giềng

- Mảng dinstances → Dùng để dánh dấu cho các đỉnh ( 0 nếu là đỉnh nguồn, $ \infty $ nếu là các đỉnh còn lại). Đồng thời, còn dùng để cập nhật mỗi láng giềng bằng dấu vết đã lưu lại 

_Lưu ý: Làm việc với mảng parents, ta sẽ dùng kỹ thuật đệ quy để truy xuất các đỉnh bắt đầu của một láng giềng_


Nguồn kham khảo

[_programiz.com_](https://www.programiz.com/dsa/bellman-ford-algorithm)

[_geeksforgeeks_](https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/)