# Hàm khối xác suất - probability mass function
Trong lý thuyết xác suất, __hàm khối xác suất__ (probability mass function, viết tắt PMF) là một hàm số liên hệ với một biến ngẫu nhiên __rời rạc__. Hàm này cho ta biết __xác suất__ để một biến ngẫu nhiên rời rạc X bằng với một giá trị x nào đó trong miền giá trị của nó.

# Mô tả toán học

Giả sử  X : Ω → D (đọc là _một hàm X có thể ánh xạ giá trị từ tập Ω sang tập D_) là một biến ngẫu nhiên rời rạc. Khi đó, tương ứng với mỗi $ \omega ∈ Ω $ thì ta có thể nhận được $ X(\omega) $ trong tập rời rạc D

Tuy nhiên, vấn đề là không phải lúc nào điều đó cũng xảy ra. Có những trường X sẽ ánh xạ thất bại, nghĩa dù tồn tại một $ \omega ∈ Ω $ thì ta vẫn không tìm thấy giá trị tương ứng $ X(\omega) $ của nó trong tập D. Bài toán lúc này mang tính "may rủi" do có sự "thành công" và "thất bại" trong việc truy tìm cặp giá trị tương ứng ở 2 tập Ω  và D

![](/pictures/mapping-math.jpeg)

Lúc này, Người ta quan tâm đến xác suất để điều đó xảy ra, nghĩa là xác suất để X nhận các giá trị tướng ứng $ x ∈ D  $ hay nói cách khác là  P( X = x)

Hàm dùng để tính xác suất đó gọi là __hàm khối xác suất__. ký hiệu $ p_{X} (x) = P(X = x) $

# Một số ví dụ

Ví dụ 1: Hàm khối xác suất của một con súc sắc chuẩn. Mọi mặt của con súc sắc đều có cơ hội xuất hiện ngang nhau khi ta thả con súc sắc. Khi đó:

$$ P(X = 1) = P(X = 2) = P(X = 3) = P(X = 4) = P(X = 5) = P(X = 6) = \frac{1}{6}  $$

![](/pictures/Fair_dice_probability.png)

Ví dụ 2: Hàm khối xác suất của phân phối nhị thức với các tham số khác nhau. Đường thẳng nối các chấm nhằm mục đích minh họa:

![](/pictures/BinomConvergenceProb.png)

Ví dụ 3: Giả sử X là đầu ra của phép thử gieo 1 đồng xu đồng chất, gán giá trị 0 cho mặt sấp và 1 cho mặt ngửa. Xác suất mà $ X = x $ với $ x \in $ {1, 0}  là $ \frac{1}{2} $

# Tính chất

Xác suất luôn giới hạn từ 0 đến 1

$$ 0 ≦ p_{X}(x) ≦ 1 $$

Với mọi giá trị nhận được $ x_1, x_2,... x_n \in D $ thì tổng xác suất để X bằng từng giá trị bằng 1

$$ ∑ p_{X}(x_{i}) = 1 $$






Nguồn: [wikiWand](https://www.wikiwand.com/vi/H%C3%A0m_kh%E1%BB%91i_x%C3%A1c_su%E1%BA%A5t)