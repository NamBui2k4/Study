# Khác nhau giữa List và ArrayList
1. List là một kiểu trừu tượng (abstract type): có nghĩa là ta không thể tạo một đối tượng List trực tiếp mà chỉ có thể tạo đối tượng của một __lớp triển khai__ của List, như ArrayList, LinkedList, Vector, và nhiều lớp khác.

```
    // Không thể tạo trực tiếp một đối tượng List
    List<String> myList = new List<>(); 
    // Lỗi biên dịch
```

```
    List<String> list = new ArrayList<String>(); // Dùng ArrayList làm  thể hiện của List
    list.add("Hello");
    list.add("World");

```
2. ArrayList là một kiểu cụ thể (concrete type): Có nghĩa là ta có thể tạo một đối tượng ArrayList trực tiếp bằng từ khóa new.

3. List có thể sử dụng làm kiểu tham chiếu (reference type):
Bạn có thể sử dụng List như là một kiểu tham chiếu cho bất kỳ lớp nào triển khai List. Điều này có nghĩa là bạn có thể gán một đối tượng của ArrayList, LinkedList, Vector, vv., cho một biến có kiểu List. Điều này giúp sử dụng đa hình (polymorphism) và chuyển đổi giữa các triển khai khác nhau của List mà không cần thay đổi mã nguồn sử dụng các phương thức của List.
ArrayList chỉ có thể sử dụng làm kiểu tham chiếu cho chính nó hoặc các lớp cha của nó:

ArrayList chỉ có thể được sử dụng làm kiểu tham chiếu cho chính nó hoặc các lớp cha của nó như Collection hoặc Object. Điều này có nghĩa là bạn không thể gán một đối tượng của ArrayList cho một biến có kiểu là List mà không cần ép kiểu (cast)
# Mối quan hệ giữa List và ArrayList
Trong Java, List là một __interface__ (giao diện), trong khi ArrayList là một trong các __lớp triển khai__ (implementations) của List. Mối quan hệ giữa List và ArrayList là mối quan hệ giao diện và triển khai (interface and implementation).

List Interface:

- List là một interface trong gói java.util.

- Nó là một phần của Java Collections Framework và mô tả một tập hợp có thứ tự của các phần tử có thể chứa các phần tử trùng lặp.

ArrayList Class:

- ArrayList là một lớp cụ thể (class) dùng để triển khai giao diện List.

- ArrayList sử dụng một mảng động để lưu trữ các phần tử và có thể tự động mở rộng kích thước khi cần.


# tạo đối tượng ArrayList bằng cụm từ ArrayList::new

Chúng ta đã quá quen với việc tạo một đối tượng thông qua constructor của lớp đại diện cho đối tượng đó. Tuy nhiên, có một cách khác thay thế nếu như ta không không thể xác định được constructor có tham số hay không. Một trong số đó là sử dụng phương thức tham chiếu

ArrayList::new là một __phương thức tham chiếu__ (hoặc một biểu thức lambda ngắn gọn) có chức năng tham chiếu đến constructor của lớp ArrayList và nó được dùng để tạo một thể hiện (instance) mới của lớp ArrayList. 

Xét thử ví dụ sau:
```
List< List<String> > listOfLists = new ArrayList<>();
listOfLists.add( () -> new ArrayList<String>() );
```
Trong ví dụ trên, ta để ý rằng "() -> new ArrayList<String>()" là một biểu thức lambda dùng để tạo một đối tượng ArrayList mới và truyền vào listOfLists. Tuy nhiên, ta có thể làm một cách ngắn gọn hơn như sau:
```
    List<List<String>> listOfLists = new ArrayList<>();
    listOfLists.add(ArrayList::new);
```

Có thể thấy ArrayList::new đã thay thể hoàn toàn "() -> new ArrayList<String>()" và làm code trở nên gọn gàng hơn. Tuy nhiên, nhược điểm của phương pháp này là nó chỉ tạo ra một đối tượng mặc định (không tham số) và đối tượng đó có thể là null, thậm chí nó có thể gây hiểu lầm đối với những người mới học và không hiểu rõ về tham chiếu constructor


