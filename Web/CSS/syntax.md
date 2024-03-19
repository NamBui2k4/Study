# Cú pháp CSS

Bộ quy tắc của CSS gồm có Selector (bộ chọn) và Declaration (khối khai báo). Selector là trỏ tới phần tử HTML mà bạn muốn tạo kiểu định dạng. Khối khai báo chứa một hoặc nhiều khai báo, phân tách với nhau bằng các dấu chấm phẩy. Mỗi khai báo gồm tên thuộc tính (Property) và giá trị (Value), phân tách bằng dấu hai chấm. Mô tả ảnh dễ hiểu như sau:

![](https://st.quantrimang.com/photos/image/2022/08/03/img-selector.gif)

- Selector - Selector là một thẻ HTML tại đó một style sẽ được áp dụng. Đây có thể là bất kỳ thẻ nào như h1, h2..., table...
- Property - Property là một loại thuộc tính của thẻ HTML. Nói một cách đơn giản, tất cả các thuộc tính HTML đều được chuyển đổi thành các thuộc tính CSS. Chúng có thể là màu sắc, đường viền, phông chữ...
- Value - Value là giá trị được gán cho các thuộc tính. Ví dụ: thuộc tính màu có thể có giá trị là red hoặc #F1F1F1...

Khai báo CSS luôn kết thúc bằng dấu chấm phẩy, khối khai báo nằm trong các dấu ngoặc móc. Trong ví dụ dưới đây, các phần tử <p> sẽ được căn giữa, chữ màu đỏ.

Ví dụ:

```css
p {
    color: red;
    text-align: center;
  }
```
Giải thích ví dụ:

- p là Selector
- color và text-align là Property
- red và center là Value tương ứng với Property

## Nhúng cú pháp CSS vào HTML

Có 3 cách nhúng(thêm) css vào tài liệu html của website bao gồm inline css, internal css , external css.

### Inline Css

Đây là cách thêm css trực tiếp trên thẻ html cần định dạng bằng cách chỉnh sửa thuộc tính style được khai báo bên trong một thẻ html (thường là ở thẻ đầu tiên trong một cặp thẻ).

Ví dụ: Thiết lập đoạn văn có màu đỏ, chúng ta có thể thiết lập như code bên dưới.

    <p style="color: red"> hello world </p>

- Ưu điểm: Style cho một đối tượng html rất nhanh chóng.

- Nhược điểm: 
    + Cách này chỉ áp dụng cho một thẻ nào đó, không áp dụng chung cho nhiều thẻ html cùng lúc.
    + Không phải thẻ nào trong html cũng có thuộc tính style để chỉnh sửa

### Internal Css

Đây là cách thêm đoạn code css ở một khu vực riêng trong file html. Khu vực đó được xác định bởi cặp thẻ `<style></style>`

- Ưu điểm: Phân biệt rõ ràng đoạn code css và những nội dung html còn lại.

- Nhược điểm: Những style css chỉ áp dụng được trong phạm vi một file cụ thể nơi mà nó được khai báo. Nó không thể sử dụng chung cho nhiều page khác nhau.

Ví dụ 2: Thiết lập font-size: 18px và color: orange cho thẻ tiêu đề h1.

```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <style>
            h1 {
                color: orange;
                font-size: 18px;
            }
        </style>
    <h1>Unitop.vn - Học lập trình web đi làm</h1>
    </body>
    </html>
```

### External Css
Với hình thức này, tất cả những code css được đưa vào trong file có đuôi mở rộng .css (ví dụ: main.css).

- Ưu điểm: Giúp Css có thể dùng chung cho nhiều page khác nhau của website và dễ dàng quản lý.

Ví dụ:

Giả sử chúng ta có 2 file sau:
```
index.html
css/main.css
```

File main.css:
```css
p{
    color: #f15c25;
}
```
Nội dung file index.html

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Unitop.vn - Học lập trình web đi làm</title>
    <link rel="stylesheet" href="css/main.css">
</head>
<body>
<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorem doloribus officia reiciendis sed similique sit sunt suscipit tempore! Eaque, possimus?</p>
</body>
</html>

```
Trong đó dòng code

    <link rel="stylesheet" href="css/main.css">

giúp liên kết đến file main.css nằm trong thư mục css của dự án.



Nguồn:
+ [unitop.com](https://unitop.com.vn/import-css.html/)
+ [quantrimang.com](https://quantrimang.com/hoc/cu-phap-va-selector-trong-css-152888#:~:text=C%C3%BA%20ph%C3%A1p%20CSS%20B%E1%BB%99%20quy%20t%E1%BA%AFc%20c%E1%BB%A7a%20CSS,tr%E1%BB%8B%20%28Value%29%2C%20ph%C3%A2n%20t%C3%A1ch%20b%E1%BA%B1ng%20d%E1%BA%A5u%20hai%20ch%E1%BA%A5m.)