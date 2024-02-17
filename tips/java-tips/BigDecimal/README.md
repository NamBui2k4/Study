# BigDecimal

Class `java.math.BigDecimal` biểu diễn các số thập phân cố định với độ dài bất kỳ. Nó là kiểu dữ liệu chính để xử lý các số thập phân. `BigDecimal` có tầm quan trọng lớn trong ngôn ngữ lập trình java đặc biệt là trong tài chính khi các phép tính về tiền được thực hiện.

Vì các kiểu dữ liệu nguyên thủy như `float` và `double` không phù hợp cho các phép tính tài chính do lỗi làm tròn, class `java.math.BigDecimal` cho phép người dùng kiểm soát hoàn toàn việc làm tròn, cho phép người dùng chọn từ nhiều loại làm tròn và nhiều độ chính xác khác nhau.

Một số tính năng nổi bật của class `java.math.BigDecimal`:

- Nó là cố định, tức là giá trị của nó không thể thay đổi sau khi được tạo, mặc dù có thể tạo các đối tượng mới với các giá trị khác bằng cách sử dụng các phương thức trong class này.
- Nó cung cấp kiểm soát số chữ số chính xác (số chữ số trong số), và
- Kiểm soát chế độ làm tròn trong các phép toán số học.
- Tất cả các phép toán trên BigDecimal tạo ra một kết quả mới, được làm tròn với độ chính xác bằng với độ chính xác của các toán hạng.

`BigDecimal` được sử dụng cho nhiều lĩnh vực bao gồm:

- Tính toán số học với độ chính xác bất kỳ
- Tính toán tài chính
- Định giá sản phẩm
- Lãi suất
- Tính toán yêu cầu độ chính xác cao như khác biệt giữa các đại lượng đo

## Các phép toán số học

Các phép toán cơ bản được cung cấp bởi class BigDecimal là phép cộng, phép trừ, phép nhân và phép chia. Những phép toàn này tương ứng với các phương thức:
- add() 
- subtract() 
- multiply()
- divide()

Chúng trả về một đối tượng BigDecimal mới với giá trị là kết quả của phép toán. Ví dụ, xem code dưới đây:

```
BigDecimal bd1 = new BigDecimal("2.00");
BigDecimal bd2 = new BigDecimal("1.50");

System.out.println(bd1.add(bd2)); //  3.50
System.out.println(bd1.subtract(bd2)); //  0.50
System.out.println(bd1.multiply(bd2)); //  3.00
System.out.println(bd1.divide(bd2)); //  1.(3)
```
\
Như ta có thể thấy từ kết quả, khi thực hiện phép chia với hai đối tượng BigDecimal, ta có được kết quả với 3 chữ số thập phân(độ chính xác của kết quả là 3). Nếu ta muốn chỉ định độ chính xác của kết quả, ta có thể sử dụng phương thức divide() với hai tham số - bội số và độ chính xác mong muốn của kết quả:

```
BigDecimal bd1 = new BigDecimal("2");
Bigdecimal bd2 = new BigDecimal("3");

System.out.println(bd1.divide(bd2, 2, RoundingMode.HALF_UP)) ; 
// 0.67 because 2/3 rounds up to 0.67 
// when scale is 2 and RoundingMode is HALF_UP
```
\
Dòng code cuối cùng trong code trên cho thấy một ví dụ về việc sử dụng RoundingMode trong quá trình thực hiện phép chia trên hai đối tượng BigDecimal - trong trường hợp này, ta sử dụng chế độ HALF_UP, nó sẽ làm tròn lên nếu chữ số thập phân là >=.5, và làm tròn xuống trong trường hợp còn lại. Có 7 giá trị khác có thể được truyền vào RoundingMode như sau:

- ROUND_CEILING
- ROUND_DOWN
- ROUND_FLOOR
- ROUND_HALF_DOWN
- ROUND_HALF_EVEN
- ROUND_HALF_UP
- ROUND_UP

## Các phép toán so sánh

Một số phương thứccủa BigDecimal dùng để so sánh số học:

1. compareTo()
- So sánh giá trị của BigDecimal với một giá trị khác.
- Trả về 0 nếu bằng nhau, -1 nếu nhỏ hơn, 1 nếu lớn hơn

2. equals()

- kiểm tra xem 2 đối tượng BigDecimal có bằng nhau không.
- Trả về true nếu bằng nhau, false nếu khác nhau.

Ví dụ:
```
    BigDecimal num1 = new BigDecimal("10.50");
    BigDecimal num2 = new BigDecimal("5.20");
    BigDecimal num3 = new BigDecimal("10.50");
    
    // Sử dụng compareTo() để so sánh giá trị
    System.out.println(num1.compareTo(num2)); // 1
    System.out.println(num1.compareTo(num3)); // 0

    // Sử dụng equals() để kiểm tra sự bằng nhau
    System.out.println(num1.equals(num2)); // false
    System.out.println(num1.equals(num3)); // true
```
\
Nguồn: [gurucoding](https://www.gurucoding.org/vi/docs/java/BigDecimal#:~:text=L%E1%BB%9Bp%20h%E1%BB%8Dc%20Java%20BigDecimal%20BigDecimal%20Class%20java.math.BigDecimal%20bi%E1%BB%83u,c%C3%A1c%20ph%C3%A9p%20t%C3%ADnh%20v%E1%BB%81%20ti%E1%BB%81n%20%C4%91%C6%B0%E1%BB%A3c%20th%E1%BB%B1c%20hi%E1%BB%87n.)