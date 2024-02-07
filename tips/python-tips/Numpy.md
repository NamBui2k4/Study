# Tìm Hiểu Thư Viện NumPy Trong Python

![](/pictures/thu-vien-numpy-trong-python-63724882299.0039.png)


Numpy (Numeric Python): là một thư viện toán học phổ biến và mạnh mẽ của Python. Cho phép làm việc hiệu quả với ma trận và mảng, đặc biệt là dữ liệu ma trận và mảng lớn với tốc độ xử lý nhanh hơn nhiều lần khi chỉ sử dụng “core Python” đơn thuần.

Hãy cùng tìm hiểu về thư viện này trong bài viết dưới đây:

## Cài đặt thư viện Numpy: 

- Mở Command Prompt và gõ lệnh: ```pip install numpy```

## Các thao tác với Numpy
### Khai báo thư viện: ```import numpy as np```

### Khởi tạo mảng dựa trên một list 
\
    a. Khởi tạo mảng một chiều

```
    # Khởi tạo mảng một chiều với kiểu dữ liệu các
    phần tử là Integer
    arr = np.array([1,3,4,5,6], dtype = int)

    # Khởi tạo mảng một chiều với kiểu dữ liệu mặc định
    arr = np.array([1,3,4,5,6])

    print(arr)
    OUTPUT:

    [1 3 4 5 6]
```
\
    b. Khởi tạo mảng hai chiều
```
    arr1 = np.array([(4,5,6), (1,2,3)], dtype = int)

    print(arr1)
    OUTPUT:

    [[4 5 6]
    [1 2 3]]
```
\
c. Khởi tạo mảng ba chiều
```
    arr2 = np.array(([(2,4,0,6), (4,7,5,6)],
                     [(0,3,2,1), (9,4,5,6)],
                     [(5,8,6,4), (1,4,6,8)]), dtype = int)

    print(arr2)

    OUTPUT:
    [[[2 4 0 6]

    [4 7 5 6]]

    [[0 3 2 1]

    [9 4 5 6]]

    [[5 8 6 4]

    [1 4 6 8]]]
```
\
d. Khởi tạo với các hàm đặc biệt

- __np.zeros((3,4), dtype = int)__: Tạo mảng hai chiều các phần tử 0 với kích thước 3x4.
\
- __np.ones((2,3,4), dtype = int)__: Tạo mảng 3 chiều các phần tử 1 với kích thước 2x3x4.
\
- __np.arange(1,7,2)__: Tạo mảng với các phần tử liên tục từ 1 - 6 với bước nhảy là 2.
\
- __np.full((2,3),5)__: Tạo mảng 2 chiều các phần tử 5 với kích thước 2x3.
\
- __np.eye(4, dtype=int)__: Tạo ma trận đơn vị với kích thước là 4x4.
\
- __np.random.rand((2,3))__: Tạo ma trận các phần tử ngẫu nhiên với kích thước 2x3.

_Lưu ý: random là một lớp của thư viên numpy nên khi sử dụng rand phải có đi kèm random_

## Thao tác với mảng

Một số khái niệm liên quan đến mảng

- dtype: Kiểu dữ liệu của phần tử trong mảng.
- shape: Kích thước của mảng.
- size: Số phần tử trong mảng.
- ndim: Số chiều của mảng.

vd:
``` 
    print("Kiểu dữ liệu của phần tử trong mảng:",
    arr2.dtype)

    print("Kích thước của mảng:", arr2.shape)
    print("Số phần tử trong mảng:", arr2.size)
    print("Số chiều của mảng:", arr2.ndim)
```
\
Output:

```Kiểu dữ liệu của phần tử trong mảng: int32```

```Kích thước của mảng: (3, 2, 4)```

```Số phần tử trong mảng: 24```

```Số chiều của mảng: 3```

Khác biệt giữa range() và np.arange():

Chúng ta hay nhầm lẫn giữa range() và np.arange(), nếu không phân biệt được sẽ gây khó khăn khi dùng. Có 2 điểm khác nhau cơ bản:

1.	Định dạng đầu ra: range() trả về một iterator - một trình lặp chỉ duyệt qua các phần tử mà không thể truy cập phần tử bằng chỉ số, trong khi np.arange() sẽ làm điều ngược lại
\
2. Nguồn gốc: range() vốn được xây dựng sẵn và  không cần import thư viện nào, cứ gọi là có. Trong khi đó, arange() lại thuộc về thư viện numpy, muốn sử dụng thì phải import
\

2.	Kiểu dữ liệu: range() trả về các giá trị kiểu int, trong khi np.arange() trả về các giá trị có kiểu được chỉ định bởi tham số dtype(mặc định là int).

### Truy cập phần tử trong mảng

Các phần tử trong mảng được đánh dấu bắt đầu từ 0 theo chiều từ trái sang phải, và từ -1 theo chiều từ phải qua trái.

Các phần tử không phân biệt về dtype

\
![](/pictures/numpy-array.png)

các phương thức truy cập:

- $arr[i]$: Truy cập tới phần tử thứ i của mảng 1 chiều.
- $arr1[i,j]$: Truy cập tới phần tử hàng i, cột j của mảng 2 chiều.
- $arr2[n,i,j]$: Truy cập tới phần tử chiều n, hàng i, cột j của mảng 3 chiều.
- $arr[a:b]$: Truy cập tới các phần tử từ a đến b-1 trong mảng 1 chiều.
- $arr1[:,:i]$: Truy cập tới phần tử từ cột 0 đến cột i-1, của tất cả các hàng trong mảng 2 chiều.

Ví dụ 1:

```
    print("arr[2]=", arr[2])
    print("arr1[1:2]=", arr1[1,2])
    print("arr2[1,2,3]=", arr2[1,1,3])
    print("arr[0:3]=", arr[0:3])
    print("arr1[:,:1]=", arr1[:,:2])​
```
\
Output

```arr[2]= 4```

```arr1[1 : 2]= 3```

```arr2[1, 2, 3] = 6```

```arr[0:3] = [1 3 4]```

```arr1[:, :1] = [[4 5] [1 2]]```

ví dụ 2:

```
    name = np.array(['Vu Thanh Tai', 120, 3 < 1 ])

    print(name [0] ) # Vu Thanh Tai
    print(name [1] )  # 120
    print(name [2] ) # false
    
    print(name [-3] ) # Vu Thanh Tai
    print(name [-2] ) # 120
    print(name [-1] ) # false

```

### Thay đổi toàn bộ mảng (ứng dụng cho ma trận)

Các phương thức:

- np.reshape(a, b): thay đổi shape mảng về dạng a x b mà không làm thay đổi phần tử mảng
\
- np.flip(a, axis= int): đảo ngược vị trí các phần tử mà không thay đổi shape của mảng.
    chú ý đến chỉ số axis và ndim:
    + Nếu ndim = 1 (mảng 1 chiều) thì mặc định axis luôn bằng 0, các phần tử được đảo ngươc vị trí

    VD:
    ```
        a = np.array([1 ,2 ,3, 4 ,5 ,6, 7 ,8 ,9])

        print(np.flip(a))

        # output: [9 8 7 6 5 4 3 2 1]
    ```
    \
    + Nếu ndim = 2 (ma trận), chỉ số axis được tùy chỉnh theo 3 trường hợp:

        + axis = 0 ⟶ đảo ngược vị trí các hàng 
        + axis = 1 ⟶ đảo ngược vị trí các cột
        + axis không được chỉ định ⟶ đảo ngược tương tự như đảo ngược mảng 1 chiều
    
    Vd:

    ```
        a = np.array([[1 ,2 ,3],
                      [4 ,5 ,6],
                      [7 ,8 ,9]])

        print('axis = 0: ', np.flip(a, axis = 0))
        print('axis = 0: ', np.flip(a, axis = 1))
        print('default axis: ', np.flip(a))
    ```
    \
    OUTPUT:
    ```
       axis = 0:  [[7 8 9]   axis = 1: [[3 2 1]
                  [6 5 4]               [4 5 6]
                  [1 2 3]]              [9 8 7]]
                
        default axis:  [[9 8 7]
                        [6 5 4]
                        [3 2 1]]
    ```
    \
+ np.ravel() : thay đổi ndim của mảng từ 2 ⟶ 1, hay nói cách khác là từ ma trận ⟶ vector

```
    y = [[[1, 2, 16, 31, 22],
         [2, 8, 1, 21, 23],
         [4, 9, 11, 14, 25],
         [3, 6, 10, 16, 34]]]

    print (np.ravel(y))

    output: 
    [ 1  2 16 31 22  2  8  1 21 23  4  9 11 14 25  3  6 10 16 34]
```
\
- np.vstack() : ghép 2 mảng có ndim = 1 thành một mảng có ndim = 2, hay nói cách khác là từ vector ⟶ ma trận

```
    a = np.array([1, 2, 3])
    b = np.array([4, 5, 6])

    print(np.vstack((a, b)))

    output:
            [[1 2 3]
            [4 5 6]]
```
\
- np.delete(arr, obj, axis=None): xóa hoàng hoặc cột tùy theo chỉ định của obj và axis. Trong đó 

    + obj là thứ tự của cột/hàng muốn xóa
    + axis = 0 ⟶ xóa hàng; axis = 1 ⟶ xóa cột

_Lưu ý: những điều trên chỉ áp dụng cho mảng 2 chiều. Đối với mảng có 3 chiều trở lên thì axis còn khiến hàm hoạt động theo nhiều cách khác nữa_

```
    a = np.array([[1, 2, 3],
              [4, 5, 6],
              [7, 8, 9]])

    # Loại bỏ hàng thứ 0
    print( np.delete(a, 0, axis= 0))

    # loại bỏ cột thứ 1
    print( np.delete(a, 2, axis=1))

```
\
Output:
```
    # 1                # 2
    [[4 5 6]         [[1 2]
     [7 8 9]]         [4 5]
                      [7 8]]
```
\
### Đọc mảng từ file .txt

![](/pictures/Annotation%202020-05-12%20184050.png)

```
diem_2a = np.loadtxt('Diem_2A.txt', dtype = int, delimiter=',')

#ở đây tất cả phần tử là số nguyên nên mình để kiểu
int cho dễ nhìn, các phần tử phân tách nhau bởi dấu ","

print("File dữ liệu điểm lớp 2A:\n", diem_2a)

```
\
Output

![](/pictures/Annotation%202020-05-12%20185405.png)


### Các hàm thống kê

- __arr.max()__ hoặc __np.max(arr)__: Lấy giá trị lớn nhất của mảng __arr.

- __arr.min()__ hoặc __np.min(arr)__: Lấy giá trị nhỏ nhất của mảng __arr.

- __arr.sum()__ hoặc __np.sum(arr)__: Tổng tất cả các phần tử trong mảng __arr.

- __arr.mean()__ hoặc __np.mean(arr)__: Trung bình cộng của tất cả các phần tử trong mảng __arr.

- np.median(arr): Trả về giá trị trung vị của mảng __arr.

print("Giá trị lớn nhất của mảng arr là:", np.max(arr))
print("Giá trị nhỏ nhất của mảng arr là:", np.min(arr))
print("Tổng tất cả các phần tử của mảng arr là:", np.sum(arr))
print("Trung bình cộng tất cả các phần tử của mảng arr là:", np.mean(arr))
print("Giá trị trung vị của mảng arr là:", np.median(arr))
Output:

Giá trị lớn nhất của mảng arr là: 6

Giá trị nhỏ nhất của mảng arr là: 1

Tổng tất cả các phần tử của mảng arr là: 19

Trung bình cộng tất cả các phần tử của mảng arr là: 3.8

Giá trị trung vị của mảng arr là: 4.0

NumPy dtype

Basic Type

Available Numpy types	Comments
Boolean

bool	
Elements are 1 byte in size.

Integer

int8, int16, int32, int64, int128, int	
int defaults to the size of int in C for the platform.

Unsigned Integer

uint8, uint16, uint32, uint64, uint128, uint

uint defaults to the size of unsigned int in c for the platform.
Float

float32, float64, float,

longfloat

Float is always a double precision floating point value (64 bits). longfloat represents large precision floats. Its size is platform dependent.

Complex

complex64, complex128, complex

The real and complex elements of a complex64 are each represented by a single precision (32 bit) value for a total size of 64 bits.

Strings

str, unicode

Unicode is always UTF32 (UCS4)
Object

object	Represent items in array as Python objects.
Records

void

Used for arbitrary data structures in record arrays.
Toán tử trong NumPy Array

a = np.array([2,1,3,4,5])
Toán tử	Ví dụ	
Kết quả

 (+) Một số với mảng

3 + arr

arr +3

[4, 6, 7, 8, 9]
(+) Mảng với mảng

arr + a

a + arr

[3, 4, 7, 9, 11]
(-) Một số với mảng

arr - 3

3 - arr

[-2, 0, 1, 2, 3]

[2, 0, -1, -2, -3]

(-) Mảng với mảng	
arr - a

a - arr

[-1, 2, 1, 1, 1]

[1, -2, -1, -1, -1]

(*) Một số với mảng

arr * 3

3 * arr

[3, 9, 12, 15, 18]
(*) Mảng với mảng

arr * a

a * arr

[2, 3, 12, 20, 30]
(/) Một số với mảng

arr / 3

3 / arr

[0.33333333, 1., 1.33333333, 1.66666667, 2.]

[3.,   1.,   0.75, 0.6,  0.5]

(/) Mảng với mảng	
arr / a

a / arr

[0.5, 3., 1.33333333, 1.25, 1.2]

[2., 0.33333333, 0.75, 0.8, 0.83333333]

Hạng của ma trận	
np.rank(arr)

np.rank(arr1)

1

2

Lời kết
Như vậy là mình đã giới thiệu cơ bản cho bạn về thư viện NumPy trong Python, nếu bạn muốn tìm hiểu thêm về thư viện NumPy thì bạn có thể vào ĐÂY để tham khảo thêm. Ở bài sau mình sẽ giới thiệu cho các bạn về cách xử lý dữ liệu với thư viện Pandas.

Nguồn: [_codelearn_](https://codelearn.io/sharing/tim-hieu-thu-vien-numpy-trong-python)