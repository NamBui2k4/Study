# String - Chuỗi

Một chuỗi trong java là một đối tượng bất biến đại diện cho một chuỗi ký tự. 

Lớp String trong Java cung cấp các phương thức để xử lý các chuỗi, chẳng hạn như kiểm tra độ dài của chúng, nối chúng lại với nhau và tìm kiếm các ký tự cụ thể bên trong chúng. Chuỗi cũng được dùng để hiển thị cho người dùng, chẳng hạn như thông báo lỗi hoặc tùy chọn menu.

Vì các String là bất biến nên chúng có thể được chia sẻ an toàn giữa các phần khác nhau của chương trình mà không phải lo lắng về việc dữ liệu bị sửa đổi. Điều này khiến chúng trở nên lý tưởng để lưu trữ dữ liệu cần được truy cập bởi nhiều luồng, chẳng hạn như cài đặt cấu hình.

## Làm việc với String

Khác với ngôn ngữ C/C++, Java định nghĩa Chuỗi là một kiểu dữ liệu riêng biệt và có tính năng riêng chứ không phải là một mảng ký tự. Những ai đã học C/C++ chắc đã quen với cú pháp tạo chuỗi kiểu như `char[] c = {'a', 'b', 'c'};`. Khá lằng nhằng phải ko ? Không phải lo, vì Java sẽ cho chúng ta tiếp cận chuỗi theo một cách khác, chẳng hạn như `String str = "abc";`. Thậm chí nếu bạn muốn làm việc trên mảng Ký tự thì java cũng đã có phương thức `toCharArray()`, giúp chuyển một chuỗi sang mảng ký tự.

__Khởi tạo chuỗi__

```
String brand = new String("gurucoding");
String sentence = new String("Here we have a whole sentence created");
```
\
Vì Chuỗi là đối tượng nên bạn có thể sử dụng từ khóa new, liên quan đến hàm tạo Chuỗi, giống như bất kỳ loại tham chiếu nào khác (giống với các đối tượng khác phải khởi tạo đối tượng). Tuy nhiên, có một cách khác để gán là sử dụng String literals (dấu nháy kép).

```
String brand = "gurucoding";
String sentence = "Here we have a whole sentence created";
```
\
Chuỗi là một loại tham chiếu đặc biệt trong Java. Vì chúng quá phổ biến nên JVM dành một vùng bộ nhớ đặc biệt cho Chuỗi (ông thần này có hẳn một vùng nhớ riêng nhé). Vùng nhớ này được gọi là String Pool.

Khi gán một chuỗi ký tự cho một biến Chuỗi, như trong tập ví dụ thứ hai ở trên, chúng ta thêm biến của mình vào String Pool. Nói chung sử dụng khai báo biên string ở ví dụ thứ 2 là nó sẽ ném string vào String Pool

## String Pool​

Các chuỗi là bất biến (immutable), nghĩa là sau khi chúng được tạo, chúng không thể sửa đổi được. String Pool là một tập hợp các chuỗi được duy trì bởi thời gian chạy java. Khi một chuỗi được tạo, trước tiên nó sẽ được kiểm tra xem nó đã tồn tại trong nhóm chưa. Nếu có, thì tham chiếu đến chuỗi hiện có sẽ được trả về. Nếu không, thì một chuỗi mới sẽ được thêm vào nhóm và một tham chiếu đến chuỗi mới được trả về. Quá trình này đảm bảo rằng chỉ có một bản sao của mỗi chuỗi trong bộ nhớ (có nghĩa là khai báo một biến string có chuỗi giống với một trong số string đã tạo trước đó thì nó sẽ tham chiếu đến string đã tạo trước đó), điều này có thể cải thiện hiệu suất và giảm mức sử dụng bộ nhớ (Tối ưu bộ nhớ và hiệu năng).

```
Ghi nhớ

Trong Java, "bất biến" (immutable) có nghĩa là giá
trị của một đối tượng không thể thay đổi sau khi nó
đã được tạo. Nghĩa là, một đối tượng bất biến không
thể thay đổi trạng thái của chính nó hoặc của các
thuộc tính của nó sau khi được khởi tạo.

Trong Java, một số lớp được thiết kế để là bất
biến, chẳng hạn như String, Integer và BigDecimal.
Việc sử dụng đối tượng bất biến có nhiều lợi ích,
bao gồm việc chúng an toàn khi sử dụng đa luồng
(multithreading) và giúp đảm bảo tính nhất quán của
dữ liệu.

Một đối tượng được tạo thành bởi các thành phần bất
biến có thể bị "sửa đổi" thông qua việc tạo một đối
tượng mới, được sao chép từ đối tượng cũ và thực
hiện các thay đổi cần thiết. Kỹ thuật này được gọi
là "immutable copying" và được sử dụng rộng rãi
trong thiết kế và triển khai các thuật toán xử lý
dữ liệu.
```
\
Khi một Chuỗi được tạo bằng cách sử dụng một Chuỗi ký tự tức là sử dụng dấu ngoặc kép, nó sẽ được thêm vào String Pool. Ví dụ:

    String brand = "FOO";
\
Giá trị `FOO` sẽ được lưu trữ trong khu vực đặc biệt trong bộ nhớ được đề cập ở trên — String Constants Pool. "Nhưng tại sao điều này lại quan trọng?".

Hãy thử tạo một biến Chuỗi khác bằng từ khóa mới:

```
String brand = "FOO";

String courseName = new String("FOO");
```
\
Vì giá trị `FOO` đã có sẵn bên trong String Pool, nên biến CourseName đề cập đến cùng một giá trị `FOO` trong String Pool.

Cả `brand` và `courseName` đều đề trỏ đến cùng một giá trị FOO trong bộ nhớ:

![](/pictures/strings-1-2bf228d5c8fb24f8071ecfcf15c74b39.png)

## Tính bất biến 

Hãy xét kịch bản sau: bạn có nhiều biến trỏ đến cùng một đối tượng String trong Pool. Nếu chúng ta thay đổi giá trị của một biến nào đó (ví dụ: brand) thành một giá trị mới (ví dụ: "Hedgehog"), chúng ta sẽ tác động tới tất cả các biến còn lại. 
```
String brand = "FOO";
String courseName = brand;

System.out.println(brand);       // Output: FOO
System.out.println(courseName);  // Output: FOO

brand = "Hedgehog";

System.out.println(brand);       // Output: Hedgehog
System.out.println(courseName);  // Output: Hedgehog
```
\
Rõ ràng, điều này có thể gây ra rắc rối nghiêm trọng và do đó chuỗi đã được làm bất biến trong Java để ngăn chặn hành vi này xảy ra.

Nhưng đối với đối tượng String được khởi tạo bằng từ khóa new thì sao? Liệu chúng có bất biến không?

```
String brand = new String("FOO");
String courseName = brand;

System.out.println(brand);       // Output: FOO
System.out.println(courseName);  // Output: FOO

brand = "Hedgehog";

System.out.println(brand);         // Output: Hedgehog
System.out.println(courseName);  // Output: FOO (vẫn giữ giá trị cũ)

```
\
Sự khác biệt ở đây là khi chúng ta tạo một đối tượng String bằng cách sử dụng từ khóa new, nó luôn tạo một đối tượng mới trong bộ nhớ heap.

Tuy nhiên, hành vi mà chúng ta đã quan sát ở trên, khi tạo đối tượng `courseName`, hành vi đó được liên kết với chuỗi `FOO` đã có trong String pool.

Tóm lại, tất cả các chuỗi là bất biến, cho dù được tạo dưới dạng đối tượng hay ký tự.

```
Ghi nhớ

Khi bạn sử dụng String Literal, Java sẽ kiểm tra
xem trong String Constant Pool có chứa chuỗi đó hay
chưa. Nếu có, Java sẽ sử dụng lại chuỗi đã có trong
String Constant Pool. Nếu không, Java sẽ tạo một
chuỗi mới trong String Constant Pool. Bất kể chuỗi
đã có hay mới được tạo, nó đều là bất biến và không
thể thay đổi giá trị của nó.

Khi bạn sử dụng String Object và tạo một đối tượng
mới bằng cách sử dụng từ khóa new, Java sẽ tạo một
đối tượng mới trong bộ nhớ heap. Tuy nhiên, các đối
tượng String cũng là bất biến, có nghĩa là một khi
một đối tượng String đã được tạo, bạn không thể
thay đổi giá trị của nó.

Do đó, cả String Literal và String Object đều là
bất biến trong Java và có cùng hành vi khi sử dụng.
```

## TÓM TẮT QUAN TRỌNG
String Literal và String Object được lưu ở hai vị trí khác nhau trong bộ nhớ của Java.

String Literal được lưu trữ trong String Constant Pool, một vùng nhớ đặc biệt trong bộ nhớ heap.

String Object được lưu trữ trong vùng nhớ bộ nhớ heap thông thường, bởi vì khi ta sử dụng từ khóa new để tạo đối tượng String, nó sẽ tạo một đối tượng mới trong bộ nhớ heap, thay vì sử dụng lại đối tượng có sẵn trong String Constant Pool.

Cả String Literal và String Object đều có giá trị được lưu trữ trong bộ nhớ heap, nhưng do String Literal có tính bất biến, vì vậy giá trị của nó sẽ không thay đổi trong suốt thời gian chạy của chương trình. Trong khi đó, String Object có thể thay đổi giá trị được lưu trữ của nó, vì vậy giá trị của nó có thể khác nhau tại các thời điểm khác nhau của chương trình.

## Đẳng thức chuỗi - String Equality​

Trong java, toán tử `==` thường được sử dụng để so sánh các giá trị (ví dụ: ourInt == 2) và trả về giá trị đúng hoặc sai. Ngoài ra, ta còn có thể sử dụng phương thức `.equals()` khi so sánh các đối tượng với nhau. Cụ thể, 2 cách này có đặc điểm:

- `==` trả về true khi và chỉ khi cả hai biến tham chiếu đến cùng một đối tượng
- `.equals()` trả về true nếu giá trị giống nhau

Quay trở lại ví dụ trước của chúng ta, Khi chúng ta khởi tạo chuỗi bằng literals (dấu nháy kép), Java thực hiện quy tắc "String interning", tức là cố gắng tái sử dụng chuỗi có sẵn trong String Pool. Khi cả hai chuỗi được khởi tạo bằng literals và có cùng giá trị, chúng sẽ trỏ đến cùng một đối tượng trong String Pool.

```
String brand = "FOO";
String courseName = "FOO";
System.out.println(brand == courseName); // True
System.out.println(brand.equals(courseName)); // True
```
\
Ngược lại, khi ta sử dụng từ khóa `new` để tạo chuỗi, một đối tượng mới sẽ được tạo trong heap memory mà không nằm trong String Pool. Do đó, nếu 2 chuỗi ban đầu có cách khởi tạo khác nhau (một bên sử dụng literals trong khi bên kia dùng từ khóa `new`) thì toán tử `==` sẽ trả về `false`

```
String brand = "FOO";
String courseName = new String("FOO");

System.out.println(brand == courseName); // Output: false

```
\
_Lời khuyên: không nên dùng toán tử `==` để so sánh 2 chuỗi nếu không thành thạo và nắm rõ bản chất. Hãy dùng `.equals()` nhiều nhất có thể_


Nguồn: [gurucoding](https://www.gurucoding.org/vi/docs/java/the-basics/strings)