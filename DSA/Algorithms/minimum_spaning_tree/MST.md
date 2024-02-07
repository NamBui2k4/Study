Lưu ý: Bài viết được lấy từ [_VNOI_](https://vnoi.info/wiki/algo/graph-theory/minimum-spanning-tree.md)
Tác giả:
- Hoàng Việt Cường - Đại học Bách Khoa Hà Nội
- Phan Thành Long - THPT Chuyên Thái Bình (K17-20)

# MINIMUM SPANNING TREE (Tìm Cây khung nhỏ nhất)
## Cây khung nhỏ nhất là gì
Định nghĩa:
Theo lý thuyết đồ thị, chúng ta đều biết rằng 1 đồ thị được biểu diễn bằng công thức $ G=(V,E) $ trong đó đồ thị G của chúng ta bao gồm tập các đỉnh V và tập các cạnh E

__Cây khung (spanning tree)__ của đồ thị là một tập hợp các cạnh của đồ thị thỏa mãn tập cạnh này __không chứa chu trình__ và __liên thông__ (từ một đỉnh bất kì có thể đi tới bất kỳ đỉnh nào khác theo mà chỉ dùng các cạnh trên cây khung)

Trong đồ thị có trọng số, cây khung nhỏ nhất (minimum spanning tree) là cây khung có tổng trọng số các cạnh trong cây nhỏ nhất. Một đồ thị có thể có một hoặc nhiều cây khung nhỏ nhất.

Trong trường hợp đồ thị không có trọng số thì mặc định các cạnh có trọng số bằng nhau (thường là bằng 1). Khi đó, bất kỳ đường đi nào từ một đỉnh cũng sẽ tạo ra một cây khung nhỏ nhất

Một ví dụ về cây khung trong đồ thị vô hướng không trọng số:

![](/pictures/MST.png)

Một ví dụ về cây khung nhỏ nhất trong đồ thị vô hướng có trọng số:

![](/pictures/weighted_mst.jpg)


## Tính chất
Một vài tính chất của cây khung nhỏ nhất trong đồ thị vô hướng có trọng số:

1. Tính chất chu trình: Trong một chu trình C bất kỳ, nếu tồn tại một cạnh e có trọng số lớn nhất  thì e không thể nằm trên bất kỳ cây khung nhỏ nhất nào.

2. Đường đi hẹp nhất: Xét 2 đỉnh u, v bất kỳ trong đồ thị. Nếu w là trọng số của cạnh lớn nhất trên đường đi từ u đến v trên cây khung nhỏ nhất của đồ thị thì ta không thể tìm được đường đi nào từ u đến v trên đồ thị ban đầu chỉ đi qua những cạnh có trọng số nhỏ hơn w
.
3. Tính duy nhất: Nếu tất cả các cạnh đều có trọng số khác nhau thì chỉ có một cây khung nhỏ nhất. Ngược lại, nếu một vài cạnh có trọng số giống nhau thì có thể có nhiều hơn một cây khung nhỏ nhất.

4. Tính chất cạnh nhỏ nhất: Nếu e là cạnh có trọng số nhỏ nhất của đồ thị, và không có cạnh nào có trọng số bằng e thì e nằm trong mọi cây khung nhỏ nhất của đồ thị.