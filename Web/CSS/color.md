# Màu Sắc trong CSS: Tên Màu, Màu RGB, Màu HEX và Màu HSL - CSS Cơ Bản

Trong CSS có hai cách khác nhau để xác định màu sắc được sử dụng đó là:

- Sử dụng màu theo tên.
- Sử dụng màu theo giá trị định dạng kiểu RGB, HEX hay HSL.

## Màu Sắc Theo Tên

CSS hỗ trợ 140 tên màu khác nhau. Các tên được lấy từ tiếng Anh và được viết theo kiểu chữ in thường.

Ví dụ dưới đây liệt kê một số tên màu thường được sử dụng phổ biến trong thiết kế web:

![](https://www.codehub.com.vn/ckfinder/userfiles/images/bang-ma-mau-css.jpg)

## Màu Sắc Theo Giá Trị

Có ba cách khác nhau khi biểu diễn một giá trị màu sắc đó là sử dụng kiểu RGB, HEX hoặc HSL. Trong bài học này chúng ta tìm hiểu hai kiểu giá trị màu được sử dụng nhiều trong CSS là màu RGB và màu HEX.

## Màu RGB

Giá trị màu RGB được xác định dựa trên sự kết hợp của ba màu đó là màu đỏ (Red), màu xanh lá cây (Green) và màu xanh da trời (Blue).

Cú pháp giá trị màu RGB trong CSS:

    rgb(red, green, blue)

Trong đó giá trị của các màu red, green và blue dao động từ 0 tới 255, thể hiện độ độ đậm của chúng để hình thành nên màu sắc cuối cùng (với độ đậm cao nhất là 255 và thấp nhất là 0).

## Màu HEX
Giá trị màu HEX tương tự như RGB được hình thành từ sự kết hợp của ba màu: màu đỏ, màu xanh lá cây và , màu xanh da trời. Tuy nhiên HEX sử dụng các số trong hệ cơ số 16 cho giá trị của mỗi màu này thay vì các số từ 0 tới 255 như ở màu RGB.

Cú pháp giá trị màu HEX trong CSS:

    #rrggbb

Trong đó:

- `rr` là giá trị của màu đỏ biểu diễn ở cơ số 16.
- `gg` là giá trị của màu xanh lá cây biểu diễn ở cơ số 16.
- `bb` là giá trị của màu xanh da trời biểu diễn ở cơ số 16.

Ở cơ số 16, giá trị mỗi màu trong ba màu trên dao động từ 00 tới FF, khoảng giá trị này tương ứng với khoảng giá trị từ 0 tới 255 ở hệ cơ số thập phân sử dụng cho giá trị màu RGB.

 

Chuyển đổi giá trị HEX (ở hệ cơ số 10) qua giá trị ở hệ cơ số 10 (hệ thập phân):

- Đổi 0 từ hệ cơ số 10 qua hệ cơ số 16 sẽ là 00. Cụ thể: 0 = 0 x 16^1 + 0 x 16^0.

- Đổi 255 từ hệ cơ số 10 qua hệ cơ số 16 sẽ là FF. Cụ thể: 255 = 15 (F) x 16^1 + 15 (F) x 16^0.

Lưu ý: Hệ cơ số 16 bao gồm 16 số 0 tới 10 và 5 ký tự a, b, c, d, e, f. Theo đó khi chuyển đổi từ cơ số 16 qua cơ số 10 thì a, b, c, d, e, f lần lượt sẽ nhận các giá trị tương ứng là 10, 11, 12, 13, 14 và 15.

Nguồn: [codehub.com.vn](https://codehub.com.vn/CSS-Co-Ban/Mau-Sac#:~:text=C%C3%BA%20ph%C3%A1p%20gi%C3%A1%20tr%E1%BB%8B%20m%C3%A0u%20HEX%20trong%20CSS%3A,da%20tr%E1%BB%9Di%20bi%E1%BB%83u%20di%E1%BB%85n%20%E1%BB%9F%20c%C6%A1%20s%E1%BB%91%2016.)