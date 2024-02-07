# Binomial Distribution (phân phối nhị thức)

## Định nghĩa
Phân phối nhị thức của dữ liệu rời rạc nhận 2 tham số (n, p) là phân phối xác suất biểu diễn số sự kiện thực hiện thành công trong n sự kiện độc lâp. Mỗi một sự kiện sẽ có kết quả CÓ hay KHÔNG , hoặc,  thành công (với xác suất p) hay thất bại (với xác suất q = 1 - p ). Loại phân phối này được ứng dụng nhiều trong thực tế. Tuy nhiên, nó đòi hỏi phải đảm bảo nhiều điều kiện. 

1. Điều kiện cần: hàm khối xác suất PMF 

$$ P(X = k) = \binom{k}{n} p^{k}(1-p)^{n - k} \quad với \quad k = 0, 1, 2, 3,.... n \quad (1) $$

Ở đây, $$ \binom{k}{n} = \frac{n!}{k! ( n -k )!}$$ 

Công thức trên có thể được hiểu như sau: trong n lần thử nghiệm, k gọi là số lần thành công và (n-k) gọi là số lần thất bại. Xác suất của k là $ p^{k} $ và xác suất của (n - k)  là $ (1-p)^{n-k} $ . Ngoài ra,  vì k lượt thử thành công có thể được phân bố bất kỳ trong n lượt thử nên số cách phân bố k lượt thử thành công trong n lượt thử liên tiếp là $ \binom{k}{n} $

2. điều kiện đủ: hàm phân phối tích lũy (CDF)

$$ F(k, n, p) = P(X \leq k ) = ∑_(i=0)^{k} \binom{k}{n} p^{k}(1-p)^{n - k} \quad (2) $$

Về bản chất, phân phối nhị thức xuất phát từ nhị thức Newton, khi ta áp dụng công thức này cho trường hợp xác suất thành công là p và xác suất thất bại là 1-p. 

có thể thấy, công thức (1) dùng để tính xác suất của một biến ngẫu nhiên bất kỳ trong tập dữ liệu. Tuy nhiên, dữ liệu là tập hợp các kết quả CÓ hoặc KHÔNG và công thức (1) vẫn là chưa đủ nếu ta không biết biến ngẫu nhiên đó đại diện cho giá trị nào. Đó là lý do ta cần công thức (2) để để tính xác suất của một biến ngẫu nhiên luôn nhận giá trị CÓ

Một biến ngẫu nhiên X được cho là có __phân phối nhị thức__( ký hiệu là X ~ Bin(n, p) với n là số lần thực nghiệm và p là xác suất thành công ) nếu xác suất của nó thỏa mãn công thức (1).


## Đồ thị biểu diễn
giả sử n = 10, p = 0.5, thì phân phối xác suất của biến ngẫu nhiên X, ký hiệu là X ~ Bin(10 , 0.5) sẽ được biểu diễn dưới dạng đồ thị sau:
![](/pictures/bino_exmple1.png)

Ngược lại, nếu p = 0.1 thì X ~ Bin(10 , 0.1) sẽ được biểu diễn như sau

![](/pictures/bino_exmple2.png)


## Công thức tính xác suất của một biến X ~ $ N(\mu, \sigma^2) $ nằm trong khoảng (a,b)
Quy đổi X về Z để đơn giản hóa dữ liệu
$$ P(a < X < b) = P(\frac{a - \mu}{\sigma} < Z < \frac{a - \mu}{\sigma}) = \phi() $$