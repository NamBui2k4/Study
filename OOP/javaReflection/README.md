# Java Reflection là gì? Hướng dẫn Java Reflection API

___Bài viết được sự cho phép của tác giả Trần Hữu Cương___

__Java Reflection là gì?__

Java Refelection là một tính năng (gọi là API hay thư viện cũng được) trong Java. Java Reflection cho phép truy cập các thông tin của đối tượng (tên class, các attribute, các method) và chỉnh sửa các attribute của đối tượng (kể cả các attribute private) trong quá trình run time.

Ta có thể áp dụng Java Reflection trong những trường hợp không biết object được xử lý là gì. (tên class là gì, ở package nào, có những attribute nào, method nào…).

Ví dụ mình muốn viết một hàm copy 2 đối tượng có thể dùng cho loại đối tượng khác nhau. Thì mình cần phải biết 2 đối tượng có cùng kiểu không, có những attribute nào, lấy và copy giá trị từng attribute.

Ngoài ra, với các attribute, method có modifier là private thì ta không thể truy cập ở bên ngoài class đó. Trong những trường hợp bắt buộc phải gọi, truy cập các attribute, method private ở bên ngoài class đó thì Reflection là một giải pháp.

Một số framework sử dụng Java Reflection: Spring, JUnit, Tomcat, Eclipse (dùng để autocomplete)

__Hạn chế, nhược điểm của Java Reflection__

Trong trường hợp đã biết rõ cấu trúc class, có quyền truy cập các attribute, method thì ta không nên sử dụng Java Reflection bởi các lý do sau:

- Hiệu năng thấp: Ví dụ nó phải quét classpath để tìm class.

- Các vấn đề bảo mật: Việc chỉnh sửa class/object trong quá trình runtime có thể ảnh hưởng tới các thread … khiến cho ứng dụng bị fail.

- Khó bảo trì: Việc Reflection khá khó hiểu với người mới và không dễ để debug, nên sẽ rất khó để có thể tìm ra lỗi. Ngoài ra chúng ta cũng không thể check được một số lỗi trong quá trình compile (không tìm thấy class, không tìm thấy attribute…)

__Các thành phần trong Java Reflection__

Tương ứng với các thành phần trong một class, thì Java Reflection cũng cung cấp các class tương ứng để ta có thể xử lý:

- Class: Đại diện cho class/interface để lấy ra các thông tin của class (tên class, super class, class modifier, các method, các attribute …)

- Constructor: Xử lý các hàm khởi tạo của class

- attribute: Xử lý các attribute của class (tên, modifier của attribute, lấy giá trị, thiết lập giá trị cho object…)

- Method: Xử lý các method của class (liệt kê các method, thực thi các method …)

__Ví dụ__

Person.java
```
    Person.java
    package stackjava.com.reflection;
    public class Person {
      public String address;
    
     // setter - getter
    }
```


Customer.java
```
    package stackjava.com.reflection;
    
    public class Customer extends Person {
        private int age;
        protected String gender;
        public String name;
        String phone;

        public Customer() {
        }
        public Customer(int age, String name) {
        this.age = age;
        this.name = name;
        }
        // setter - getter

        @Override
        public String toString() {
         return "Customer [age=" + age + ", gender=" + gender + ", name=" + name + ", phone=" + phone + "]";
        }
    }
```

Lớp xử lý Demo: 

```
package stackjava.com.reflection;

import java.lang.reflect.*;

public class Demo {
    
    public void demoReflection(Object object) throws ClassNotFoundException {
      Class myClass = object.getClass();
       // Class myClass = Class.forName("stackjava.com.reflection.Customer");

      System.out.println("Class name: " + myClass.getName());
      System.out.println("Super Class name: " + myClass.getSuperclass().getName());
      System.out.println("Is interface: " + myClass.isInterface());
      System.out.println("Constructors: ");
      Constructor[] constructors = myClass.getDeclaredConstructors();
      for (Constructor constructor : constructors) {
        System.out.println(" Number of parameters: " + constructor.getParameterCount() + " - modifier: "
            + getModifierName(constructor.getModifiers()));
       }

       System.out.println("Fields:");
       Field[] allFields = myClass.getDeclaredFields();
       for (Field field : allFields) {
         System.out.println(" " + field.getName() + " - type: " + field.getType() + " - modifier: "
             + getModifierName(field.getModifiers()));
       }

       System.out.println("Methods: ");
       Method[] methods = myClass.getDeclaredMethods();
       for (Method field : methods) {
         System.out.println(" " + field.getName() + " - modifier: " + getModifierName(field.getModifiers()));
       }
     }
    
     public static String getModifierName(int mod) {
       if (Modifier.isPrivate(mod)) {
         return "private";
       }
       if (Modifier.isProtected(mod)) {
         return "protected";
       }
       if (Modifier.isPublic(mod)) {
          return "public";
       }
       if (Modifier.isPrivate(mod)) {
          return "private";
       }
       return "default";
     }
}   
```

Output:

```
Class name: Customer
Super Class name: Person
Is interface: false
Constructors: 
 Number of parameters: 5 - modifier: public
 Number of parameters: 0 - modifier: public
Attributes:
 age - type: int - modifier: private
 gender - type: class java.lang.String - modifier: protected
 name - type: class java.lang.String - modifier: public
 phone - type: class java.lang.String - modifier: default
Methods:
 toString - modifier: public
 setName - modifier: public
 setAge - modifier: public
 setGender - modifier: public
 setPhone - modifier: public
```

Nguồn: [topdev](https://topdev.vn/blog/java-reflection-la-gi-huong-dan-java-reflection-api/)


Lưu ý: Bài viết đã có nhiều chỉnh sửa sao cho phù hợp