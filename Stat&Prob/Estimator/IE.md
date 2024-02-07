# Ước lượng khoảng (Interval Estimation)

Ước lượng khoảng là một trong những rẽ nhánh của bài toán ước lượng hợp lý (Likelihood Estimation )

Trong chủ đề MLE, ta đã định nghĩa likelihood $L(θ) $ là một hàm đo lường mức độ "phù hợp" của bộ tham số  $θ$ dựa trên các kết quả $x_1,x_2,...,x_n$

- $L(θ)= f(x_1,x_2,...,x_n | θ_1,θ_2,...,θ_k)$  (nếu  X  liên tục)
- $L(θ)= p(x_1,x_2,...,x_n | θ_1,θ_2,...,θ_k)$  (nếu  X  rời rạc)

Trong đó:
- $x_1,x_2,...,x_n$ là các kết quả đầu ra của X 
- $θ_1,θ_2,...,θ_k$ là các tham số của bộ $θ$

Tuy nhiên, cần lưu ý rằng, đôi khi ta không thể ước lượng chính xác bộ tham số $θ$ vì các giá trị tham số có thể rơi vào một khoảng nào đó. Ta gọi đó là _khoảng tin cậy (confidence interval - CI)_. 

Điều này giống như việc tính xác suất để ném một hạt cát trúng vào một hạt cát khác trên một dải sa mạc rộng lớn. Kết quả là ta không bao giờ có thể tính chính xác tỷ lệ đó vì một hạt cát sẽ bị ảnh hưởng bởi nhiều yếu tố. Nhưng ta có thể tính xác suất để nó rơi vào một vùng nào đó gần nhất với mục tiêu mà ta muốn ném trúng.

__Khái niệm khoảng tin cậy__

_Khoảng tin cậy (confidence interval - CI) được hiểu là khoảng giá trị mà bộ tham số θ có thể rơi vào với một xác suất là $ 100(1 - \alpha)$% . Xác suất đó được gọi là __độ tin cậy__, hoặc __mức ý nghĩa__. Nó cho ta biết được tần suất mà θ có thể rơi vào khoảng tin cậy._

Phủ định lại, ta nói $\alpha$ là mức độ "không đáng tin", hay chính là xác suất mà θ không rơi khoảng tin cậy đó. Thường thì ta mặc đinh $\alpha$ là 0.05. Khi đó độ tin cậy sẽ là độ tin cậy sẽ là 0.95

Phân phối xác suất  của độ tin cậy luôn là phân phối chuẩn

![](/pictures/CI.jpeg)

## Phương pháp ước lượng khoảng (c.i)

Bản chất của ước lượng c.i chính là tìm ra một khoảng giá trị phù hợp với θ. Trong thực tế, ta thực hiện điều này bằng việc thu thập mẫu dữ liệu từ tổng thể.

Nếu mẫu có n dữ liệu là $x_1, x_2,..., x_n$ thì tồn tại 2 giới hạn a và b của một khoảng (a, b) sao cho:
$$(a, b) = (d_1(x_1, x_2,..., x_n), d_2(x_1, x_2,..., x_n))$$

Trong đó, $d_1$ và $d_2$ là thống kê mô tả của các dữ liệu $x_1, x_2,..., x_n$.

_Nhắc lại: thống kê mô tả của một tập dữ liệu là các tham số của phân phối dữ liệu đó. Hay nói cách khác thì $d_1$ và $d_2$  chính là $θ_1$ và $θ_2$_

Như vậy, bài toán lúc này trở thành "tìm $θ_1$ và $θ_1$ sao cho $θ_1$ < θ < $θ_2$". Tuy nhiên, tùy thuộc vào θ có tham số nào mà bài toán sẽ có những phương pháp ước lượng khác nhau.

__Ước lượng c.i cho Kỳ vọng__

Giả sử một tổng thể có phân phối chuẩn $N(\mu, \sigma^2)$ với kì vọng $\mu$ chưa biết và mẫu được trích từ tổng thể là $x_1, x_2,..., x_n$ . Bài toán đặt ra là tìm khoảng tin cậy cho $\mu$ với độ tin cậy $ 100(1 - \alpha)$% cho trước.

_Trường hợp 1 - đã biết giá trị của $\sigma^2$ của tổng thể_

- Bước 1: xác định trung bình mẫu $\mu_0 = \frac{x_1+x_2+...+x_n}{n}$

- Bước 2: với độ tin cậy $ 100(1 - \alpha)$%, xác đinh $\alpha$. Từ đó, xác định $Z_\frac{\alpha}{2}$ bằng phương pháp tra bảng ngược

_Nhắc lại, tra bảng ngược được thực hiện bằng cách tìm  giá trị xác suất $1 - \frac{\alpha}{2}$ của biến ngẫu nhiên $Z_\frac{\alpha}{2}$ trong bảng phân phối Z_

- Bước 3: Tính độ chính xác $$\epsilon = Z_\frac{\alpha}{2} (\frac{\sigma}{\sqrt{n}}) $$

- Khoảng tin cậy cần tìm $(\mu_0 - \epsilon, \mu_0 + \epsilon)$


Khoảng tin cậy rất có ý nghĩa trong thực tiễn. Nó cho phép  ta ước lượng hợp lý tham số chính xác dựa trên việc 

Nguồn: [elearning.tcu.edu.vn](https://elearning.tcu.edu.vn/1156/73_c_lng_khong.html)

[luatduonggia.vn](https://luatduonggia.vn/khoang-tin-cay-la-gi-nhung-quan-niem-sai-lam-ve-khoang-tin-cay/)
