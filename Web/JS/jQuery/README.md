# Sử dụng jQuery

jQuery là một thư viện được viết bởi ngôn ngữ lập trình JavaScript giúp đơn giản hoá công việc của các lập trình viên. jQuery giúp cho việc xây dựng và sử dụng các chức năng được diễn ra một cách nhanh, dễ dàng và đơn giản hơn.

Hiện nay, jQuery vẫn là một trong những thư viện JavaScript phổ biến nhất trên thế giới.

## Những module chính của jQuery

- Ajax: tương tác với server và cập nhật trang web mà không cần phải tải lại trang.
- Atributes: xử lý các thuộc tính HTML
- Effect: xử lý hiệu ứng, giúp tạo ra các hiệu ứng ẩn hiện phần tử, thay đổi kích thước, v.v.
- Event: xử lý sự kiện, cho phép xử lý các sự kiện của người dùng như click, hover, keydown, v.v.
- Form: xử lý sự kiện liên quan tới form.
- DOM: xử lý Data Object Model. Cho phép thay đổi, thêm hoặc xoá các phần tử HTML trong trang web.
- Selector: xử lý luồng lách giữa các đối tượng HTML, cho phép lựa chọn các phần tử HTML dựa trên các tiêu chí như ID, class, thuộc tính, v.v

## Các thuật ngữ cần biết khi sử dụng jQuery

- jQuery Selectors: Dùng để chỉ những thao tác trên các phần tử HTML. Với jQuery Selection, bạn có thể tìm và chọn các phần từ HTML dựa trên các trường, types, ID, thuộc tính,… Tất cả jQuery Selectors đều được bắt đầu bằng ký tự $ () (factory function).

![](https://mikotech.vn/wp-content/uploads/2022/10/thuat-ngu-jquery.jpg)

- jQuery Tag Name: Thuật ngữ đại diện cho tên thẻ đã có sẵn trong DOM.
- Tag ID: Đại diện cho thẻ có sẵn được gắn với ID cụ thể trong DOM.
- Tag Class: Đại diện cho tag có sẵn tương ứng với class cụ thể trong DOM.
- Function trong jQuery: Dùng để nói về từ khóa đặt tên cho các hàm trong jQuery.
- Callback trong jQuery: Hàm thuần JavaScript có thể được truyền các phương thức như là tham số hoặc tùy chọn. Một số callback có thể là các sự kiện, được dùng ở khắp mọi nơi trong jQuery. Hầu hết các callback đều cung cấp tham số và context.
- Closure trong jQuery: Các Closure được tạo ra mỗi khi các biến được định nghĩa ngoài phạm vi hiện tại và được truy cập từ bên trong nội bộ.
- Proxy Pattern trong jQuery: Các Proxy có khả năng điều khiển sự truy cập đến các phần tử khác. Chúng thi hành cùng giao diện cho đối tượng khác (Real Subject), đồng thời truyền trên mọi phương thức sẵn có.
- Phạm vi trong jQuery: Dùng để chỉ khu vực có trong chương trình mà biến đó được định nghĩa. Biến trong JavaScript sẽ có hai phạm vi: biến Global (được định nghĩa tại mọi nơi trong JavaScript code) và biến Local (chỉ có ở hàm được định nghĩa).
- Tham số có trong jQuery: Một loại của kiểu Array và có thuộc tính length.
- Context trong jQuery: Trong JavaScript, ‘this’ là một từ khóa tham chiếu với Context. Từ khóa này có khả năng thay đổi tùy theo cách hàm đó được gọi.

##  Cách cài đặt jQuery

### Download jQuery

- Truy cập vào địa chỉ https://jquery.com/download/
- Lựa chọn phiên bản tải (phụ thuộc vào trình duyệt web và nơi dùng jQuery)
- include thư viện jQuery vào trong HTML file như sau:

```html
<html>
   <head>
      <script src="đường link phiên bản jQuery"></script>
   </head>

   <body>

   </body>
</html>
```


***Ví dụ***: 
- `src="https://code.jquery.com/jquery-3.7.1.js"`
- `src="https://code.jquery.com/jquery-3.6.4.js"`

### Sử dụng CDN

Thay vì tải thư viện jQuery về máy, bạn sẽ liên kết đến thư viện jQuery của một số nhà cung cấp như: cộng đồng jQuery, Google hay Microsoft. Một số CDN phổ biến và đáng tin cậy nhất hiện nay là:

- jQuery CDN.
- Google CDN.
- Microsoft CDN.

Bên cạnh đó, bạn còn có thể include thư viện jQuery vào trong HTML code một cách trực tiếp từ Content Delivery Network (CDN).

Ví dụ

## Gọi một hàm thư viện jQuery

- charAt(): Trả về ký tự tại chỉ mục (index) đã xác nhận.
- concat(): Dùng để kết nối hai chuỗi văn bản, đồng thời trả về một chuỗi mới.
- forEach(): Dùng để gọi một hàm cho mỗi phần tử của một mảng.
- indexOf(): Trả về chỉ mục đầu tiên trong việc gọi đối tượng String với giá trị đã cho hoặc -1 nếu không tìm thấy.
- length(): Dùng để trả về độ dài của chuỗi.
- pop(): Gỡ bỏ phần tử cuối của một mảng, đồng thời trả về phần tử đó.
- push(): Thêm một hoặc nhiều phần tử tới phần cuối của một mảng và tiến hành trả về độ dài mới của mảng đó.
- reverse(): Đảo ngược thứ tự các phần tử trong một mảng ( vị trí đầu tiên trở thành cuối cùng và vị trí cuối cùng thành đầu tiên).
- sort(): Dùng để sắp xếp phân loại các phần tử của một mảng.
- substr(): Thực hiện trả về các ký tự trong một mảng, bắt đầu từ vị trí đã xác định với các ký tự đã xác định.
- toLowerCase(): Dùng để trả về giá trị chuỗi đang gọi được biến đổi thành kiểu chữ thường.
- toString(): Trả về sự biểu diễn chuỗi của giá trị số đã xác định.
- toUpperCase(): Trả về giá trị chuỗi đang gọi được biến đổi thành kiểu chữ ho

Để một sự kiện làm việc trên trang của bạn, bạn nên gọi nó bên trong hàm `$(document).ready()`. Mọi thứ bên trong sẽ được tải ngay sau khi DOM được tải và trước khi nội dung trang được tải.

Cú pháp:

```css
$(document).ready(function() {
   // do stuff when DOM is ready
});
```
