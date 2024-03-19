# Index trong SQL

Các chỉ mục hay index trong sql là các bảng tra cứu đặc biệt mà công cụ tìm kiếm cơ sở dữ liệu có thể sử dụng để tăng tốc độ truy xuất dữ liệu. Đơn giản chỉ cần thiết lập một chỉ số là một con trỏ đến dữ liệu trong một bảng. Một chỉ mục trong một cơ sở dữ liệu rất giống với một chỉ mục ở mặt sau của một cuốn sách.

Ví dụ: nếu bạn muốn tham chiếu tất cả các trang trong một cuốn sách thảo luận về một chủ đề nhất định. Trước tiên bạn hãy tham chiếu chỉ mục, liệt kê tất cả các chủ đề theo thứ tự bảng chữ cái và sau đó được gọi đến một hoặc nhiều số trang cụ thể.

Một chỉ mục giúp tăng tốc các truy vấn SELECT và các mệnh đề WHERE , nhưng nó làm chậm dữ liệu nhập vào, với các câu lệnh UPDATE và INSERT . Các chỉ mục có thể được tạo ra hoặc bỏ đi mà không ảnh hưởng đến dữ liệu.

Tạo một chỉ mục bao gồm lệnh CREATE INDEX , cho phép bạn đặt tên cho chỉ mục, để xác định bảng, cột và cột nào cần lập chỉ mục, và chỉ ra cho dù chỉ mục có tăng dần hay giảm dần hay không.

Các chỉ mục cũng có thể là duy nhất, như hạn chế UNIQUE , trong đó chỉ mục ngăn ngừa các mục trùng lặp trong cột hoặc sự kết hợp của các cột mà trên đó có một chỉ mục.

# Lệnh CREATE INDEX
Cú pháp cơ bản của một CREATE INDEX như sau.

    CREATE INDEX index_name ON table_name;

## Chỉ mục Cột (Column)
Chỉ mục một cột được tạo dựa trên một cột của bảng. Cú pháp cơ bản như sau.


    CREATE INDEX index_name
    ON table_name (column_name);

## Chỉ mục UNIQUE
Chỉ số duy nhất được sử dụng không chỉ cho hiệu suất, mà còn cho tính toàn vẹn dữ liệu. Một chỉ mục duy nhất không cho phép chèn bất kỳ giá trị nhân bản nào vào bảng. Cú pháp cơ bản như sau.

    CREATE UNIQUE INDEX index_name
    on table_name (column_name);

Giải thích:

- `CREATE UNIQUE INDEX` : Tạo một chỉ mục duy nhất.
- `index_name` : Tên của chỉ mục.
- `ON table_name` : Bảng mà chỉ mục được áp dụng.
- `column_name` : Cột mà chỉ mục được tạo.


### Ví dụ về chỉ mục UNIQUE

Giả sử bạn có bảng products với các cột sau:

- id: Khóa chính
- name: Tên sản phẩm
- price: Giá sản phẩm

Bạn muốn đảm bảo rằng không có hai sản phẩm nào có cùng tên. Để thực hiện việc này, bạn có thể tạo một chỉ mục duy nhất trên cột name:


    CREATE UNIQUE INDEX idx_product_name
    ON products (name);

Sau khi tạo chỉ mục này:

- Nếu bạn cố gắng chèn một bản ghi mới với tên sản phẩm đã tồn tại, bạn sẽ nhận được lỗi.
- Truy vấn tìm kiếm sản phẩm theo tên sẽ nhanh hơn vì chỉ mục sẽ được sử dụng để truy cập dữ liệu.
Ví dụ khác:

Giả sử bạn có bảng users với các cột sau:

- id: Khóa chính
- email: Email người dùng

Bạn muốn đảm bảo rằng mỗi người dùng chỉ có một tài khoản. Để thực hiện việc này, bạn có thể tạo một chỉ mục duy nhất trên cột email:

    CREATE UNIQUE INDEX idx_user_email
    ON users (email);

Sau khi tạo chỉ mục này:

- Nếu bạn cố gắng chèn một bản ghi mới với email đã tồn tại, bạn sẽ nhận được lỗi.
- Bạn có thể sử dụng email để xác định duy nhất một người dùng.

Lưu ý:

- Chỉ mục duy nhất chỉ có thể được tạo trên các cột không chứa giá trị null.
- Bạn có thể tạo nhiều chỉ mục duy nhất trên cùng một bảng.

## Chỉ số kết hợp

Một chỉ mục kết hợp là một chỉ mục trên hai hoặc nhiều cột của một bảng. Cú pháp cơ bản của nó như sau.

    CREATE INDEX index_name
    on table_name (column1, column2);

Cho dù bạn có tạo chỉ mục một cột hoặc một chỉ mục kết hợp, hãy xem xét (các) cột mà bạn có thể sử dụng rất thường xuyên trong mệnh đề WHERE của truy vấn dưới dạng điều kiện bộ lọc.

Nếu chỉ có một cột được sử dụng thì một chỉ mục cột đơn là sự lựa chọn. Nên có hai hoặc nhiều cột được sử dụng thường xuyên trong mệnh đề WHERE làm bộ lọc, thì chỉ số kết hợp sẽ là sự lựa chọn tốt nhất.

Chỉ mục ẩn
Chỉ mục ngầm là các chỉ mục được tạo tự động bởi máy chủ cơ sở dữ liệu khi một đối tượng được tạo ra. Các chỉ mục được tạo tự động cho các ràng buộc khoá chính và các ràng buộc duy nhất.


Lệnh DROP INDEX
Một chỉ mục có thể được bỏ qua bằng lệnh SQL DROP . Cần lưu ý khi thả một chỉ mục bởi vì hiệu suất có thể chậm lại hoặc cải thiện.

Cú pháp cơ bản như sau:

?
1
DROP INDEX index_name;
Khi nào nên tránh lập chỉ mục?
Mặc dù các chỉ mục nhằm mục đích nâng cao hiệu suất của một cơ sở dữ liệu, nhưng đôi khi cần tránh.

Các hướng dẫn sau đây chỉ ra khi sử dụng một chỉ mục nên được xem xét lại.

Các chỉ mục không được sử dụng trên các bảng nhỏ.
Các bảng có cập nhật hàng loạt thường xuyên, hoặc các hoạt động insert.
Các chỉ mục không nên được sử dụng trên các cột có chứa một số lượng lớn các giá trị NULL.
Các cột thường được thao tác không nên được lập chỉ mục.

Nguồn: [viettus](https://viettuts.vn/sql/index-trong-sql#:~:text=C%C3%A1c%20ch%E1%BB%89%20m%E1%BB%A5c%20hay%20index%20trong%20sql%20l%C3%A0,%C4%91%E1%BB%83%20t%C4%83ng%20t%E1%BB%91c%20%C4%91%E1%BB%99%20truy%20xu%E1%BA%A5t%20d%E1%BB%AF%20li%E1%BB%87u.)