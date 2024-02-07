# Hàm phân phối tích lũy (CDF)
Trong thế giới ban ngày, xác suất là rất hữu ích. Từ dự báo thời tiết đến dự đoán xem đội bóng yêu thích của bạn có giành chiến thắng trong giải đấu hay không, tất cả đều dựa trên xác suất. Ngay cả thế giới giao dịch cũng dựa vào xác suất. 

Một nhà giao dịch đặt giao dịch của họ với xác suất tạo ra lợi nhuận. Nhưng làm thế nào để họ làm điều đó? Và làm thế nào chúng ta có thể xác định liệu một khoản đầu tư sẽ thu về lợi nhuận hay không? Câu trả lời tốt nhất cho câu hỏi này là Hàm phân phối tích lũy.
## 1. Định nghĩa
Trong lý thuyết xác suất, hàm phân phối tích lũy (Tiếng Anh: Cumulative distribution function hay viết tắt CDF) là hàm tính xác suất của một biến X nhận giá trị bằng hoặc nhỏ hơn một biến x khác. Về tổng quát, phân phối tích lũy được định nghĩa theo công thức:
$$ F(x) = P(X \leq x) = P(X \in (-\infty]) , \quad x \in R  $$  

Về chi tiết, nó sẽ được định nghĩa theo 2 trường hợp:
-   xét trên tập dữ liệu rời rạc. Công thức sẽ là 
    $$ F(x) = P(x_1) + P(x_2) + ... + P(x) = ∑_{x_i ≦ x} P(x_i)   $$

Lấy ví dụ đơn giản: giả sử ta tung một xúc sắc. Hỏi xác suất để xúc xắc xuất hiện ra số nút tối đa là 3 là bao nhiêu?

_Giải:_

Đối với loại vật đặc thù như con xúc xắc thì xác suất để xuất hiện bao nhiêu nút đi nữa vẫn luôn là 1/6 (vì bản chất nó chính là xác suất để xuất hiện một mặt trong tổng cộng 6 mặt của con xúc sắc). Do số mặt của con xúc sắc là đếm được (dữ liệu rời rạc). Do đó, xác suất để xuất hiện mặt có số nút nhỏ hơn 3 là:
    $$ F(x) = ∑_{x_i ≦ 3} P(x_i)  = P(x_1) + P(x_2) + P(x_3)  = 1/6 + 1/6 + 1/6 = 1/2 $$  

Giả sử, ta thay đổi yêu cầu bài toán là " số nút nhỏ hơn 3", tức là điều kiện sẽ trở thành $x_i < 3$ , xác suất sẽ được tính là:
    $$ F(x) = ∑_{x_i < 3} P(x_i)  = P(x_1) + P(x_2)  = 1/6 + 1/6 = 1/3 $$  

Đây chính là một trường hợp xảy ra thường thấy ở biến ngẫu nhiên rời rạc khi mà xác suất của nó lại không tính chung cho cả giá trị tận cùng trong tập hợp các xác suất có thể có (hiểu đơn giản là con số cuối cùng trong tập hợp các xác suất)

- xét trên tập dữ liệu liên tục. Công thức là:

.. ................ .. ..                  




Ngoài ra xác suất X nằm trong khoảng [a, b] là F(b) − F(a) nếu a < b. Theo quy ước, chữ F hoa được dùng cho hàm phân phối tích lũy, còn chữ f thường được dùng cho hàm mật độ xác suất và hàm khối xác suất.


Lưu ý rằng trong định nghĩa trên, dấu "nhỏ hơn hay bằng" ('≤') có thể được thay bằng dấu "nhỏ hơn" ('<'). Việc đó sẽ cho ra một hàm khác, nhưng hàm nào trong hai hàm đó cũng đều dễ dàng thu được từ hàm kia. Vấn đề cần nhớ là không nên dùng lẫn lộn hai kiểu trên, vì việc đó sẽ dẫn đến kết quả sai. Ở Châu Âu và Mỹ, người ta hầu như luôn luôn sử dụng quy ước dùng dấu '≤' thay vì dấu '<'.

Đặc biệt, nếu dấu '=' xảy ra, ta có "Xác suất điểm" (point probability) mà X có giá trị bằng đúng b là
$$ P( X = b ) = F(b) - lim_{x \rightarrow b}F(x) $$

## 2. tính chất:
- $ lim_{x\rightarrow -\infty}F(x) = 0 $
- $ lim_{x\rightarrow \infty}F(x) = 1 $



{\\displaystyle \\operatorname {P} (X=b)=F(b)-\\lim _{x\\to b^{-}}F(x)}
Liên hệ với hàm mật độ xác suất
Một hàm phân phối tích lũy F(t) tương ứng với một hàm mật độ xác suất f(x) là:

�
(
�
)
=
∫
−
∞
�
�
(
�
)
�
�
{\displaystyle F(t)=\int _{-\infty }^{t}\,f(x)\,dx}
Biến ngẫu nhiên
Một biến ngẫu nhiên, x, tuân theo hàm phân phối tích lũy F(x) có liên hệ với biến ngẫu nhiên đều y trong khoảng [0,1] thông qua công thức:

x == F-1(y)
trong đó F−1(y) là hàm ngược của F(x)


Nguồn: [wikiwan](https://www.wikiwand.com/vi/H%C3%A0m_ph%C3%A2n_ph%E1%BB%91i_t%C3%ADch_l%C5%A9y)