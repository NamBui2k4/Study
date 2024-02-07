# Disjoint-Find Set Union (UFDS) - Cấu trúc các tập không giao nhau

Cấu trúc dữ liệu Union-Find Disjoint Sets là một cấu trúc dữ liệu hữu ích để quản lý một tập hợp lớn chứa các tập dữ liệu con phân biệt (thường tồn tại dưới dạng mảng). Các thao tác chính của cấu trúc này là:
- Tạo một tập hợp mới chỉ chứa một phần tử cho trước.
- Gộp hai tập hợp chứa hai phần tử cho trước thành một tập hợp mới.
- Tìm ra đại diện của tập hợp chứa một phần tử cho trước.

Cấu trúc dữ liệu này có nhiều ứng dụng trong lập trình, như kiểm tra tính liên thông của đồ thị, tìm cây khung nhỏ nhất, xử lý các truy vấn đảo ngược, v.v.

# Đăt vấn đề
Hai tập dữ liệu được gọi là phân biệt nếu chúng không có phần tử nào giống nhau
Giả sử ta có nhiều tập dữ liệu phân biệt. Yêu cầu:
- hợp nhất 2 tập bất kỳ (gộp toàn bộ giá trị của 2 tập thành 1 tập duy nhất)
- chỉ ra xem một giá trị A bất kỳ sẽ thuộc tập nào trong số các tập đó
# Ý tưởng
Nếu ta coi mỗi mảng là một cái cây thì toàn bộ mảng đó là một rừng cây. Mỗi cái cây sẽ được đại diện bởi một cái gốc gọi là _Đại diện_. Lưu ý: đây không phải cây nhị phân vì mỗi gốc sẽ có nhiều hơn 2 con

Ví dụ: giả sử ta có ba tập giá trị sau
- A =  { 1, 2, 3, 4, 6}
- B =  {0, 7}
- C =  {5}

Ta sẽ gọi chúng là 3 cái cây A, B , C. Ta sẽ chọn ra một phần tử bất kỳ ứng với mỗi cây đại diện cho gốc của nó và các phần tử còn lại chính là lá cây. Chẳng hạn, nếu chọn số 2 làm gốc cho cây A thì 1 3 4 6 sẽ là lá cây của A, chọn số 7 làm gốc cho cây B thì 0 là lá cây của B, riêng cây C không có lá mà chỉ có gốc là 5. Minh họa ở hình sau:

![](/pictures/Example.png)

Lưu ý: từ "cây" ở đây không phải là cây nhị phân mà chỉ là cách gọi để biễu diễn dưới dạng hình học nên sẽ không có khái niệm con trái, con phải. Ngoài ra, cách tính chiều cao cũng sẽ ngược lại so với cây nhị phân (thấp nhất ở lá và cao nhất ở gốc). Thực thế thì người ta sẽ dùng mảng để lưu trữ một cây.

Mỗi một cây là một mảng p duy nhất. Ứng với mỗi lá i trong một cái cây, phần tử p[i] được gọi là parent của i . Ngoài ra, ta quy ước nếu i là gốc của cây thì p[i] = i.

Khi đó ta có:
| p[i]   | 7  2  2  2  2  5  2  7 |
|------  |------------------------|
| __i__  | 0  1  2  3  4  5  6  7 |

tức là p = {7, 2, 2, 2, 2, 5, 2, 7}
 
Như vậy, cấu trúc UFDS không có tác dụng lưu trữ trực tiếp các tập dữ liệu mà chỉ đơn giản là quản lý các tập dữ liệu thông qua _Đại diện_ của nó

# Thao tác trên UFDS
## 1. find - tìm một cây chứa lá i cho trước 
Để làm được điều này, ta duyệt qua mảng p, ta tìm lá i bằng đệ quy và trả về gốc của cây đó. Quá trình duyệt sẽ kết thúc nếu tìm được i

Độ phức tạp được xác định bởi chiều sâu của cây con chứa phần tử i trong tập hợp
và nó thay đổi tùy thuộc vào cách cài đặt cấu trúc dữ liệu.
- Nếu không sử dụng kỹ thuật nào, độ phức tạp thuật toán tìm kiếm của UFDS là O(n) vì ta phải đi qua toàn bộ lá của mỗi cây để tìm ra x Vì ta sử dụng mảng và cây
- Nếu sử dụng kỹ thuật nén đường đi, độ phức tạp thuật toán sẽ là O(α(n)), với α(n) là hàm nghịch đảo Ackermann, một hàm tăng rất chậm.
p/s: có thể kham khảo thêm hàm Ackermann tại [_Wikiwan_](https://www.wikiwand.com/vi/H%C3%A0m_s%E1%BB%91_Ackermann)

Thuật toán tổng quát sẽ là:

```
    function Tìm(X) {
        Nếu X.cha == X
            return X
        Ngược lại
            X.cha = Tìm(X.cha)
            return X.cha
    }
```
   

## 2. union - gộp 2 cây lại thành 1 cây
![](/pictures/Union.png)
Như đã nói, nếu không sử dụng kỹ thuật nào, độ phức tạp thuật toán của việc gộp vẫn là O(n)

Nếu sử dụng kỹ thuật gộp theo kích thước hoặc thứ hạng của cây, độ phức tạp thuật toán của là O(log n). Đối với gộp theo thứ hạng, ta sẽ sử dụng một biến rank để quản lý độ sâu cây. 

Thuật toán tổng quát sẽ là:
```
    function Hợp (X, Y){
        A = Tìm(X)
        B = Tìm(Y)
        Nếu A == B
            return

        Nếu A.rank == B.rank
            Tăng A.rank

        Nếu A.rank < B.rank
            A.cha = B
        Ngược lại
            B.cha = A
    }
```
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
 
    