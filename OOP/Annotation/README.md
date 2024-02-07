# Annotation trong Java

Annotation trong Java cung cấp thông tin bổ sung về chương trình mà Java có thể sử dụng.

Annotation bắt đầu bằng dấu  `@`. Cú pháp là:

    @AnnotationName
\
Trước khi tìm hiểu về annotation, hãy cùng ôn tập qua về Tính kế thừa mà chúng ta đã học trong Khóa Java OOP.

__Ôn tập: Tính kế thừa trong Java__

Khái niệm kế thừa rất đơn giản, lớp con có thể kế thừa tất cả các trường và phương thức của lớp cha.

Chúng ta sử dụng từ khóa extends để kế thừa từ lớp cha.
```
class Animal {
    public void displayInfo() {
        System.out.println("I am an animal.");
    }
}


class Dog extends Animal {


    // override the display() method
    public void displayinfo() {
        System.out.println("I am a dog.");
    }
}
```
\
Trong đó

- Dog - lớp con (lớp phụ)
- Animal - lớp cha (siêu lớp)

Bây giờ, lớp Dog có thể kế thừa tất cả các trường và phương thức của lớp Animal. Lớp Dog cũng có thể có các trường và lớp riêng.

Annotation `@Override `

Trong quá trình kế thừa, chúng ta biết rằng nếu một phương thức xuất hiện trong cả lớp cha và lớp con, phương thức trong lớp con sẽ ghi đè phương thức của lớp cha.

Để chỉ định phương thức ghi đè, chúng ta sử dụng annotation `@Override`. Hãy xem một ví dụ:

```
class Animal {
    public void displayInfo() {
        System.out.println("I am an animal.");
    }
}
 
class Dog extends Animal {
 
    @Override
    public void displayInfo() {
        System.out.println("I am a dog.");
    }
}
 
class Main {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.displayInfo();
    }
}
```
\
Đầu ra: `I am a dog.`

Ở trên, chúng ta đã ghi đè phương thức `displayInfo()` của lớp Animal trong lớp Dog.

Annotation `@Override` được sử dụng ở trên displayInfo() của Dog để chỉ định rằng đó là phương thức được ghi đè.

Khi chúng ta sử dụng `@Override`, phương thức sẽ được ghi đè từ lớp cha. Nếu không, chúng ta sẽ nhận được lỗi.

```
class Animal {
 
}
 
class Dog extends Animal {
 
    @Override
    public void displayinfo() {
        System.out.println("I am a dog.");
    }
}
 
class Main {
    public static void main(String[] args) {
        Dog d1 = new Dog();
        d1.displayinfo();
    }
}
```
\
Ở đây không có displayInfo() trong lớp cha, vì vậy việc ghi đè phương thức không diễn ra. Do đó, chúng ta gặp phải lỗi

    method does not override or implement a method from a supertype
    @Override

\
Note: Đôi khi, chúng ta mắc các lỗi phức tạp, lỗi chính tả, v.v. trong khi ghi đè phương thức. Annotation @Override đảm bảo rằng chúng ta đang ghi đè phương thức của lớp cha.

## Câu hỏi

 Annotation @Override được sử dụng để làm gì?

A. Annotation @Override ghi đè phương thức của lớp cha.

B. Annotation @Override không ảnh hưởng gì đến code.

C. Annotation @Override đảm bảo rằng chúng ta đang ghi đè phương thức của lớp cha.

D. Không có đáp án đúng.

Đáp án: C

Nguồn: [tek4.vn](https://tek4.vn/khoa-hoc/lap-trinh-java-nang-cao/annotation-trong-java)