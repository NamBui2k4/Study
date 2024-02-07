# Thuật toán Prim

__Cây khung nhỏ nhất là gì ?__

Cây khung (spanning tree) của một đồ thị là một đồ thị con liên thông không có chu trình đi qua tất cả các đỉnh. Một đồ thị sẽ có nhiều cây khung và bài toán của chúng ta là phải tìm ra cây khung nhỏ nhất.

![](/pictures/spanning-tree.png)
\
Dưới đây là ví dụ về cây khung nhỏ nhất

![](/pictures/mst.jpg)
\
__Tính chất__

Một vài tính chất của cây khung nhỏ nhất:

1. Tính chất chu trình: Trong một chu trình bất kỳ, nếu e là cạnh có trọng số lớn nhất thì e không thể nằm trên bất kỳ cây khung nhỏ nhất nào.
|
2. Đường đi hẹp nhất: Trong một cây khung nhỏ nhất, nếu w là trọng số của cạnh lớn nhất (u, v) thì ta không thể tìm thêm được đường đi ngắn hơn từ u đến v 
|
3. Tính duy nhất: Nếu tất cả các cạnh đều có trọng số khác nhau thì chỉ có duy một cây khung nhỏ nhất. Ngược lại, nếu một vài cạnh có trọng số giống nhau thì có thể có nhiều hơn một cây khung nhỏ nhất.
|
4. Tính chất cạnh nhỏ nhất: Nếu e là cạnh có trọng số nhỏ nhất của đồ thị thì e nằm trong mọi cây khung nhỏ nhất của đồ thị.

Có 2 thuật toán cơ bản để tìm cây khung nhỏ nhất là thuật toán Prim và thuật toán Kruskul. Trong bài viết này, chúng ta sẽ làm việc với thuật toán Kruskul với đồ thị vô hướng có trọng số

Nguồn kham khảo: 
[Tuấn Nguyễn](https://chidokun.github.io/2021/07/prim-algorithm/#:~:text=Ch%E1%BB%8Dn%20%C4%91%E1%BB%89nh%20%240%24%20l%C3%A0m%20%C4%91%E1%BB%89nh%20b%E1%BA%AFt%20%C4%91%E1%BA%A7u%2C%20%C4%91%C6%B0a,c%E1%BA%A1nh%200-2%20v%C3%A0%20%C4%91%E1%BB%89nh%20%242%24%20v%C3%A0o%20c%C3%A2y%20khung.)
[VNOI](https://vnoi.info/wiki/algo/graph-theory/minimum-spanning-tree.md)