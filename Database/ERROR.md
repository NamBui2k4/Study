# Một số Lỗi thường gặp trong sql Server
Lỗi "Cannot find either column 'dbo' or the user-defined function or aggregate 'dbo.tao_macn', or the name is ambiguous.":

Nguyên nhân: Có thể do không có chữ "dbo." trước tên hàm.
Giải pháp: Thêm "dbo." trước tên hàm để chỉ định đúng schema.
Lỗi "String or binary data would be truncated":

Nguyên nhân: Trường hợp này thường xảy ra khi giá trị bạn cố thêm vào cột có độ dài lớn hơn độ dài tối đa được định nghĩa cho cột đó.
Giải pháp: Đảm bảo rằng độ dài của giá trị bạn thêm không vượt quá độ dài được định nghĩa cho cột.
Lỗi "The INSERT statement conflicted with the FOREIGN KEY constraint":

Nguyên nhân: Giá trị bạn đang thêm vào cột ngoại trội không có trong cột chính của bảng tham chiếu.
Giải pháp: Đảm bảo rằng giá trị bạn thêm vào cột ngoại trội đã tồn tại trong cột chính của bảng tham chiếu.
Vấn đề với Font chữ trong kết quả in ra:
chọn nhầm giữa varchar và nvarchar

## Lỗi thiếu schema
Ví dụ:
```
Cannot find either column 'dbo' or the user-defined
function or aggregate 'dbo.tao_macn', or the name
is ambiguous.
```
Trước khi tìm hiểu về lỗi này, ta cần hiểu khái niệm về schema. Schema được hiểu là một tập hợp chứa các đối tượng cơ sở dữ liệu ( ví dụ bảng, view, function, procedure, khóa chính, ràng buộc v.v.) được tổ chức và nhóm lại. Nó định nghĩa cách mà dữ liệu được tổ chức và lưu trữ trong cơ sở dữ liệu.

Lưu ý: không nên hiểu nhầm schema là cái giao diện mà ta thường gặp khi tkhởi tạo bằng cú pháp use master, create database, create table,.... Những cái giao diện chỉnh sửa này chỉ là phương tiện được thực hiện thông qua các công cụ quản lý cơ sở dữ liệu như SQL Server Management Studio (SSMS).

Một csdl sẽ có nhiều schema. Khi ta tạo csdl, mặc định các schema sẽ có tên là 'dbo'. 

# lỗi chèn dữ liệu vào bảng không có thứ tự
vd:
```
The INSERT statement conflicted with the FOREIGN 
KEY constraint "FR_KEY_MAHD". The conflict occurred
in database "quanlybatdongsan", table "dbo
hợp_đồng", column 'mã_hd'.
```

Trong mô hình quan hệ cơ sở dữ liệu, khi ta có một bảng A với khóa ngoại tham chiếu đến bảng B, thứ tự chèn dữ liệu có thể quan trọng trong một số trường hợp. Cụ thể:

__Bảng được tham chiếu (B) phải có dữ liệu trước:__ Nếu Bảng B chưa có dữ liệu và bảng A có khóa ngoại tham chiếu đến bảng Bảng B, ta sẽ phải chèn dữ liệu vào Bảng B trước, đảm bảo rằng giá trị khóa chính của bảng B đã tồn tại trước khi được tham chiếu bởi bảng A.

__Bảng tham chiếu (A) có dữ liệu sau:__ Nếu dữ liệu trong bảng B đã tồn tại, ta có thể chèn dữ liệu vào bảng A. Trong trường hợp này, ta phải chắc chắn rằng giá trị trong cột tham chiếu của bảng A (khóa ngoại) phải trỏ đến giá trị hợp lệ trong bảng cha.

Ở ví dụ đầu, thông báo lỗi _"The INSERT statement conflicted with the FOREIGN KEY constraint..."_ thông thường xuất hiện khi ta đang chèn một giá trị vào khóa ngoại 'mã_hd' trong bảng nào đó, nhưng giá trị đó không tồn tại trong khóa chính 'mã_hd' của bảng 'hợp_đồng'.