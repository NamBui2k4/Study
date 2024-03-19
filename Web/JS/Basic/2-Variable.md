# Biến

- Khai báo biến bằng từ khóa `var`

    ```javascript
    var domain = "freetuts.net" ;
- Khai báo biến bằng từ khóa `let`

    ```javascript
    let username = "freetuts.net";
- Nếu khai báo bằng `var` thì biến sẽ có phạm vi toàn cục, nhưng nếu khai báo bằng `let` thì chỉ có phạm vi cục bộ.

```javascript
if (true){
    let domain_1 = "freetuts.net";

    var  domain_2 = "freetuts.net";
}
 
// Lỗi vì phạm vi không hợp lệ
console.log(domain_1);
 
// chạy bình thường
console.log(domain_2);
```

- Khai báo hằng bằng từ khóa `const`
    ```javascript
    const username = 'giá trị';
const là một hằng số nên phải gán giá trị ngay khi khai báo. Sau khi khai báo thì const sẽ immutable
```javascript
const domain = "freetuts.net";
 
// Lỗi, vì biến const không được phép thay đổi giá trị
domain = "danhgiawp.com";
```

- Quy tắc đặt tên biến
  + Tên biến phải là các chữ không dấu viết hoa hoặc viết thường, các chữ số từ 0-9 và dấu gạch dưới (_).
  + Tên biến bắt đầu phải là chữ hoặc dấu gạch dưới (_), nếu bắt đầu bằng số là sai
  + Tên biến có thể đặt dài hay ngắn tùy vào lập trình viên.

```javascript
// Đúng
var username;
 
// Đúng
var _username;
 
// Đúng
var __username;
 
// Đúng
var username90;
 
// SAI
var 90thehalfheart;
```

- Khai báo nhiều biến

```javascript
var username, _username, __username, username90;
```

- javascript cho phép đổi kiểu biến linh hoạt
```javascript
// Biến website đag kiểu String
var website = 'thehalfehart';
 
// Biến website chuyển sang kiểu INT
website = 12;
 
// Biến website chuyển sang kiểu float
website = 12.5;
```

- In giá trị biến: dùng `document.write(value)`.

```html
<html>
    <head>
        <title></title>
    </head>
    <body>
        <script language="javascript">
            var website = 'freetuts.net';
            document.write(website);
        </script>
    </body>
</html>
```

- phép toán javascript: cộng trừ nhân chia, gán, nối chuỗi

```javascript
// Phép gán
var domain = "freetuts.net";
 
// Phép nối chuỗi
var subdomain = "code." + domain; 
 
// Phép cộng
var number = 20 + 10;
 
// Phép trừ
var number = 20 - 10;
 
// Phép nhân
var number = 20 * 10;
 
// Phép chia
var number = 20 / 10;
```


Bài viết được lấy từ nguồn: [freetus](https://freetuts.net/bien-va-khai-bao-bien-trong-javascript-265.html)