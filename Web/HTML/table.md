# Thẻ tạo bảng trong HTML

## Cấu trúc thẻ tạo bảng trong HMTL

Bảng HTML được tạo ra bằng cách sử dụng cặp thẻ `<table>…</table>.` Trong đó:

+ Thẻ tạo hàng: `<tr>…</tr>`

+ Thẻ tạo ô: `<td>…</td>`

+ Thẻ tạo tiêu đề ô: `<th>…</th>`. Đặt tên cho cột, các ô cũng giống như thẻ `<td>` những có nó có sẵn thuộc tính font chữ đậm và căn giữa (`align=center`).

+ Thẻ tạo tiêu đề của toàn bảng: `<caption>…</caption>`. Đặt tiêu đề cho một bảng nên thẻ này không nằm trong hàng hay cột. Thuộc tính mặc định là `align=”top”` (không cần viết). Tuy nhiên, bạn có thể đặt tiêu đề ở phía dưới bảng với thuộc tính `align=”bottom”`.
+

        <table>
            <caption> Bảng thực hành số 1 </cation>

        <tr>
            <!--Đây là dòng số 1-->

            <td> Ô 1 của dòng 1 </td>

            <td> Ô 2 của dòng 1 </td>

        </tr>

        <tr>
            <!--Đây là dòng số 2-->

            <td> Ô 1 của dòng 2 </td>

            <td> Ô 2 của dòng 2 </td>

        </tr>

        </table>

Output:

![](https://giuseart.com/wp-content/uploads/2017/02/Tao-the-chen-bang-trong-html.jpg)

Để một bảng có thể hiển thị đúng trên trình duyệt, khi viết .html, chúng ta buộc phải có sự xuất hiện cùng một lúc 3 loại thẻ: `<table>/<tr>/<td>`. 

Nghĩa là, khi tạo bảng, sau khi khai báo thẻ `<table>` phải có đầy đủ thông tin số hàng `<tr>` và số cột của một hàng `<td>`.

## Các dạng bảng trong HTML

### Dạng 1: Bảng đầy đủ dữ liệu

Đây là loại bảng chứa thông tin dữ liệu đầy đủ ở tất cả các ô của bảng, cách tạo bảng đầy đủ dữ liệu là cách đơn giản và thông dụng nhất để tạo một bảng dữ liệu trong html. ví dụ:

![](https://giuseart.com/wp-content/uploads/2017/02/b%E1%BA%A3ng-%C4%91%E1%BA%A7y-%C4%91%E1%BB%A7-d%E1%BB%AF-li%E1%BB%87u-trong-html-1.png)

Qua bảng trên, ta có bảng được tạo với 2 dòng, mỗi dòng 2 cột.

+ Dòng 1 gồm 2 cột “Họ và tên” và “Ngày tháng năm sinh”.

+ Dòng 2 là dữ liệu “Lê Văn Thiện” và “24.01.1991”.


### Dạng 2: Bảng có ô dữ liệu trống

Tạo bảng có ô dữ liệu trống thực chất là việc tạo một bảng dữ liệu đầy đủ, sau đó bạn xóa dữ liệu ở một ô bất kỳ bên trong cặp thẻ 
`<td>Nội_dung_cần_xóa</td>` 

Ví dụ:

![](https://giuseart.com/wp-content/uploads/2017/02/B%E1%BA%A3ng-c%C3%B3-%C3%B4-d%E1%BB%AF-li%E1%BB%87u-tr%E1%BB%91ng-trong-html.png)

### Dạng 3: Bảng có nhiều cột gộp thành 1 cột

![](https://giuseart.com/wp-content/uploads/2017/02/d%E1%BA%A1ng-b%E1%BA%A3ng-c%C3%B3-2-c%E1%BB%99t-g%E1%BB%99p-l%C3%A0m-2-c%E1%BB%99t-trong-html.png)

Trong hình trên, bạn dễ dàng nhận thấy cột “Thông tin khác” được tạo nên nhờ việc gộp 2 cột liền nhau. Để gộp 2 cột thành 1, chúng ta sử dụng thuộc tính `colspan`.

```
<table border="1px">

	<tr>
		<td> Họ và tên </td>
		<td colspan="2"> Ngày tháng năm sinh </td>
	</tr>

	<tr>
		<td> Lê Văn Thiện </td>
		<td></td>
		<td></td>
	</tr>

	<tr>
		<td> Lê Văn Thiện </td>
		<td></td>
		<td></td>
	</tr>

</table>
```

Phân tích đoạn code trên, ta thấy bảng trên có 3 dòng, mỗi dòng 3 cột. Cột 2 của dòng 1 sử dụng thuộc tính `colspan=”2″`, nghĩa là nó sẽ gộp hai cột liên tiếp từ nó trở đi (cột 3). Như vậy, chúng ta phải cột 3 của dòng 1 đi để thuộc tính colspan có hiệu lực.


### Dạng 4: Bảng có nhiều dòng gộp thành 1

Đây là dạng bảng có 2 hoặc nhiều dòng gộp thành 1 như sau:

![](https://giuseart.com/wp-content/uploads/2017/02/b%E1%BA%A3ng-c%C3%B3-2-d%C3%B2ng-g%E1%BB%99p-l%C3%A0m-1.png)

Như bảng trên, ta thấy 2 dòng ID 1 và 2 đã bị gộp chung thành 1 dòng. Để làm được điều đó, chúng ta sử dụng thuộc tính rowspan, ví dụ:

```
<table border="1px">
	<tr>
		<td rowspan="2"> Họ và tên </td>
		<td> Ngày tháng năm sinh   </td>
		<td> Số điện thoại         </td>
	</tr>

	<tr>
		<!--đã xóa-->
		<td> 24.01.1991 </td>
		<td> 0972939830 </td>
	</tr>

	<tr>
		<td>Lê Văn Thiện</td>
		<td>23.2.2016</td>
		<td>0972939830</td>
	</tr>

</table>
```
Phân tích đoạn code trên, ta thấy bảng trên có 3 hàng, mỗi hàng có 3 cột. Cột 1 của hàng 1 sử dụng thuộc tính `rowspan=”2“`, nghĩa là nó sẽ gộp một ô của dòng thứ 2 bên dưới tính từ nó. Bên cạnh đó, chúng ta phải xóa cột thứ nhất của dòng 2 để thuộc tính `rowspan=”2″` có hiệu lực (Comment=đã xóa).  Và ta có kết quả như sau:

![](https://giuseart.com/wp-content/uploads/2017/02/g%E1%BB%99p-nhi%E1%BB%81u-h%C3%A0ng-th%C3%A0nh-1-trong-html.png)


Nguồn: [](https://giuseart.com/the-tao-bang-trong-html/)