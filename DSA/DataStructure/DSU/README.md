Bài viết này kham khảo từ nguồn của [howkteam](https://howkteam.vn/course/cau-truc-du-lieu-va-giai-thuat/tong-quan-ve-disjoint-sets-union-va-cach-xay-dung-dsu-4385), [vnoi](https://vnoi.info/wiki/algo/data-structures/disjoint-set.md##:~:text=Disjoint%20Sets%20l%C3%A0%201%20CTDL%20r%E1%BA%A5t%20h%E1%BB%AFu%20d%E1%BB%A5ng%2C,n%C3%B3%2C%20l%C3%A0%20m%E1%BB%99t%20t%E1%BA%ADp%20h%E1%BB%A3p%20c%C3%A1c%20t%E1%BA%ADp%20h%E1%BB%A3p.), và một số nguồn khác

# Disjoint Set Union (DSU) - Cấu trúc các tập không giao nhau
## Đăt vấn đề
Hai tập dữ liệu được gọi là phân biệt nếu chúng không có phần tử nào giống nhau.

Giả sử ta có nhiều tập dữ liệu phân biệt. Yêu cầu:
- Hợp nhất 2 tập bất kỳ (gộp toàn bộ giá trị của 2 tập thành 1 tập duy nhất)
- chỉ ra xem một giá trị A bất kỳ sẽ thuộc tập nào trong số các tập đó



## Ý tưởng
Nếu ta coi mỗi tập dữ liệu là một cái cây thì nhiều tập như vậy là một rừng cây. Mỗi cái cây sẽ được đại diện bởi một cái gốc gọi là root. 

Lưu ý: đây không phải cây nhị phân.

Ví dụ: giả sử ta có ba tập hợp sau
- A =  { 1, 2, 3, 4, 6}
- B =  {0, 7}
- C =  {5}

Ta sẽ gọi chúng là 3 cái cây A, B , C.

Root của mỗi cây là 1 trong các node của cây đó, thường là node có giá trị thấp nhất. Ta có thể chọn root của A là 1. Tương tự, root của B là 0 và root của C là 5

Một ví dụ khác, ta có thể minh họa như hình sau:

![](/pictures/Example.png)

Như bạn thấy, chúng ta có 3 cây tương ứng với 3 tập hợp. Mỗi tập được đại diện bởi một phần tử là gốc của cây đó.

Như vậy, đây chính là tiền đề xây dựng cấu trúc dữ liệu Disjoint Set Union (DSU). Chúng ta có thể ứng dụng nó giải quyết bài toán ban đầu.

## Tổng quan về Disjoint Set Union (DSU)

Disjoint Sets Union là một cấu trúc dữ liệu hữu ích để quản lý một tập hợp lớn chứa các tập dữ liệu con phân biệt. 

Cấu trúc dữ liệu này có nhiều ứng dụng trong lập trình, như kiểm tra tính liên thông của đồ thị, tìm cây khung nhỏ nhất, xử lý các truy vấn đảo ngược, v.v.

## Biểu diễn DSU

Có nhiều cách để biểu diễn DSU, nhưng phổ biến là dùng mảng 1 chiều.

Chúng ta có một mảng p chứa các phần tử. Với mỗi phần tử i , phần tử p[i] được gọi là parent của i . 

Ngoài ra, ta quy ước nếu i là root của cây thì $p[i] = i$.

Biểu diễn bằng bảng như sau:

| p[i]   | 7  2  2  2  2  5  2  7 |
|------  |------------------------|
| __i__  | 0  1  2  3  4  5  6  7 |

Xin nhắc lại một lần nữa, DSU không phải đồ thị hay cây nào mà chỉ đơn giản là mảng một chiều chứa các phần tử (với mỗi phần tử, tôi gọi nó là 1 node). 

Mỗi phần tử thuộc một tập hợp nào đó, nhưng chúng ta không lưu trữ cả tập hợp vào mảng mà thay vào đó, ta chỉ lưu một phần tử đại diện cho tập hợp đó mà thôi. Phần tử đó chính là chỉ số của mảng (và phần tử đó chính là gốc của cây chứa node). 

Cách lưu trữ trên giúp chúng ta tiết kiệm được rất nhiều bộ nhớ. Mặt khác, nó có thể "gây lú" cho nhiều người vì khiến ta nghĩ rằng DSU là giải thuật chứ không phải CTDL (và thực tế đúng là như vậy, nó còn được gọi là kỹ thuật backtracking)

Các thao tác chính của cấu trúc này là:
- Tìm kiếm đại diện tập hợp chứa một phần tử x.
- Gộp hai tập hợp chứa hai phần tử cho trước thành một tập hợp mới.
- Tìm ra đại diện của tập hợp chứa một phần tử cho trước.

## Thao tác trên DSU

## 1. find - tìm kiếm đại diện của tập hợp chứa phần tử x

Để thực hiện thao tác này, ta gọi đệ quy lên cha của x là p[x] . Quá trình đệ quy kết thúc nếu `p[x] == x`.

- input: `x`
- output: `p[x]`


Thuật toán tổng quát sẽ là:

```
    Tìm(x) {
        Nếu p[x] == x
            ⟶ x
        Ngược lại
            ⟶ Tìm(p[x])
    }
```

Vì ta sử dụng mảng để biểu diễn nên trong trường hợp xấu nhất, độ phức tạp thuật toán tìm kiếm của DSU sẽ là $O(n)$ vì ta phải duyệt qua toàn bộ mảng p để tìm x 

Một cách để cải thiện độ phức tạp này là sử dụng kỹ thuật nén đường đi (path compression). Cụ thể, tại mỗi lần gọi đệ quy, ta lấy kết quả của đệ quy gán cho `p[x]`. 

```
    Tìm(x) {
        Nếu p[x] == x
            ⟶ x
        Ngược lại
            p[x] = Tìm(p[x])  // thay đổi ở đây
            ⟶ p[x]
    }
```

Khi đó, độ phức tạp thuật toán sẽ là $O(log(n))$.
   

## 2. union - Gộp hai tập hợp

![](/pictures/Union.png)

Trường hợp này, cho 2 phần tử X, Y (chưa biết nằm ở tập hợp nào). Yêu cầu hãy gộp tập hợp của chúng lại làm một.

Như đã nói, nếu không sử dụng kỹ thuật nào, độ phức tạp thuật toán của việc gộp vẫn là O(n). Tuy nhiên , nếu sử dụng kỹ thuật gộp theo thứ hạng, độ phức tạp thuật toán của là $O(log(n))$. 

Một lần nữa, tôi xin gọi tập hợp là cây để dễ trình bày thuật toán hơn.

Mỗi cây sẽ có một độ sâu nhất định. Cây nào có độ sâu nhỏ hơn sẽ nối đuôi cây có độ sâu lớn hơn. Nó giống như việc chúng ta lấy một cành cây nhỏ cấy ghép lên thân cây to vậy (Chứ chẳng ai làm ngược lại đâu :v ).

Khi đó, ta sẽ sử dụng một biến `rank` để quản lý độ sâu của cây. 

- input:  X, Y
- output: Cây gộp bởi cây của X và Y

Thuật toán tổng quát sẽ là:

```
    Gộp (X, Y){

        A = Tìm(X)
        B = Tìm(Y)

        Nếu A == B
            stop

        Nếu rank[A] < rank[B]
            p[A] = B

        Nếu rank[A] > rank[B]
            p[B] = A
            
        Nếu rank[A] == rank[B]
            p[B] = A
            Tăng rank[A]  
            // hoặc tăng rank[B] rồi gán p[A] = B đều được
    }
```
Demo:
```
1   2   3
        /\
       0   5
       /   /    
      6   4  
1   2    3
          /|\
        0 5 6
            |
           4
```
 
    