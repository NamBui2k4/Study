# Giá trị kỳ vọng (Expectation)

_Trong xác suất và thống kê, kỳ vọng hay giá trị kỳ vọng , được hiểu là giá trị trung bình của một biến ngẫu nhiên._

Tuy nhiên, nói như vậy vẫn quá mơ hồ. Ta sẽ định nghĩa chính xác hơn về kỳ vọng.

# Định nghĩa toán học

Nhắc lại: Trong thống kê, ta có 2 loại biến ngẫu nhiên (r.v): 
-   Biến liên tục (cont):
    + tồn tại trong các khoảng mà ta không thể đếm được có bao nhiêu giá trị. Ví dụ : khoảng (0, 1)
    + thường liên quan đến các công thức tính mật độ xác suất

    $$  p(x) = ∫_{\infty}^{\infty} f(x) dx $$

-   biến rời rạc (discrete):
    + tồn tại trong các khoảng mà ta có thể đếm được từng giá trị. Ví dụ: {1, 2, 3, 4, 5}
    + thường liên quan đến các công thức tính khối xác suất
    $$ f(x) = P(X = x) $$

Nếu X là một biến liên tục với hàm mật độ xác suất f(x) thì Kỳ vọng của các giá trị được ánh xạ từ biến ngẫu nhiên là 
    
$$ E(x) = ∫_{\infty}^{\infty} xf(x) dx $$

Nếu X là một biến rời rạc với hàm khối xác suất p(x) thì Kỳ vọng của các giá trị được ánh xạ từ biến ngẫu nhiên là 
    
$$ E(x) = x_1 p(x_1) + x_2 p(x_2) + ... + x_n p(x_n)= ∑ x_i p(x_i) dx $$

# Ví dụ thực tế

Ví dụ 1:

Giả sử bạn đang đánh bạc tại một sòng bạc và trò chơi được thiết lập để bạn có thể thắng 100 đô la, thua 1 đô la hoặc thua 5 đô la, nhưng xác suất bạn thắng 100 đô la chỉ là 1%. Và giả sử có 49% khả năng bạn sẽ mất 1 đô la và 50% khả năng bạn sẽ mất 5 đô la. Giá trị tiền thắng cược dự kiến ​​của bạn (Y) được đưa ra bởi:
$$ E (Y) = 100.0,01 + (-1).0,49 + (-5).0,5 = - 1,99 $$ (đô la)

Vì vậy, số tiền thắng dự kiến ​​của bạn là - $ 1,99. Nói cách khác, bạn dự kiến ​​sẽ mất 1,99 đô la.

Không phải ngẫu nhiên mà giá trị kỳ vọng là âm. Các sòng bạc cố tình thiết lập trò chơi của họ để có giá trị kỳ vọng âm, bởi vì đó là cách họ kiếm tiền từ bạn

Ví dụ 2:

Giả sử bạn tung một con xúc xắc sáu mặt (đánh số từ 1 đến 6). Nếu ta coi mỗi lần tung là một biến ngẫu nhiên X nhận 1 giá trị $ x_i $ từ tập {1, 2, 3, 4, 5, 6} với xác suất để xuất hiện là $ P(X = x_i) = \frac{1}{6} $ thì kỳ vọng mà ta nhận được sẽ là:

$$ E(X) = ∑_{i = 1}^{6} x_i P(X = x_i) =\frac{1}{6}(1+2+3+4+5+6) = 3.5 $$



Giá trị kỳ vọng 3.5 trong bài toán này mang ý nghĩa là mức điểm trung bình mà bạn có thể mong đợi. Nếu bạn ném xúc xắc đủ nhiều lần và tính trung bình số điểm nhận được trong mỗi lần ném, thì giá trị này sẽ tiệm cận 3.5

# Sự khác biệt giữa trung bình và kỳ vọng

Cả trung bình lẫn kỳ vọng đều là khái niệm rất phổ biến trong toán học và thống kê. Hai loại phương tiện số học này về bản chất tương tự nhau mặc dù chúng cũng có một số khác biệt. Có chăng thì giá trị trung bình phổ biến hơn và được dạy ở các lớp cơ sở. Trong khi đó giá trị kỳ vọng lại là một phần của nghiên cứu thống kê ở các lớp cao hơn. 

Về lịch sử, khái niệm kỳ vọng nảy sinh do trò chơi cờ bạc và nó thường trở thành một vấn đề khi trò chơi không có kết thúc hợp lý, tức là người chơi không thỏa mãn với lợi ích nhận về khi phân phối tiền đặt cược. Nhà toán học nổi tiếng Pascal coi đó là một thách thức và đưa ra giải pháp bằng cách đề xuất giá trị kỳ vọng.


Về bản chất, giá trị trung bình là dạng trung bình "đơn giản nhất" được tính bằng cách lấy trung bình của tất cả các con số, trong khi đó giá trị kỳ vọng lại là dạng trung bình của một biến ngẫu nhiên có xác suất. 

Có thể hiểu khái niệm kỳ vọng bằng một ví dụ liên quan đến việc tung đồng xu. Bây giờ khi bạn tung đồng xu 10 lần, bạn mong đợi có 5 mặt ngửa và 5 mặt xấp. Đây được gọi là giá trị kỳ vọng vì xác suất nhận được một mặt trên mỗi lần tung là 0,5. Nếu bạn muốn mặt ngửa, xác suất nhận được mỗi lần tung là 0,5, giá trị kỳ vọng cho 10 lần tung là 0,5 x 10 = 5. Vì vậy, nếu p là xác suất của một sự kiện xảy ra và có n số sự kiện thì giá trị kỳ vọng là a = n x p. 

Trong trường hợp biến ngẫu nhiên X có giá trị thực, kỳ vọng và trung bình là như nhau. Chỉ khác nhau ở chỗ giá trị trung bình không tính đến xác suất, kỳ vọng thì có tính xác suất.

