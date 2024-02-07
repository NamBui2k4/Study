# Các thao tác trong CSDL (Đối với ngôn ngữ sql server) 

## Truy vấn
Dù không hẳn là một trong 3 thao tác chính khi làm việc với một CSDL(thêm, xóa, sửa) nhưng truy vấn cũng rất quan trọng và là nền tảng để thực hiện 3 thao tác đó. Ta sẽ kham khảo một số bài toán truy vấn sau

### Truy vấn ra số hàng của bảng
```
    SELECT COUNT(*) FROM tên_bảng;
```

VD: giả sử ta có một bảng danh_mục_khách_hàng được khởi tạo như sau:
```
    CREATE TABLE Danh_mục_khách_hàng
    (
        SDT VARCHAR NOT NULL,
        mã_kh VARCHAR(10) NOT NULL,
    );
```
cú pháp trả về số hàng sẽ là: ```SELECT COUNT(*) FROM Danh_mục_khách_hàng;```
Vì bảng chưa có dữ liệu nào nên mặc định trả về số hàng là 0

Ngoài ra, ta có thể dùng số hàng đó lưu vào một biến rồi tính toán với phép + - * / thông thường
VD:
```
    DECLARE @a INT;

    -- Truy vấn số hàng từ bảng Danh_mục_khách_hàng
    SELECT @a = COUNT(*) FROM Danh_mục_khách_hàng;

    -- Cập nhật giá trị của @a
    SET @a = @a + 10;

    -- In ra giá trị của @a
    PRINT @a;

    -- Kết quả: 10
```

_*Ta không Truy vấn số cột của bảng bởi số cột luôn cố định và chúng chính là số thuộc tính mà ta khởi tạo ban đầu_


### Truy vấn ra thông tin từ dữ liệu thời gian
Giả sử ta có dữ liệu thời gian là ngày sinh của một người: '23/02/1993', yêu cầu truy vấn thông tin cụ thể từ dữ liệu thời gian này, cụ thể:
1. Truy vấn năm
    cú pháp: ```YEAR(năm_sinh)```
VD: 
```
    DECLARE @năm_sinh DATETIME = '23/02/1993';

    PRINT YEAR( @năm_sinh );
    -- kết quả: 1993
```

2. Truy vấn tháng
cú pháp: ```MONTH(năm_sinh)```
```
    DECLARE @năm_sinh DATETIME = '23/02/1993';

    PRINT MONTH( @năm_sinh );
    -- kết quả: 2
```
3. Truy vấn quý
riêng với quý thì __không có__ cú pháp ```QUARTER(năm_sinh)```
bù lại ta có cú pháp ```DATEPART(datepart, date)```
trong đó:
- datepart là một phần của thời gian mà ta cần trích xuất (ví dụ: YEAR, QUARTER, MONTH, DAY, HOUR, MINUTE, SECOND, v.v.).
- date là giá trị thời gian cần trích xuất thông tin.

VD:
```
    DECLARE @năm_sinh DATETIME = '23/02/1993';

    PRINT DATEPART( QUARTER, @năm_sinh );
    -- kết quả: 1
```
cú pháp trên rất hữu dụng khi ta có thể áp dụng nó với tất cả các phần khác của thời gian như năm, tháng, ngày

### Truy vấn dữ liệu bằng function
Cấu trúc của một function là:
```
    CREATE FUNCTION function_name
    (
        -- parameters @a, @b, @c, ....
    )
    RETURNS return_data_type
    AS
    BEGIN
        -- function body
        RETURN expression;
END;

```
Sau khi khởi tạo cấu trúc một function thì ta có thể gọi function đó thể thực thi lệnh
Cú pháp gọi một function: ```SELECT dbo.function_name(@a, @b, @c,...);```

__Tính chất của function:__
- function chỉ có chức năng tính toán chứ không có chức năng thực hiện thao tác với cú pháp như thủ tục
- Một function luôn có giá trị trả về. function có thể trả về bất cứ kiểu nào trừ void. 
- function sẽ không cho phép các câu lệnh tác động đến dữ liệu như INSERT, UPDATE, DELETE
Nếu function chỉ có một lệnh duy nhất là return thì ta bỏ qua begin và end
- Một function có thể có khối lệnh kiểm tra ngoại lệ TRY...CATCH nhưng không được sử dụng PRINT để hiển thị thông điệp ngoại lệ. 

VD:
Giả sử ta có một bảng DONHANG(SOHD, MaKH, NgayDatHang). Dữ liệu được thêm vào bảng bằng cú pháp insert into DONHANG VALUES('DH01' ,'KH01', '19/12/2012'). Khi đó, ta có thể truy vấn các dữ liệu đó bằng function sau

```
    CREATE FUNCTION LayChiTietDonHang( @SoDH CHAR(4))
    RETURNS TABLE
    AS
    RETURN
    (
        SELECT * FROM CHITIETDONHANG WHERE SoDH = @SoDH
    );
```
Có thể thấy, function LayChiTietDonHang sẽ trả về toàn bộ dữ liệu dựa trên khóa chính 'DH01'
 
### Truy vấn một chuỗi con được cắt ra từ chuỗi parent
__1. Cắt chuỗi thông thường__ 
cú pháp:
```
    SUBSTRING ( expression, start, length )
```
Trong đó:
- expression: Chuỗi cần cắt.
- start: Vị trí bắt đầu cắt chuỗi.
- length: Số ký tự cần cắt từ vị trí bắt đầu.
Cú pháp trên cho phép ta truy vấn một chuỗi con được cắt ở vị trí bât kỳ từ chuỗi parent
VD:
```
    DECLARE @chuoi NVARCHAR(100) = 'Hello World';
    SELECT SUBSTRING(@chuoi, 3, 5) AS NewString;
```
kết quả: 'llo W'

__2. Cắt chuỗi từ bên phải__
cú pháp:  
```
RIGHT(expression, length)
```
trong đó:
- expression: Chuỗi ta cần xử lý.
- length: Số lượng ký tự cần lấy
Cú pháp trên cho phép ta truy vấn một chuỗi con được cắt ở vị trí bên phải của chuỗi parent.

VD:
```
    DECLARE @chuoi NVARCHAR(50) = 'DVC_778_79_0124';
    DECLARE @doDaiCuoi INT = 4;

    DECLARE @chuoiCuoi NVARCHAR(50) = RIGHT(@chuoi, @doDaiCuoi);

    PRINT @chuoiCuoi;
    -- kết quả: 0124
```

### Một số ví dụ bài tập truy vấn

Giả sử tồn tại một CSDL bán xe máy như sau 

- NhaSanXuat (MaNSX, TenNSX);
- XeMay (MaXe, TenXe , MaNSX, SoLuong, DonGia);
- KhachHang (SoDienThoai ,HoTen ,DiaChi);
- Hoađon (SoHoaDon ,NgayLap ,MaKhachHang);
- ChiTiếtHoáDơn (SoHoaDon, MaXe, SoLuong, DonGia);

-- cauc
```
SELECT XeMay.Maxe
FROM XeMay
INNER JOIN ChiTietHoaDon cthd 
        ON XeMay.MaXe = cthd.Maxe
INNER JOIN HoaDon 
        ON cthd.SoHoaDon = HoaDon.SoHoaDon
WHERE YEAR(NgayLap) = 2020
GROUP BY XeMay.MaXe
HAVING SUM(cthd.SoLuong) >= ( SELECT SUM(thd.SoLuong) 
FROM XeMay
INNER JOIN ChiTietHoaDon cthd ON XeMay.MaXe = cthd.MaXe
INNER JOIN HoaDon ON ek sattoaDn = HoaDon.SoHoaDon
WHERE YEAR(NgayLap) =
GROUP BY cthd.MaXe)
```
--Caud

select * from xemay

(
FROM XeMay
INNER JOIN ChiTietHoaDon cthd ON XeMay.MaXe = cthd.MaXe

INNER JOIN HoaDon ON sie. szattonton = HoaDon.SoHeaDon
WHERE YEAR(NgayLap) =
GROUP BY XeMay.MaXe
HAVING SUM(cthd.SoLuong) >= (
SELECT SUM(thd2,Sol.uong)
FROM XeMay
INNER JOIN ‘Chiliettloabon gthd2 ON XeMay.MaXe = cthd2,MaXe
INNER JOIN HoaDon ON cthd2.SoHoaDon = HoaDon.SoHoaDon
WHERE YEAR(NgayLap) = 2020
GROUP BY cthd2,Maxe
)
)
--Cau f
select month(ngaylap) as ‘Thang’, sum(soluong) as 'SL' from ChiTietHoaDon cthd inner join
hoadon on cthd: seationpon = hoadon.SoHoaDon
where year(ngaylap) =

## Thêm

__1. Thêm thủ công__
```
         insert into tên_bảng values(cột_1, cột_2, cột_3,....) 
``` 
__2. thêm bằng cách dùng procedure__

Cấu trúc của procedure:
```
    CREATE PROC tên_procedure
        @a KIỂU_DƯ_LIỆU,
        @b KIỂU_DƯ_LIỆU,
        @c KIỂU_DƯ_LIỆU
        ...................
    AS
    BEGIN
        thực hiện thao tác nào đó với @a , @b,  @c,....
    END;

```
Tương tự như function, ta có cú pháp gọi thực thi procedure: ```EXEC tên_procedure @a, @b, @c, ...;```

__3. Kết hợp procedure và function__


## Sửa
## Sửa dữ liệu bằng procedure

Nhắc lại cú pháp của procedure:
```
    CREATE PROCEDURE procedure_name
        @parameter1 data_type,
        @parameter2 data_type,
        .....................
    AS
    BEGIN
        -- Procedure body
        -- SQL statements and logic go here
    END;

```
### Đổi tên
__1. đổi tên bảng__
```
    EXEC sp_rename 'tên_cũ', 'tên_mới';
```
VD: giả sử ta có một bảng khách_hàng và muốn đổi tên thành customer thì cú pháp sẽ là:
```
    EXEC sp_rename 'khách_hàng', 'customer';
```


__2. Đổi tên cột trong bảng__
````
    EXEC sp_rename 'tên_bảng.tên_cột', 'tên_mới', 'column'
````
VD:
Giả sử ta có bảng khách_hàng được tạo ra từ mã nguồn sau
```
    CREATE TABLE khách_hàng
    (
    họ_tên VARCHAR NOT NULL,
    địa_chỉ_cư_trú VARCHAR NOT NULL,
    nơi_làm_việc VARCHAR NOT NULL,
    mã_kh VARCHAR NOT NULL,
    mã_hd VARCHAR NOT NULL,
    PRIMARY KEY (mã_kh),
    FOREIGN KEY (mã_hd) REFERENCES hợp_đồng(mã_hd)
    );
```
Nếu ta muốn đổi tên cột địa_chỉ_cư_trú thành dcct (viết tắt) thì cú pháp sẽ là
```
    exec sp_rename N'khách_hàng.địa_chỉ_cư_trú', 'dcct', 'column'
```

__Lưu ý__
-   Bất cứ khi nào đổi tên bảng/cột mà là chuỗi có dấu ( chữ tiếng Việt) thì phải có đặc tả N phía trước (ví dụ như N'khách_hàng.địa_chỉ_cư_trú' ở trên)
-   Muốn đổi tên bảng/cột cần tạo bảng trước nếu không sẽ bị lỗi


### Ép kiểu
Lưu ý: Thuật ngữ "ép kiểu" ở đây không phải làm thay đổi kiểu dữ liệu của một biến mà tạo một kiểu mới từ kiểu gốc của biến đó
Có 2 hàm liên quan đến ép kiểu:
1. cast
```
    CAST (expression AS data_type(length) )
```
Trong đó:
- expression: Giá trị cần ép kiểu.
- data_type: kiểu cần ép.
- length: (Tùy chọn) Chiều dài, dùng khi muốn ép về kiểu CHAR hoặc VARCHAR có độ dài là length.

VD: ```CAST(123 AS VARCHAR(10))```

2. convert
```
CONVERT (data_type(length), expression, style)
```
Trong đó:
- data_type: kiểu cần ép.
- length: (Tùy chọn) Chiều dài, dùng khi muốn ép về kiểu CHAR hoặc VARCHAR có độ dài là length.
- expression: Giá trị cần ép kiểu.
- style: (Tùy chọn) Một số nguyên đại diện cho kiểu định dạng. Nó được sử dụng khi chuyển đổi giữa các kiểu dữ liệu ngày/tháng.

VD: ```CONVERT(VARCHAR(10), 456)```

__chú ý__ 
Như đã nói, cả CONVERT và CAST sẽ không làm thay đổi một biến nếu ta khởi tạo cho biến đó
một kiểu cố định. Chúng chỉ trả về một dữ liệu mới được ép kiểu từ dữ liệu cũ. 
VD:
```
    -- @a đã được khởi tạo với kiểu int cố định nên không thể thay đổi
    DECLARE @a INT = 123;

    -- dùng convert ép kiểu của a từ int --> varchar(10) và gán cho @b
    DECLARE @b VARCHAR(10) = CONVERT(VARCHAR(10), @a);
```

