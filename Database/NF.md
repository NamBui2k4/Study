# Chuẩn hóa cơ sở dữ liệu

## Chuẩn hóa dữ liệu là gì?

Chuẩn hóa dữ liệu là quá trình biểu diễn cơ sở dữ liệu dưới dạng chuẩn. Đây là một kỹ thuật thiết kế bảng trong cơ sở dữ liệu, chia các bảng lớn thành các bảng nhỏ hơn và liên kết chúng bằng các mối quan hệ.

Mục đích của chuẩn hoá là loại bỏ các dư thừa dữ liệu và các lỗi khi thao tác dư thừa và các lỗi khi thao tác dữ liệu (Insert, Delete, Update). Nhưng chuẩn hoá làm tăng thời gian truy vấn.

## Các dạng chuẩn hoá (Normal Form)

![](/pictures/NF.png)

### Dạng chuẩn 1 (First Normal Form)

Định nghĩa: Một bảng (quan hệ) được gọi là ở dạng chuẩn 1 nếu và chỉ nếu toàn bộ các miền giá trị của các cột có mặt trong bảng (quan hệ) đều chỉ chứa các giá trị nguyên tử (nguyên tố)

Nói cách khác, mỗi ô trong các cột của bảng không chứa nhiều giá trị

Ví dụ:

| StudentID | Course                    |
|-----------|---------------------------|
| 1         | Math, Physics             |
| 2         | Chemistry, Biology, Math  |

Trong ví dụ trên, cột Course chứa nhiều giá trị đa trị và bảng không đáp ứng được yêu cầu của dạng chuẩn 1.

Ví dụ 2:

|Mã sinh viên | Học phí	| Môn học        |
|-------------|---------|----------------|
|   SV001     |	500 USD	| Math, Physics  |   
|   SV002     |	600 USD	| Chemistry      |

Trong ví dụ này, cột "Môn học" chứa giá trị đa trị (nhiều môn học được liệt kê trong một ô), và do đó, bảng không đạt chuẩn 1

Nếu dữ liệu được biểu diễn dưới dạng __tập phụ thuộc hàm__ thì ta mặc định nó đạt dạng chuẩn 1. Nếu nó được biểu diễn dưới dạng __bảng__ thì phải kiểm tra bảng xem có đạt dạng chuẩn 1 hay không , nếu không thì phải tự đưa về dạng chuẩn 1

### Dạng chuẩn 2 – 2NF

Định nghĩa:

Một quan hệ ở dạng chuẩn 2NF nếu quan hệ đó:

- Là Dạng chuẩn 1

- Các thuộc tính không khoá phải phụ thuộc hàm đầy đủ vào khoá chính

Như vậy, để đưa một bảng về dạng chuẩn 2, ta cần làm 3 bước:

- kiểm tra xem bảng có đạt dạng chuẩn 1 hay chưa, nếu chưa thì đưa về dạng chuẩn 1. 

- xác định khóa của bảng bằng thuật toán tìm khóa ( hoặc  là tìm tất cả các khóa và chọn ra "siêu khóa" )

- Các thuộc tính nằm trong khóa đã tìm được gọi là "thuộc tính khóa" => các thuộc tính còn lại là "thuộc tính không khóa". Nếu thuộc tính không khoá phụ thuộc hàm đầy đủ vào thuộc tính khóa thì ta nói bảng đạt dạng chuẩn 2

Ví dụ 1: 

Cho quan hệ R = (ABCD), tập phụ thuộc hàm F = {AB -> C, AB -> D}. Hỏi quan hệ trên có đạt dạng chuẩn không?

_Trả lời_

Bằng thuật toán tìm khóa, ta xác định khoá là AB 

=> thuộc tính khóa là (A, B). Các thuộc tính còn lại (C và D) là thuộc tính không khóa. 

Vì AB -> C và AB -> D, nghĩa là C và D phụ thuộc vào AB nên quan hệ đạt chuẩn 2NF.

_Nhớ: thuật ngữ Bảng với quan hệ là giống nhau_

Ví dụ 2: 

Cho quan hệ R = (ABCD) , tập phụ thuộc hàm F = {AB -> C, AB -> D, B -> DC}.  Hỏi quan hệ trên có đạt dạng chuẩn không? 

_Trả lời_

Tương tự, bằng thuật toán tìm khóa thì ta xác định khóa là AB. Các thuộc tính khóa là (A, B) và thuộc tính không khóa là (C, D)

Tuy nhiên, quan hệ trên là quan hệ không đạt chuẩn 2NF vì có phụ thuộc hàm B -> DC là phụ thuộc hàm bộ phận (phụ thuộc hàm không đầy đủ) vào khoá AB. Khi đó ta đưa về dạng chuẩn 2NF như sau:

Nhận xét

Một quan hệ ở dạng chuẩn 2NF nếu thoả mãn 1 trong các đièu kiện sau: Khoá chính chỉ gồm một thuộc tính Bảng không có các thuộc tính không khoá Tất cả các thuộc tính không khoá phụ thuộc hoàn toàn vào tập các thuộc tính khoá chính

--------------------------------

Tài liệu kham khảo: 

[funix.edu](https://funix.edu.vn/chia-se-kien-thuc/chuan-hoa-cac-quan-he-ve-cac-dang-chuan-co-ban)

[viblo.asia](https://viblo.asia/p/tong-hop-ve-chuan-hoa-co-so-du-lieu-ORNZqP33K0n)