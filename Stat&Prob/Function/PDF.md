# Hàm mật độ xác suất - Probability density function (PDF)
Trong toán học, hàm mật độ xác suất dùng để biểu diễn một phân bố xác suất theo tích phân. Hàm mật độ xác suất luôn có giá trị không âm và tích phân của nó từ −∞ tới +∞ có giá trị bằng 1. Nếu một phân bố xác suất có mật độ f(x), thì về mặt trực quan, khoảng vi phân (vô cùng bé) [x, x + dx] có xác suất bằng f(x) dx.

# Định nghĩa
Một hàm mật độ xác suất (Tiếng Anh là Probability density function hay PDF) là một hàm bất kỳ f(x) mô tả mật độ xác suất theo biến đầu vào x theo cách dưới đây.

- $ f(x) > 0 \quad \forall x \in R $
- Tổng diện dích bên dưới đồ thị là 1 bởi nó chính là tổng xác suất của tất cả biến ngẫu nhiên trong tập dữ liệu:
$$ ∫_{-\infty}^{+\infty} f(x)\,dx = 1 $$

Về bản chất pdf là đạo hàm của cdf. 

Về nguyên tắc, người ta quy định Ký hiệu của cdf là F(x), pdf là f(x)

    f = F' <=> pdf = (cdf)'

Trên thực tế, ta không dùng đến $ -\infty \quad và \quad +\infty $ để tính mật độ xác suất mà ta sẽ xét trên một đoạn [a,b] cụ thể, công thức tổng quát là: 
    $$ P(X \in (a,b)) = P(a < X < b ) = ∫_{a}^{b} f(x)\,dx $$

Biểu diễn trên đồ thị:

![](/pictures/PDF.png)

Ví dụ, biến x trong đoạn [4.3,7.8] sẽ có xác suất thực sự là:
$$ P(X \in (4.3,7.8)) = P(4.3 < X < 7.8 ) = ∫_{4.3}^{7.8} f(x)\,dx  $$


Lưu ý rằng: hàm mật độ xác suất không cho ta biết được xác suất của một điểm dữ liệu cụ thể mà chỉ cho ta biết xác suất của một khoảng nhất định trong tập dữ liệu. Chẳng hạn, ta không bao giờ biết xác suất để một người nào đó cao đúng 1m75 nhưng có thể biết họ cao vào khoảng 1m74 - 1m76 với xác suất là $ P(1.74 < X < 1.76) $