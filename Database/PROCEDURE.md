# Giới thiệu tổng quan Stored Procedure là gì trong SQL Server

Trong bài này bạn sẽ được tìm hiểu khái niệm về stored procedure trong SQL Server, qua đó bạn sẽ biết được cách tạo mới, thực thi, thay đổi và xóa stored procedure.

![](/pictures/SQL.png)

Stored procedure là tập hợp một hoặc nhiều câu lệnh T-SQL tạo thành một nhóm đơn vị xử lý logic và được lưu trữ trên Database Server. Khi một câu lệnh gọi chạy stored procedure lần đầu tiên thì SQL Server sẽ chạy nó và lưu trữ vào bộ nhớ đệm, gọi là plan cache, những lần tiếp theo SQL Server sẽ sử dụng lại plan cache nên sẽ cho tốc độ xử lý tối ưu.

Nói một cách đơn giản, stored procedure gần giống với một function có kiểu void. Nó là một đoạn code có thể tái sử dụng nhiều lần phục vụ thao tác thêm ,xóa, sửa dữ liệu

__1. Khi nào bạn cần sử dụng Stored Procedure?__

Khi bạn phải thực hiện một project lớn, đòi hỏi nghiêm ngặt về tốc độ thực thi thì Stored Procedure chính là một phần lời giải cho bạn. Stored Procedure cho tốc độ thực thi nhanh hơn so với các câu lệnh SQL Server thông thường, Stored Procedure đã được lưu sẵn tại SQL server, do vậy chương trình không cần gởi hàng ngàn dòng lệnh đến SQL Server. Nó chỉ cần gọi một dòng lệnh để thực thi Stored Procedure, điều này giúp tăng tốc độ thực thi.

Bên cạnh đó trong quá trình tạo Stored Procedure, SQL Server đã tối ưu hóa những dòng lệnh này, điều này giúp cho tốc độ thực thi cao hơn câu lệnh SQL thông thường rất nhiều.

__2. Khi nào bạn không cần sử dụng Stored Procedure?__

Store Procedured làm quá trình debug trở nên khó khăn hơn. Do vậy hãy nghĩ đến Stored Procedure như là phương án cuối cùng để tối ưu hóa tốc độ thực thi chương trình. Thực tế 90% các project bạn làm có size nhỏ và vừa, do vậy hãy ưu tiên sử dụng các thư viện ORM (Object Relation Mapping), như Entity Framework cho C#, TypeORM cho NodeJs. Chúng sẽ giúp bạn phát triển, bảo trì, debug chương trình dễ dàng hơn


3. cú pháp của procedure:
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

## Ví dụ

Giả sử tồn tại một CSDL bán xe máy như sau 

- NhaSanXuat (MaNSX, TenNSX);
- XeMay (MaXe, TenXe , MaNSX, SoLuong, DonGia);
- KhachHang (SoDienThoai ,HoTen ,DiaChi);
- Hoađon (SoHoaDon ,NgayLap ,MaKhachHang);
- ChiTiếtHoáDơn (SoHoaDon, MaXe, SoLuong, DonGia);

Yêu cầu: thêm dữ liệu vào các bảng 

Cách 1 : làm thủ công

```
-- Thêm dữ liệu vào bảng Nhà sản xuất
INSERT INTO NhaSanXuat  VALUES
('NXS1', N'Honda'),
('NXS2', N'Yamaha'),
('NXS3', N'Suzuki');

-- Thêm dữ liệu vào bảng Xe máy
INSERT INTO XeMay VALUES
('X1', N'Wave Alpha', 'NXS1', 10, 15000000),
('X2', N'Exciter 150', 'NXS2', 5, 20000000),
('X3', N'Raider 150', 'NXS2', 8, 18000000);


-- Thêm dữ liệu vào bảng Khách hàng
INSERT INTO KhachHang VALUES
('0123456789', N'Nguyễn Văn A', N'Hà Nội'),
('0987654321', N'Trần Thị B', N'TPHCM'),
('0123412345', N'Lê Văn C', N'Đà Nẵng');

-- Thêm dữ liệu vào bảng Hoá đơn
INSERT INTO HoaDon  VALUES
('HD01', '2023-11-27', '0123456789'),
('HD02', '2023-11-28', '0987654321'),
('HD03', '2023-11-29', '0123412345');

-- Thêm dữ liệu vào bảng Chi tiết hoá đơn
INSERT INTO ChiTietHoaDon  VALUES
('HD03', 'X2', 2, 18000000),
('HD03', 'X1', 2, 15000000),
('HD01', 'X1', 2, 15000000),
('HD01', 'X2', 1, 20000000),
('HD02', 'X3', 2, 18000000);

```
Cách 2: sử dụng stored procedure

```
CREATE PROCEDURE Procedure_ThemXeMay
	@MaXe NVARCHAR (10),
	@TenXe NVARCHAR(100),
	@MaNSX NVARCHAR (10),
	@SoLuong INT,
	@DonGia INT
AS
BEGIN

	IF (EXISTS (SELECT * FROM XeMay WHERE
            @MaXe=MaXe))
	BEGIN
		PRINT N'Khóa chính MaXe đã tồn tại'
		RETURN -1
	END
	
	IF (NOT EXISTS (SELECT * FROM NhaSanXuat 
                    WHERE @MaNSX=MaNSX))
	BEGIN
		PRINT N'Không tìm thấy khóa ngoại MaNSX
        trong bảng NhaSanXuat'
		RETURN -1
	END

	IF (@SoLuong <=0 or @DonGia<=0)
	BEGIN
		PRINT N'Số lượng và đơn giá phải lớn hơn 0'
		RETURN -1
	END

	INSERT INTO XeMay
	VALUES(	@MaXe,
		@TenXe,
		@MaNSX,
		@SoLuong,
		@DonGia
	)
	PRINT N'Thêm xe máy thành công'
	RETURN 1
END

-- gọi tới stored procedure để thực thi
exec Procedure_ThemXeMay 'X7', N'Wave Alpha', 
'NXS1', 10, 15000000

kết quả: (1 row affected)
Thêm xe máy thành công
```

Có thể thấy, việc sử dụng stored procedure tăng hiệu suất công việc lên rất nhanh

Nguồn [semtek.com](https://www.semtek.com.vn/procedure-la-gi/)