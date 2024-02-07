Nguồn: [topdev](https://topdev.vn/blog/lam-the-nao-tao-instance-cua-mot-class-ma-khong-goi-tu-khoa-new/?utm_source=facebook&utm_medium=post&utm_campaign=anhltv&utm_term=blog&utm_content=b_lam-the-nao-tao-instance-cua-mot-class-ma-khong-goi-tu-khoa-new&fbclid=IwAR2OAYFybuMskvPzoF4bGV9IZQaSdwTbCEuVLVSuTYEgIkUWk82L3rWPOq4)

# Làm thế nào tạo instance của một class mà không gọi từ khóa new?

___Bài viết được sự cho phép của tác giả Nguyễn Hữu Khanh___

Như đã biết, trong Java để khởi tạo một instance của một class chúng ta sẽ sử dụng từ khóa new. Tuy nhiên, trong một số trường hợp chúng ta cần tạo một instance khi chỉ biết tên class hoặc private constructor hoặc không biết được số lượng tham số của constructor,… Với những trường hợp như vậy, chúng ta không thể gọi từ khóa new một cách trực tiếp mà sẽ sử dụng một số cách đặc biệt và chúng ta sẽ cùng tìm hiểu các cách giải quyết vấn đề này trong phần tiếp theo của bài viết.

__Sử dụng Reflection khi biết tên class__

Một trong những cách đơn giản và thường được sử dụng để tạo instance của một class là sử dụng kỹ thuật Reflection. Nếu bạn chưa biết về Reflection, hãy dành chút thời gian xem lại bài viết Hướng dẫn sử dụng Java Reflection.

Sử dụng newInstance() khi class có constructor không có tham số và phạm vi truy cập không phải private

__Sử dụng newInstance() khi class có constructor không có tham số và phạm vi truy cập không phải private__

```
package com.gpcoder.instance;
    
    public class Employee {

        private int id;
        private String name;

        public Employee() { super();  }

        public Employee(int id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        // getter - setter

        @Override
        public String toString() {
            return "Employee [id=" + id + ", name=" + name + "]";
        }
    }
```

Tạo instance sử dụng newInstance():

```
    package com.gpcoder.instance;
    import java.lang.reflect InvocationTargetException;

    public class NewInstanceExample {

        public static void main(String[] args)
                throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException,
                InvocationTargetException, NoSuchMethodException, SecurityException {

            // Get class based on the given class name
            Class<?> clazz = Class.forName("com.gpcoder.instance.Employee");

            // Create a new instance with empty argument of constructor of a class
            Employee employee = (Employee) clazz.newInstance();
            employee.setId(1);
            employee.setName("gpcoder");
            System.out.println("employee: " + employee);
        }
    }
```

Lưu ý:

Nếu không tồn tại constructor không có tham số, chương trình sẽ throw ra một exception như sau:

```
    Exception in thread "main" java.lang.InstantiationException: com.gpcoder.instance.Employee
        at java.lang.Class.newInstance(Class.java:427)
        at com.gpcoder.instance.NewInstanceExample.main(NewInstanceExample.java:15)
    Caused by: java.lang.NoSuchMethodException: com.gpcoder.instance.Employee.<init>()
        at java.lang.Class.getConstructor0(Class.java:3082)
        at java.lang.Class.newInstance(Class.java:412)
        ... 1 more
```

Nguồn [topdev](https://topdev.vn/blog/lam-the-nao-tao-instance-cua-mot-class-ma-khong-goi-tu-khoa-new/?utm_source=facebook&utm_medium=post&utm_campaign=anhltv&utm_term=blog&utm_content=b_lam-the-nao-tao-instance-cua-mot-class-ma-khong-goi-tu-khoa-new&fbclid=IwAR2OAYFybuMskvPzoF4bGV9IZQaSdwTbCEuVLVSuTYEgIkUWk82L3rWPOq4)