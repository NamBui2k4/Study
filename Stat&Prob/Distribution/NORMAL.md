# Phân phối chuẩn (normal or Gaussian distribution)
Trong lý thuyết xác suất thống kê, phân phối chuẩn còn được gọi là phân phối Gauss, Nó là phân bố xác suất quan trọng nhất trong thống kê vì nó mô tả chính xác sự phân bố các giá trị của nhiều hiện tượng tự nhiên. Đôi khi nó còn được gọi là đường cong hình chuông vì đồ thị biểu diễn mật độ xác suất (PDF) của nó có dạng chuông

![](/pictures/NormalDistribution.jpg)

Phân phối chuẩn có nhiểu ứng dụng quan trọng như biểu diễn:
- Chiều cao của một người
- Kích thước của những thứ do máy móc sản xuất
- Sai số trong phép đo
- Huyết áp
- Điểm trong bài kiếm tra
- Điểm IQ

## Công thức phân phối chuẩn
Một biến ngẫu nhiên X được gọi là tuân theo phân phối chuẩn, ký hiệu  X ~  $ N(\mu, \sigma^2) $ khi và chỉ khi mật độ xác suất pdf của nó thỏa công thức:
    $$ \phi(x) = f(x,\mu, \sigma) = \frac{1}{\sigma \sqrt {2\pi} }e^{\frac{-(x - \mu )^2}{2\sigma^2}}  $$

Trong đó:
-   $ \mu $ là kỳ vọng
-   $ \sigma^2 $ là phương sai

Liên hệ với kiến thức từ bài viết STD.md, chúng  ta đã biết rằng độ lệch chuẩn $ \sigma $ của tổng thể được hiểu là mức độ phân tán của dữ liệu so với kỳ vọng.

Nếu độ lệch chuẩn càng nhỏ thì dữ liệu có xu hướng gần với giá trị kỳ vọng. Khi đó, biểu đồ sẽ trở nên hẹp hơn và có dạng hình chuông, điều đó có nghĩa là phân phối dữ liệu đã gần nhất với phân phối chuẩn

Ngược lại, Nếu độ lệch chuẩn càng lớn, dữ liệu sẽ bị phân tán nhiều hơn và biểu đồ trở nên rộng hơn. Nghĩa là phân phối càng rời xa với phân phối chuẩn. Do đó, để dữ liệu luôn tuân theo phân phối chuẩn, người ta luôn tìm mọi cách giảm độ lệch chuẩn nhiều nhất có thể.

![](/pictures/standard-deviation.png)

## Tính chất 
1. Nếu X ~ $ N(\mu, \sigma^2) $  Và Y = a + bX  thì Y ~ $ N(a + b\mu,  b^2\sigma^2) $

![](/pictures/transformation.png)

2. Nếu X ~ $ N(\mu_x, \sigma_y^2) $ và Y ~ $ N(\mu_y, \sigma_y^2) $ thì:
- __X + Y__ ~ $ N(\mu_x + \mu_y, \sigma_x^2 + \sigma_y^2 ) $
- __X - Y__ ~ $ N(\mu_x - \mu_y, \sigma_x^2 + \sigma_y^2 ) $


## Xác suất của một biến ngẫu nhiên tuân theo phân phối chuẩn

Xác suất để biến X ~ $ N(\mu, \sigma^2) $ tiệm cận và đạt ngưỡng một giá trị x nào đó trong tổng thể là:

\[ P(X ≦ x) = \int_{-\infty}^{x} \frac{1}{\sqrt{2\pi\sigma^2}} \exp\left(-\frac{(t - \mu)^2}{2\sigma^2}\right) dt \]
 

- được sử dụng khi ta muốn tính xác suất cụ thể với điều kiện là đã biết phân phối gì, giá trị kỳ vọng μ và độ lệch chuẩn σ bằng bao nhiêu.

Thường được sử dụng trong các phương pháp thống kê, đặc biệt là khi làm việc với bảng Z hoặc khi muốn so sánh giữa các phân phối khác nhau.
Tuy nhiên, thực tế là ít ai dùng công thức trên để tính toán vì nó quá phức tạp. Do đó, người ta đã dùng nó tính toán và cho ra toàn bộ các kết quả chính xác cho một lần duy nhất rồi đưa toàn bộ vào bảng sau:


