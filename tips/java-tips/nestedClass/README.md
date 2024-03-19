# Nested class - Lớp lồng nhau trong Java

Trong lập trình Java, chúng ta thường tạo một lớp và tạo các trường và phương thức bên trong nó.

```
class CPU {

    // fields
    // methods
  
}
```
\
Tuy nhiên, chúng ta cũng có thể tạo lớp bên trong một lớp bên trong một lớp khác. khi một lớp được định nghĩa bên trong một lớp khác, chúng ta gọi nó là nested class. Còn cái lớp chứa nó được gọi là outer class

```
// outer class
class CPU {

    // nested class
    class Process {

        void display() {
            System.out.println("Process");
        }

    }
}
```
\
__Truy cập một nested class__

Giả sử chúng ta có lớp CPU với một nested class của nó là Process.

```
// outer class
class CPU {

    // nested class
    class Process {

        void display() {
            System.out.println("Process");
        }

    }
}
```
\
Để truy cập các trường và phương thức của nested class:

1. Chúng ta phải tạo một đối tượng thuộc outer class:
    
        CPU cpu = new CPU();

2. Tạo một đối tượng của lớp trong bằng cách sử dụng đối tượng của outer class:

        CPU.Process p1 = cpu.new Process();

Vì Process nằm trong lớp CPU nên lớp Process được tham chiếu thành `CPU.Process` thay vì chỉ `Process`.

Ví dụ:  

```
// outer class
class CPU {
 
    // nested class
    class Process {
 
        // method inside nested class
        void display() {
            System.out.println("Process");
        }
 
    }
}
 
class Main {
    public static void main(String[] args) {
 
        // object of outer class
        CPU cpu = new CPU();
 
        // object of inner class
        CPU.Process p1 = cpu.new Process();
 
        // call method of inner class
        p1.display();
 
    }
}
```
Đầu ra

    Process

## Mở rộng

Một nested class được phân loại thành stactic và non-static

__Non-static nested class__

Non-static nested class hay còn gọi là những Inner class. Chúng ta có thể định nghĩa những Inner class này bên trong một class khác như class Builder ở trên, bên trong một phương thức nào đó  (còn gọi là Method-local Inner Class), ngoài ra chúng ta còn có những class không có tên gọi là Anonymous Inner Class.

__Một số lưu ý__

1. Khi khai báo một class, chúng ta không thể định nghĩa nó với private access modifier, nhưng đối với Inner class thì có thể.

```
public class Application {
    private class Builder {

    }
}
```
\
Mà khi đã định nghĩa một Inner class là private thì nó chỉ có thể được truy cập bởi các thành phần bên trong outer class thôi. Những lớp bên ngoài hoặc cùng level với outer class sẽ không thể truy cập được nó trừ khi có accessor


2. Khi chúng ta khai báo một class bên trong một method nào đó, gọi là Method-local Inner Class, thì scope của class này chỉ thuộc về method đó mà thôi. Nó không thể đi kèm với bất kỳ access modifier nào dù là public, protected, hay private . Ví dụ như:

```
public class Application {
    public void print() {
        class Builder { // code here }
    }
}
```
\
_Ghi chú: scope của một lớp hiểu đơn giản là phạm vi của lớp đó, giới hạn bởi 2 dấu ngoặc nhọn { } trong java_

Tuy nhiên, chúng ta hoàn toàn vẫn có thể cho nó về dạng abstract class hoặc final class.

```
public class Application {
    private void print() {
        abstract class Builder1 { // code here}
        final class Builder2 { // code here  }
    }
}
```
\
3. Anonymous Inner Class thường được khai báo khi chúng ta muốn override một phương thức nào đó của một class hoặc interface. Chúng ta sẽ khai báo Anonymous Inner Class và khởi tạo đối tượng cho class này cùng một thời điểm. Ví dụ như:

```
public class Application {

    public void print() {
        Comparable<String> comparable = new Comparable<String>() {
            public int compareTo(String o) {
                return 0;
            }
        };
    }
}
```
\
__Static Nested Class__

Static nested class là những class được định nghĩa với từ khoá static. Nó là static member của outer class và do đó chúng ta không cần phải khởi tạo đối tượng của outer class và chính class này để access tới nó luôn. Ví dụ như:

```

public class Application {

    static class Builder {
        private static void print() {   }
    }   

    public static void main(String[] args) {
        Application.Builder.print();
    }
}
```
\

Lưu ý:  Static nested class sẽ không access được tới các thành phần non-static của outer class. Nó sẽ gây ra ngoại lệ "Cannot make reference static to non-static"


Nguồn: 
[topdev](https://topdev.vn/blog/nested-class-trong-java/)
[tek4](https://tek4.vn/khoa-hoc/lap-trinh-java-nang-cao/lop-long-nhau-trong-java)