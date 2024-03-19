# Tính logic của một mệnh đề

Toán rời rạc là nền tảng của thuật toán và  khoa học máy tính, lý thuyết thông tin, mã hóa, logic toán học, đồ thị, thuật toán và nhiều lĩnh vực khác. Một trong những kiến thức quan trọng nhất của toán rời rạc là tính logic mệnh đề, vì nó cung cấp cơ sở lý luận cho các khái niệm, định nghĩa, định lý và chứng minh.

## Định nghĩa
    Mệnh đề (statement / proposition) là 
    một câu khẳng định có giá trị chân lý 
    xác định đúng (True) hoặc sai 
    (False). Nhưng không được phép bằng cả hai
\
Ví dụ:

- 2+3=5 ⟶ `true`
- Tam giác đều có 3 cạnh bằng nhau ⟶ `true`
- Toronto là thủ đô của Canada ⟶ `false`
- 3*4=10 ⟶ `false`
- “Hà Nội là thủ đô của Việt Nam” ⟶ `true`   
- “Hà Nội là thủ đô của Mỹ” ⟶ `false` 

_Đọc thêm: Ở một số ngữ cảnh khác, tồn tại các cặp giá trị có tính chất gần giống `true/false` nhưng không phải. Chẳng hạn như `right/wrong`, hay `valid/invalid`. Về mặt ngôn ngữ, chúng giống hệt `true/false`, nhưng khi đặt vào toán rời rạc thì tính logic luôn được nhấn mạnh - nghĩa là đúng là đúng mà sai là sai, không có chuyện "ba phải". Nói cách khác, `true/false` được hiểu là có hoặc không. Trong khi đó, `right/wrong` chỉ mang nghĩa là đúng hoặc sai một cách hời hợt, đây là cách nhận định theo chuẩn mực đạo đức chứ không có tính khoa học cụ thể. Còn `valid/invalid` lại được hiểu là hợp lệ hoặc không hợp lệ_

Lưu ý: một mệnh đề phải là một câu khẳng định có ý nghĩa. Những câu cảm thán hoặc câu đặc biệt không có đầy đủ chủ ngữ, vị ngữ không phải là mệnh đề. Ví dụ: "Ôi trời ơi!".

## Mệnh đề phức hợp


Một mệnh đề có thể được tạo bởi nhiều mệnh đề đơn lẻ kết nối bằng các liên từ như “và”, “hay”, “nếu…thì”, "suy ra". Mệnh đề như vậy được gọi là mệnh đề phức hợp (compound statement)

Ví dụ: `nếu tôi ra ngoài, thì trời mưa`. Đây là một mệnh đề phức hợp được tạo bởi 2 mệnh đề đơn:
- `tôi ra ngoài`
-  `trời mưa`

được nối với nhau bởi cụm "nếu...thì"

Trong tiếng anh, một mệnh đề được hiểu đơn giản là một câu có cấu trúc S V O và không có tính cảm thán. Các mệnh đề đơn được nối với nhau bởi các từ tiếng anh "and", "or", "if...then", "therefore".


![](/pictures/statements.png)

## Đưa mệnh đề về dạng toán học

Trong toán rời rạc, chúng ta luôn làm việc với các mệnh đề. Nhưng điều này khó khăn ở chỗ, các mệnh đề thường là câu văn rất dài ngay cả khi chúng không phải là mệnh đề phức hợp. Do đó, để dễ đọc và xử lý, ta có thể ký hiệu chúng bằng các chữ cái như p, q, m,...

Lấy ví dụ, chúng ta có các mệnh đề sau:

- If Jane is a math major or Jane is a computer  science major, then Jane will take MA1101R.
- Jane is a computer science major. 
- Therefore, Jane will take MA1101R.

Ta có thể ký hiệu các mệnh đề nhỏ bằng các chữ cái:

- p : "Jane is a math major"
- q : "Jane is a computer  science major"
- r : "Jane will take MA1101R"

Khi đó, các mệnh đề sẽ được rút gọn thành:
```
If p or q, then r
q.
Therefore, r
```
\
Những chữ cái p, q, r được gọi là biến mệnh đề (statement variable). 

## Phép toán với biến mệnh đề

Một biến mệnh giống như một biến số học khi mà nó có thể tương tác với các biến mệnh đề khác thông các phép toán hợp, giao, phủ định để cho ra biểu thức của các mệnh đề đó. 

__Phép hợp__

    Nếu p và q là hai biến mệnh đề thì "p or q" 
    được gọi là hợp của hai biến mệnh đề đó
\
Ký hiệu của phép hợp là  `^`

Phép hợp của hai biến mệnh đề p và q cho ra một biểu thức "p `^` q"   với giá trị trả về tuân theo nguyên tắc: _Kết quả là false khi và chỉ khi cả hai biến là false_

| p | q | p `^` q |
|---|---|---------|
| T | T |    T    |
| T | F |    T    |
| F | T |    T    |
| F | F |    F    |



__Phép giao__

    Nếu p và q là hai biến mệnh đề thì "p and q" 
    được gọi là giao của hai biến mệnh đề đó
\
Ký hiệu của phép giao là  `v`

Ngược lại với phép hội, phép giao của p và q trả về biểu thức "p `^` q" với giá trị trả về tuân theo nguyên tác: _Kết quả là true khi và chỉ khi cả hai biến là true_

| p | q | p `^` q |
|---|---|---------|
| T | T |    T    |
| T | F |    F    |
| F | T |    F    |
| F | F |    F    |

__Phép phủ định__

    Nếu p là một biết mệnh đề thì "not p" gọi là
    phủ định của p
\
Ký hiệu là `~` hoặc `¬`

Phép phủ định trả về kết quả ngược với kết quả của p

| p | `~`p |
|---|---   |
| T | F    |
| F | T    |


Biểu thức tạo bởi các biến mệnh đề sẽ cho ra một mệnh đề mới. Ví dụ: 

- p : "Quảng ngãi ở Việt Nam"
- q : "thủ đô của Việt Nam là Hà Nội"

⟶ p `^` q : "Quảng ngãi ở Việt Nam và thủ đô của Việt Nam là Hà Nội"

Lưu ý: Mệnh đề mới có thể trả về giá trị tùy ý, có thể là false mà không nhất thiết phải là true

Hãy nhớ rằng, khi chúng ta thực hiện phép toán lên n biến (n ≧ 1) thì số dòng của bảng chân trị là $2^n$

Nếu một mệnh đề được đưa về một biểu thức thì các phép toán của biến mệnh đề được ưu tiên nguyên tắc:
- phép phủ định `~` luôn được ưu tiên trước
- độ ưu tiên của `v` và `^` là như nhau

Ví dụ 1:

    ~p ^ q = (~p) ^ q 

Trong biểu thức trên, chúng ta cần xác định giá trị của  `~`p trước rồi mới đi phép toán `^`

Ví dụ 2:

    p ^ q v r

Trong trường hợp này, vì phép toán `^` và `v` ngang hàng với nhau nên biểu thức được tính toán tuần tự từ trái sang phải 


## Xử lý tính logic của mệnh đề

Quay trở lại chủ đề ban đầu, tính logic của một mệnh đề chính là giá trị true hoặc false của mệnh đề đó. Người làm toán cần biết một mệnh đề đúng hay sai bằng cách chỉ ra mệnh đề đó trả về true hay false. Có 2 cách để làm điều này:

- Dùng bảng chân trị
- Dùng lý luận chứng minh phản chứng

Cách đầu tiên là cách dễ nhất đối với những người là học sinh, sinh viên. Bằng cách đưa mệnh đề về dạng biểu thức và kiểm tra giá trị trả về trong bảng chân trị, ta có thể chỉ ra tính đúng sai của mệnh đề. 

Lấy ví dụ