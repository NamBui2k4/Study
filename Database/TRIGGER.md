# Trigger là gì ?

Hiểu đơn giản thì Trigger là một stored procedure không có tham số. Trigger thực thi một cách tự động khi một trong ba câu lệnh Insert, Update, Delete làm thay đổi dữ liệu trên bảng có chứa trigger. 😄

# Đặc điểm của trigger 

__Kích Hoạt Tự Động:__

Trigger được kích hoạt tự động bởi sự kiện nào đó trong cơ sở dữ liệu, như việc thêm mới (INSERT), cập nhật (UPDATE), hoặc xóa (DELETE) dữ liệu từ một bảng.

__Thực Hiện Nhiều Hành Động:__

Một trigger có thể thực hiện nhiều hành động khác nhau như một stored procedure thông thường, bao gồm chèn dữ liệu, cập nhật giá trị, xóa dữ liệu, 

__BEFORE hoặc AFTER:__

Trigger có thể được thiết kế để chạy trước khi sự kiện được thực hiện (BEFORE) hoặc sau khi sự kiện đã được thực hiện (AFTER).

__Có Thể Được Vô Hiệu Hóa và Kích Hoạt Lại:__

Trigger có thể được tạm thời vô hiệu hóa và sau đó kích hoạt lại, giúp quản trị viên cơ sở dữ liệu thực hiện bảo trì hoặc kiểm tra các vấn đề.

# Cú pháp của Trigger
```
CREATE TRIGGER tên_trigger 
ON tên_bảng
AFTER/BEFORE/INSTEAD OF
DELETE/INSERT/UPDATE
AS 
  câu_lệnh_sql
```


Trong đó:

```DELETE/INSERT/UPDATE``` là các thao tác của người dùng lên một bảng

```AFTER/BEFORE/INSTEAD OF``` là những từ khóa dùng để chỉ thời điểm trigger sẽ can thiệp vào các thao tác đó

Bởi vì về nguyên tắc, cả Trigger và stored procedure sẽ tạo một "bảng ảo" hay bảng tạm thời lưu trữ những thay đổi lên bảng gốc. Các từ khóa trên sẽ xác đinh khi nào thì trigger sẽ thực thi lên bảng ảo đó trước khi áp dụng nó lên bảng gốc. Ví dụ:

-  ```AFTER```: thời điểm sau khi người dùng thực thi lên bảng
- ```BEFORE```: thời điểm trước khi người dùng thực thi lên bảng
- ```INSTEAD OF```: Ngay tại thời điểm người dùng thực thi lên bảng và sẽ thay thế hoạt động đó bằng một hoạt động khác do người dùng định nghĩa trong trigger

Bên cạnh đó, trigger cũng tồn tại một số cụm từ đặc biệt như:
- ```ROLLBACK TRANSACTION```: Hủy bỏ các thao tác của người dùng lên một bảng
- ```RETURN```: Dừng trigger
- ```THROW```: ném ra một lỗi nào đó do người dùng tự định nghĩa

# Trigger dùng làm gì ?

- Trigger thường được sử dụng để kiểm tra ràng buộc (check constraints) trên nhiều quan hệ (nhiều bảng/table) hoặc trên nhiều dòng (nhiều record) của bảng.
- Ngoài ra việc sử dụng Trigger để chương trình có những hàm chạy ngầm nhằm phục vụ nhưng trường hợp hữu hạn và thường không sử dụng cho mục đích kinh doanh hoặc giao dịch

# Ví dụ
Giả sử tồn tại một CSDL bán xe máy như sau 

- NhaSanXuat (MaNSX, TenNSX);
- XeMay (MaXe, TenXe , MaNSX, SoLuong, DonGia);
- KhachHang (SoDienThoai ,HoTen ,DiaChi);
- Hoađon (SoHoaDon ,NgayLap ,MaKhachHang);
- ChiTiếtHoáDơn (SoHoaDon, MaXe, SoLuong, DonGia);

Yêu cầu: Thêm một hóa đơn có kiểm tra khóa chính, khóa ngoại

Trong bài toán này, việc thêm dữ liệu vẫn sẽ là thủ công, nhưng ta hãy thử tạo một trigger có chức năng tương tự để xem nó hoạt động như thế nào

```

CREATE TRIGGER TrgThemHoaDon
ON HoaDon
INSTEAD OF INSERT
AS
BEGIN
    IF EXISTS (SELECT * FROM inserted i WHERE i.SoHoaDon IN (SELECT SoHoaDon FROM HoaDon))
    BEGIN
        PRINT(N'Hóa đơn đã tồn tại.')
        ROLLBACK TRANSACTION
        RETURN
    END

    IF EXISTS (SELECT * FROM inserted i WHERE i.MaKhachHang NOT IN (SELECT SoDienThoai FROM KhachHang))
    BEGIN
        PRINT(N'Khách hàng không tồn tại.')
        ROLLBACK TRANSACTION
        RETURN
    END
	INSERT INTO HoaDon (SoHoaDon, NgayLap, MaKhachHang) 
    SELECT i.SoHoaDon, i.NgayLap, i.MaKhachHang
    FROM inserted i
END



```

Tiến hành thêm dữ liệu thử công:

```
INSERT INTO HoaDon (SoHoaDon, NgayLap, MaKhachHang) VALUES
('HD01', '2023-11-27', '0123456789'),
('HD02', '2023-11-28', '0987654321'),
('HD03', '2023-11-29', '0123412345');
```


kết quả:
 ```
 (3 rows affected)

HD01	2023-11-27	0123456789
HD02	2023-11-28	0987654321
HD03	2023-11-29	0123412345
```
Việc thêm dữ liệu đã thành công. Nhưng, ta hãy thử lặp lại cú pháp thêm dữ liệu trên xem chuyện gì sẽ xảy ra. Kết quả là nhận được thông báo lỗi
```
Hóa đơn đã tồn tại.
Msg 3609, Level 16, State 1, Line 67
The transaction ended in the trigger. 
The batch has been aborted.
```

Có thể thấy, Trigger đã thực thi một cách tự động ngay cả khi ta không hề chỉ mặt gọi tên. Điều đó cũng có nghĩa là ta đã định nghĩa một tính năng thống báo lỗi đặc biệt thân thiện hơn với người dùng, đặc biệt là với những người không hiểu tiếng anh hoặc không có chuyên môn sâu vào ngôn ngữ SQL-Server. Điều này tương tự như việc ta kiểm soát các Exception trong java 

