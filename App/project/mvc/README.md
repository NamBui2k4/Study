# Mô hình Model-View-Controller (MVC)

MVC (viết tắt của Model-View-Controller) là một mẫu kiến 
trúc phần mềm hay mô hình thiết kế để tạo lập giao diện 
người dùng trên máy tính. MVC chia một ứng dụng thành ba 
phần tương tác được với nhau, mỗi thành phần có một nhiệm
 vụ riêng biệt và độc lập với các thành phần khác.

- Model: Quản lý, xử lý dữ liệu.
- View: Hiển thị dữ liệu cho người dùng.
- Controller: Điều khiển sự tương tác giữa Model và View.

![](https://viettuts.vn/images/struts2/mvc-la-gi.png)

Mô hình MVC giúp tách biệt giữa cách thức mà dữ liệu được xử 
lý phía nội hàm và phần dữ liệu hiển thị phía người dùng. 
Ở đây Controller nhận được tất cả các yêu cầu cho ứng dụng 
và sau đó làm việc với Model để chuẩn bị dữ liệu cần thiết 
cho View. View sau đó sử dụng các dữ liệu được chuẩn bị bởi 
Controller để hiển thị cho người dùng.

## Các thành phần trong MVC


**Model**
- Là bộ phận có nhiệm vụ quản lý dữ liệu của ứng dụng.
- Chức năng biểu diễn, vận chuyển thông tin để trình diễn (view) và xử lý (control)
- Chứa tất cả các nghiệp vụ logic, đối tượng mô tả dữ liệu, ...

**View**
- Tương tác với người sử dụng.
- Show kết quả từ tầng Controller.
- Thu nhận các hoạt động, request của người sử dụng và 
chuyển cho tầng Controller xử lý.
- Hiểu một cách đơn giản, View là hệ thống các frame, 
cửa sổ của ứng dụng; các trang giao diện web: html, jsp; 
Các bảng, mẫu biểu, báo cáo.

**Controller**
- Định nghĩa các hành vi, hoạt động, xử lý của hệ thống.
- Đối chiếu hành động của người sử dụng từ View. Đồng thời tương tác Model để gọi View và hiển thị thông tin tương ứng cho người dùng.

----

## Ưu điểm và nhược điểm của MVC

**Ưu điểm**

- Do được chia thành các thành phần độc lập
nên Mô hình MVC giúp phát triển ứng dụng có code 
dễ đọc, dễ nâng cấp, bảo trì.

- Thể hiện tính chuyên nghiệp trong việc tạo ứng dụng.

**Nhược điểm**

- Đối với dự án nhỏ việc áp dụng mô hình 
MC gây cồng kềnh, tốn thời gian trong quá 
trình phát triển. 

- Tốn thời gian trung chuyển dữ
 liệu của các thành phần.


