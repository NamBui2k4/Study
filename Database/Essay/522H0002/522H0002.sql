use master
go
create database quanlybatdongsan
go
use quậnlybatdongsan
go

drop database quậnlybatdongsan

CREATE TABLE chi_nhánh
(
  tên_cn NVARCHAR(20) NOT NULL,
  mã_cn NVARCHAR(20) NOT NULL,
  PRIMARY KEY (mã_cn)
);
go

CREATE TABLE nhân_viên
(
  tên_nv NVARCHAR(20) NOT NULL,
  mã_nv NVARCHAR(8) NOT NULL,
  chức_vụ NVARCHAR(20) NOT NULL,
  địa_chỉ_liên_lạc NVARCHAR(20) NOT NULL,
  mã_cn NVARCHAR(20) NOT NULL,
  PRIMARY KEY (mã_nv),
  CONSTRAINT FR_KEY_mãCN_NHANVIEN FOREIGN KEY (mã_cn) REFERENCES chi_nhánh(mã_cn)
);
go

CREATE TABLE khách_hàng
(
  họ_tên NVARCHAR(20) NOT NULL,
  địa_chỉ_cư_trú NVARCHAR(20) NOT NULL,
  nơi_làm_việc NVARCHAR(30) NOT NULL,
  mã_kh NVARCHAR(20) NOT NULL,
  CONSTRAINT PR_KEY_mãKH PRIMARY KEY (mã_kh)
);
go

CREATE TABLE phiếu_đánh_giá
(
  ngày_đánh_giá DATE NOT NULL,
  điểm FLOAT NOT NULL,
  nhận_xét NVARCHAR NOT NULL,
  mã_kh NVARCHAR(20) NOT NULL,
  CONSTRAINT FR_KEY_mãKH_PDG FOREIGN KEY (mã_kh) REFERENCES khách_hàng(mã_kh)
);
go

CREATE TABLE hợp_đồng
(
  mã_hd NVARCHAR(10) NOT NULL,
  ngày_ký DATE NOT NULL,
  giá_trị_hd INT NOT NULL,
  mã_kh NVARCHAR(20) NOT NULL,
  CONSTRAINT PR_KEY_mãHD PRIMARY KEY (mã_hd),
  CONSTRAINT FR_KEY_mãKH_HD FOREIGN KEY (mã_kh) REFERENCES khách_hàng(mã_kh)
);
go

CREATE TABLE danh_mục_nhân_viên
(
  SDT NVARCHAR NOT NULL,
  mã_nv NVARCHAR(8) NOT NULL,
  CONSTRAINT PR_KEY_SDT PRIMARY KEY (SDT, mã_nv),
  FOREIGN KEY (mã_nv) REFERENCES nhân_viên(mã_nv)
);
go

CREATE TABLE khách_hàng_SDT
(
  SDT NVARCHAR NOT NULL,
  mã_kh NVARCHAR(20) NOT NULL,
  CONSTRAINT PR_KEY_SDT_mãKH PRIMARY KEY (SDT, mã_kh),
  CONSTRAINT FR_KEY_mãKH FOREIGN KEY (mã_kh) REFERENCES khách_hàng(mã_kh)
);
go

CREATE TABLE Nhà_ở
(
  mã_nhà NVARCHAR(20) NOT NULL,
  tỉnh_tp NVARCHAR(20) NOT NULL,
  phường_quận NVARCHAR(20) NOT NULL,
  số_nhà INT NOT NULL,
  diện_tích FLOAT NOT NULL,
  mã_cn NVARCHAR(20) NOT NULL,
  CONSTRAINT PR_KEY_mãNHA_NHAO PRIMARY KEY (mã_nhà),
  CONSTRAINT FR_KEY_mãCN_NHAO FOREIGN KEY (mã_cn) REFERENCES chi_nhánh(mã_cn)
);
go


go
CREATE TABLE chung_cư
(
  số_tầng INT NOT NULL,
  Mã_nhà NVARCHAR(20) NOT NULL,
  CONSTRAINT PR_KEY_mãNHA_CHUNGCU PRIMARY KEY (Mã_nhà),
  CONSTRAINT FR_KEY_mãNHA_CHUNGCU FOREIGN KEY (Mã_nhà) REFERENCES Nhà_ở(mã_nhà)
);
go

CREATE TABLE danh_mục_nhà_ở
(
  mã_nhà NVARCHAR(20) NOT NULL,
  mã_kh NVARCHAR(20) NOT NULL,
  CONSTRAINT PR_KEY_MANHA_MAKH PRIMARY KEY (mã_nhà, mã_kh),
  CONSTRAINT FR_KEY_MANHA_DMNHA FOREIGN KEY (mã_nhà) REFERENCES Nhà_ở(mã_nhà),
  CONSTRAINT FR_KEY_MAKH_DMNHA FOREIGN KEY (mã_kh) REFERENCES khách_hàng(mã_kh)
);
go

-- function tạo mã hợp đồng
create function tạo_mã_hd(@ngay_ki datetime, @mã_kh NVARCHAR(20))
returns NVARCHAR(10)
as
begin
	declare @quy NVARCHAR(10);
	set @quy = (case
		when datepart(QUARTER, @ngay_ki) = 1 then 'Q1'
		when datepart(QUARTER, @ngay_ki)  = 2 then 'Q2'
		when datepart(QUARTER, @ngay_ki)  = 3 then 'Q3'
		else 'Q4'
	end
	);
	declare @stt NVARCHAR(10) = CONVERT(NVARCHAR(10), SUBSTRING(@mã_kh,3, len(@mã_kh)));
	return 'HD' + '0' + @stt + @quy;
end;
go

-- xóa function tạo_mã_hd (nếu cần)
drop function tạo_mã_hd

go
-- thứ tự thực hiện: tạo_mã_kh -> thêm_kh -> tạo_mã_hd -> thêm_hd
-- procedure thêm hợp đồng
go
create proc thêm_hd
	@ngày_ký DATE,
	@giá_trị_hd INT,
	@mã_kh NVARCHAR(20)
as
begin
	IF NOT EXISTS (select mã_kh from khách_hàng where @mã_kh = mã_kh )
		begin
			print N'Mã khách hàng không hợp lệ hoặc chưa có mã khác hàng trong bảng'
			return;
		end;
	declare @mã_hd NVARCHAR(10) = dbo.tạo_mã_hd(@ngày_ký, @mã_kh);
	insert into hợp_đồng values(@mã_hd, @ngày_ký, @giá_trị_hd,@mã_kh);
end;
go

-- xóa  proccedure thêm_hd
drop proc thêm_hd;

go
-- tạo function thêm thực hiện thêm khách hàng vào bảng
create function tạo_mã_kh()
returns NVARCHAR(20)
as
begin
	-- khởi tạo STT của khách hàng bằng STT của hợp đồng
	declare @stt NVARCHAR(20) = CONVERT(NVARCHAR(20), (select count(*) from khách_hàng) + 1);
	-- trả về kết quả
	return 'KH' + '0' + @stt
end;
go

-- xóa function tạo_mã_kh (nếu cần)
drop function tao_mã_kh;

go
-- tạo procedure thêm khách hàng vào bảng
create proc thêm_kh
	@họ_tên NVARCHAR(20), 
	@dc_cutru NVARCHAR(20), 
	@nơi_làm_việc NVARCHAR(30)
as
begin
declare @mã_kh NVARCHAR(20) = dbo.tạo_mã_kh();
if exists (select mã_kh from khách_hàng where mã_kh = @mã_kh)
    begin
	print N'Khách hàng đã tồn tại';
	return
	end;
insert into khách_hàng(họ_tên,địa_chỉ_cư_trú ,nơi_làm_việc ,mã_kh) 
	   values         (@họ_tên, @dc_cutru, @nơi_làm_việc, @mã_kh);
end;
go

-- xóa procedure thêm_kh (nếu cần)
drop proc thêm_kh

go
-- function sinh ra mã nhân viên
create function tạo_mã_nv()
returns NVARCHAR(8)
as
begin
	declare @stt NVARCHAR(8);
	set @stt = convert(NVARCHAR(8), (select count(*) from nhân_viên) + 1);
	return 'DVC' + '0' + @stt;
end;
go

-- xóa function tạo_mã_nv (nếu cần)
drop function tạo_mãnv
go

--procedure thêm nhân viên
create proc thêm_nv
  @tên_nv NVARCHAR(20),
  @chuc_vu NVARCHAR(20),
  @dcll NVARCHAR(20),
  @mã_cn NVARCHAR(20)
as
begin
	if not exists (select 1 from chi_nhánh where mã_cn = @mã_cn)
		begin
			print N'Cần thêm chi nhánh trước khi thêm nhân viên';
			return;
		end;
	declare @mã_nv NVARCHAR(8);
	set @mã_nv = dbo.tạo_mãnv();
	insert into nhân_viên values(@tên_nv, @mã_nv, @chuc_vu, @dcll, @mã_cn);
end;
go

-- xóa procedure thêm_nv (nếu cần)
drop proc thêm_nv;

go
-- function tạo mã cn

create function tạo_mã_cn(@mã_tp NVARCHAR(20),@mã_quận NVARCHAR(20))
returns NVARCHAR(20)
as
begin
	--khởi tạo STT
	declare @stt NVARCHAR(20);
	set @stt = convert(NVARCHAR(20), (select count(*) from chi_nhánh) + 1);
	-- Trả về kết quả
	return 'DVC_' + @mã_quận +'_' + @mã_tp + '_' + '0' + @stt;
end;
GO

go
--procedure thêm chi nhánh
create proc thêm_cn
	@mã_tp NVARCHAR(20),
	@mã_quận NVARCHAR(20)
as
begin
	declare @mã_cn NVARCHAR(20);
	set @mã_cn = dbo.tạo_mãcn( @mã_tp, @mã_quận);

	declare @tên_cn NVARCHAR(20);
	set @tên_cn = N'Chi nhánh' + convert(NVARCHAR(20),(select count(*) from chi_nhánh) + 1 );
	insert into chi_nhánh values (@tên_cn,@mã_cn);
end;
drop proc thêm_cn
go

-- function tạo mã nhà ở
create function tạo_mã_nhà( -- remake
	@mã_tp NVARCHAR(20),
	@mã_quận NVARCHAR(20),
	@mã_phuong NVARCHAR(20)
)returns NVARCHAR(20)
as
begin
	declare @stt NVARCHAR(20);
	set @stt = CONVERT(NVARCHAR(10), (select count(*) from hợp_đồng) + 1 );

	return @mã_tp + '\' + @mã_quận + '\' + @mã_phuong + '\' + '0' + @stt;
end;
GO


-- procedure thêm nhà ở
create proc thêm_nhà_ở
  @mã_tp NVARCHAR(20),
  @mã_quận NVARCHAR(20),
  @mã_phuong NVARCHAR(20),
  @tỉnh_tp NVARCHAR(20),
  @phường_quận NVARCHAR(20),
  @số_nhà INT,
  @diện_tích FLOAT,
  @mã_cn NVARCHAR(20)
as
begin
if not exists (select mã_cn from chi_nhánh where mã_cn = @mã_cn)
  BEGIN
    PRINT N'Hãy thêm mã chi nhánh trước khi thêm nhà ở'
    RETURN
  END;

declare @mã_nhà NVARCHAR(20) = dbo.tạo_mã_nhà(@mã_tp, @mã_quận, @mã_phuong);
insert into Nhà_ở values (@mã_nhà, @tỉnh_tp, @phường_quận , @số_nhà, @diện_tích, @mã_cn);
end;
go



