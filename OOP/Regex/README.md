# Regex là gì
Biểu thức chính quy (regular expression hay regex) là một chuỗi các ký tự đặc biệt được sử dụng để mô tả một quy tắc cụ thể trong xử lý chuỗi. Biểu thức chính quy được sử dụng để tìm kiếm, so khớp, và xử lý văn bản dựa trên các mô hình chuỗi.

Một số ký tự đặc biệt trong biểu thức chính quy có thể thực hiện các chức năng như sau:

```.``` : Khớp với bất kỳ ký tự nào.
```*``` : Khớp với 0 hoặc nhiều lần xuất hiện của ký tự trước đó.
```+``` : Khớp với ít nhất một lần xuất hiện của ký tự trước đó.
```?``` : Khớp với 0 hoặc 1 lần xuất hiện của ký tự trước đó.
```^``` : Bắt đầu một chuỗi.
```$``` : Kết thúc một chuỗi.
```[]```: Tập hợp các ký tự có thể khớp.
```()```: Nhóm kết hợp các phần của biểu thức.
```|```: Lựa chọn giữa các biểu thức con.

Ví dụ 1: biểu thứ chính quy đơn giản
```
/abc/
```
Chuổi ký tự trên là chuổi mẫu, và chúng ta dùng nó để kiểm tra các mẫu khác có chưa các ký tự abc hay không

Chúng ta đi xem xét các chuổi sau: 
```
abc def
```
Chuổi này hợp lệ với chuổi mẫu vì chứa chuỗi abc
```
      abdefgh123
```
Chuổi này thì không đúng với chuỗi mẫu vì không chứa chuỗi abc

Ví dụ 2: giả sử ta có chuỗi bắt đầu từ "A" và kết thúc bằng "J" thì ta có thể mô tả nó bằng một biểu thức chính quy:
``` 
^A.*J$ 
```
       

Lưu ý ký tự ```^``` :
- Khi ```^``` được đặt ở đầu biểu thức chính quy (ngoài dấu ngoặc vuông), nó có ý nghĩa "khớp với đầu chuỗi". Nói cách khác, nó chỉ khớp với chuỗi nếu chuỗi bắt đầu bằng mẫu mô tả sau ```^```. Ví dụ, ```^abc``` sẽ khớp với chuỗi nào bắt đầu bằng abc.

- Khi ```^``` được đặt bên trong dấu ngoặc vuông [...], nó trở thành một ký tự phủ định, có ý nghĩa "không khớp với các ký tự được liệt kê trong dấu ngoặc vuông". Ví dụ, [^abc] sẽ khớp với bất kỳ ký tự nào trừ a, b, và c.
# Các vấn đề liên quan đến chuỗi và biểu thức regex
Xét cú pháp khởi tạo một biểu thức chính quy sau: ```String regex = "\\d+";```. Giả sử ta thêm bớt một ký tự ```\``` thì điều gì xảy ra?
Trong biểu thức chính quy ```\\d+```

```\\:``` Được sử dụng để tránh xung đột với các ký tự đặc biệt trong Java. Trong Java, bạn cần sử dụng \\ để đại diện cho một dấu \ trong biểu thức chính quy.

- ```\d``` Là ký tự đặc biệt trong biểu thức chính quy, khớp với bất kỳ chữ số nào từ 0 đến 9.

- ```+``` Là một quantifier, chỉ định rằng phải có ít nhất một chữ số xuất hiện.

Nếu bạn bỏ đi một dấu \ (đặc biệt là ở phần \\d), biểu thức chính quy sẽ không còn đúng nữa. Nó sẽ trở thành ```\d+``` và nó có thể không được hiểu đúng và có thể không khớp với bất kỳ chữ số nào. Do đó, việc bỏ đi một dấu \ sẽ làm thay đổi ý nghĩa của biểu thức.

Nếu bạn thêm thừa một dấu \, chẳng hạn là ```\\d+\\d``` hay ```\\\d+``` thì nó cũng không gây ảnh hưởng đáng kể đến ý nghĩa. Dấu ```\\\``` Sẽ được hiểu là ```\\```, vì hai dấu ```\\``` đầu tiên đại diện cho một dấu ```\```.

# Regex Java
Trong Java, Regex hoặc Regular Expression là một API để định nghĩa một mẫu để tìm kiếm hoặc thao tác với chuỗi. Nó được sử dụng rộng rãi để xác định ràng buộc trên các chuỗi như xác thực mật khẩu, email, kiểu dữ liệu datetime, .
## Gói java.util.regex
Java Regex API cung cấp 1 interface và 3 lớp trong gói java.util.regex.

Lớp Matcher và Pattern trong java cung cấp cơ sở của biểu thức chính quy. Gói java.util.regex cung cấp các lớp và giao diện sau cho các biểu thức chính quy.

1. Interface MatchResult
2. Lớp Matcher
3. Lớp Pattern
4. Lớp PatternSyntaxException

__Lớp Matcher__
Nó implements interface MatchResult, cung cấp bộ máy xử lý biểu thức chính quy để thao tác với chuỗi ký tự.

No.	Phương thức	Mô tả
|No|           Method            |                  Description                                            
|- |-----------------------------|-------------------------------------------------
|1 |	boolean matches()   	 |    kiểm tra xem biểu thức chính quy có khớp với mẫu hay không.
|2 |	boolean find()	         |    tìm biểu thức tiếp theo khớp với mẫu.
|3 |	boolean find(int start)  | 	  tìm biểu thức tiếp theo khớp với mẫu từ số bắt đầu đã cho.
|4 |	String group()	         |    trả về chuỗi con phù hợp.
|5 |	int start()	             |    trả về vị trí bắt đầu của chuỗi con phù hợp.
|6 |	int end()	             |    trả về vị trí kết thúc của chuỗi con phù hợp.
|7 |	int groupCount()	     |    trả về tổng số các chuỗi con phù hợp.

Lớp Pattern
Đây là phiên bản được biên dịch của một biểu thức chính quy. Nó được sử dụng để xác định một mẫu cho bộ máy regex.

No.	Phương thức	Mô tả
1	static Pattern compile(String regex)	biên dịch regex đã cho và trả về thể hiện của Pattern.
2	Matcher matcher(CharSequence input)	tạo một matcher khớp với đầu vào đã cho với mẫu.
3	static boolean matches(String regex, Nó biên dịch biểu thức chính quy và tìm kiếm các chuỗi con từ chuỗi       
                                                            inpu         phù hợp với mẫu regex.
    CharSequence input) 
4	String[] split(CharSequence input)	chia chuỗi input đã cho thành mảng các kết quả trùng khớp với mẫu đã cho.
5	String pattern()	trả về mẫu regex.

nguồn [_viettuts.vn_](https://viettuts.vn/java/su-dung-regex-trong-java#:~:text=Java%20Regex%20ho%E1%BA%B7c%20Regular%20Expression%20%28bi%E1%BB%83u%20th%E1%BB%A9c%20ch%C3%ADnh,th%E1%BB%B1c%20m%E1%BA%ADt%20kh%E1%BA%A9u%2C%20email%2C%20ki%E1%BB%83u%20d%E1%BB%AF%20li%E1%BB%87u%20datetime%2C)


