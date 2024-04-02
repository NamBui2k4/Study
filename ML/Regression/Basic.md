# Linear Regression

Trong bài này, tôi sẽ giới thiệu một trong những thuật toán cơ bản nhất (và đơn giản nhất) của Machine Learning. Đây là một thuật toán Supervised learning có tên Linear Regression (Hồi Quy Tuyến Tính). Bài toán này đôi khi được gọi là Linear Fitting (trong thống kê) hoặc Linear Least Square

## 1. Giới thiệu

**Hãy thử đặt câu hỏi**

Một căn nhà rộng $x_1$ $m^2$, có $x_2$ phòng ngủ và cách trung tâm thành phố $x_3$ km có giá là bao nhiêu ?

**Lời giải khả thi**

Gọi y là giá của một căn nhà mà ta cần dự đoán.

Một cách đơn giản nhất, chúng ta có thể thấy rằng: 
- diện tích nhà ($x_1$) càng lớn thì giá nhà càng cao; 
- số lượng phòng ngủ ($x_2$) càng lớn thì giá nhà càng cao; 
- càng xa trung tâm ($x_3$) thì giá nhà càng giảm

Quy luật của bài toán ở ngay đó, thế nhưng lời giải vẫn rất mơ hồ. Vì ta không biết y sẽ thay đổi thế nào nếu cả 3 đại lượng trên cùng thay đổi. 

Giả sử chúng ta đã đi khảo sát 1000 căn nhà và biết $x_1$, $x_2$ ,$x_3$ của mỗi căn là bao nhiêu. 

Vậy thì quan hệ giữa chúng và y là gì? Câu trả lời chính là hàm $f(x)$:    

$$ f(x) = w_1 x_1 + x_2 w_2 + x_3 w_3 + w_0 \text{  (1)}$$ 

Trong đó, $w_1, w_2, w_3, w_0$ là các hằng số chưa biết, $w_0$ còn được gọi là bias.

Khi chúng ta xác định rõ ràng f(x) là gì thì ta có  quan hệ $y≈f(x)$, nghĩa là giá nhà được dự đoán theo hàm f(x). Đây chính là một mối quan hệ tuyến tính (linear). 

Bài toán chúng ta đang làm là đi tìm các hệ số $w_1,w_2,w_3,w_0$ sao cho f(x) tối ưu nhất có thể.
Chính vì vậy nó được gọi là bài toán Linear Regression.

## 2. Phân tích toán học


### Dạng của Linear Regression

Nếu bạn để ý, phương trình (1) chính là tích của 2 ma trận cột $w$ và ma trận hàng $\bar{x}$

[$w_0$]

[$w_1$]      _ _  _ _ _và_ _ _ _ _ $[1,x_1,x_2,x_3]$

[$w_2$]

[$w_3$]


Khi đó, phương trình (1) có thể được viết lại dưới dạng:

$$ y ≈ \bar{x}w=\hat{y}$$
***Lưu ý về ký hiệu toán học***: 

- Các số được biểu diễn bởi chữ cái không in đậm, có thể viết hoa, ví dụ $x_1,N,y,k$. 
- Các vector được biểu diễn bằng các chữ cái thường in đậm, ví dụ $y,x_1$. 
- Các ma trận được biểu diễn bởi các chữ viết hoa in đậm, ví dụ $X,Y,W$ .