# Làm quen với javascript

- Code javascript luôn tương tác với html
- Code Javascript được đặt trong cặp `<script></script>`
- Cặp này luôn có thuộc tính `language` để xác định loại ngôn ngữ kịch bản
- In ra màn hình: dùng hàm `alert()`
    ```html
    <script language="javascript">
        alert("Hello World!");
    </script>
    ```

**Đặt thẻ script ở đâu?**

- Internal - viết trong file html hiện tại

```html
<html>
    <head>
        <title></title>
        <script language="javascript">
            alert("Hello World!");
        </script>
    </head>
    <body>
         
    </body>
</html>
```
- External - viết ra một file js khác rồi import vào
```html
<script language="javascript" src="demo.js"></script>

<!-- demo.js là một file .js >
```
- Inline - viết trực tiếp trong thẻ HTML

```html
<script language="javascript" src="demo.js"></script>
```

- Viết chương trình hoàn chỉnh

Yêu cầu: Viết một chương trình Hello world đơn giản. Người dùng nhấn vào nút "click me" thì chữ "Hello world" sẽ xuất hiện.

1. Xác định phương thức nhập chuẩn bằng thẻ input

2. Ba thuộc tính quan trọng của thẻ input:
- `type="button"`: thẻ input này chính là nút bấm
- `id="clickme"`: nút này phải là duy nhất, không trùng với nút bấm nào
- `value="Click Me"`: nút bấm có dòng chữ "Click Me"

```html
<html>
    <head>
        <title></title>
    </head>
    <body>
        <input type="button" id="clickme" value="Click Me"/>
        <script language="javascript">
         
        // Lấy element có id=clickme lưu vào biến button
        var button = document.getElementById('clickme');
         
        // Khi click vào element chứa trong button thì thực hiện một function, 
        // bên trong function thông báo lên Hello World!
        button.addEventListener('click', function(){
            alert('Hello World!');
        });
        </script>
    </body>
</html>
```

Nguồn: [freetuts](https://freetuts.net/javascript-la-gi-viet-ung-dung-javascript-dau-tien-263.html)