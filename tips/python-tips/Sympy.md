# Sympy - thư viện toán học mạnh mẽ của python

Không có gì là không xoay quanh toán học, cho dù bạn là sinh viên đại học hay làm việc trong ngành khoa học dữ liệu.

Đã có nhiều tranh cãi cho rằng khoa học dữ liệu là một loại toán học. Để giải quyết các bài toán phức tạp liên quan đến dữ liệu, người ta sử dụng các công cụ toán học của python như Math, NumPy, SciPy, scikit-learn và TensorFlow. Tuy nhiên, chúng chỉ có thể xử lý dữ liệu một cách định lượng, nghĩa là tính toán ra kết quả dựa trên các tham số đầu vào. Thực tế, có những bài toán buộc ta phải làm việc với ký hiệu thay vì số. Đó là lúc  SymPy ra đời để giải quyết vấn đề này

__Sympy là gì?__

SymPy là một thư viện Python cho phép bạn sử dụng các _ký hiệu_ để tính toán các phương trình toán học khác nhau. Nó bao gồm các chức năng để tính toán các phương trình giải tích và nhiều hàm khác để giải quyết các bài toán cấp cao hơn.

__Cài đặt Sympy__

cú pháp:

    pip install sympy
\
__Tính năng của Sympy__

1. khai báo biến

Sympy hỗ trợ chức năng khai báo các ký hiệu toán học như x, y, z, u, p,... bằng hàm symbols. Chúng đóng vai trò là các biến thay vì các giá trị số thông thường

```
    import sympy as sp
    x,y,z = sp.symbols("x,y,z")

    print(x, y, z)

    # output: x y z
```
\
Ngoài ra, hàm symbols của Sympy còn hỗ trợ khai báo nhiều ký hiệu cùng một lúc, phục vụ cho việc giải quyết các bài toán liên quan đến dãy số có giới hạn. 

cú pháp: 

```sp.symbols('tên biến(vị trí băt đầu : số lượng + 1)')```

Vd:

```
    x0,x1,x2,x3,x4,x5 = sp.symbols('x(0:6)')
    y6,y7,y8,y9,y10,y11 = sp.symbols('y(6:12)')

    print(x0,x1,x2,x3,x4,x5)
    print(y6,y7,y8,y9,y10,y11)

    # output:
        x0 x1 x2 x3 x4 x5
        y6 y7 y8 y9 y10 y11
    
```
\
2. Triển khai các đa thức 

Thư viện sympy có tất cả các hàm của thư viện math, đó là một số hàm toán học cơ bản sau:

- sin() : sin của biến
- cos() : cosin của biến
- sqrt(): căn bậc 2
- Abs() : trị tuyệt đối
- Pow() : lũy thừa
- Rational(): phân thức đại số
- limit(): tính giới hạn
- diff(): tính đạo hàm
- subs(): thay ký hiệu trong biểu thức bằng giá trị số


Mỗi hàm của Sympy có 2 thức năng:
- tính toán và trả về giá trị 
- biểu diễn đa thức 

Ở chức năng đầu tiên, hàm của sympy xử lý toán học tương tự như các hàm của thư viện math, numpy nhưng cần lưu ý rằng:

Kiểu trả về của hàm sẽ phụ thuộc vào kiểu của đầu vào. Nếu đầu vào là số thực thì kết quả là số thực. Nếu đầu vào là số nguyên thì kết quả là số nguyên, nhưng nếu kết quả không thể nguyên thì hàm sẽ tự động trả về biểu thức chứa tham số đó

Vd:

```
x = sp.symbols('x')

print(sp.sqrt(9))
print(sp.sqrt(7))
print(sp.sqrt(7.0))

# output: 
   3
   sqrt(7)
   2.64575131106459
```
\
Trong trường hợp trên, ta lấy căn bậc 2 của các số bằng hàm sqrt. Lưu ý rằng 7 và 7.0 có kiểu khác nhau (kiểu nguyên vs kiểu thực).

Số 9 có kiểu nguyên nên sqrt sẽ trả về số nguyên là 3. Còn đối với số 7, ta biết rằng $\sqrt{7} = 2.64575131106459$ nhưng vì kiểu của 7 là kiểu nguyên nên về lý thuyết thì kết quả sẽ là 2. Tuy nhiên kết quả này thì lại không chính xác. Do đó, để không mất tính tổng quát, hàm sqrt sẽ trả về sqrt(7). Nếu muốn có kết quả 2.64575131106459 thì nên đổi đầu vào thành 7.0. 

Ở chức năng thứ 2, Sympy có một lợi thế là nó cho phép ta dùng ký hiệu để biểu diễn các biểu thức cũng như các phương trình một ẩn/nhiều ẩn.

Vd:
```
    x = sp.symbols('x,y')
    print('y =' , sp.sin(x) + sp.cos(x))

    # output: y = sin(x) + cos(x)
```
\
Chức năng này thậm chí còn có thể liên kết với chức năng đầu tiên, cho phép ta tính toán giới hạn, đạo hàm, tích phân,...

Vd:
```
    from sympy import *

    x = symbols('x')
    y = sin(3 * x)/x

    # lim của y tại x = 0
    lim_y = limit(y, x, 0) 
    print('lim của y tại x = 0 :', lim_y)

    # đạo hàm của y
    d_y = y.diff(x)
    print("y'(x) =" ,d_y)

    # đạo hàm của y tại x = 1 
    print("y'(1) =" ,d_y.subs(x, 1))

```
\
output:
```
    lim của y tại x = 0 : 3
    y'(x) = 3*cos(3*x)/x - sin(3*x)/x**2
    y'(1) = 3*cos(3) - sin(3)
```
\
3. Giải phương trình

Đây là tính năng mạnh mẽ nhất của thư viện sympy, cho phép ta giải các phương trình cơ bản bằng 2 hàm chủ đạo là Eq() và solve()

```
    import sympy as sp
    from sympy import Eq, solve

    # Khai báo biến và phương trình
    x = sp.symbols('x')
    equation = Eq(x**2 - 4, 0)

    # Giải phương trình
    solution = solve(equation, x)

    # In kết quả
    print("Nghiệm của phương trình là:", solution)
```
\
output:

```Nghiệm của phương trình là: [-2, 2]```

__Một số tính năng khác__

Mô-đun cốt lõi trong gói SymPy chứa lớp Number đại diện cho số học. Lớp này có hai lớp con: lớp Float và lớp Rational. Lớp Rational lại có một lớp con là Integer.

1. Lớp Float đại diện cho một số thực thực biểu diễn dưới dạng thập phân.

> from sympy import Float 
> Float(6.32)

output: 6.32

SymPy có thể chuyển đổi một số nguyên hoặc một chuỗi thành float.

> Float(10)
 
kết quả: 10.0

> Float('1.33E5')

Kết quả: 133000.0

Trong khi chuyển đổi thành float, cũng có thể chỉ định số chữ số cho độ chính xác như được đưa ra bên dưới:

> Float(1.33333, 2)

output: 1.3

2. Lớp Rational - đại diện cho số thực biểu diễn dưới dạng phân số điều kiện mẫu khác 0.

> Rational(3/4)

output: $\frac{3}{4}$

 

Nếu một số thực được truyền vào hàm tạo Rational(), nó sẽ trả về giá trị cơ bản của biểu diễn nhị phân của nó

> Rational(0.2)

output: $\frac{3602879701896397}{18014398509481984}$

 

Để biểu diễn đơn giản hơn, hãy chỉ định giới hạn mẫu số.

> Rational(0.2).limit_denominator(100)

output: $\frac{1}{5}$

 

Khi một chuỗi được truyền vào hàm tạo Rational(), một số hữu tỉ có độ chính xác tùy ý được trả về.

> Rational("3.65")

output: $\frac{73}{20}$

Ta cũng có thể tạo một phân số bằng cách khởi tạo một đối tượng Rational thông qua hàm Rational(), truyền vào hai đối số dưới dạng thuộc tính.

> a = Rational(3,5) 
> print (a) 

output: 3/5

3. Lớp Integer - đại diện cho một số nguyên có kích thước bất kỳ. Hàm khởi tạo có thể chấp nhận số Float hoặc Rational, nhưng phần thập phân sẽ bị loại bỏ

> Integer(10)

output: 10

> Integer(3.4)

output: 3

> Integer(2/7)

output: 0

Ngoài ra, SymPy cũng định nghĩa Zero và One là các lớp singleton thông qua đối tượng S (viết tắt của symbolic). 

```
    from sympy import S

    zero = S.Zero
    one = S.One

    print(zero)  # Kết quả: 0
    print(one)   # Kết quả: 1

```
\
Đối tượng S còn có thể truy cập một số lớp Singleton khác là Half, NaN,oo và Infinity 
```
    from sympy import S, oo

    print(S.Half)     # Kết quả: 1/2
    print(S.NaN)      # Kết quả: nan
    print(oo)         # Kết quả: oo (vô cùng dương)
    print(S.Infinity) # Kết quả: oo (cũng là vô cùng dương)

```
\
# Tổng kết

Trên đây là những gì tạm thời biết về thư viện Sy
Kham khảo từ nguồn:
[_isolution_](https://isolution.pro/vi/t/sympy/sympy-quick-guide/sympy-huong-dan-nhanh)


