# Stream Xử Lý Dữ Liệu Thế Nào Trong Java
Sự ra đời của Java 8 đã làm thay đổi thói quen sử dụng của nhiều người lập trình đối với các Collection so với các phiên bản Java trước. Một trong những điều mới mẻ nhất chính là thêm các phương thức mở rộng vào các interface có sẵn (Collection, List, Iterable) cùng các lớp abstraction như Stream để thực hiện các phép toán tổng hợp trên tập dữ liệu và không làm thay đổi dữ liệu cũ. Trong bài viết này chúng ta sẽ tìm hiểu về Stream là gì và các đặc điểm của nó.

1. __Stream là gì?__

Stream được giới thiệu từ bản java 8 và được nằm trong gói java.util.stream. Stream đại diện cho một chuỗi các giá trị và phục vụ nhiều chức năng tổng hợp để thao tác với dữ liệu như duyệt, tìm giá trị lớn (bé) nhất, sorting, filter, hay limit. Stream có rất nhiều methods đa dạng và chúng có thể được kết hợp với nhau, một vài trong số chúng trả về kiểu Stream được gọi là intermediate operations và một số khác trả về kiểu non-stream(int, long, list, arrays,…) được gọi là terminal operations.

Một ví dụ là khi bạn muốn sắp xếp các giá trị trong một mảng thì thay vì phải viết các vòng lặp for hoặc while, bạn chỉ cần dùng một hay một vài phương thức của stream một cách ngắn gọn và đơn giản.

__Các tính chất của Stream:__

- Stream không phải là một cấu trúc dữ liệu, đầu vào của Stream có thể là các Colllections (Arraylist, Set, LinkedList,…), Arrays và các kênh Input/Output.
- Stream không làm thay đổi dữ liệu gốc mà chỉ trả về kết quả thông qua các methods.
- Về cơ bản các method của stream được phân làm 2 loại là method xử lý trung gian(Intermediate Operation) và method xử lý đầu cuối(Terminal Operation).

Sau đây là một ví dụ về Stream:

```
    Collection<Integer> collection = Arrays.asList(1,2 3);
    Stream<Integer> stream = collection.stream();

    System.out.println(stream); 
    
    // kết quả: java.util.stream.DistinctOps$1@512ddf17
    // giải thích: ta không thể in ra stream vì đây không phải một cấu trúc dữ liệu
    
```

2. Các methods trong Stream

- Terminal Operations (nhóm methods xử lý kết quả cuối cùng)

Nhóm methods này gồm các method có kiểu trả kiểu nguyên thủy(primitive), và kiểu đối tượng khác Stream ( như String, Integer,…) hay collections. Thuật ngữ "terminal" ở đây ám chỉ rằng khi một phương thức terminal operation được gọi, nó đánh dấu sự kết thúc của một chuỗi thao tác trên Stream và thực hiện các thao tác cuối cùng trên dữ liệu, trả về kết quả mong muốn


| | Tên method   |                           Diễn giải chức năng                                   |
|-|-----------|-------------------------------------------------------------------------|
|a| Collect()   |Trả về kết quả của stream dưới dạng List hoặc Set.                       |
|b| forEach()   |Duyệt qua mọi phần tử trong stream.                                      |
|c| Reduce()   |Kết hợp các phần tử thành một giá trị đơn cùng kiểu với dữ liệu ban đầu  |
|d| Max, Min()  |Trả về giá trị lớn nhất hoặc bé nhất trong các phần tử.                  |

Ví dụ a - Collect()
```
public static void main(String[] args) {
      List<String> strings = Arrays.asList("args", "", "code", "learn", "...");
      List<String> filter = strings.stream().collect(Collectors.toList());
      System.out.println(filter);
}

Outout: args, , code, learn, ...
```

Ví dụ b - forEach()
```
public static void main(String[] args) {
      List<String> strings = Arrays.asList("args", "", "code", "learn", "...");
      strings.stream().forEach(s -> System.out.println(s));
}

Output:
    args

    code
    learn 
    ...
```

Ví dụ c - reduce()
```
public static void main(String[] args) {
      List<String> strings = Arrays.asList("args", "", "code", "learn", "...");
      String result = strings.stream().reduce("-", String::concat);
      System.out.println(result);
}

Output: -argscodelearn...
```

Ví dụ d) - Max và Min
```
public static void main(String[] args) {
      List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
      Integer maxx = list.stream().max(Integer::compare).get();
      Integer minn = list.stream().min(Integer::compare).get();
      System.out.println("Max: "+maxx+"\nMin: "+minn);
}

Output:
    Max: 10
    Min: 1
```

- Intermediate Operations(nhóm method thực thi phép toán trung gian)

Nhóm các method này chủ yếu được sử dụng để thực hiện các biến đổi, lọc, và ánh xạ trên dữ liệu. Thuật ngữ "intermediate" ở đây ám chỉ rằng các phương thức này được thực hiện trên một Stream và tạo ra một Stream mới với các biến đổi được áp dụng, nhưng chúng không làm thay đổi dữ liệu gốc. 

|  | Tên method | Diễn giải chức năng                                                   |
|--|------------|---------------------------------- 
|a | Distinct   | Loại bỏ các phần tử trùng lặp|
|b | Map        | Trả về một stream mà ở đó các phần tử đã  được thay đổi theo cách người dùng tự định nghĩa.|
|c | Filter     | Lọc và xóa bỏ các phần tử với điều kiện do người dùng định nghĩa|
|d | Sorted     | Dùng cho việc sắp xếp các phần tử.|
|e | Limit(n)   | Với tham số đầu vào là số nguyên không âm n nó sẽ trả về một stream chứa n phần tử đầu tiên.|

Ví dụ a - distinc
```
public static void main(String[] args) {

      // Khởi tạo List các số tự nhiên
      List<Integer> list = Arrays.asList(1,2,2,2,2,3,4,5);

      // dùng distinc để xáa số trùng lặp 
      list.stream().distinct().forEach(System.out::println);
}

Output:
    1
    2
    3
    4
    5
```

Ví dụ b)
```
public static void main(String[] args) {

      // Khởi tạo List các số tự nhiên
      List<Integer> list = Arrays.asList(1,2,2,2,2,3,4,5);

      // định nghĩa lambda  y = x^2  cho từng số đó
      list.stream().distinct().map(i -> i*i).forEach(System.out::println);
}

Output:
    1
    4
    9
    16
    25
```

Ví dụ c - filter
```
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

      // Sử dụng Stream để lọc các số lẻ
      List<Integer> oddNum = numbers.stream()
                  .filter(n -> n % 2 != 0)
                  .collect(Collectors.toList());

Output: [1, 3, 5, 7, 9]
```
Ghi chú: tham số n trong biểu thức lambda của filter chính là phần tử của tập numbers
 Do đó, Khi ứng dụng filter trong các bài toán khác phức tạp hơn, muốn biết tham số của biểu thức lambda là gì thì ta căn cứ vào vào tập dữ liệu mà Stream thực thi để xác định kiểu của nó. 


# Nhược điểm của Stream
Stream thực hiện theo cơ chế lazy evaluation, nghĩa là nó chỉ thực hiện tính toán khi giá trị cụ thể được yêu cầu. Các intermediate method không hoạt động khi chúng ta gọi đến mà chỉ thực thi khi có một terminal method kết thúc stream của nó

Đối với tập dữ liệu lớn, các vòng lặp có thể chỉ cần xử lý tại một vùng nhất định vì chúng truy cập trực tiếp các phần tử bằng chỉ số, trong khi đó Stream có thể phải duyệt qua toàn bộ dữ liệu, điều này có thể dẫn đến việc tăng đáng kể thời gian xử lý.

Stream tạo ra nhiều đối tượng trung gian và phải xử lý nhiều phép toán hơn vòng lặp. Điều này có thể gây ra chi phí bộ nhớ và thời gian cao hơn

Stream có thể hỗ trợ thao tác song song, nhưng không phải lúc nào cũng hiệu quả. Thao tác song song có thể gây ra chi phí phối hợp, phân chia, và gộp dữ liệu giữa các luồng. Nếu dữ liệu quá nhỏ, hoặc thao tác quá đơn giản, hoặc không có sự phụ thuộc giữa các phần tử, thì thao tác song song có thể không mang lại lợi ích nào, thậm chí còn chậm hơn thao tác tuần tự
Nguồn:

 [_CodeLearn_](https://codelearn.io/sharing/stream-xu-ly-du-lieu-the-nao-trong-java)