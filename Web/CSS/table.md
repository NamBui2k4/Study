# Tìm hiểu cách định dạng cho một cái bảng trong CSS

- Trong bộ tài liệu học HTML thì tôi đã có hướng dẫn các bạn cách tạo một cái bảng rồi. Tuy nhiên, HTML chỉ hỗ trợ có một vài thuộc tính (border, cellspacing, cellpadding, . . . .) dùng để định dạng cho bảng, cho nên cái bảng sẽ nhìn rất đơn sơ, hay nói cách khác là không được đẹp.

- Nhằm giúp các bạn có thể tạo ra được những chiếc bảng đẹp hơn và nhìn chuyên nghiệp hơn (giống như cái bảng bên dưới) thì ở trong bài viết này, tôi sẽ hướng dẫn các bạn cách vận dụng CSS để định dạng cho bảng.

|STT|Mã thẻ SV	|Họ tên	            | Ngày sinh	  |  Giới tính|Quê quán	|Lớp
|---|-----------|-------------------|-------------|-----------|---------|-----
|1	|12A10010151|Nguyễn Hoàng Anh	| 23/11/1992  |  Nam	  |Cần Thơ	|12A1
|2	|12A10010007|Nguyễn Thị Thùy Anh| 12/12/1994  |  Nữ	      |Vĩnh Long|12A1
|3	|12A10010184|Hoàng Hiếu Dương	| 07/07/1993  |  Nam	  |Sóc Trăng|12A1
|4	|12A10010154|Hoàng Tiến Đạt	    | 16/01/1994  |  Nam	  |Hậu Giang|12A1
|5	|12A10010160|Lê Quang Đạt	    | 10/12/1994  |  Nam	  |Bạc Liêu	|12A1


1) Cách tạo đường viền cho bảng & các ô bên trong bảng

- Để tạo đường viền cho bảng thì chúng ta thiết lập thuộc tính border cho thẻ `<table>`

- Để tạo đường viền cho ô tiêu đề thì chúng ta thiết lập thuộc tính border cho thẻ `<th>`

- Để tạo đường viền cho ô bình thường thì chúng ta thiết lập thuộc tính border cho thẻ `<td>`

```
table{
    border`:1px solid black;
}
th{
    border`:1px solid black;
}
td{
    border`:1px solid black;
}
```

Output`:

![](/pictures/border.png)

2) làm cho đường viền đa dạng kiểu dáng hơn

Trong CSS, thuộc tính border-style xác định kiểu của đường viền của một phần tử. Dưới đây là các giá trị mà border-style có thể có:

- `none`: Không có đường viền.
- `hidden`: Giống như none, nhưng dành cho các phần tử không hỗ trợ none.
- `dotted`: Đường viền được vẽ dưới dạng chấm.
- `dashed`: Đường viền được vẽ dưới dạng đứt.
- `solid`: Đường viền được vẽ dưới dạng đồng nhất.
- `double`: Đường viền được vẽ dưới dạng đôi.
- `groove`: Hiệu ứng 3D với màu sáng ở hai cạnh và màu tối ở hai cạnh còn lại.
- `ridge`: Hiệu ứng 3D với màu tối ở hai cạnh và màu sáng ở hai cạnh còn lại.
- `inset`: Hiệu ứng 3D giả lập lồng vào bên trong.
- `outset`: Hiệu ứng 3D giả lập bên ngoài.

Nguồn: [](https://webcoban.vn/css/cac-thuoc-tinh-dinh-dang-bang-table-trong-css.html)