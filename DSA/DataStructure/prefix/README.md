# Mảng cộng dồn

Prefix sum (mảng cộng dồn) là một cấu trúc dữ liệu thực thi với với mảng số nguyên. Ý tưởng của nó là tạo một mảng prefix trong đó `prefix[i]` là tổng của tất cả các phần tử tính từ 0 đến chỉ số i (đã bao gồm cả phần tử thứ i). 

Ví dụ: cho `num[6] = [5, 2, 1, 6, 3, 8]` , ta sẽ có 
- `prefix[0] = 0 + num[0] = 5`
- `prefix[1] = 0 + num[0] + num[1] = 7`
........................................
- `prefix[5] = 0 + num[0] + .... + num[5] = 25` 
\
Tổng quát, ta có: `prefix = [5, 7, 8, 14, 17, 25].`

Đây là chính là ứng dụng của tổng các số trong một dãy số mà chúng ta đã được học trong chương trình tin học phổ thông. Đây không hẳn là toán học vì dãy số này không phải một cấp số cộng hay cấp số nhân. Nó chỉ đơn giản là một dãy ngẫu nhiên dùng để sinh ra một dãy khác bằng cách lấy tổng các phần tử của nó. Tuy nhiên, kỹ thuật này có thể ứng dụng cho toán học, đặc biệt là những bài toán có tính truy hồi như dãy fibonaci, tổng của cấp số cộng, cấp số nhân,...

Mảng cộng dồn cho phép ta tìm tổng của bất kỳ mảng con nào trong thời gian O(1). Nếu ta muốn tổng của mảng con từ i đến j (bao gồm cả chỉ số i và j) thì  là `prefix[j] - prefix[i - 1]` hoặc `prefix[j] - prefix[i] + nums[i]` nếu bạn không muốn xử lý trường hợp ngoài giới hạn khi i = 0.

```
//Given an integer array nums,

prefix = [nums[0]]
for i in [1, len(nums) - 1]:
    prefix.append(nums[i] + prefix[prefix.length - 1])
```
\
Mảng cộng dồn là một công cụ hữu ích cho tất cả các bài toán liên quan đến tổng của mảng con. Chỉ tốn O(n) để tạo mảng cộng dồn nhưng cho phép tất cả các truy vấn mảng con trong tương lai chạy trong thời gian O(1), do đó, kỹ thuật này có thể tinh chỉnh độ phức tạp thuật toán theo hệ số O(n), trong đó n là độ dài của mảng. Hãy xem xét một số ví dụ.

## Ứng dụng 

__Tính tổng các số trong một khoảng bất kỳ__

Ví dụ 1: Cho một mảng số nguyên `nums = [1, 6, 3, 2, 7, 2]`, một mảng `queries` thỏa điều kiện `queries[i] = [x, y]`, và một số nguyên `limit = 13`. Mảng `queries` có chức năng truy vấn các phần tử của `nums` ở vị trí x và y.

Chẳng hạn `queries = [[0, 3], [2, 5], [2, 4]]` . 

Hãy tạo mảng boolean trả về các kết quả `true` nếu tổng của mảng con từ vị trí x đến y nhỏ hơn `limit`, ngược lại là `false`.

_Giải_:

Thay vì dùng cách thông thường là duyệt qua mảng nums nhiều lần để tính tổng các số từ vị trí x đến y thì chúng ta tạo một mảng `prefix` đại diện cho tổng các số từ vị trí 0 đến vị trí cuối mảng nums. Khi đó, ta chỉ cần truy cập `prefix[x]` và `prefix[y]` là đã giải được bài toán mà không cần duyệt quá nhiều. 

Ta có: 
`nums: [1, 6, 3, 2, 7, 2]`

`prefix: [1, 7, 10, 12, 19, 21]`

tính tổng từ vị trí x đến y: `prefix[y] - prefix[x] + nums[x]`. Nếu tổng này nhỏ hơn `limit` thì true, ngược lại thì false

Lý do chúng ta phải cộng thêm `nums[x]` là vì `prefix[x]` là tổng của 2 số liền trước `nums[x]`, nghĩa là nó không bao gồm `nums[x]`. Nếu không cộng thêm vào sẽ mất mát `nums[x]` dẫn đến sai kết quả bài toán.


```
public boolean[] answer(int[] nums, int[][] queries, int limit) {

    // Khởi tạo mảng prefix
    int[] prefix = new int[nums.length];

    // xây dựng mảng prefix thông qua nums
    prefix[0] = nums[0];
    for (int i = 1; i < nums.length; i++) {
        prefix[i] = prefix[i - 1] + nums[i];
    }

    // kết quả trả về
    boolean[] ans = new boolean[queries.length];

    // duyệt qua queries
    // lấy ra x và y từ queries
    // nếu prefix[y] - prefix[x] + nums[x] < limit
    // thì true, ngược lại là false

    for (int i = 0; i < queries.length; i++) {
        int x = queries[i][0], y = queries[i][1];
        int curr = prefix[y] - prefix[x] + nums[x];
        ans[i] = curr < limit;
    }
    
    return ans;
}

```
\
Đáp án  là `[true, false, true]`. Đối với mỗi truy vấn, tổng của mảng con lần lượt là `[12, 14, 12]`.

Nguồn kham khảo: 

[tek4.vn](https://tek4.vn/khoa-hoc/cau-truc-du-lieu-va-thuat-toan/ky-thuat-mang-cong-don)
[vnoi](https://vnoi.info/wiki/algo/data-structures/prefix-sum-and-difference-array.md)