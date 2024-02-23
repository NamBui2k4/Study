# Thuộc tính Margin và padding trong CSS

Trong một trang web đôi lúc chúng ta thấy có những khoảng trống giữa các khối với nhau, nhưng mà họ lại không sử dụng tag `<br>`,... Những khoảng trống đó được tạo bằng CSS và cụ thể là sử dụng hai thuộc tính margin và padding.


## 1, Thuộc tính Margin.

-Thuộc tính margin trong CSS cho phép chúng ta tạo ra các khoảng cách từ thành phần được chọn ra phía bên ngoài của thành phần đó.

![](/pictures/margin-trong-css.png)

Thuộc tính margin với một giá trị
-Khi khai báo thuộc tính margin chứa một giá trị thì thành phần được chọn cách đều bốn phía trên - phải - dưới - trái.

VD: CSS cho thẻ div cách đều 4 phía 30px.

```
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Toidicode margin padding</title>
    <style type="text/css">
        div{
            margin: 20px;
            /*Tạo viền cho dễ nhận biết*/
            border: 1px solid orange;
        }
    </style>
</head>
<body>
    <div>Học Lập Trình Online</div>
    <div>Toidicode.Com</div>
</body>
</html>
```
Xem Kết Quả

Thuộc tính margin với hai thuộc tính
-Khi khai báo thuộc tính margin với hai giá trị thì:

Giá trị thứ nhất sẽ là cách trên và cách dưới.
Giá trị thứ hai sẽ là cách trái và cách phải.
Cú Pháp:

css
copy
selector{
    margin: top-bottom lef-right;
}
VD: CSS cho thẻ div cách trên dưới 20px, trái phải 30px.

html
copy
```
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Toidicode margin padding</title>
    <style type="text/css">
        div{
            margin: 20px 30px;
            /*Tạo viền cho dễ nhận biết*/
            border: 1px solid orange;
        }
    </style>
</head>
<body>
    <div>Học Lập Trình Online</div>
    <div>Toidicode.Com</div>
</body>
</html>
```
Xem Kết Quả

Thuộc tính margin với ba giá trị
-Khi chúng ta khai báo thuộc tính margin với 3 giá trị kèm theo thì

Giá trị thứ nhất là cách trên.
Giá trị thứ hai là cách trái phải.
Giá trị thứ ba là cách dưới.
Cú Pháp:

css
copy
selector{
    margin: top left-right right;
}
VD: CSS cho thẻ div cách trên 20px, cách trái phải 30px, cách dưới 40px.

html
copy
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Toidicode margin padding</title>
    <style type="text/css">
        div{
            margin: 20px 30px 40px;
            /*Tạo viền cho dễ nhận biết*/
            border: 1px solid orange;
        }
    </style>
</head>
<body>
    <div>Học Lập Trình Online</div>
    <div>Toidicode.Com</div>
</body>
</html>
Xem Kết Quả

Thuộc tính margin với bốn giá trị
-Khi khai báo thuộc tính margin với bốn giá trị kèm theo thì:

Giá trị thứ nhất sẽ là cách trên.
Giá trị thứ hai sẽ là cách phải.
Giá trị thứ ba sẽ là cách dưới.
Giá trị thứ bốn sẽ là cách trái.
Cú Pháp:

css
copy
selector{
    margin: top right left bottom;
}
VD: CSS cho thẻ div các trên 5px, phải 10px, dưới 15px, trái 20px.

html
copy
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Toidicode margin padding</title>
    <style type="text/css">
        div{
            margin: 5px 10px 45px 20px;
            /*Tạo viền cho dễ nhận biết*/
            border: 1px solid orange;
        }
    </style>
</head>
<body>
    <div>Học Lập Trình Online</div>
    <div>Toidicode.Com</div>
</body>
</html>
Xem Kết Quả

Margin theo từng chiều
-Ngoài các thuộc tính như trên thì chúng ta hoàn toàn có thể CSS margin theo từng chiều với các thuộc tính như sau:

Thuộc tính	Mô Tả
margin-top: value	-Cách trên.
margin-bottom: value	-Cách dưới.
margin-left: value	-Cách trái.
margin-right:value	-Cách phải.
VD: CSS cho thẻ div cách trên 15px.

css
copy
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Toidicode margin padding</title>
    <style type="text/css">
        div{
            margin-top:15px;
            /*Tạo viền cho dễ nhận biết*/
            border: 1px solid orange;
            bor
        }
    </style>
</head>
<body>
    <div>Học Lập Trình Online</div>
    <div>Toidicode.Com</div>
</body>
</html>
Xem Kết Quả

2, Thuộc tính padding.
-Thuộc tính padding trong CSS có tác dụng căn chỉnh nội dung hiển thị trong một thành phần so với viền của thành phần đó.

padding trong css 

-Thuộc tính padding cũng cho phép chúng ta điền vào từ 1 đến 4 giá trị như thuộc tính margin. Và vị trí cách của nó cũng tương ứng như thuộc tính margin nên mình sẽ nói nữa.

CSS từng thành phần.
-Cũng giống như margin thì padding cũng cung cấp cho chúng ta các thuộc tính cách tương tự với từng phía.

Thuộc tính	Mô Tả
padding-top: value	-Cách trên.
padding-bottom: value	-Cách dưới.
padding-left: value	-Cách trái.
padding-right:value	-Cách phải.
VD: CSS cho nọi dung trong thẻ div cách trên 15px.

html
copy
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Toidicode margin padding</title>
    <style type="text/css">
        div{
            padding-top: 15px;
            /*Tạo viền cho dễ nhận biết*/
            border: 1px solid orange;
        }
    </style>
</head>
<body>
    <div>Học Lập Trình Online</div>
    <div>Toidicode.Com</div>
</body>
</html>
Xem Kết Quả

3, Chú ý.
-Đối với 2 thuộc tính margin và padding thì chúng ta có thể sử dụng các đơn vị đo trong CSS (px,%,in,em,...), hoặc sử dụng giá trị auto khi muốn nó tự căn chỉnh.

VD: CSS cho thẻ div cách đều 2 bên.

html
copy
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Toidicode margin padding</title>
    <style type="text/css">
        div{
            margin: 0 auto;
            width: 700px;
            /*Tạo viền cho dễ nhận biết*/
            border: 1px solid orange;
        }
    </style>
</head>
<body>
    <div>Học Lập Trình Online</div>
    <div>Toidicode.Com</div>
</body>
</html>
Xem Kết Quả

4, Lời kết.
-Như vậy mình đã giới thiệu xong đến mọi người cơ bản về nguyên lý hoạt động của hai thuộc tính margin và padding trong CSS rồi. Các bạn chú ý phần này, vì sau này sẽ phải sử dụng nó thường xuyên đó.


Nguồn: [](https://toidicode.com/thuoc-tinh-margin-va-padding-trong-css-169.html)